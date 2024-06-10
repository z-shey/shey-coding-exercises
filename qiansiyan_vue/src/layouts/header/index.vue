<script setup lang="ts">
const navItems = [
  {text: '首页', to: 'home'},
  // {text: '产品展示'},
  {text: '思州石砚', to: 'sizhoushiyan'},
  {text: '关于我们', to: 'about'},
];

const logoPath = 'logo.png';
</script>

<template>
  <div class="header">
    <div class="main">
      <a href="/">
        <img :src="logoPath" alt="" style="height: 85px"/>
      </a>
    </div>
  </div>
  <div class="clear"></div>

  <div class="nav">
    <ul>
      <li v-for="item in navItems" :key="item.text">
        <RouterLink :to="{ name: item.to }">{{ item.text }}</RouterLink>
      </li>
    </ul>
  </div>
  <div class="clear"></div>
</template>

<style scoped>

</style>