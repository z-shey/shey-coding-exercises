import java.util.concurrent.*;

class EvenSumTask implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 2; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += i;
                System.out.println(i);
            }

            Thread.sleep(100);
        }

        return sum;
    }
}

public class EvenSumExample {
    public static void main(String[] args) {
        EvenSumTask evenSumTask = new EvenSumTask();

        FutureTask futureTask = new FutureTask(evenSumTask);

        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            Object result = futureTask.get();
            System.out.println("Sum of even numbers from 2 to 100 -> " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
