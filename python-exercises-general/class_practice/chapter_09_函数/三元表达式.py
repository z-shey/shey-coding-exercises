"""
 @Project: python-practice
 @File: 三元表达式.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 01/20/24
 @Modified: 01/20/24
 @Description: 三元表达式.py
"""

def func(x, y):
    if x > y:
        return x
    else:
        return y

res = func(1, 2)
print(res)

# 三元表达式
x = 1
y = 2
res = x if x > y else y
print(res)