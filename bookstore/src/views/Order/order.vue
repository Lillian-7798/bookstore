<template>
  <div class="site-content">
    <main class="site-main  main-container no-sidebar">
      <div class="container">
        <div class="breadcrumb-trail breadcrumbs">
          <ul class="trail-items breadcrumb">
            <li class="trail-item trail-begin">
              <a href="">
                <span>
                  Home
                </span>
              </a>
            </li>
            <li class="trail-item trail-end active">
              <span>
                Orders
              </span>
            </li>
          </ul>
        </div>
        <div class="row">
          <div class="main-content-cart main-content col-sm-12">
            <h3 class="custom_blog_title">
              Orders
            </h3>
            <!-- <div class="page-main-content">
              <div class="shoppingcart-content">
                <form action="/Cart" class="cart-form">
                  <table class="shop_table">
                    <thead>
                    <tr>
                      <th class="product-remove"></th>
                      <th class="product-thumbnail"></th>
                      <th class="product-name"></th>
                      <th class="product-price"></th>
                      <th class="product-quantity"></th>
                      <th class="product-subtotal"></th>
                    </tr>
                    </thead>
                  </table>
                </form>
              </div>
            </div> -->
            <div class="search_bar" style="width: 500px;margin: auto">
              <el-input @input="recoverdata" @keyup.enter="searchnow" type="text" v-model="input"
                placeholder="请输入要查找的名称" />
              <el-button type="primary" @click="searchnow">搜索</el-button>
            </div>
            <el-date-picker v-model="date" type="datetimerange" range-separator="至" start-placeholder="开始日期"
              end-placeholder="结束日期">
            </el-date-picker>
            <br />
            <el-card class="box-card" v-for="order in showList" style="margin-bottom: 15px;">
              <div slot="header" class="clearfix">
                <span style="font-size:30px">Order</span>
                <h style="float:right">{{order.time}}</h>
              </div>
              <hr />
              <el-row v-for="book in order.bookList" style="width:2400px;">
                <el-col span="2" style="width:200px">
                  <img :src="book.img" style="height:60px" />
                </el-col>
                <el-col span="6" style="width:180px">
                  <h class="title" style="font-size:25px;">{{ book.bookName }}</h>
                  <p class="attributes-select attributes-size" style="font:#a9a9a9">{{ book.author }}</p>
                </el-col>
                <el-col span="5" style="width:520px"></el-col>
                <el-col span="2" style="padding-top: 15px;width: 90px;">
                  <h style="font-size:25px">${{ book.price }}</h>
                </el-col>
                <el-col span="2" style="padding-top: 15px;padding-left: 100px;">
                  <p style="font-size:20px">×{{ book.count }}</p>
                </el-col>
                <el-divider style="margin-top:3px;"></el-divider>
              </el-row>
              <h style="font-size:20px;float:left;padding-left: 20px;padding-bottom: 20px;">Shipping
                address:{{order.address}}</h>
              <h style="font-size:20px;float:right;padding-right: 50px;padding-bottom: 20px;">Total:${{order.total}}</h>
            </el-card>
          </div>
        </div>
      </div>
    </main>
  </div>
</template>

<script>
import {instance} from "../../axios/axios";
export default {
  data(){
    return{
      date:"",
      input:"",
      showList:[],
      dateList:[],
      orderList:[
        // {
        //   id:2,
        //   time:"2022-07-18 13:34:00:02",
        //   address:"这是一个地址2",
        //   total:199.2,
        //   bookList:[
        //     {
        //       bookID:1,
        //       bookName:'A',
        //       author:"me",
        //       img:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
        //       price:33.2,
        //       count:6
        //     },
        //   ]
        // }
      ]
    }
  },
  created(){
    instance.get("/getOrders",{
      params:{
        userid:this.$route.query.userid,
      }
    }).then(res=>{
      res.data.forEach(item=>{
        this.orderList.push({
          id:item.id,
          time:new Date(item.time).toLocaleDateString().replace(/\//g, "-") + " " + new Date(item.time).toTimeString().substr(0, 8),
          address:item.address,
          total:item.total,
          bookList:item.bookList,
        })
      })
      // this.orderList=res.data;
      this.showList=this.orderList;
      console.log(res.data);
    }).catch(err=>{
      console.log(err);
    })
  },
  methods: {
    // get(e){
    //   let time = new Date(e).Format("yyyy-MM-ss hh:mm:ss");
    //   console.log(time);
    //   return time;
    // },
    searchnow() {
      this.dateList=[];
      this.showList = [];
      //获取dataList
      if (this.date == "") this.dateList = this.orderList;
      else {
        this.orderList.forEach(item => {
          var time =new Date(Date.parse(item.time.replace("-","/"))) ;
          if(this.date[0]<=time&&this.date[1]>=time){
            this.dateList.push(item);
          }
        })
        console.log(this.dateList);
      }
      //获取showList
      this.dateList.forEach(item => {
					// console.log(item.goods.name);
					try{
					item.bookList.forEach(it=>{
						if (String(it.bookName).indexOf(this.input) > -1){
							this.showList.push(item);
							throw "break!"; 
						}
					})
					}catch(e){}
				})
    }
  }
}
</script>

<style scoped>
.search_bar {
  margin: 10px;
  display: flex;
  justify-content: space-around;
  height: 35px;
}
</style>