<template>
  <div class="main-content main-content-login">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="breadcrumb-trail breadcrumbs">
            <ul class="trail-items breadcrumb">
              <li class="trail-item trail-begin">
                <a href="/home">Home</a>
              </li>
              <li class="trail-item trail-end active">Authentication</li>
            </ul>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="content-area col-lg-12 col-md-12 col-sm-12 col-xs-12">
          <div class="site-main">
            <h3 class="custom_blog_title">Authentication</h3>
            <div class="customer_login">
              <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-12">
                  <div class="login-item">
                    <h5 class="title-login">Login your Account</h5>
                    <!--                    <form class="login">-->
                    <div class="login">
                      <div class="social-account">
                        <h6 class="title-social">Login with social account</h6>
                        <a href="#" class="mxh-item facebook">
                          <i
                            class="icon fa fa-facebook-square"
                            aria-hidden="true"
                          ></i>
                          <span class="text">FACEBOOK</span>
                        </a>
                        <a href="#" class="mxh-item twitter">
                          <i class="icon fa fa-twitter" aria-hidden="true"></i>
                          <span class="text">TWITTER</span>
                        </a>
                      </div>
                      <p class="form-row form-row-wide">
                        <label class="text">Username</label>
                        <input
                          title="username"
                          type="text"
                          class="input-text"
                          id="username"
                        />
                      </p>
                      <p class="form-row form-row-wide">
                        <label class="text">Password</label>
                        <input
                          title="password"
                          type="password"
                          class="input-text"
                          id="password"
                        />
                      </p>
                      <p class="lost_password">
                        <span class="inline">
                          <input type="checkbox" id="cb1" />
                          <label for="cb1" class="label-text"
                            >Remember me</label
                          >
                        </span>
                        <a href="#" class="forgot-pw">Forgot password?</a>
                      </p>
                      <p class="form-row">
                        <!--                        <input type="submit" class="button-submit" value="login" @click="login()">-->
                        <button class="button-submit" @click="login()">
                          Login
                        </button>
                      </p>
                    </div>
                    <!--                    </form>-->
                  </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-12">
                  <div class="login-item">
                    <h5 class="title-login">Register now</h5>
                    <form class="register">
                      <p class="form-row form-row-wide">
                        <label class="text">Your email</label>
                        <input
                          title="email"
                          type="email"
                          class="input-text"
                          id="email"
                        />
                      </p>
                      <p class="form-row form-row-wide">
                        <label class="text">Username</label>
                        <input
                          title="name"
                          type="text"
                          class="input-text"
                          id="usn"
                        />
                      </p>
                      <p class="form-row form-row-wide">
                        <label class="text">Password</label>
                        <input
                          title="pass"
                          type="password"
                          class="input-text"
                          id="pass"
                        />
                      </p>
                      <p class="form-row form-row-wide">
                        <label class="text">Password Again</label>
                        <input
                          title="pass"
                          type="password"
                          class="input-text"
                          id="pass2"
                        />
                      </p>
                      <p class="form-row">
                        <span class="inline">
                          <input type="checkbox" id="cb2" />
                          <label for="cb2" class="label-text"
                            >I agree to <span>Terms & Conditions</span></label
                          >
                        </span>
                      </p>
                      <!-- <p class="form-row">
                                               <input type="submit" class="button-submit" value="Register Now">
                        <button class="button-submit" @click="register()">
                          register
                        </button>
                      </p> -->
                      <el-button @click="register()">register</el-button>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { instance } from "../../axios/axios";
export default {
  name: "info",
  // data(){
  //   return {
  //     username: "",
  //     password: "",
  //   }
  // },
  methods: {
    login() {
      let username = document.getElementById("username").value;
      let password = document.getElementById("password").value;
      console.log(username);
      console.log(password);
      if (username == "" || password == "")
        this.$message.error("用户名或密码不能为空");
      else {
        instance
          .get("/checkUsers", {
            params: {
              name: username,
              password: password,
            },
          })
          .then((res) => {
            console.log(res.data);
            if (res.data == "") this.$message.error("密码错误！");
            else {
              if (res.data.state == 0) this.$message.error("该用户被禁用！");
              else {
                instance.get("/time").then()
                this.$router.push({
                  path: "/home",
                  query: {
                    userid: res.data.user_id,
                    username: res.data.user_name,
                    type: res.data.type,
                  },
                });
              }
            }
          })
          .catch((err) => {
            console.log(err);
          });
      }
    },
    register() {
      let usname = document.getElementById("usn").value;
      let password = document.getElementById("pass").value;
      let password2 = document.getElementById("pass2").value;
      let email = document.getElementById("email").value;
      console.log(usname);
      console.log(password);
      console.log(email);
      //检查用户名重复
      instance
        .get("/checkDup", {
           params: {
            username: usname,
          },
        })
        .then((res) => {
          if (res.data) this.$message.error("该用户名已经被使用!");
          else {
            //检查密码是否一致
            if (password != password2) this.$message.error("密码不一致！");
            else {
              //检查email格式
              if (email.indexOf("@") <= 1) this.$message.error("邮箱格式有误!");
              else {
                instance
                  .post("/Register", null, {
                    params: {
                      name: usname,
                      pass: password,
                    },
                  })
                  .then((res) => {
                    this.$message({
                      message: "注册成功",
                      type: "success",
                    });
                  })
                  .catch((err) => {
                    console.log(err);
                  });
              }
            }
          }
        }).catch(err=>{
          console.log(err);
        })
    },
  },
};
</script>

<style scoped>
</style>