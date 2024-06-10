"""
 @Project: python-practice
 @File: 函数.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 01/18/24
 @Modified: 01/18/24
 @Description: 函数.py
"""

# def function():
#     print('Hello World!')
#
# print(function)  # <function function at 0x00000233C13C04A0>
# # print(function())


# def func(x, y):
#     print(x, y)
#
# func(1, 2)  # 1 2
# func(y=3, x=5)  # 5 3

# def func(x, y=3):
#     print(x, y)
#
# func(2)  # 2 3

# def func(x, y, z, l=None):
#     if l is None:
#         l = []
#     l.append(x)
#     l.append(y)
#     l.append(z)
#     print(l)
#
# func(1, 2, 3)  # [1, 2, 3]


# def func(x, y, z, *l):
#     print(x, y, z, l)
#
# func(1, 2, 3, 4, 5, 6)  # 1 2 3 (4, 5, 6)
#

# def func(x, y, z, **l):
#     print(x, y, z, l)
#
# func(x=1, y=2, z=3, a=4, b=5, c=6)  # 1 2 3 {'a': 4, 'b': 5, 'c': 6}


# def func(x, y, z):
#     print(x, y, z)
#
# func(*[11, 22, 33])  # 11 22 33

# def func(x, y, *args):
#     print(x, y, args)
#
# func(1, 2, [4, 5, 6])  # 1 2 ([4, 5, 6],)
# func(1, 2, *[4, 5, 6])  # 1 2 (4, 5, 6)

# def func(x, y, z):
#     print(x, y, z)
#
# func(*{'x': 1, 'y': 2, 'z': 3})  # 相当于 func('x', 'y', 'z') 输出：x y z
# func(**{'x': 1, 'y': 2, 'z': 3})  # 相当于 func(x=1, y=2, z=3) 输出：1 2 3

# def func(x, y, **kwargs):
#     print(x, y, kwargs)
#
# func(**{'x': 1, 'y': 2, 'a': 3, 'b': 4})  # 1 2 {'a': 3, 'b': 4}

# def func(*args, **kwargs):
#     print(args)
#     print(kwargs)
#
# func(1, 2, 3, x=4, y=5)
#
# # (1, 2, 3)
# # {'x': 4, 'y': 5}


# def func(x, y, *, a, b):  # a, b 是命名关键字参数
#     print(x, y)
#     print(a, b)
#
# func(1, 2, a=123, b=456)
#
# # 1 2
# # 123 456

# def func(x, y, *, a=55, b):
#     print(x, y)
#     print(a, b)
#
# func(1, 2, b=123)

# def func():
#     print(x)
#
# x = 111
#
# func()

# x = 111
#
# def func():
#     print(x)
#
# def foo():
#     x = 222
#     func()
#
# foo()  # 111

# # input = 111
# def f1():
#     # input = 222
#     def f2():
#         # input = 333
#         print(input)
#     f2()
#
# f1()  # <built-in function input>

# x = 111
# def func():
#     print(x)
#     x = 222
#
# func()

# def func():
#     print("hello")
#
# f = func
# print(f, func)
# f()
# # <function func at 0x0000022C17D604A0> <function func at 0x0000022C17D604A0>
# # hello


# def func():
#     print("hello")

# def foo(x):
#     print(x)
#     x()  # hello
#
# foo(func)  # <function func at 0x00000244006204A0>

# def foo(x):
#     return x
#
# res = foo(func)
# print(res)
# res()
# # <function func at 0x00000200C4F304A0>
# # hello

# def func():
#     print("hello")
#
# l = [func,]
# print(l)
# l[0]()
#
# dic = {'k1': func}
# print(dic)
# dic['k1']()
#
# # [<function func at 0x000001E4FF7F04A0>]
# # hello
# # {'k1': <function func at 0x000001E4FF7F04A0>}
# # hello


# def outer_function():
#     x = 333
#     def inner_function():
#         print(x)
#     return inner_function
#
# f1 = outer_function()
# print(f1)
# f1()
# # <function outer_function.<locals>.inner_function at 0x0000020270D098A0>
# # 333

# def outer_function(x):
#     def inner_function(y):
#         return x + y
#     return inner_function
#
# add_3 = outer_function(3)
# add_5 = outer_function(5)
#
# print(add_3(2))  # 输出: 5
# print(add_5(2))  # 输出: 7

import requests

def get_1(url):
    response = requests.get(url)
    print(len(response.text))

get_1('http://httpbin.org')

def outter(url):
    def get_1():
        response = requests.get(url)
        print(len(response.text))
    return get_1

get = outter('http://httpbin.org')
get()