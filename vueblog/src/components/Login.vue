<template>
  <el-form :rules="rules" class="login-container" label-position="left"
           label-width="0px" v-loading="loading">
    <h3 class="login_title">系统登录</h3>
    <el-form-item prop="account">
      <el-input type="text" v-model="loginForm.username"
                auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="checkPass">
      <el-input type="password" v-model="loginForm.password"
                auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item prop="code">
      <el-input
        v-model="loginForm.code"
        auto-complete="off"
        placeholder="验证码"
        style="width: 63%"
      >
        <svg-icon slot="prefix" icon-class="validCode" class="el-input__icon input-icon" />
      </el-input>
      <div class="login-code">
        <img :src="codeUrl" @click="getCode" />
      </div>
      <span v-model="codeUrl"></span>
    </el-form-item>
    <el-checkbox class="login_remember" v-model="checked"
                 label-position="left">记住密码</el-checkbox>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%" @click="submitClick">登录</el-button>
    </el-form-item>
  </el-form>
</template>
<script>
  export default{
    data(){
      return {
        codeUrl: "",
        rules: {
          account: [{required: true, message: '请输入用户名', trigger: 'blur'}],
          checkPass: [{required: true, message: '请输入密码', trigger: 'blur'}],
          checkCode: [{required: true, message: '请输入验证码', trigger: 'blur'}]
        },
        checked: true,
        loginForm: {
          username: 'admin',
          password: '123',
          code: "",
          uuid:""
        },
        loading: false
      }
    },
    created() {
      this.getCode();
    },
    methods: {
      submitClick: function () {
        var _this = this;
        this.loading = true;
        this.postRequest('/login', this.loginForm).then(resp=> {
          _this.loading = false;
          if (resp && resp.status == 200) {
            var data = resp.data;
            _this.$store.commit('login', data.obj);
            var path = _this.$route.query.redirect;
            _this.$router
              .replace({path: path == '/' || path == undefined ? '/home' : path});}

        });
      },
      getCode() {
        this.getRequest('/captchaImage').then(res => {
          this.codeUrl = "data:image/gif;base64," + res.data.img;
          this.loginForm.uuid = res.data.uuid;
        });
      },
    }
  }
</script>
<style>
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
  .login_remember {
    margin: 0px 0px 35px 0px;
    text-align: left;
  }
  .login-code {
    width: 33%;
    height: 38px;
    float: right;
   img {
    cursor: pointer;
    vertical-align: middle;
  }
  }

</style>
