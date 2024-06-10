"""
 @Project: python-practice
 @File: 创建进程的两种方式.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 02/02/24
 @Modified: 02/02/24
 @Description: 创建进程的两种方式.py
"""
import time
from multiprocessing import Process


# import time
# from multiprocessing import Process
#
#
# def task(id):
#     print(f"进程{id}")
#     time.sleep(2)
#     print(f"进程{id}")
#
#
# if __name__ == '__main__':
#     # 创建对象
#     p = Process(target=task, args=(123,))
#
#     # 开始进程
#     p.start()
#
#     print("Finish")


class MyProcess(Process):
    def run(self):
        print("process 1-1")
        time.sleep(2)
        print("process 1-2")


if __name__ == '__main__':
    p = MyProcess()
    p.start()
    p.join()
    print("Main")
