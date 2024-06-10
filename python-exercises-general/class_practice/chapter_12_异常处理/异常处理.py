"""
 @Project: python-practice
 @File: 异常处理.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 01/28/24
 @Modified: 01/28/24
 @Description: 异常处理.py
"""

try:
    print(5 / 0)
except ZeroDivisionError as e:
    print("除数不能为0")
