import org.junit.Test;

interface IAverage {
    double average(double[] x);

    default double max(double[] x) {
        double max = Double.MIN_VALUE;
        for (double num : x) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    default double min(double[] x) {
        double min = Double.MAX_VALUE;
        for (double num : x) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}

class FinalExam implements IAverage {
    @Override
    public double average(double[] x) {
        double sum = 0;
        for (double num : x) {
            sum += num;
        }
        return sum / x.length;
    }
}

class StaffRecruit implements IAverage {
    @Override
    public double average(double[] x) {
        double sum = 0;
        for (double num : x) {
            if (num != max(x) && num != min(x)) {
                sum += num;
            }
        }
        return sum / 7;
    }

    @Override
    public double max(double[] x) {
        return IAverage.super.max(x); // 调用 父类的（IAverage.super） 寻找最大值（max）
    }

    @Override
    public double min(double[] x) {
        return IAverage.super.min(x);
    }
}

public class Q2 {
    @Test
    public void Q2Test() {
        double[] faceExamScore = {0.54, 0.56, 0.99, 0.23, 0.64, 0.69, 0.38};
        double[] finalExamScore = {50, 80, 90, 58, 85, 68, 86, 74, 32, 99, 89};


        StaffRecruit staffRecruit = new StaffRecruit();
        System.out.println("Face final score " + staffRecruit.average(faceExamScore));

        FinalExam finalExam = new FinalExam();
        System.out.println("Final exam score " + finalExam.average(finalExamScore));
    }
}