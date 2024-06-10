"""
 @Project: python-practice
 @File: 生成式.py
 @Version: 1.0.0
 @Author: Shey
 @Created: 01/20/24
 @Modified: 01/20/24
 @Description: 生成式.py
"""

# list = ['alex_a', 'bob_a', 'charlie_b', 'john_a']
#
# new_list = []
# for name in list:
#     if name.endswith('a'):
#         new_list.append(name)
# print(new_list)
#
# new_list.clear()
#
# new_list = [name for name in list if name.endswith('a')]
# print(new_list)


# items = [('name', 'shey'), ('age', 25), ('weight', '110kg')]
# res = {key: value for key, value in items if key != 'weight'}
# print(res)  # {'name': 'shey', 'age': 25}

with open('data.txt', mode='rt', encoding='utf-8') as f:
    # 方式一
    # result = 0
    # for line in f:
    #     result += len(line)
    #
    # print(result)  # 13

    # 方式二
    # result = sum([len(line) for line in f])
    # print(result)  # 13

    # 方式三
    result = sum(len(line) for line in f)
    print(result)  # 13
