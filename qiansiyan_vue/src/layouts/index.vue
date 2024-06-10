<script setup lang="ts">
import Header from '@/layouts/header/index.vue'
import Banner from '@/layouts/banner/index.vue'
import Footer from "@/layouts/footer/index.vue";
import { RouterView } from "vue-router";
</script>

<template>
    <Header/>
    <Banner/>
    <RouterView/>
    <Footer/>
</template>

<style scoped>

</style>