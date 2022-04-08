package ru.vsu.cs.kislova_i_v;

import org.junit.*;

public class Test {
    @BeforeClass
    public static void reportAboutStartOfTests() {
        System.out.println("Testing of the program begins...");
        System.out.println();
    }

    @Before
    public void reportOnTestOperation() {
        System.out.print("Test is running...");
    }

    @org.junit.Test
    public void testDifferentiatedMethod() {
        Credit credit = new Credit(200000, 24, 12, 0);
        int nMonth = 5;
        double sumOfPaymentInNMonth = Credit.calculateSumOfPaymentInNMonthDifferentiated(nMonth, credit);
        double totalSumOfPayment = Credit.calculateTotalSumOfPaymentDifferentiated(credit);
        Assert.assertEquals(sumOfPaymentInNMonth, 10000.0, 0.000000000000001);
        Assert.assertEquals(totalSumOfPayment, 224999.99999999997, 0.0000000000001);
    }

    @org.junit.Test
    public void testAnnuityMethod() {
        Credit credit = new Credit(200000, 24, 12, 1);
        int nMonth = 3;
        double sumOfPaymentInNMonth = Credit.calculateSumOfPaymentInNMonthAnnuity(credit);
        double totalSumOfPayment = Credit.calculateTotalSumOfPaymentAnnuity(credit);
        Assert.assertEquals(sumOfPaymentInNMonth, 9414.694444652936, 0.0000000000000000001);
        Assert.assertEquals(totalSumOfPayment, 225952.66667167048, 0.0000000000000000001);
    }

    @After
    public void reportCompletionOfTest() {
        System.out.println("Test execution completed");
    }

    @AfterClass
    public static void reportAboutEndOfTests() {
        System.out.println();
        System.out.print("Testing of the program is completed");
    }
}
