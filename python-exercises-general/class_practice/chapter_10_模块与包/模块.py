"""
 @Project: python-practice
 @File: 模块.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 01/20/24
 @Modified: 01/20/24
 @Description: 模块.py
"""

# import module
#
# x = 3333333
# module.change()
# print(x)  # 3333333
#
# print(module.x)  # 0
# module.get()  # 0

# import sys
#
#
# print(sys.path)
# # 值是一个列表，存放了一系列的文件夹
# # 第一个文件夹是当前文件夹所在的文件夹

# import sys
#
#
# print(sys.modules)

import sys
import os

BASE_DIR = os.path.dirname(__file__)

print(__file__)
print(BASE_DIR)

sys.path.append(BASE_DIR)

from .module import func1

if __name__ == '__main__':
    func1()
