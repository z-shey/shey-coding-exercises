<script setup lang="ts">
import { onMounted, ref, watch } from 'vue';

// 使用ref创建响应式引用
const typeOneElements = ref<HTMLDivElement[]>([]);

onMounted(() => {
  typeOneElements.value = document.querySelectorAll(".typeone");
  typeOneElements.value.forEach(element => {
    element.addEventListener("click", toggleArrowAndSlide);
  });
});

function toggleArrowAndSlide(event: Event) {
  const target = event.currentTarget as HTMLDivElement;
  const arrow = target.querySelector(".arrow");

  if (arrow) {
    arrow.classList.toggle("up");
    arrow.classList.toggle("down");

    const typeTwo = target.nextElementSibling as HTMLDivElement;
    if (typeTwo) {
      typeTwo.classList.toggle("show");
      typeTwo.classList.toggle("hide");
    }
  }
}

import { useAboutInfo, useCategoryInfo, useNewsInfo } from "@/stores";
import { useRoute } from "vue-router";

const aboutInfo = useAboutInfo().aboutInfo

// 创建一个响应式引用来存储当前路由的位置
const currentLocation = ref({
  routeName: "",
});

// 使用 useRoute 钩子来访问当前路由对象
const route = useRoute();

onMounted(() => {
  // 在组件挂载时更新当前位置
  updateCurrentLocation();
});

watch(route, () => {
  // 在路由发生变化时更新当前位置
  updateCurrentLocation();
})

function updateCurrentLocation() {
  // 根据当前路由更新当前位置的响应式引用
  currentLocation.value = {
    routeName: `${String(route.name) || '当前页面'}`,
  };
}

const newsA = useNewsInfo().newsA
const categoryS = useCategoryInfo().category
</script>

<template>
  <div class="main">
    <div class="mainL">
      <div class="titbox">产品分类</div>
      <ul class="typeul">
        <li v-for="(category, index) in categoryS" :key="index">
          <div class="typeone"><a href="product.html">{{ category.title }}</a><span class="arrow up"></span></div>
          <div class="typetwo hide" v-for="(subItem, subIndex) in category.item" :key="subIndex">
            <a :href="subItem.link">{{ subItem.titlea }}</a>
          </div>
        </li>

      </ul>

      <div class="titbox">热门资讯</div>
      <ul class="newsul">
        <li v-for="(item, index) in newsA" :key="index">
          <a :href="item.link" class="ccsl">> {{ item.title }}</a>
        </li>
      </ul>

    </div>
    <div class="mainR">
      <div class="brandnavbox">
        <h2>{{ currentLocation.routeName }} </h2>
        <div class="con">当前位置：{{ currentLocation.routeName }}</div>
      </div>
      <div class="detailbox">
        <div class="xq">

          <RouterView/>

        </div>
      </div>
    </div>
    <div class="clear"></div>
  </div>
  <div class="clear"></div>
</template>

<style scoped>
.typetwo.hide {
  padding: 5px 0 0 43px;
  display: none
}

.typetwo.show a {
  display: block;
  line-height: 36px;
  font-size: 13px;
  color: #6c6b6b;
  padding-left: 20px;
}

</style>