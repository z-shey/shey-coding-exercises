"""
 @Project: python-practice
 @File: 引用计数.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 14/01/2024
 @Modified: 14/01/2024
 @Description: 垃圾回收机制 - 引用计数
"""

a = 10  # 10 的引用计数为 1
b = a  # 10 的引用计数为 2
c = a  # 10 的引用计数为 3

print(f'begin: {a}')
print(f'begin: {b}')
print(f'begin: {c}')

del a  # 解除变量名 a 与值的绑定关系，此时 10 的引用计数为 2
del b  # 解除变量名 b 与值的绑定关系，此时 10 的引用计数为 1
print(f'after: {a}')  # error
print(f'after: {b}')  # error
print(f'after: {c}')




#%%
