<script setup lang="ts">
const excellentExample = [
  {
    title: '2023年6月8日',
    link: '/product',
    img: 'images/album/image01.png'
  },
  {
    title: '2023年6月8日',
    link: '/product',
    img: 'images/album/image02.png'
  },
  {
    title: '2023年6月8日',
    link: '/product',
    img: 'images/album/image03.png'
  },
  {
    title: '2023年6月8日',
    link: '/product',
    img: 'images/album/image05.png'
  }
]

const morePage = '/product'
</script>

<template>

  <div class="wow fadeInUp part3">
    <div class="contitbox">
      <label>动态相册</label>
      <a :href="morePage">更多</a>
    </div>
    <ul>
      <li v-for="(item, index) in excellentExample" :key="index">
        <div class="pro">
          <a :href="item.link">
            <img :src="item.img"/>
          </a>
        </div>
        <a :href="item.link">
          <p class="ccsl">{{ item.title }}</p>
        </a>
      </li>
    </ul>
  </div>
  <div class="clear"></div>
</template>

<style scoped>

</style>