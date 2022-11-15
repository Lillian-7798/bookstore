<template>
  <div style="width:90%;margin: auto">
    <div>
      <h>统计本账号购买情况</h>
      <el-row>
        <el-date-picker v-model="date1" type="datetimerange" range-separator="至" start-placeholder="开始日期"
                        end-placeholder="结束日期">
        </el-date-picker>
        <el-button :disabled="this.$route.query.type==0" @click="st1">统计</el-button>
      </el-row>
      <el-table :data="showData1" style="width: 720px;margin:auto" show-summary v-show="show1">
        <el-table-column prop="name" label="书本名称" width="240" />
        <el-table-column prop="count" label="购书数量" width="240" />
        <el-table-column prop="price" label="购书总价" width="240" />
      </el-table>
      <br />
    </div>
    <div>
      <h>统计书本销量情况（仅管理员可查看）</h>
      <el-row>
        <el-date-picker v-model="date2" type="datetimerange" range-separator="至" start-placeholder="开始日期"
                        end-placeholder="结束日期">
        </el-date-picker>
        <el-button :disabled="this.$route.query.type==1" @click="st2">统计</el-button>
      </el-row>
      <el-table :data="showData2" style="width: 720px;margin:auto" v-show="show2">
        <el-table-column prop="name" label="书本名称" width="240" />
        <el-table-column prop="price" label="书本单价" width="240" />
        <el-table-column prop="count" label="购书数量" width="240" sortable />
      </el-table>
      <br />
    </div>
    <div>
      <h>统计用户消费情况（仅管理员可查看）</h>
      <el-row>
        <el-date-picker v-model="date3" type="datetimerange" range-separator="至" start-placeholder="开始日期"
                        end-placeholder="结束日期">
        </el-date-picker>
        <el-button :disabled="this.$route.query.type==1" @click="st3">统计</el-button>
      </el-row>
      <el-table :data="showData3" style="width: 720px;margin:auto" v-show="show3">
        <el-table-column prop="id" label="用户ID" width="240" />
        <el-table-column prop="name" label="用户名" width="240" />
        <el-table-column prop="total" label="消费金额" width="240" sortable />
      </el-table>
      <br />
    </div>
  </div>
</template>

<script>
import {instance} from "../../axios/axios"
export default {
  data(){
    return{
      show1:false,
      show2:false,
      show3:false,
      date1:"",
      date2:"",
      date3:"",
      showData1:[],
      showData2:[],
      showData3:[]
    }
  },
  methods: {
    st1() {
      if (this.date1 == "") this.$message.error("请先选择时间范围")
      else {
        // console.log(this.date1[0].toLocaleDateString().replace(/\//g, "-") + " " +this.date1[0].toTimeString().substr(0, 8));
        this.show1 = true;
        instance.get("/getBuyID", {
          params: {
            userid: this.$route.query.userid,
            start: this.date1[0].toLocaleDateString().replace(/\//g, "-") + " " + this.date1[0].toTimeString().substr(0, 8),
            end: this.date1[1].toLocaleDateString().replace(/\//g, "-") + " " + this.date1[1].toTimeString().substr(0, 8)
          }
        }).then(res => {
          this.showData1 = res.data;
          console.log(res.data)
        }).catch(err => {
          console.log(err);
        })
      }
    },
    st2() {
      if (this.date2 == "") this.$message.error("请先选择时间范围")
      else {
        // console.log(this.date1[0].toLocaleDateString().replace(/\//g, "-") + " " +this.date1[0].toTimeString().substr(0, 8));
        this.show2 = true;
        instance.get("/getBuyManagerB", {
          params: {
            start: this.date2[0].toLocaleDateString().replace(/\//g, "-") + " " + this.date2[0].toTimeString().substr(0, 8),
            end: this.date2[1].toLocaleDateString().replace(/\//g, "-") + " " + this.date2[1].toTimeString().substr(0, 8)
          }
        }).then(res => {
          this.showData2 = res.data;
          console.log(res.data)
        }).catch(err => {
          console.log(err);
        })
      }
    },
    st3() {
      if (this.date3 == "") this.$message.error("请先选择时间范围")
      else {
        // console.log(this.date1[0].toLocaleDateString().replace(/\//g, "-") + " " +this.date1[0].toTimeString().substr(0, 8));
        this.show3 = true;
        instance.get("/getBuyManagerU", {
          params: {
            start: this.date3[0].toLocaleDateString().replace(/\//g, "-") + " " + this.date3[0].toTimeString().substr(0, 8),
            end: this.date3[1].toLocaleDateString().replace(/\//g, "-") + " " + this.date3[1].toTimeString().substr(0, 8)
          }
        }).then(res => {
          this.showData3 = res.data;
          console.log(res.data)
        }).catch(err => {
          console.log(err);
        })
      }
    },
  }
}
</script>

<style scoped>

</style>