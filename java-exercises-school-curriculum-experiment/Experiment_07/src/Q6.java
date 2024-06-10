/**
 * @Project_Name: java-school-curriculum-experiment
 * @Package_Name: PACKAGE_NAME
 * @File: Q6
 * @Version: 1.0.0
 * @Author: 榭壹Shey
 * @Created: 2023-11-26 17:53
 * @Last_Modified: 2023-11-26 17:53
 * @Description: No Description
 */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public double div(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("除数不能为零");
        }
        return (double) a / b;
    }
}


public class Q6 {
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        calculator = null;
    }

    @Test
    public void testAdd() {
        assertEquals(3, calculator.add(1, 2));
        assertEquals(-1, calculator.add(1, -2));
        assertEquals(0, calculator.add(0, 0));
    }

    @Test
    public void testSub() {
        assertEquals(-1, calculator.sub(1, 2));
        assertEquals(3, calculator.sub(1, -2));
        assertEquals(0, calculator.sub(0, 0));
    }

    @Test
    public void testMul() {
        assertEquals(6, calculator.mul(2, 3));
        assertEquals(-6, calculator.mul(2, -3));
        assertEquals(0, calculator.mul(0, 0));
    }

    @Test
    public void testDiv() {
        assertEquals(2, calculator.div(6, 3), 0);
        assertEquals(-2, calculator.div(6, -3), 0);
        assertEquals(Double.POSITIVE_INFINITY, calculator.div(1, 0), 0);
    }
}
