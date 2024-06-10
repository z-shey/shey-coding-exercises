"""
 @Project: python-practice
 @File: 装饰器.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 01/19/24
 @Modified: 01/19/24
 @Description: 装饰器.py
"""

# import time
#
#
# def index(x, y):
#     start = time.time()
#     time.sleep(3)
#     print(f"x is {x}, y is {y}")
#     stop = time.time()
#     print(stop - start)
#
#
# index(11, 22)


# import time
#
#
# def index(x, y):
#     time.sleep(3)
#     print(f"x is {x}, y is {y}")
#
#
# start = time.time()
# index(11, 22)
# stop = time.time()
# print(stop - start)

import time


#
#
# def timemer(func):
#     def wrapper(*args, **kwargs):
#         start = time.time()
#         result = func(*args, **kwargs)
#         stop = time.time()
#         print(stop - start)
#         return result
#
#     return wrapper
#
#
# @timemer  # index = timemer(index)
# def index(x, y):
#     time.sleep(3)
#     print(f"x is {x}, y is {y}")
#
#
# @timemer  # home = timemer(home)
# def home(name):
#     time.sleep(2)
#     print(f"Hello, {name}")
#     return 123
#
#
# res = home('shey')
# print(res)  # 123

# from functools import wraps
#
#
# def outter(function):
#     @wraps(function)
#     def wrapper(*args, **kwargs):
#         """wrapper function"""
#         # wrapper.__doc__ = function.__doc__
#         pass
#
#     return wrapper
#
#
# @outter
# def index(x, y):
#     """index function"""
#     print(x, y)
#
#
# print(index.__doc__)  # 输出 index function

# def auth(db_type):
#     def decorator(function):
#         def wrapper(*args, **kwargs):
#             username = input("Enter your name: ").strip()
#             password = input("Enter your password: ").strip()
#
#             if db_type == 'file':
#                 print('from file')
#                 if username == 'admin' and password == 'admin':
#                     result = function(*args, **kwargs)
#                     return result
#                 else:
#                     print('wrong')
#             elif db_type == 'mysql':
#                 print('from mysql')
#                 if username == 'admin' and password == 'admin':
#                     result = function(*args, **kwargs)
#                     return result
#                 else:
#                     print('wrong')
#             elif db_type == 'ldap':
#                 print('from ldap')
#                 if username == 'admin' and password == 'admin':
#                     result = function(*args, **kwargs)
#                     return result
#                 else:
#                     print('wrong')
#             else:
#                 print('wrong')
#
#         return wrapper
#
#     return decorator
#
#
# @auth('mysql')
# def login(username, password):
#     print(username, password)
#
#
# login('admin', 'admin')

def deco1(func1):  # func1 = 被装饰对象 index 函数的内存地址(wrapper2 的内存地址)
    def wrapper1(*args, **kwargs):
        print("deco1.wrapper1")
        res1 = func1(*args, **kwargs)
        return res1

    return wrapper1


def deco2(func2):  # func2 = 被装饰对象 index 函数的内存地址(wrapper3 的内存地址)
    def wrapper2(*args, **kwargs):
        print("deco2.wrapper2")
        res2 = func2(*args, **kwargs)
        return res2

    return wrapper2


def deco3(x):
    def outter3(func3):  # func3 = 原函数 index 的内存地址
        def wrapper3(*args, **kwargs):
            print("deco3.outter3.wrapper3")
            res3 = func3(*args, **kwargs)
            return res3

        return wrapper3

    return outter3


# 加载顺序：自下而上
@deco1  # index = deco1(wrapper2的内存地址) -> index = wrapper1的内存地址
@deco2  # index = deco2(wrapper3的内存地址) -> index = wrapper2的内存地址
@deco3(111)  # @outter3 -> index = outter3(index) -> index = wrapper3的内存地址
def index(x, y):
    print("index", x, y)


print(index)  # <function deco1.<locals>.wrapper1 at 0x000001F046ED85E0>
index(1, 2)

# deco1.wrapper1
# deco2.wrapper2
# deco3.outter3.wrapper3
# index 1 2
