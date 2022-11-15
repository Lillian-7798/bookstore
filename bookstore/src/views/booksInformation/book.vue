<template>
  <div class="main-content main-content-details single no-sidebar">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="breadcrumb-trail breadcrumbs">
            <ul class="trail-items breadcrumb">
              <li class="trail-item trail-begin">
                <a href="/home">Home</a>
              </li>
              <li class="trail-item">
                <a href="#">Accents</a>
              </li>
              <li class="trail-item trail-end active">
                {{this.bookName}}
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="content-area content-details full-width col-lg-9 col-md-8 col-sm-12 col-xs-12">
          <div class="site-main">
            <div class="details-product">
              <div class="details-thumd">
                <div class="image-preview-container image-thick-box image_preview_container">
                  <img id="img_zoom" data-zoom-image="assets/images/details-item-1.jpg"
                       :src="this.image" alt="img">
                  <a href="#" class="btn-zoom open_qv"><i class="fa fa-search" aria-hidden="true"></i></a>
                </div>
                <div class="product-preview image-small product_preview">
                  <div id="thumbnails" class="thumbnails_carousel owl-carousel" data-nav="true"
                       data-autoplay="false" data-dots="false" data-loop="false" data-margin="10"
                       data-responsive='{"0":{"items":3},"480":{"items":3},"600":{"items":3},"1000":{"items":3}}'>
                    <a href="#" data-image="assets/images/details-item-1.jpg"
                       data-zoom-image="assets/images/details-item-1.jpg" class="active">
                      <img src="../../assets/img/logo.png"
                           data-large-image="assets/images/details-item-1.jpg" alt="img">
                    </a>
                    <a href="#" data-image="assets/images/details-item-2.jpg"
                       data-zoom-image="assets/images/details-item-2.jpg">
                      <img src="../../assets/img/logo.png"
                           data-large-image="assets/images/details-item-2.jpg" alt="img">
                    </a>
                    <a href="#" data-image="assets/images/details-item-3.jpg"
                       data-zoom-image="assets/images/details-item-3.jpg">
                      <img src="../../assets/img/logo.png"
                           data-large-image="assets/images/details-item-3.jpg" alt="img">
                    </a>
                    <a href="#" data-image="assets/images/details-item-4.jpg"
                       data-zoom-image="assets/images/details-item-4.jpg">
                      <img src="../../assets/img/logo.png"
                           data-large-image="assets/images/details-item-4.jpg" alt="img">
                    </a>
                  </div>
                </div>
              </div>
              <div class="details-infor">
                <h1 class="product-title">
                  {{this.bookName}}
                </h1>
                <div class="stars-rating">
                  <div class="star-rating">
                    <span class="star-5"></span>
                  </div>
                  <div class="count-star">
                    (7)
                  </div>
                </div>
                <div class="availability">
                  availability:
                  <a href="#">{{this.inventory}}}</a>
                </div>
                <div class="price">
                  <span>${{ this.price }}</span>
                </div>
                <div class="product-details-description">
                  <ul>
<!--                    <li>Vestibulum tortor quam</li>-->
                    <li>{{this.author}}</li>
                    <li>Art.No. 06-7680</li>
                  </ul>
                </div>
                <div class="variations">
<!--                  <div class="attribute attribute_color">-->
<!--                    <div class="color-text text-attribute">-->
<!--                      Color:-->
<!--                    </div>-->
<!--                    <div class="list-color list-item">-->
<!--                      <a href="#" class="color1"></a>-->
<!--                      <a href="#" class="color2"></a>-->
<!--                      <a href="#" class="color3 active"></a>-->
<!--                      <a href="#" class="color4"></a>-->
<!--                    </div>-->
<!--                  </div>-->
                  <div class="attribute attribute_size">
                    <div class="size-text text-attribute">
                      Sets:
                    </div>
                    <div class="list-size list-item">
                      <a href="#" class="">set1</a>
                      <a href="#" class="">set2</a>
                      <a href="#" class="active">set3</a>
                      <a href="#" class="">set4</a>
                      <a href="#" class="">set5</a>
                      <a href="#" class="">set6</a>
                    </div>
                  </div>
                </div>
                <div class="group-button">
                  <div class="yith-wcwl-add-to-wishlist">
                    <div class="yith-wcwl-add-button">
                      <a href="#">Add to Wishlist</a>
                    </div>
                  </div>
                  <div class="size-chart-wrapp">
                    <div class="btn-size-chart">
                      <a id="size_chart" href="../../assets/img/logo.png" class="fancybox">View
                        Size Chart</a>
                    </div>
                  </div>
                  <div class="quantity-add-to-cart">
                    <div class="quantity">
                      <div class="control">
                        <a class="btn-number qtyminus quantity-minus" href="#">-</a>
                        <input type="text" data-step="1" data-min="0" value="1" title="Qty"
                               class="input-qty qty" size="4" id="bookNum">
                        <a href="#" class="btn-number qtyplus quantity-plus">+</a>
                      </div>
                    </div>
                    <button class="single_add_to_cart_button button" @click="addToCart()">Add to cart</button>
                  </div>
                </div>
              </div>
            </div>
            <div class="tab-details-product">
              <ul class="tab-link">
                <li class="active">
                  <a data-toggle="tab" aria-expanded="true" href="#product-descriptions">Descriptions </a>
                </li>
                <li class="">
                  <a data-toggle="tab" aria-expanded="true" href="#information">Information </a>
                </li>
<!--                <li class="">-->
<!--                  <a data-toggle="tab" aria-expanded="true" href="#reviews">Reviews</a>-->
<!--                </li>-->
              </ul>
              <div class="tab-container">
                <div id="product-descriptions" class="tab-panel active">
                  <p>{{this.bookDescription}}</p>
                </div>
                <div id="information" class="tab-panel">
                  <table class="table table-bordered">
                    <tr>
                      <td>Size</td>
                      <td> XS / S / M / L</td>
                    </tr>
                    <tr>
                      <td>Color</td>
                      <td>White/ Black/ Teal/ Brown</td>
                    </tr>
                    <tr>
                      <td>Properties</td>
                      <td>Colorful Dress</td>
                    </tr>
                  </table>
                </div>
<!--                <div id="reviews" class="tab-panel">-->
<!--                  <div class="reviews-tab">-->
<!--                    <div class="comments">-->
<!--                      <h2 class="reviews-title">-->
<!--                        1 review for-->
<!--                        <span>Rolf Round</span>-->
<!--                      </h2>-->
<!--                      <ol class="commentlist">-->
<!--                        <li class="conment">-->
<!--                          <div class="conment-container">-->
<!--                            <a href="#" class="avatar">-->
<!--                              <img src="assets/images/avartar.png" alt="img">-->
<!--                            </a>-->
<!--                            <div class="comment-text">-->
<!--                              <div class="stars-rating">-->
<!--                                <div class="star-rating">-->
<!--                                  <span class="star-5"></span>-->
<!--                                </div>-->
<!--                                <div class="count-star">-->
<!--                                  (1)-->
<!--                                </div>-->
<!--                              </div>-->
<!--                              <p class="meta">-->
<!--                                <strong class="author">Cobus Bester</strong>-->
<!--                                <span>-</span>-->
<!--                                <span class="time">June 7, 2013</span>-->
<!--                              </p>-->
<!--                              <div class="description">-->
<!--                                <p>Simple and effective design. One of my favorites.</p>-->
<!--                              </div>-->
<!--                            </div>-->
<!--                          </div>-->
<!--                        </li>-->
<!--                      </ol>-->
<!--                    </div>-->
<!--                    <div class="review_form_wrapper">-->
<!--                      <div class="review_form">-->
<!--                        <div class="comment-respond">-->
<!--                          <span class="comment-reply-title">Add a review </span>-->
<!--                          <form class="comment-form-review">-->
<!--                            <p class="comment-notes">-->
<!--                              <span class="email-notes">Your email address will not be published.</span>-->
<!--                              Required fields are marked-->
<!--                              <span class="required">*</span>-->
<!--                            </p>-->
<!--                            <div class="comment-form-rating">-->
<!--                              <label>Your rating</label>-->
<!--                              <p class="stars">-->
<!--                                        						<span>-->
<!--                                        							<a class="star-1" href="#"></a>-->
<!--                                        							<a class="star-2" href="#"></a>-->
<!--                                        							<a class="star-3" href="#"></a>-->
<!--                                        							<a class="star-4" href="#"></a>-->
<!--                                        							<a class="star-5" href="#"></a>-->
<!--                                        						</span>-->
<!--                              </p>-->
<!--                            </div>-->
<!--                            <p class="comment-form-comment">-->
<!--                              <label>-->
<!--                                Your review-->
<!--                                <span class="required">*</span>-->
<!--                              </label>-->
<!--                              <textarea title="review" id="comment" name="comment" cols="45"-->
<!--                                        rows="8"></textarea>-->
<!--                            </p>-->
<!--                            <p class="comment-form-author">-->
<!--                              <label>-->
<!--                                Name-->
<!--                                <span class="">*</span>-->
<!--                              </label>-->
<!--                              <input title="author" id="author" name="author" type="text"-->
<!--                                     value="">-->
<!--                            </p>-->
<!--                            <p class="comment-form-email">-->
<!--                              <label>-->
<!--                                Email-->
<!--                                <span class="">*</span>-->
<!--                              </label>-->
<!--                              <input title="email" id="email" name="email" type="email"-->
<!--                                     value="">-->
<!--                            </p>-->
<!--                            <p class="form-submit">-->
<!--                              <input name="submit" type="submit" id="submit" class="submit"-->
<!--                                     value="Submit">-->
<!--                            </p>-->
<!--                          </form>-->
<!--                        </div>-->
<!--                      </div>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
              </div>
            </div>
            <div style="clear: left;"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {instance} from "../../axios/axios";
export default {
  name: "book",
  data(){
    return{
      bookId: 1,
      bookName: "",
      price: 1,
      bookType:"",
      author: "",
      bookDescription: "",
      inventory: 1,
      image:"",
    };
  },
  created(){
    instance.get('/getBookDetails',{
      params:{
        id:this.$route.query.bid,
      }
    }).then(res=>{
      console.log(res);
      this.bookId= res.data.bookId;
      this.bookName=res.data.bookName;
      this.price=res.data.price;
      this.bookType=res.data.bookType;
      this.author=res.data.author;
      this.bookDescription=res.data.bookDescription;
      this.inventory=res.data.inventory;
      this.image=res.data.image;

    }).catch(err=>{
      console.log(err);
    })
  },
  methods:{
    addToCart(){
      let bnum=document.getElementById("bookNum").value;
      instance.post('/addToCart',null,{
        params:{
          userId:this.$route.query.userid,
          bookId:this.$route.query.bid,
          bookNum:bnum,
        }
      }).then(res=>{
        console.log(res.data);
        if(res.data) this.$message.success("成功加入购物车！")
        else this.$message.error("加入购物车失败！")
      }).catch(err=>{
        console.log(err);
      })
    }
  }
}
</script>

<style scoped>

</style>