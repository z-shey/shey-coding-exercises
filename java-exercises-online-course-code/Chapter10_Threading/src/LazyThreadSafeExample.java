class Bank {
    private static Bank instance = null;

    public Bank() {
    }

    public static synchronized Bank getInstance() {
        if (instance == null) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                instance = new Bank();
            }

        }

        return instance;
    }

    public static Bank getInstance1() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        instance = new Bank();
                    }

                }
            }

        }
        return instance;
    }

    public static Bank getInstance2() {
        synchronized (Bank.class) {
            if (instance == null) {

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    instance = new Bank();
                }

            }
        }

        return instance;
    }


}

public class LazyThreadSafeExample {
    static Bank bank1 = null;
    static Bank bank2 = null;

    public static void main(String[] args) {

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                bank1 = Bank.getInstance2();
            }
        };
        thread1.start();

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                bank2 = Bank.getInstance2();
            }
        };
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(bank1);
        System.out.println(bank2);
        System.out.println(bank1 == bank2);
    }
}
