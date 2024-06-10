"""
 @Project: python-practice
 @File: 迭代器.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 01/19/24
 @Modified: 01/19/24
 @Description: 迭代器.py
"""


# my_list = [1, 2, 3, 4, 5]
#
# list_iterator = my_list.__iter__()
# print(list_iterator)  # <list_iterator object at 0x000002833C314D30>
#
# print(list_iterator.__next__())  # 1
# print(list_iterator.__next__())  # 2
# print(list_iterator.__next__())  # 3


# def function():
#     print('first')
#     yield 1
#     print('second')
#     yield 2
#     print('third')
#     yield 3
#
#
# func = function()
# res = func.__next__()  # first
# print(res)  # 1
#
# res = func.__next__()  # second
# print(res)  # 2
#
# res = func.__next__()  # third
# print(res)  # 3
#
# # res = func.__next__()  # StopIteration

# def dog(name):
#     list = []
#     print(f"eating{name}")
#     while True:
#         x = yield list
#         # 两个功能：
#         # x = yield 是无论next还是send，先传值给x
#         # 运行再遇到新的yield，yield list 就返回本次的值
#         print(f"ate{name}, {x}")
#         list.append(x)
#
#
# d = dog('alex')
# res = d.send(None)  # 相当于 next(d)
# print(res)  # []
#
# res = d.send('ABC')
# print(res)  # ['ABC']
# # 先把 'ABC' 给 yield ，yield 再给 x（x = 'ABC'），再运行其他代码，再执行遇到新的 yield，再将本次结果返回
#
# res = d.send('123')
# print(res)  # ['ABC', '123']


# def func():
#     print("start...")
#     x = yield 111  # x = "ABC"
#     print("middle...")
#     yield 222  # 返回 222
#
# g = func()
# result = next(g)
# print(result)  # 111
#
# res = g.send("ABC")  # middle...
# print(res)  # 222
