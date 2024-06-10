class SaleTickets implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket >= 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println(Thread.currentThread().getName() + "Selling ticket No." + ticket);
                    ticket--;
                }
            } else {
                System.out.println("Ticket is sold out.");
                break;
            }
        }
    }
}

class SaleTicketsSafe implements Runnable {
    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {

            synchronized (obj) {
                if (ticket >= 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        System.out.println(Thread.currentThread().getName() + "Selling ticket No." + ticket);
                        ticket--;
                    }
                } else {
                    System.out.println("Ticket is sold out.");
                    break;
                }
            }

        }
    }
}

class SaleTicketsThis implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {

            synchronized (this) {
                if (ticket >= 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        System.out.println(Thread.currentThread().getName() + "Selling ticket No." + ticket);
                        ticket--;
                    }
                } else {
                    System.out.println("Ticket is sold out.");
                    break;
                }
            }

        }
    }
}

class SaleTicketsExtends extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {

//            synchronized (this) {
            synchronized (SaleTicketsExtends.class) {
                if (ticket >= 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        System.out.println(Thread.currentThread().getName() + "Selling ticket No." + ticket);
                        ticket--;
                    }
                } else {
                    System.out.println("Ticket is sold out.");
                    break;
                }
            }

        }
    }
}

class SaleMethod implements Runnable{
    private int ticket = 100;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            SMethod();
        }
    }

    public synchronized void SMethod() {
        if (ticket >= 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println(Thread.currentThread().getName() + "Selling ticket No." + ticket);
                ticket--;
            }
        } else {
            System.out.println("Ticket is sold out.");
            flag = false;
        }
    }
}

public class ThreadSynchronizedExample {
    public static void main(String[] args) {
        SaleTickets saleTickets = new SaleTickets();
        SaleTicketsSafe saleTicketsSafe = new SaleTicketsSafe();
        SaleTicketsThis saleTicketsThis = new SaleTicketsThis();

        SaleTicketsExtends saleTicketsExtends1 = new SaleTicketsExtends();
        SaleTicketsExtends saleTicketsExtends2 = new SaleTicketsExtends();
        SaleTicketsExtends saleTicketsExtends3 = new SaleTicketsExtends();

        SaleMethod saleMethod = new SaleMethod();

//        Thread thread1 = new Thread(saleTickets, "Windows 01 -> ");
//        Thread thread2 = new Thread(saleTickets, "Windows 02 -> ");
//        Thread thread3 = new Thread(saleTickets, "Windows 03 -> ");

//        Thread thread1 = new Thread(saleTicketsSafe, "Windows 01 -> ");
//        Thread thread2 = new Thread(saleTicketsSafe, "Windows 02 -> ");
//        Thread thread3 = new Thread(saleTicketsSafe, "Windows 03 -> ");

//        Thread thread1 = new Thread(saleTicketsThis, "Windows 01 -> ");
//        Thread thread2 = new Thread(saleTicketsThis, "Windows 02 -> ");
//        Thread thread3 = new Thread(saleTicketsThis, "Windows 03 -> ");

        Thread thread1 = new Thread(saleMethod, "Windows 01 -> ");
        Thread thread2 = new Thread(saleMethod, "Windows 02 -> ");
        Thread thread3 = new Thread(saleMethod, "Windows 03 -> ");

        thread1.start();
        thread2.start();
        thread3.start();

//        saleTicketsExtends1.start();
//        saleTicketsExtends2.start();
//        saleTicketsExtends3.start();
    }
}
