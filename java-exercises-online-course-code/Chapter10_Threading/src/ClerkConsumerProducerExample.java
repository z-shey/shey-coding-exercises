class Clerk {
    private int producerNumber = 0;

    public synchronized void addProducerNumber() {
        if (producerNumber >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            this.producerNumber++;
            System.out.println(Thread.currentThread().getName() + " Product -> " + producerNumber);

            notifyAll();
        }

    }

    public synchronized void minusProducerNumber() {

        if (producerNumber <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " Consume -> " + producerNumber);
            this.producerNumber--;

            notifyAll();
        }

    }
}

class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Producing...");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.addProducerNumber();
        }
    }
}

class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Consuming...");

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.minusProducerNumber();
        }
    }
}

public class ClerkConsumerProducerExample {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer producer1 = new Producer(clerk);
//        Producer producer2 = new Producer(clerk);
//        Producer producer3 = new Producer(clerk);
//        Producer producer4 = new Producer(clerk);

        Consumer consumer1 = new Consumer(clerk);
        Consumer consumer2 = new Consumer(clerk);
        Consumer consumer3 = new Consumer(clerk);
        Consumer consumer4 = new Consumer(clerk);

        producer1.setName("Producer 1");
//        producer2.setName("Producer 2");
//        producer3.setName("Producer 3");
//        producer4.setName("Producer 4");

        consumer1.setName("Consumer 1");
        consumer2.setName("Consumer 2");
        consumer3.setName("Consumer 3");
        consumer4.setName("Consumer 4");

        producer1.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
    }
}
