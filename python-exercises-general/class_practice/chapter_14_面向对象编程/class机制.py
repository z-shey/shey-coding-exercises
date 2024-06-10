"""
 @Project: python-practice
 @File: class机制.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 01/28/24
 @Modified: 01/28/24
 @Description: class机制.py
"""


# class People:
#     def __init__(self, name, age):
#         self.name = name
#         self.age = age
#
#     def say(self):
#         print(f'{self.name} is saying hello')
#
# # 1. 类名
# class_name = 'People'
#
# # 2. 基类（父类）
# class_base = (object,)
#
# # 3. 执行类体代码得到类名称空间
# class_dic = {}
# class_body = """
# def __init__(self, name, age):
#     self.name = name
#     self.age = age
#
# def say(self):
#     print(f'{self.name} is saying hello')
# """
# exec(class_body, {}, class_dic)
# # print(class_dic)
#
# # 4. 调用元类
# People = type(class_name, class_base, class_dic)
# print(People)  # <class '__main__.People'>


# class MyMeta(type):
#     def __new__(cls, *args, **kwargs):
#         print("MyMeta.__new__")
#         return super().__new__(cls, *args, **kwargs)  # 返回对象方式一
#
#     def __init__(self, class_name, class_base, class_dic):
#         print("MyMeta.__init__")
#
#     def __call__(self, *args, **kwargs):
#         print("MyMeta.__call__")
#         print(self)  # <class '__main__.People'>
#         print(args)  # ('Shey', 24)
#         print(kwargs)  # {}
#         # 1. MyMeta.__call__会先调用People.__new__
#         people_obj = self.__new__(self)
#         # 2. MyMeta.__call__会调用People.__init__
#         self.__init__(people_obj, *args, **kwargs)
#         # 3. MyMeta.__call__会返回好一个初始化好的对象
#         # return 1112311233221312321231123
#         return people_obj
#
#
# # 类的产生
# # People = MyMeta('People', (object,), {}) --> type.__call__：
# # 1. type.__call__内会先调用MyMeta.__new__
# # 2. type.__call__内会会调用MyMeta.__init__
# # 3. type.__call__内会会返回一个初始化好的对象
# class People(object, metaclass=MyMeta):
#     def __new__(cls, *args, **kwargs):
#         # 产生真正的对象
#         print("People.__new__")
#         return object.__new__(cls)
#
#     def __init__(self, name, age):
#         self.name = name
#         self.age = age
#
#     def say(self):
#         print(f'{self.name} is saying hello')
#
#     def __call__(self, *args, **kwargs):
#         print("MyMeta.__call__")
#         print(args, kwargs)
#         return 12313
#
#
# # 类的调用
# # 触发MyMeta.__call__
# # 1. MyMeta.__call__会先调用People.__new__
# # 2. MyMeta.__call__会调用People.__init__
# # 3. MyMeta.__call__会返回好一个初始化好的对象
# people = People('Shey', 24)
# result = people  # MyMeta.__call__
# # print(result)  # 1112311233221312321231123
# print(result)  # <__main__.People object at 0x00000243E7BA1F50>
# print(result.__dict__)  # {'name': 'Shey', 'age': 24}


class MyMeta(type):
    n = 444

    def __call__(self, *args, **kwargs):
        obj = self.__new__(self)
        self.__init__(obj, *args, **kwargs)
        return obj


class Bar(object):
    pass
    # n = 333


class Foo(Bar):
    pass
    # n = 222


class People(Foo, metaclass=MyMeta):
    # n = 111

    school = 'Stanford'

    def __init__(self, name, age):
        self.name = name
        self.age = age

    def say(self):
        print('%s says welcome to the Stanford to learn Python' % self.name)


print(People.n)
# n的查找顺序为StanfordTeacher->Foo->Bar->object->MyMeta->type
