<template>
  <div class="main-content main-content-product no-sidebar">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="breadcrumb-trail breadcrumbs">
            <ul class="trail-items breadcrumb">
              <li class="trail-item trail-begin">
                <a href="/home">Home</a>
              </li>
              <li class="trail-item trail-end active">
                Products
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="content-area shop-grid-content full-width col-lg-12 col-md-12 col-sm-12 col-xs-12">
          <div class="site-main">
            <h3 class="custom_blog_title">
              Products
            </h3>
            <div class="shop-top-control">
              <form class="filter-choice select-form">
                <span class="title">Sort by</span>
                <select title="sort-by" data-placeholder="Price: Low to High" class="chosen-select" onchange="Column();" id="sort">
                  <option value="1" >price: low to high</option>
                  <option value="2">popularity</option>
                  <option value="4">newness</option>
                  <option value="5">price: high to low</option>
                </select>
              </form>
<!--              <div class="grid-view-mode">-->
<!--                <div class="inner">-->
<!--                  <a href="listproducts.html" class="modes-mode mode-list">-->
<!--                    <span></span>-->
<!--                    <span></span>-->
<!--                  </a>-->
<!--                  <a href="gridproducts.html" class="modes-mode mode-grid  active">-->
<!--                    <span></span>-->
<!--                    <span></span>-->
<!--                    <span></span>-->
<!--                    <span></span>-->
<!--                  </a>-->
<!--                </div>-->
<!--              </div>-->
            </div>
          </div>
          <ul class="row list-products auto-clear equal-container product-grid">
<!--            <li class="product-item  col-lg-3 col-md-4 col-sm-6 col-xs-6 col-ts-12 style-1">-->
<!--              <div class="product-inner equal-element">-->
<!--                <div class="product-top">-->
<!--                  <div class="flash">-->
<!--                                        <span class="onnew">-->
<!--                                            <span class="text">-->
<!--                                                new-->
<!--                                            </span>-->
<!--                                        </span>-->
<!--                  </div>-->
<!--                </div>-->
<!--                <div class="product-thumb">-->
<!--                  <div class="thumb-inner">-->
<!--                    <a href="#">-->
<!--                      <img src="../../assets/img/logo.png" alt="img">-->
<!--                    </a>-->
<!--                    <div class="thumb-group">-->
<!--                      <div class="yith-wcwl-add-to-wishlist">-->
<!--                        <div class="yith-wcwl-add-button">-->
<!--                          <a href="#">Add to Wishlist</a>-->
<!--                        </div>-->
<!--                      </div>-->
<!--                      <a href="#" class="button quick-wiew-button">Quick View</a>-->
<!--                      <div class="loop-form-add-to-cart">-->
<!--                        <button class="single_add_to_cart_button button">Add to cart-->
<!--                        </button>-->
<!--                      </div>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--                <div class="product-info">-->
<!--                  <h5 class="product-name product_title">-->
<!--                    <a href="#">Aluminum Plant</a>-->
<!--                  </h5>-->
<!--                  <div class="group-info">-->
<!--                    <div class="stars-rating">-->
<!--                      <div class="star-rating">-->
<!--                        <span class="star-3"></span>-->
<!--                      </div>-->
<!--                      <div class="count-star">-->
<!--                        (3)-->
<!--                      </div>-->
<!--                    </div>-->
<!--                    <div class="price">-->
<!--                      <del>-->
<!--                        $65-->
<!--                      </del>-->
<!--                      <ins>-->
<!--                        $45-->
<!--                      </ins>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--              </div>-->
<!--            </li>-->
<!--            <li class="product-item product-type-variable col-lg-3 col-md-4 col-sm-6 col-xs-6 col-ts-12 style-1">-->
<!--              <div class="product-inner equal-element">-->
<!--                <div class="product-top">-->
<!--                </div>-->
<!--                <div class="product-thumb">-->
<!--                  <div class="thumb-inner">-->
<!--                    <a href="#">-->
<!--                      <img src="../../assets/img/logo.png" alt="img">-->
<!--                    </a>-->
<!--                    <div class="thumb-group">-->
<!--                      <div class="yith-wcwl-add-to-wishlist">-->
<!--                        <div class="yith-wcwl-add-button">-->
<!--                          <a href="#">Add to Wishlist</a>-->
<!--                        </div>-->
<!--                      </div>-->
<!--                      <a href="#" class="button quick-wiew-button">Quick View</a>-->
<!--                      <div class="loop-form-add-to-cart">-->
<!--                        <button class="single_add_to_cart_button button">Add to cart-->
<!--                        </button>-->
<!--                      </div>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--                <div class="product-info">-->
<!--                  <h5 class="product-name product_title">-->
<!--                    <a href="#">Rolf Round</a>-->
<!--                  </h5>-->
<!--                  <div class="group-info">-->
<!--                    <div class="stars-rating">-->
<!--                      <div class="star-rating">-->
<!--                        <span class="star-3"></span>-->
<!--                      </div>-->
<!--                      <div class="count-star">-->
<!--                        (3)-->
<!--                      </div>-->
<!--                    </div>-->
<!--                    <div class="price">-->
<!--                      <del>-->
<!--                        $65-->
<!--                      </del>-->
<!--                      <ins>-->
<!--                        $45-->
<!--                      </ins>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--              </div>-->
<!--            </li>-->
<!--            <li class="product-item product-type-variable col-lg-3 col-md-4 col-sm-6 col-xs-6 col-ts-12 style-1">-->
<!--              <div class="product-inner equal-element">-->
<!--                <div class="product-top">-->
<!--                  <div class="flash">-->
<!--                                        <span class="onnew">-->
<!--                                            <span class="text">-->
<!--                                                new-->
<!--                                            </span>-->
<!--                                        </span>-->
<!--                  </div>-->
<!--                </div>-->
<!--                <div class="product-thumb">-->
<!--                  <div class="thumb-inner">-->
<!--                    <a href="#">-->
<!--                      <img src="../../assets/img/logo.png" alt="img">-->
<!--                    </a>-->
<!--                    <div class="thumb-group">-->
<!--                      <div class="yith-wcwl-add-to-wishlist">-->
<!--                        <div class="yith-wcwl-add-button">-->
<!--                          <a href="#">Add to Wishlist</a>-->
<!--                        </div>-->
<!--                      </div>-->
<!--                      <a href="#" class="button quick-wiew-button">Quick View</a>-->
<!--                      <div class="loop-form-add-to-cart">-->
<!--                        <button class="single_add_to_cart_button button">Add to cart-->
<!--                        </button>-->
<!--                      </div>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--                <div class="product-info">-->
<!--                  <h5 class="product-name product_title">-->
<!--                    <a href="#">Foyer Back</a>-->
<!--                  </h5>-->
<!--                  <div class="group-info">-->
<!--                    <div class="stars-rating">-->
<!--                      <div class="star-rating">-->
<!--                        <span class="star-3"></span>-->
<!--                      </div>-->
<!--                      <div class="count-star">-->
<!--                        (3)-->
<!--                      </div>-->
<!--                    </div>-->
<!--                    <div class="price">-->
<!--                      <del>-->
<!--                        $65-->
<!--                      </del>-->
<!--                      <ins>-->
<!--                        $45-->
<!--                      </ins>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--              </div>-->
<!--            </li>-->
<!--            <li class="product-item product-type-variable col-lg-3 col-md-4 col-sm-6 col-xs-6 col-ts-12 style-1">-->
<!--              <div class="product-inner equal-element">-->
<!--                <div class="product-top">-->
<!--                </div>-->
<!--                <div class="product-thumb">-->
<!--                  <div class="thumb-inner">-->
<!--                    <a href="#">-->
<!--                      <img src="../../assets/img/logo.png" alt="img">-->
<!--                    </a>-->
<!--                    <div class="thumb-group">-->
<!--                      <div class="yith-wcwl-add-to-wishlist">-->
<!--                        <div class="yith-wcwl-add-button">-->
<!--                          <a href="#">Add to Wishlist</a>-->
<!--                        </div>-->
<!--                      </div>-->
<!--                      <a href="#" class="button quick-wiew-button">Quick View</a>-->
<!--                      <div class="loop-form-add-to-cart">-->
<!--                        <button class="single_add_to_cart_button button">Add to cart-->
<!--                        </button>-->
<!--                      </div>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--                <div class="product-info">-->
<!--                  <h5 class="product-name product_title">-->
<!--                    <a href="#">Go Gray</a>-->
<!--                  </h5>-->
<!--                  <div class="group-info">-->
<!--                    <div class="stars-rating">-->
<!--                      <div class="star-rating">-->
<!--                        <span class="star-3"></span>-->
<!--                      </div>-->
<!--                      <div class="count-star">-->
<!--                        (3)-->
<!--                      </div>-->
<!--                    </div>-->
<!--                    <div class="price">-->
<!--                      <del>-->
<!--                        $65-->
<!--                      </del>-->
<!--                      <ins>-->
<!--                        $45-->
<!--                      </ins>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--              </div>-->
<!--            </li>-->
<!--            <li class="product-item  col-lg-3 col-md-4 col-sm-6 col-xs-6 col-ts-12 style-1">-->
<!--              <div class="product-inner equal-element">-->
<!--                <div class="product-top">-->
<!--                </div>-->
<!--                <div class="product-thumb">-->
<!--                  <div class="thumb-inner">-->
<!--                    <a href="#">-->
<!--                      <img src="../../assets/img/logo.png" alt="img">-->
<!--                    </a>-->
<!--                    <div class="thumb-group">-->
<!--                      <div class="yith-wcwl-add-to-wishlist">-->
<!--                        <div class="yith-wcwl-add-button">-->
<!--                          <a href="#">Add to Wishlist</a>-->
<!--                        </div>-->
<!--                      </div>-->
<!--                      <a href="#" class="button quick-wiew-button">Quick View</a>-->
<!--                      <div class="loop-form-add-to-cart">-->
<!--                        <button class="single_add_to_cart_button button">Add to cart-->
<!--                        </button>-->
<!--                      </div>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--                <div class="product-info">-->
<!--                  <h5 class="product-name product_title">-->
<!--                    <a href="#">Boston Fern</a>-->
<!--                  </h5>-->
<!--                  <div class="group-info">-->
<!--                    <div class="stars-rating">-->
<!--                      <div class="star-rating">-->
<!--                        <span class="star-3"></span>-->
<!--                      </div>-->
<!--                      <div class="count-star">-->
<!--                        (3)-->
<!--                      </div>-->
<!--                    </div>-->
<!--                    <div class="price">-->
<!--                      <del>-->
<!--                        $65-->
<!--                      </del>-->
<!--                      <ins>-->
<!--                        $45-->
<!--                      </ins>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--              </div>-->
<!--            </li>-->
<!--            <li class="product-item product-type-variable col-lg-3 col-md-4 col-sm-6 col-xs-6 col-ts-12 style-1">-->
<!--              <div class="product-inner equal-element">-->
<!--                <div class="product-top">-->
<!--                  <div class="flash">-->
<!--                                        <span class="onnew">-->
<!--                                            <span class="text">-->
<!--                                                new-->
<!--                                            </span>-->
<!--                                        </span>-->
<!--                  </div>-->
<!--                </div>-->
<!--                <div class="product-thumb">-->
<!--                  <div class="thumb-inner">-->
<!--                    <a href="#">-->
<!--                      <img src="../../assets/img/logo.png" alt="img">-->
<!--                    </a>-->
<!--                    <div class="thumb-group">-->
<!--                      <div class="yith-wcwl-add-to-wishlist">-->
<!--                        <div class="yith-wcwl-add-button">-->
<!--                          <a href="#">Add to Wishlist</a>-->
<!--                        </div>-->
<!--                      </div>-->
<!--                      <a href="#" class="button quick-wiew-button">Quick View</a>-->
<!--                      <div class="loop-form-add-to-cart">-->
<!--                        <button class="single_add_to_cart_button button">Add to cart-->
<!--                        </button>-->
<!--                      </div>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--                <div class="product-info">-->
<!--                  <h5 class="product-name product_title">-->
<!--                    <a href="#">Palm Chair</a>-->
<!--                  </h5>-->
<!--                  <div class="group-info">-->
<!--                    <div class="stars-rating">-->
<!--                      <div class="star-rating">-->
<!--                        <span class="star-3"></span>-->
<!--                      </div>-->
<!--                      <div class="count-star">-->
<!--                        (3)-->
<!--                      </div>-->
<!--                    </div>-->
<!--                    <div class="price">-->
<!--                      <del>-->
<!--                        $65-->
<!--                      </del>-->
<!--                      <ins>-->
<!--                        $45-->
<!--                      </ins>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--              </div>-->
<!--            </li>-->
<!--            <li class="product-item product-type-variable col-lg-3 col-md-4 col-sm-6 col-xs-6 col-ts-12 style-1">-->
<!--              <div class="product-inner equal-element">-->
<!--                <div class="product-top">-->
<!--                </div>-->
<!--                <div class="product-thumb">-->
<!--                  <div class="thumb-inner">-->
<!--                    <a href="#">-->
<!--                      <img src="../../assets/img/logo.png" alt="img">-->
<!--                    </a>-->
<!--                    <div class="thumb-group">-->
<!--                      <div class="yith-wcwl-add-to-wishlist">-->
<!--                        <div class="yith-wcwl-add-button">-->
<!--                          <a href="#">Add to Wishlist</a>-->
<!--                        </div>-->
<!--                      </div>-->
<!--                      <a href="#" class="button quick-wiew-button">Quick View</a>-->
<!--                      <div class="loop-form-add-to-cart">-->
<!--                        <button class="single_add_to_cart_button button">Add to cart-->
<!--                        </button>-->
<!--                      </div>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--                <div class="product-info">-->
<!--                  <h5 class="product-name product_title">-->
<!--                    <a href="#">Foglia </a>-->
<!--                  </h5>-->
<!--                  <div class="group-info">-->
<!--                    <div class="stars-rating">-->
<!--                      <div class="star-rating">-->
<!--                        <span class="star-3"></span>-->
<!--                      </div>-->
<!--                      <div class="count-star">-->
<!--                        (3)-->
<!--                      </div>-->
<!--                    </div>-->
<!--                    <div class="price">-->
<!--                      <del>-->
<!--                        $65-->
<!--                      </del>-->
<!--                      <ins>-->
<!--                        $45-->
<!--                      </ins>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--              </div>-->
<!--            </li>-->
<!--            <li class="product-item  col-lg-3 col-md-4 col-sm-6 col-xs-6 col-ts-12 style-1">-->
<!--              <div class="product-inner equal-element">-->
<!--                <div class="product-top">-->
<!--                </div>-->
<!--                <div class="product-thumb">-->
<!--                  <div class="thumb-inner">-->
<!--                    <a href="#">-->
<!--                      <img src="../../assets/img/logo.png" alt="img">-->
<!--                    </a>-->
<!--                    <div class="thumb-group">-->
<!--                      <div class="yith-wcwl-add-to-wishlist">-->
<!--                        <div class="yith-wcwl-add-button">-->
<!--                          <a href="#">Add to Wishlist</a>-->
<!--                        </div>-->
<!--                      </div>-->
<!--                      <a href="#" class="button quick-wiew-button">Quick View</a>-->
<!--                      <div class="loop-form-add-to-cart">-->
<!--                        <button class="single_add_to_cart_button button">Add to cart-->
<!--                        </button>-->
<!--                      </div>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--                <div class="product-info">-->
<!--                  <h5 class="product-name product_title">-->
<!--                    <a href="#">Magnificent Bangle</a>-->
<!--                  </h5>-->
<!--                  <div class="group-info">-->
<!--                    <div class="stars-rating">-->
<!--                      <div class="star-rating">-->
<!--                        <span class="star-3"></span>-->
<!--                      </div>-->
<!--                      <div class="count-star">-->
<!--                        (3)-->
<!--                      </div>-->
<!--                    </div>-->
<!--                    <div class="price">-->
<!--                      <del>-->
<!--                        $65-->
<!--                      </del>-->
<!--                      <ins>-->
<!--                        $45-->
<!--                      </ins>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--              </div>-->
<!--            </li>-->
<!--            <li class="product-item product-type-variable col-lg-3 col-md-4 col-sm-6 col-xs-6 col-ts-12 style-1">-->
<!--              <div class="product-inner equal-element">-->
<!--                <div class="product-top">-->
<!--                  <div class="flash">-->
<!--                                        <span class="onnew">-->
<!--                                            <span class="text">-->
<!--                                                new-->
<!--                                            </span>-->
<!--                                        </span>-->
<!--                  </div>-->
<!--                </div>-->
<!--                <div class="product-thumb">-->
<!--                  <div class="thumb-inner">-->
<!--                    <a href="#">-->
<!--                      <img src="../../assets/img/logo.png" alt="img">-->
<!--                    </a>-->
<!--                    <div class="thumb-group">-->
<!--                      <div class="yith-wcwl-add-to-wishlist">-->
<!--                        <div class="yith-wcwl-add-button">-->
<!--                          <a href="#">Add to Wishlist</a>-->
<!--                        </div>-->
<!--                      </div>-->
<!--                      <a href="#" class="button quick-wiew-button">Quick View</a>-->
<!--                      <div class="loop-form-add-to-cart">-->
<!--                        <button class="single_add_to_cart_button button">Add to cart-->
<!--                        </button>-->
<!--                      </div>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--                <div class="product-info">-->
<!--                  <h5 class="product-name product_title">-->
<!--                    <a href="#">Lounge Chair</a>-->
<!--                  </h5>-->
<!--                  <div class="group-info">-->
<!--                    <div class="stars-rating">-->
<!--                      <div class="star-rating">-->
<!--                        <span class="star-3"></span>-->
<!--                      </div>-->
<!--                      <div class="count-star">-->
<!--                        (3)-->
<!--                      </div>-->
<!--                    </div>-->
<!--                    <div class="price">-->
<!--                      <del>-->
<!--                        $65-->
<!--                      </del>-->
<!--                      <ins>-->
<!--                        $45-->
<!--                      </ins>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--              </div>-->
<!--            </li>-->
<!--            <li class="product-item  col-lg-3 col-md-4 col-sm-6 col-xs-6 col-ts-12 style-1">-->
<!--              <div class="product-inner equal-element">-->
<!--                <div class="product-top">-->
<!--                </div>-->
<!--                <div class="product-thumb">-->
<!--                  <div class="thumb-inner">-->
<!--                    <a href="#">-->
<!--                      <img src="../../assets/img/logo.png" alt="img">-->
<!--                    </a>-->
<!--                    <div class="thumb-group">-->
<!--                      <div class="yith-wcwl-add-to-wishlist">-->
<!--                        <div class="yith-wcwl-add-button">-->
<!--                          <a href="#">Add to Wishlist</a>-->
<!--                        </div>-->
<!--                      </div>-->
<!--                      <a href="#" class="button quick-wiew-button">Quick View</a>-->
<!--                      <div class="loop-form-add-to-cart">-->
<!--                        <button class="single_add_to_cart_button button">Add to cart-->
<!--                        </button>-->
<!--                      </div>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--                <div class="product-info">-->
<!--                  <h5 class="product-name product_title">-->
<!--                    <a href="#">Dainty Bangle</a>-->
<!--                  </h5>-->
<!--                  <div class="group-info">-->
<!--                    <div class="stars-rating">-->
<!--                      <div class="star-rating">-->
<!--                        <span class="star-3"></span>-->
<!--                      </div>-->
<!--                      <div class="count-star">-->
<!--                        (3)-->
<!--                      </div>-->
<!--                    </div>-->
<!--                    <div class="price">-->
<!--                      <del>-->
<!--                        $65-->
<!--                      </del>-->
<!--                      <ins>-->
<!--                        $45-->
<!--                      </ins>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--              </div>-->
<!--            </li>-->
<!--            <li class="product-item  col-lg-3 col-md-4 col-sm-6 col-xs-6 col-ts-12 style-1">-->
<!--              <div class="product-inner equal-element">-->
<!--                <div class="product-top">-->
<!--                  <div class="flash">-->
<!--                                        <span class="onnew">-->
<!--                                            <span class="text">-->
<!--                                                new-->
<!--                                            </span>-->
<!--                                        </span>-->
<!--                  </div>-->
<!--                </div>-->
<!--                <div class="product-thumb">-->
<!--                  <div class="thumb-inner">-->
<!--                    <a href="#">-->
<!--                      <img src="../../assets/img/logo.png" alt="img">-->
<!--                    </a>-->
<!--                    <div class="thumb-group">-->
<!--                      <div class="yith-wcwl-add-to-wishlist">-->
<!--                        <div class="yith-wcwl-add-button">-->
<!--                          <a href="#">Add to Wishlist</a>-->
<!--                        </div>-->
<!--                      </div>-->
<!--                      <a href="#" class="button quick-wiew-button">Quick View</a>-->
<!--                      <div class="loop-form-add-to-cart">-->
<!--                        <button class="single_add_to_cart_button button">Add to cart-->
<!--                        </button>-->
<!--                      </div>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--                <div class="product-info">-->
<!--                  <h5 class="product-name product_title">-->
<!--                    <a href="#">Go Gray</a>-->
<!--                  </h5>-->
<!--                  <div class="group-info">-->
<!--                    <div class="stars-rating">-->
<!--                      <div class="star-rating">-->
<!--                        <span class="star-3"></span>-->
<!--                      </div>-->
<!--                      <div class="count-star">-->
<!--                        (3)-->
<!--                      </div>-->
<!--                    </div>-->
<!--                    <div class="price">-->
<!--                      <del>-->
<!--                        $65-->
<!--                      </del>-->
<!--                      <ins>-->
<!--                        $45-->
<!--                      </ins>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--              </div>-->
<!--            </li>-->
            <li v-for="book in books" class="product-item  col-lg-3 col-md-4 col-sm-6 col-xs-6 col-ts-12 style-1">
              <div class="product-inner equal-element">
                <div class="product-top">
                  <div class="flash">
                                        <span class="onnew">
                                            <span class="text">
                                                new
                                            </span>
                                        </span>
                  </div>
                </div>
                <div class="product-thumb">
                  <div class="thumb-inner">
                    <a href="#">
                      <img :src="book.img" alt="img">
                    </a>
                    <div class="thumb-group">
                      <div class="yith-wcwl-add-to-wishlist">
                        <div class="yith-wcwl-add-button">
                          <a href="#">Add to Wishlist</a>
                        </div>
                      </div>
                      <a href="#" class="button quick-wiew-button">Quick View</a>
                      <div class="loop-form-add-to-cart">
                        <button class="single_add_to_cart_button button">Add to cart
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="product-info">
                  <h5 class="product-name product_title">
                    <a :href="'/bookInformation?userid='+this.$route.query.userid+'&username='+this.$route.query.username+'&type='+this.$route.query.type+'&bid='+book.bid">{{book.bname}} </a>
                  </h5>
                  <div class="group-info">
                    <div class="stars-rating">
                      <div class="star-rating">
                        <span class="star-3"></span>
                      </div>
                      <div class="count-star">
                        (3)
                      </div>
                    </div>
                    <div class="price">
<!--                      <del>-->
<!--                        $65-->
<!--                      </del>-->
                      <ins>
                        ${{book.price}}
                      </ins>
                    </div>
                  </div>
                </div>
              </div>
            </li>
          </ul>
          <div class="pagination clearfix style2">
            <div class="nav-link">
              <a href="#" class="page-numbers"><i class="icon fa fa-angle-left" aria-hidden="true"></i></a>
              <a href="#" class="page-numbers">1</a>
              <a href="#" class="page-numbers">2</a>
              <a href="#" class="page-numbers current">3</a>
              <a href="#" class="page-numbers"><i class="icon fa fa-angle-right" aria-hidden="true"></i></a>
            </div>
          </div>
        </div>
      </div>
      <div class="sidebar col-lg-3 col-md-3 col-sm-12 col-xs-12">
        <div class="wrapper-sidebar shop-sidebar">
          <div class="widget woof_Widget">
            <div class="widget widget-categories">
              <h3 class="widgettitle">Categories</h3>
              <ul class="list-categories">
                <li>
                  <input type="checkbox" id="cb1">
                  <label for="cb1" class="label-text">
                    New Arrivals
                  </label>
                </li>
                <li>
                  <input type="checkbox" id="cb2">
                  <label for="cb2" class="label-text">
                    Dining
                  </label>
                </li>
                <li>
                  <input type="checkbox" id="cb3">
                  <label for="cb3" class="label-text">
                    Desks
                  </label>
                </li>
                <li>
                  <input type="checkbox" id="cb4">
                  <label for="cb4" class="label-text">
                    Accents
                  </label>
                </li>
                <li>
                  <input type="checkbox" id="cb5">
                  <label for="cb5" class="label-text">
                    Accessories
                  </label>
                </li>
                <li>
                  <input type="checkbox" id="cb6">
                  <label for="cb6" class="label-text">
                    Tables
                  </label>
                </li>
              </ul>
            </div>
            <div class="widget widget_filter_price">
              <h4 class="widgettitle">
                Price
              </h4>
              <div class="price-slider-wrapper">
                <div data-label-reasult="Range:" data-min="0" data-max="3000" data-unit="$" class="slider-range-price " data-value-min="0" data-value-max="1000">
                </div>
                <div class="price-slider-amount">
                  <span class="from">$45</span>
                  <span class="to">$215</span>
                </div>
              </div>
            </div>
            <div class="widget widget-brand">
              <h3 class="widgettitle">Brand</h3>
              <ul class="list-brand">
                <li>
                  <input id="cb7" type="checkbox">
                  <label for="cb7" class="label-text">New Arrivals</label>
                </li>
                <li>
                  <input id="cb8" type="checkbox">
                  <label for="cb8" class="label-text">Dining</label>
                </li>
                <li>
                  <input id="cb9" type="checkbox">
                  <label for="cb9" class="label-text">Desks</label>
                </li>
                <li>
                  <input id="cb10" type="checkbox">
                  <label for="cb10" class="label-text">Accents</label>
                </li>
                <li>
                  <input id="cb11" type="checkbox">
                  <label for="cb11" class="label-text">Accessories</label>
                </li>
                <li>
                  <input id="cb12" type="checkbox">
                  <label for="cb12" class="label-text">Tables</label>
                </li>
              </ul>
            </div>
            <div class="widget widget_filter_size">
              <h4 class="widgettitle">Size</h4>
              <ul class="list-brand">
                <li>
                  <input id="cb13" type="checkbox">
                  <label for="cb13" class="label-text">14.0 mm</label>
                </li>
                <li>
                  <input id="cb14" type="checkbox">
                  <label for="cb14" class="label-text">14.4 mm</label>
                </li>
                <li>
                  <input id="cb15" type="checkbox">
                  <label for="cb15" class="label-text">14.8 mm</label>
                </li>
                <li>
                  <input id="cb16" type="checkbox">
                  <label for="cb16" class="label-text">15.2 mm</label>
                </li>
                <li>
                  <input id="cb17" type="checkbox">
                  <label for="cb17" class="label-text">15.6 mm</label>
                </li>
                <li>
                  <input id="cb18" type="checkbox">
                  <label for="cb18" class="label-text">16.0 mm</label>
                </li>
              </ul>
            </div>
            <div class="widget widget-color">
              <h4 class="widgettitle">
                Color
              </h4>
              <div class="list-color">
                <a href="#" class="color1"></a>
                <a href="#" class="color2 "></a>
                <a href="#" class="color3 active"></a>
                <a href="#" class="color4"></a>
                <a href="#" class="color5"></a>
                <a href="#" class="color6"></a>
                <a href="#" class="color7"></a>
              </div>
            </div>
            <div class="widget widget-tags">
              <h3 class="widgettitle">
                Popular Tags
              </h3>
              <ul class="tagcloud">
                <li class="tag-cloud-link">
                  <a href="#">Office</a>
                </li>
                <li class="tag-cloud-link">
                  <a href="#">Accents</a>
                </li>
                <li class="tag-cloud-link">
                  <a href="#">Flowering</a>
                </li>
                <li class="tag-cloud-link active">
                  <a href="#">Accessories</a>
                </li>
                <li class="tag-cloud-link">
                  <a href="#">Hot</a>
                </li>
                <li class="tag-cloud-link">
                  <a href="#">Tables</a>
                </li>
                <li class="tag-cloud-link">
                  <a href="#">Dining</a>
                </li>
              </ul>
            </div>
          </div>
          <div class="widget newsletter-widget">
            <div class="newsletter-form-wrap ">
              <h3 class="title">Subscribe to Our Newsletter</h3>
              <div class="subtitle">
                More special Deals, Events & Promotions
              </div>
              <input type="email" class="email" placeholder="Your email letter">
              <button type="submit" class="button submit-newsletter">Subscribe</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {instance} from "../../axios/axios";
export default {
  name: "product",
  data(){
    return {
      books:[
        // {bid:1,bname:"aaa",price:233},
        // {bid:2,bname:"help",price:333}
      ]
    };
  },
  created(){
    instance.get('/getBooks').then(res=>{
      res.data.forEach(item=>{
        this.books.push({
          bid:item.bookId,
          bname:item.bookName,
          price:item.price,
          img:item.image
        })
      })
    }).catch(err=>{
      console.log(err);
    })
  }
}
</script>

<style scoped>

</style>