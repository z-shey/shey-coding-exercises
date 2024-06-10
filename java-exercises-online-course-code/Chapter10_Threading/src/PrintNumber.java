class Number implements Runnable{

    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {

                this.notify();

                if (number <= 100) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + number);
                    number++;

                    try {
                        this.wait(); // 等待状态，同时会释放同步监视器
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}

public class PrintNumber {
    public static void main(String[] args) {
        Number number = new Number();

        Thread thread1 = new Thread(number, "Thread 1 -> ");
        Thread thread2 = new Thread(number, "Thread 2 -> ");

        thread1.start();
        thread2.start();
    }
}
