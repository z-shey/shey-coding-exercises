<script setup lang="ts">
import { useAboutInfo } from "@/stores";

const aboutInfo = useAboutInfo().aboutInfo
</script>

<template>
  <div class="wow fadeInLeft part2">
    <div class="contitbox">
      <label>关于我们</label>
      <RouterLink :to="{ name: 'about' }">更多</RouterLink>
    </div>
    <div class="aboutBox">
      <div class="L">
        <img :src="aboutInfo.imgPath" alt="" style="height: 100%; object-fit: contain;"/>
      </div>
      <div class="R">
        <p>{{ aboutInfo.text }}</p>
      </div>
    </div>
  </div>
  <div class="clear"></div>
</template>

<style scoped>

</style>