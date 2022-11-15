<template>
  <div>
    <Header />
    <div style="width:1300px;margin: auto" >
    <el-table :data="ShowData" border>
      <el-table-column type="selection" width="55" />
      <el-table-column prop="name" label="用户名" width="200">
      </el-table-column>
      <el-table-column prop="password" label="密码" width="240" />
      <el-table-column prop="type" label="用户类型" width="240" />
      <el-table-column prop="state" label="用户状态" width="240" />
      <el-table-column label="用户管理">
        <template v-slot="scope">
          <el-popconfirm
              title="您确定要禁用改用户的账号吗？"
              confirm-button-text="确定"
              cancel-button-text="取消"
              @confirm="changeType(scope.row)"
          >
            <template #reference>
              <el-button :disabled="scope.row.type=='管理员'">CHANGE</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    </div>
    <Footer />
  </div>
</template>

<script>
import Header from "@/components/Head";
import Footer from  "@/components/Foot";
import {instance} from "../../../axios/axios";
export default {
  name: "index",
  components:{
    Header,
    Footer
  },
  data() {
    return {
      ShowData:[
        // {name:"hhh",password:"123",type:1},
        // {name:"a",password:"123e",type:1}
      ]
    }
  },
  created(){
    instance.get("/getUsers").then(res=>{
      res.data.forEach(item=>{
        this.ShowData.push({
          id:item.userId,
          name:item.userName,
          password:item.password,
          type:item.type==0?"管理员":"用户",
          state:item.state==0?"被禁用":"正常",
        })
      })
    }).catch(err=>{
      console.log(err);
    })
  },
  methods:{
    changeType(n) {
      instance.get("/changeState",{
        params:{
          userid: n.id
        }
      }).then((res)=>{
        if(res.data) this.$message.success("修改用户状态成功！")
      }).catch((err)=>{
        console.log("err",err);
      })
      window.location.reload();
    }
  },
}
</script>

<style scoped>

</style>