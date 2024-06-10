"""
 @Project: python-practice
 @File: 元类.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 01/28/24
 @Modified: 01/28/24
 @Description: 元类.py
"""


class People:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def say(self):
        print(f'{self.name} is saying hello')


# 查看内置的元类
print(type(People))  # <class 'type'>
# 用关键字class创建类，其实是在调用type实例化产生的

print(type(int))  # <class 'type'>
