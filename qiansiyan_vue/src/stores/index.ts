import { defineStore } from 'pinia'

export const useAboutInfo = defineStore('aboutInfo', () => {
    const aboutInfo = {
        morePath: "/about",
        imgPath: "logo.png",
        text: "我们致力于非物质文化遗产的保护、申请、传承、推广、教学、发展。项目特色鲜明，通过“高品质”、“纯手工”、“品牌化”、“国际化”建立“黔思砚”品牌，针对性强，针对于传统文化遗产做出正规保护。借助“非遗+”智慧服务平台，在科学认证的前提下进行市场发展策略。注重“绿水青山就是金山银山”的环保理念，在以科技为媒介的前提下，对非遗文化进行多元化的传播推广、教学研究等。让更多人感受到传统文化的魅力与黔东南人民淳朴的情感。"
    }

    return {aboutInfo}
})

export const useNewsInfo = defineStore('newsInfo', () => {
    const newsA = [
        {
            title: '2023年6月8日 调研相册上传',
            link: 'news.html'
        }
    ]

    const newsB = [
        {
            title: '2023年6月8日 调研',
            link: 'news.html'
        }
    ]

    return {newsA, newsB}
})

export const useCategoryInfo = defineStore('categoryInfo', () => {
    const category = [
        {
            title: '产品分类',
            // item: [
            //     {
            //         titlea: '调研',
            //         link: 'category.html'
            //     }
            // ]
        },
        // {
        //     title: '产品分类',
        //     item: [
        //         {
        //             titlea: '调研',
        //             link: 'category.html'
        //         },
        //         {
        //             titlea: '调研',
        //             link: 'category.html'
        //         },
        //     ]
        // }
    ]

    return {category}
})