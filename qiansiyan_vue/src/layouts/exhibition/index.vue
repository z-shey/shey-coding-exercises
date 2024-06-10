<script setup lang="ts">
const images = [
  {src: 'images/yantai/yantai_01.png', text: '石', href: ''},
  {src: 'images/yantai/yantai_02.png', text: '砚', href: ''},
  {src: 'images/yantai/yantai_03.png', text: '在', href: ''},
  {src: 'images/yantai/yantai_04.png', text: '思', href: ''},
  {src: 'images/yantai/yantai_05.png', text: '州', href: ''},
];
</script>

<template>
  <div class="wow fadeInRight part1" data-wow-offset="10">
    <ul>
      <li v-for="(image, index) in images" :key="index">
        <a :href="image.href">
          <img :src="image.src"/>
        </a>
        <p>{{ image.text }}</p>
      </li>
    </ul>
  </div>
  <div class="clear"></div>
</template>

<style scoped>

</style>