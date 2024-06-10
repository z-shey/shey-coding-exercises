"""
 @Project: python-practice
 @File: 反射.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 01/28/24
 @Modified: 01/28/24
 @Description: 反射.py
"""


# class People:
#     def __init__(self, name, age):
#         self.name = name
#         self.age = age
#
#     def say(self):
#         print(f"hello, {self.name}, {self.age}")
#
#
# obj = People("shey", 24)
#
# # 四个内置函数通过字符串来操作属性值、类名
# # hasattr()
# print(hasattr(obj, "name"))
#
# # getattr()
# print(getattr(obj, "name"))
#
# result1 = getattr(obj, "say")  # obj.say
# print(result1)  # <bound method People.say of <__main__.People object at 0x000002C5CCB814D0>>
# result2 = getattr(People, "say")  # People.say
# print(result2)  # <function People.say at 0x000002C5CC898860>
#
# # setattr()
# setattr(obj, "name", "XiaoMing")
# print(getattr(obj, "name"))
#
# # delattr()
# delattr(obj, "name")  # del obj.name
# print(hasattr(obj, "name"))

# class ftp:
#     def put(self):
#         print('putting')
#
#     def get(self):
#         print('getting')
#
#     def interactive(self):
#         method = input('>>:').strip()
#
#         if hasattr(self, method):
#             getattr(self, method)()
#         else:
#             print('no such method')
#
#
# ftp = ftp()
# ftp.interactive()