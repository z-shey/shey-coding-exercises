<script setup lang="ts">

const contactUs = {
  phone: '12345678910',
  tel: '77000000',
  email: '3432806168@qq.com',
  address: '贵州省凯里市凯里学院',
  copyright: '',
  archivalInformation: '备案号：Nan',
}

</script>

<template>

  <div class="footerBox">
    <div class="main">
      <div class="footL">
        <div class="tit">联系我们</div>
        <ul>
          <!--          <li class="f1">手 机：{{ contactUs.phone}}</li>-->
          <!--          <li class="f2">电 话：{{ contactUs.tel}}</li>-->
          <li class="f3">邮箱：{{ contactUs.email }}</li>
          <li class="f4">地 址：{{ contactUs.address }}</li>
        </ul>
      </div>
      <div class="footR">
        <div class="telbox">
          <!--          <div class="tel">-->
          <!--            <span>12345678910</span>-->
          <!--            <b><p>欢迎来电咨询</p></b>-->
          <!--          </div>-->
        </div>
        <div class="footer">
          <div>
            {{ contactUs.archivalInformation }}<br/>
            {{ contactUs.copyright}}
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="clear"></div>
</template>

<style scoped>

</style>