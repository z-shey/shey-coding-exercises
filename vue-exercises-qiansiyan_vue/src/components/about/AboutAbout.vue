<script setup lang="ts">

import { useAboutInfo } from "@/stores";

const aboutInfo = useAboutInfo().aboutInfo
</script>

<template>

  <div class="con">
    <img :src="aboutInfo.imgPath" alt="" style="width: 150px;">
    <p>{{ aboutInfo.text }}</p>
  </div>

</template>

<style scoped>

</style>