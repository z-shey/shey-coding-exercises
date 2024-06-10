"""
 @Project: python-practice
 @File: property.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 01/26/24
 @Modified: 01/26/24
 @Description: property.py
"""


# class People:
#     def __init__(self, name, weight, height):
#         self.name = name
#         self.weight = weight
#         self.height = height
#
#     @property
#     def bmi(self):
#         return self.weight / (self.height ** 2)
#
#
# obj = People('Bob', 70, 1.85)
# # print(obj.bmi())
#
# print(obj.bmi)


# class Person:
#     def __init__(self, name):
#         self.__name = name
#
#     # @property
#     def get_name(self):
#         return self.__name
#
#     def set_name(self, val):
#         if type(val) is not str:
#             print('must input str')
#             return None
#         self.__name = val
#
#     def del_name(self):
#         print('del_name -> called')
#
#     name = property(get_name, set_name, del_name)
#
#
# # obj = Person('Bob')
# # print(obj.get_name)
# # obj.set_name('Shey')
# # print(obj.get_name)
# # obj.del_name()
#
# obj = Person('Bob')
# print(obj.name)
# obj.name = '1231230'
# print(obj.name)


class Person:
    def __init__(self, name):
        self.__name = name

    @property  # name = property(name)
    def name(self):
        return self.__name

    @name.setter
    def name(self, val):
        if type(val) is not str:
            print('must input str')
            return
        self.__name = val

    @name.deleter
    def name(self):
        print('del_name -> called')


obj = Person('Bob')
print(obj.name)
obj.name = '1231230'
print(obj.name)
