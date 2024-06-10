<script setup lang="ts">

import { useNewsInfo } from "@/stores";

const newsA = useNewsInfo().newsA
const newsB = useNewsInfo().newsB


const moreAPath = '/news'
const moreBPath = '/news'

</script>

<template>

  <div class="main">

    <div class="wow fadeInLeft part4 bg">
      <div class="contitbox">
        <label>最新动态</label>
        <a :href="moreAPath">更多</a>
      </div>
      <ul>
        <li v-for="(item, index) in newsA" :key="index">
          <a :href="item.link" class="ccsl">> {{ item.title }}</a>
        </li>
      </ul>
    </div>

    <div class="wow fadeInRight part4">
      <div class="contitbox">
        <label>思州石砚</label>
        <a :href="moreBPath">更多</a>
      </div>
      <ul>
        <li v-for="(item, index) in newsB" :key="index">
          <a :href="item.link" class="ccsl">> {{ item.title }}</a>
        </li>
      </ul>
    </div>

  </div>

  <div class="clear"></div>
</template>

<style scoped>

</style>