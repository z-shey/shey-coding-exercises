import java.util.concurrent.locks.ReentrantLock;
class SaleTicketsE extends Thread {
    private static int ticket = 100;
    private static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            try {
                lock.lock();

                if (ticket >= 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + " Selling ticket No." + ticket);
                    ticket--;
                } else {
                    System.out.println("Ticket is sold out.");
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

public class ReentrantLockExample {
    public static void main(String[] args) {
        SaleTicketsE saleTicketsE1 = new SaleTicketsE();
        SaleTicketsE saleTicketsE2 = new SaleTicketsE();
        SaleTicketsE saleTicketsE3 = new SaleTicketsE();

        saleTicketsE1.setName("Windows 1 -> ");
        saleTicketsE2.setName("Windows 2 -> ");
        saleTicketsE3.setName("Windows 3 -> ");

        saleTicketsE1.start();
        saleTicketsE2.start();
        saleTicketsE3.start();
    }
}
