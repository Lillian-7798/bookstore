<template>
  <div>
  <header class="header style7">
    <div class="top-bar">
      <div class="container">
        <div class="top-bar-left">
          <div class="header-message">
            Welcome to our online store!
          </div>
        </div>
        <div class="top-bar-right">
          <div class="header-language">
            <div class="cleric-language cleric-dropdown">
              <a href="#" class="active language-toggle" data-cleric="cleric-dropdown">
									<span>
										English (USD)
									</span>
              </a>
              <ul class="cleric-submenu">
                <li class="switcher-option">
                  <a href="#">
											<span>
												Chinese (CHS)
											</span>
                  </a>
                </li>
                <li class="switcher-option">
                  <a href="#">
											<span>
												Japanese (JPY)
											</span>
                  </a>
                </li>
              </ul>
            </div>
          </div>
          <ul class="header-user-links">
            <li>
              <a href="/Login">Login or Register</a>
            </li>
          </ul>
        </div>
      </div>
    </div>

    <div class="container">
      <div class="main-header">
        <div class="row">
          <div class="col-lg-3 col-sm-4 col-md-3 col-xs-7 col-ts-12 header-element">
            <div class="logo">
              <a href="/home">
                <img src="../assets/img/logo.png" alt="img">
              </a>
            </div>
          </div>
          <div class="col-lg-7 col-sm-8 col-md-6 col-xs-5 col-ts-12">
            <div class="block-search-block">
              <form class="form-search form-search-width-category">
                <div class="form-content">
                  <div class="category">
                    <select title="cate" data-placeholder="All Categories" class="chosen-select"
                            tabindex="1">
                      <option value="United States">Accessories</option>
                      <option value="United Kingdom">Accents</option>
                      <option value="Afghanistan">Desks</option>
                      <option value="Aland Islands">Sofas</option>
                      <option value="Albania">New Arrivals</option>
                      <option value="Algeria">Bedroom</option>
                    </select>
                  </div>
                  <div class="inner">
                    <input type="text" class="input" name="s" value="" placeholder="Search here">
                  </div>
                  <button class="btn-search" type="submit">
                    <span class="icon-search"></span>
                  </button>
                </div>
              </form>
            </div>
          </div>
          <div class="col-lg-2 col-sm-12 col-md-3 col-xs-12 col-ts-12">
            <div class="header-control">
              <el-row>
              <div class="block-minicart cleric-mini-cart block-header cleric-dropdown" style="font-size: 22px;">
                <a :href="'/Cart?userid='+this.$route.query.userid+'&username='+this.$route.query.username+'&type='+this.$route.query.type">
                  Cart
                </a>
              </div>
              <div class="block-account block-header cleric-dropdown" style="font-size: 22px;" v-if="this.$route.query.userid==undefined">
                <a href="/Login" style="font-size:15px;">
                  Account
                </a>
              </div>
              <div class="block-account block-header cleric-dropdown" style="font-size: 22px;" v-if="this.$route.query.userid!=undefined">
                <a style="color: #7A82A5;">{{this.$route.query.username}}</a>
                <!-- <a href="/Login" style="font-size:15px;">
                  Logout
                </a> -->
                <el-button @click="logout">Logout</el-button>
              </div>
            </el-row>
              <a class="menu-bar mobile-navigation menu-toggle" href="#">
                <span></span>
                <span></span>
                <span></span>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="header-nav-container rows-space-20">
      <div class="container">
        <div class="header-nav-wapper main-menu-wapper">
          <div class="vertical-wapper block-nav-categori">
            <div class="block-title">
							<span class="icon-bar">
								<span></span>
								<span></span>
								<span></span>
							</span>
              <span class="text">All Categories</span>
            </div>
            <div class="block-content verticalmenu-content">
              <ul class="cleric-nav-vertical vertical-menu cleric-clone-mobile-menu">
                <li class="menu-item">
                  <a href="#" class="cleric-menu-item-title" title="New Arrivals">New Arrivals</a>
                </li>
                <li class="menu-item">
                  <a title="Hot Sale" href="#" class="cleric-menu-item-title">Hot Sale</a>
                </li>
                <li class="menu-item">
                  <a title="Children books" href="#" class="cleric-menu-item-title">Children books</a>
                </li>
                <li class="menu-item">
                  <a title="Classics" href="#" class="cleric-menu-item-title">Classics</a>
                </li>
                <li class="menu-item">
                  <a title="Professional books" href="#" class="cleric-menu-item-title">Professional books</a>
                </li>
                <li class="menu-item">
                  <a title="literature" href="#" class="cleric-menu-item-title">literature</a>
                </li>
                <li class="menu-item">
                  <a title="Others" href="#" class="cleric-menu-item-title">Others</a>
                </li>
              </ul>
            </div>
          </div>
          <div class="header-nav">
            <div class="container-wapper">
              <ul class="cleric-clone-mobile-menu cleric-nav main-menu " id="menu-main-menu">
                <li class="menu-item">
                  <a :href="'/Home?userid='+this.$route.query.userid+'&username='+this.$route.query.username+'&type='+this.$route.query.type" class="cleric-menu-item-title" title="Home">Home</a>
                </li>
                <li class="menu-item">
                  <a :href="'/Shop?userid='+this.$route.query.userid+'&username='+this.$route.query.username+'&type='+this.$route.query.type" class="cleric-menu-item-title" title="Shop">Shop</a>
                </li>
                <li class="menu-item">
                  <a :href="'/Order?userid='+this.$route.query.userid+'&username='+this.$route.query.username+'&type='+this.$route.query.type" class="cleric-menu-item-title" title="Order">Orders</a>
                </li>
                <li class="menu-item" v-if="this.$route.query.type==0">
                  <a :href="'/manageUser?userid='+this.$route.query.userid+'&username='+this.$route.query.username+'&type='+this.$route.query.type" class="cleric-menu-item-title" title="Manage">ManageUser</a>
                </li>
                <li class="menu-item" >
                  <a :href="'/manageBooks?userid='+this.$route.query.userid+'&username='+this.$route.query.username+'&type='+this.$route.query.type" class="cleric-menu-item-title" title="Manage">ManageBooks</a>
                </li>
                <li class="menu-item" v-if="this.$route.query.type==0">
                  <a :href="'/manageOrders?userid='+this.$route.query.userid+'&username='+this.$route.query.username+'&type='+this.$route.query.type" class="cleric-menu-item-title" title="Manage">ManageOrders</a>
                </li>
                <li class="menu-item" >
                  <a :href="'/Statistics?userid='+this.$route.query.userid+'&username='+this.$route.query.username+'&type='+this.$route.query.type" class="cleric-menu-item-title" title="Manage">statistics</a>
                </li>
<!--                <li class="menu-item">-->
<!--                  <a href="about.html" class="cleric-menu-item-title" title="About">About</a>-->
<!--                </li>-->
<!--                <li class="menu-item">-->
<!--                  <a href="contact with us.html" class="cleric-menu-item-title" title="Contact us">Contect us</a>-->
<!--                </li>-->
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>
    <div class="header-device-mobile">
      <div class="wapper">
        <div class="item mobile-logo">
          <div class="logo">
            <a href="#">
              <img src="img/logo.png" alt="img">
            </a>
          </div>
        </div>
        <div class="item item mobile-search-box has-sub">
          <a href="#">
						<span class="icon">
							<i class="fa fa-search" aria-hidden="true"></i>
						</span>
          </a>
          <div class="block-sub">
            <a href="#" class="close">
              <i class="fa fa-times" aria-hidden="true"></i>
            </a>
            <div class="header-searchform-box">
              <form class="header-searchform">
                <div class="searchform-wrap">
                  <input type="text" class="search-input" placeholder="Enter keywords to search...">
                  <input type="submit" class="submit button" value="Search">
                </div>
              </form>
            </div>
          </div>
        </div>
        <div class="item mobile-settings-box has-sub">
          <a href="#">
						<span class="icon">
							<i class="fa fa-cog" aria-hidden="true"></i>
						</span>
          </a>
          <div class="block-sub">
            <a href="#" class="close">
              <i class="fa fa-times" aria-hidden="true"></i>
            </a>
            <div class="block-sub-item">
              <h5 class="block-item-title">Currency</h5>
              <form class="currency-form cleric-language">
                <ul class="cleric-language-wrap">
                  <li class="active">
                    <a href="#">
											<span>
												English (USD)
											</span>
                    </a>
                  </li>
                  <li>
                    <a href="#">
											<span>
												Chinese (CHS)
											</span>
                    </a>
                  </li>
                  <li>
                    <a href="#">
											<span>
												Japanese (JPY)
											</span>
                    </a>
                  </li>
                </ul>
              </form>
            </div>
          </div>
        </div>
        <div class="item menu-bar">
          <a class=" mobile-navigation  menu-toggle" href="#">
            <span></span>
            <span></span>
            <span></span>
          </a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { instance } from "../axios/axios";
export default {
  // name: "Head"
  data(){
    return{
      ismanager:false,
    }
  },
  methods:{
    logout(){
      instance.get("/time").then((res)=>{
        console.log(res);
        this.$message.success("用户在线时间"+res.data+"秒");
        this.$router.push({path: "/Login",})
      })
    }
  },
};
</script>

<style scoped>

</style>