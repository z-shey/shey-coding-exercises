"""
 @Project: python-practice
 @File: 内置方法.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 01/28/24
 @Modified: 01/28/24
 @Description: 内置方法.py
"""


class People:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def say(self):
        print(f"hello, {self.name}, {self.age}")

    def __del__(self):
        print("对象被销毁了")


obj = People("shey", 24)

del obj

print("=========================")
