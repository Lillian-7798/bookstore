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
								Shopping Cart
							</span>
            </li>
          </ul>
        </div>
        <div class="row">
          <div class="main-content-cart main-content col-sm-12">
            <h3 class="custom_blog_title">
              Shopping Cart
            </h3>
            <div class="page-main-content">
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
                    <tbody>
                    <tr class="cart_item" v-for="book in cart">
                      <td class="product-remove">
                        <a href="#" class="remove"></a>
                      </td>
                      <td class="product-thumbnail">
                        <a href="#">
                          <img :src="book.image" alt="img"
                               class="attachment-shop_thumbnail size-shop_thumbnail wp-post-image">
                        </a>
                      </td>
                      <td class="product-name" data-title="Product">
                        <a href="#" class="title">{{book.bookName}}</a>
                        <!-- <span class="attributes-select attributes-color">Brown,</span> -->
                        <span class="attributes-select attributes-size">{{book.author}}</span>
                      </td>
                      <td class="product-quantity" data-title="Quantity">
                        <div class="quantity">
                          <div class="control">
                            <a class="btn-number qtyminus quantity-minus" href="#">-</a>
                            <input type="text" data-step="1" data-min="0" v-model="book.bookNum" title="Qty"
                                   class="input-qty qty" size="4">
                            <a href="#" class="btn-number qtyplus quantity-plus">+</a>
                          </div>
                        </div>
                      </td>
                      <td class="product-price" data-title="Price">
													<span class="woocommerce-Price-amount amount">
														<span class="woocommerce-Price-currencySymbol">
															$
														</span>
														{{book.price}}
													</span>
                      </td>
                    </tr>
                    <tr>
                      <td class="actions">
                        <div class="coupon">
                          <label class="coupon_code">shipping address:</label>
                          <input type="text" class="input-text" placeholder="Shipping address here" v-model="this.address">
                          <!-- <a href="#" class="button"></a> -->
                        </div>
                        <div class="order-total">
														<span class="title">
															Total Price:
														</span>
                          <span class="total-price">
															${{total}}
														</span>
                        </div>
                      </td>
                    </tr>
                    </tbody>
                  </table>
                </form>
                <div class="control-cart">
                  <button class="button btn-continue-shopping">
                    Continue Shopping
                  </button>
                  <button class="button btn-cart-to-checkout" @click="checkout">
                    Checkout
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
  </div>
</template>

<script>
import {instance} from "../../axios/axios";
import {websocket} from "../../websocket";
import { useRoute, useRouter } from 'vue-router'
export default {
  data(){
    return{
      cart:[
        // {
        //   // bookId:1,
        //   // author:"me",
        //   // bookName:"aaa",
        //   // price:34,
        //   // bookNum:3,
        // }
      ],
      total:0,
      address:"",
    };
  },
  setup(){
    const route = useRoute();
    const router = useRouter();
    var userId = route.query.userid;
    var userName = route.query.userName;
    var Type = route.query.type;
    // var userId = window.location.href.split("?")[1].split("=")[1].split("&")[0];
    // var userName = window.location.href.split("&")[1].split("=")[1];
    // var Type = window.location.href.split("&")[2].split("=")[1];
    const ws = websocket(userId,handleMessage);
    function handleMessage(e){
      let message = e.data;
      if(message){
        // this.$message.success("下订单成功！")
            router.push({
                  path: "/Order",
                  query: {
                    userid: userId,
                    username: userName,
                    type: Type
                  },
                });
      }
    }
  },
  created(){
    instance.get("/getCart",{
      params:{
        userId:this.$route.query.userid
      }
    }).then(res=>{
      console.log(res.data);
      
      res.data.forEach(item=>{
        this.cart.push({
          bookId:item.book_id,
          author:item.author,
          bookName:item.book_name,
          price:item.price,
          bookNum:item.count,
          image:item.image,
        })
        this.total+=item.price*item.count;
      })
      this.total=this.total.toFixed(2);
    }).catch(err=>{
      console.log(err);
    })
  },
  methods:{
    checkout(){
      console.log(this.address)
      if(this.address=="") this.$message.error("收货地址不能为空！");
      else{
        instance.post("/checkoutCart",null,{
          params:{
            address:this.address,
            userId:this.$route.query.userid
          }
        }).then(res=>{
          console.log(res.data)
          if(!res.data) this.$message.error("购买失败！");
          // else{
          //   this.$router.push({
          //         path: "/Order",
          //         query: {
          //           userid: this.$route.query.userid,
          //           username: this.$route.query.username,
          //           type: this.$route.query.type,
          //         },
          //       });
          // }
        }).catch(err=>{
          console.log(err)
        })
      }
    }
  }

}
</script>

<style scoped>

</style>