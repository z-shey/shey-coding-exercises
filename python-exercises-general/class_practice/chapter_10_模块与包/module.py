print("--------module content--------")

x = 123


def func1():
    pass


def func2():
    pass


def func3():
    pass


def get():
    print(x)


def change():
    global x
    x = 0

print(__name__)

if __name__ == '__main__':
    get()
    change()
else:
    print("被当做模块导入")
    pass