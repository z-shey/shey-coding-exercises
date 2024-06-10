"""
 @Project: python-practice
 @File: 类与对象.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 01/23/24
 @Modified: 01/23/24
 @Description: 类与对象.py
"""


class Person:
    # 类的属性
    name = ""
    age = 0

    # 类的构造函数
    def __init__(self, name, age):
        self.name = name
        self.age = age

    # 对象的方法
    def say_hello(self):
        print("Hello, my name is", self.name)

    def get_age(self):
        return self.age


# 创建对象
# person1 = Person("Alice", 25)
#
# # 调用对象的方法
# person1.say_hello()  # 输出：Hello, my name is Alice
# print("Age:", person1.get_age())  # 输出：Age: 25

# print(Person.__dict__['get_age'])

person = Person("shey", 123)

print(id(person.name))
print(id(person.age))

print(id(person.get_age()))


