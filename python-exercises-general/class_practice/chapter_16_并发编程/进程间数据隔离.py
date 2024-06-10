"""
 @Project: python-practice
 @File: 进程间数据隔离.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 02/02/24
 @Modified: 02/02/24
 @Description: 进程间数据隔离.py
"""

from multiprocessing import Process

money = 100


def task():
    global money
    money = 20


if __name__ == '__main__':
    p = Process(target=task)
    p.start()
    p.join()
    print(money)
