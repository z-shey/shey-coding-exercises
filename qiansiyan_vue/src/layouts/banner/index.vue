<script setup lang="ts">
const imgList = [
  {
    url: 'images/bg/01.png',
    name: 'banner1'
  }
  ,
  {
    url: 'images/bg/02.png',
    name: 'banner2'
  }
]
</script>

<template>
  <div class="banner">
    <div class="b-img">
      <img v-for="(item, index) in imgList" :key="index" :src="item.url" width="100%" :alt="item.name"/>
    </div>
    <div class="clear"></div>
    <div class="b-list"></div>
  </div>
  <div class="clear"></div>
</template>

<style scoped>

</style>