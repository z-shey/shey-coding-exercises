"""
 @Project: python-practice
 @File: 基本类型.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 14/01/2024
 @Modified: 14/01/2024
 @Description: 基本类型.py
"""

# a = 10
# b = 20
# print(type(a), type(b))
#
# a = 10.5
# b = 20.5
# print(type(a), type(b))
#
# a = True
# b = False
# print(type(a), type(b))
#
# a = "Hello"
# b = "World"
# print(type(a), type(b))


# str = "hello world"
#
# print(len(str))


# str = "    shey    "
# str_1 = str.strip()
# print(str)    # 输出    shey
# print(str_1)  # 输出 shey

#
# str = "****shey****"
# str_1 = str.strip("*")
# print(str)    # 输出****shey****
# print(str_1)  # 输出 shey

# info = "hello, I'm shey."
# info_1 = info.split()
# print(info_1)  # 输出 ['hello,', "I'm", 'shey.']

info = "hello:I'm:shey"
info_1 = info.split(":")
print(info_1)  # 输出 ['hello', "I'm", 'shey']
