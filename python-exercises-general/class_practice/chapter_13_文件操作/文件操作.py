"""
 @Project: python-practice
 @File: 文件操作.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 01/17/24
 @Modified: 01/17/24
 @Description: 文件操作.py
"""

# f = open("aa/bbb.txt", mode='rt')
# print(f)
#
# # <_io.TextIOWrapper name='aa/bbb.txt' mode='r' encoding='cp1252'>
#
# res = f.read()
# print(res)

# with open("aa/bbb.txt", mode='rt') as f1:
#     res = f1.read()
#     print(res)


# with open("aa/bbb.txt", mode='rt', encoding='utf-8') as f1:
#     print("第一次读取".center(20, "*"))
#     res = f1.read()
#     print(res)
#
#     print("第二次读取".center(20, "*"))
#     res = f1.read()
#     print(res)
#
# # *******第一次读取********
# # asdfasdasd
# # *******第二次读取********

with open("aa/bbb.txt", mode="rb") as f:
    res = f.read()
    print(res, type(res))

    print(res.decode('utf-8'))
