"""
 @Project: python-practice
 @File: 匿名函数.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 01/20/24
 @Modified: 01/20/24
 @Description: 匿名函数.py
"""

# def func(x, y):  # func = 函数的内存地址
#     return x + y
#
# print(func)  # <function func at 0x0000020C58D904A0>
#
# lambda x, y: x + y  # lambda 用于定义匿名函数

# 方式一
result = (lambda x, y: x + y)(1, 2)
print(result)

# 方式二
func = lambda x, y: x + y
result = func(10, 20)
print(result)

