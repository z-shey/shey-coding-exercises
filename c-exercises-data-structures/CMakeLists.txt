cmake_minimum_required(VERSION 3.28)
project(c_exercises_data_structures C)

set(CMAKE_C_STANDARD 11)

# 设置头文件的搜索路径
include_directories(
        "common"
        "src/array"
        "src/list"
        "src/queue"
        "src/stack"
        "src/tree")

# 使用 file(GLOB_RECURSE) 自动搜索并添加源文件
file(GLOB_RECURSE SOURCE_FILES "src/**/*.c" "common/*.c" "test/**/*.c")
file(GLOB_RECURSE HEADER_FILES "src/**/*.h" "common/*.h" "test/**/*.h")

add_executable(c_exercises_data_structures
        ${SOURCE_FILES}
        ${HEADER_FILES})
