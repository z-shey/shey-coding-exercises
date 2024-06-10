"""
 @Project: python-practice
 @File: 继承.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 01/26/24
 @Modified: 01/26/24
 @Description: 继承.py
"""


# class ParentClass1:
#     pass
#
#
# class ParentClass2:
#     pass
#
#
# class ChildClass1(ParentClass1):  # 单继承
#     pass
#
#
# class ChildClass2(ParentClass1, ParentClass2):  # 多继承
#     pass
#
#
# print(ChildClass1.__bases__)  # (<class '__main__.ParentClass1'>,)
# print(ChildClass2.__bases__)  # (<class '__main__.ParentClass1'>, <class '__main__.ParentClass2'>)


# class Person:
#     school = 'obx'
#
#     def __init__(self, name, age, gender):
#         self.name = name
#         self.age = age
#         self.gender = gender
#
#
# class Student(Person):
#     def choose_course(self):
#         print('choosing')
#
#
# class Teacher(Person):
#     def __init__(self, name, age, gender, salary, level):
#         Person.__init__(self, name, age, gender)  # 调用父类init方法
#         self.salary = salary
#         self.level = level
#
#     def score(self):
#         print('scoring', self.name)
#
#
# stu_obj_1 = Student('lili', 18, 'female')
# print(stu_obj_1.__dict__)  # {'name': 'lili', 'age': 18, 'gender': 'female'}
# print(stu_obj_1.school)
#
# tea_obj_1 = Teacher('alice', 18, 'male', 3000, 10)
# print(tea_obj_1.__dict__)  # {'name': 'alice', 'age': 18, 'gender': 'male', 'salary': 3000, 'level': 10}
# print(tea_obj_1.school)


# class Foo:
#     def __f1(self):  # _Foo__f1
#         print('Foo.f1')
#
#     def f2(self):
#         print('Foo.f2')
#         self.__f1()  # self._Foo__f1
#
#
# class Bar(Foo):
#     def f1(self):
#         print('Bar.f1')
#
#
# obj = Bar()
# obj.f2()


# class A:
#     def method(self):
#         print("Method of class A")
#
#
# class B(A):
#     def method(self):
#         print("Method of class B")
#
#
# class C(A):
#     def method(self):
#         print("Method of class C")
#
#
# class D(B, C):
#     pass
#
#
# print(D.mro())  # [<class '__main__.D'>, <class '__main__.B'>, <class '__main__.C'>, <class '__main__.A'>, <class 'object'>]
#
# d = D()
# d.method()

# class Vehicle:
#     pass
#
#
# class FlyableMixin(Vehicle):
#     def fly(self):
#         pass
#
#
# class Helicopter(FlyableMixin, Vehicle):
#     pass
#
#
# class CivilAircraft(FlyableMixin, Vehicle):
#     pass
#
#
# class Car(Vehicle):
#     pass


# import abc
#
# class Person(metaclass=abc.ABCMeta):
#     pass


class MyClass:
    def __init__(self, value):
        self.value = value

    def method(self):
        print(f"Value is {self.value}")

    @classmethod
    def class_method(cls):
        print(f"Class is {cls}")
        return cls(33)


obj1 = MyClass(10)
obj2 = MyClass(20)

# 绑定给对象的方法，由对象调用，自动传入的是对象
obj1.method()  # 输出 "Value is 10"
obj2.method()  # 输出 "Value is 20"

# 绑定给类的方法，由类调用，自动传入的是类
MyClass.class_method()  # 输出 "Class is <class '__main__.MyClass'>"
obj = MyClass.class_method()  # Class is <class '__main__.MyClass'>
print(obj.__dict__)  # {'value': 33}
