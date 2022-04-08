package ru.vsu.cs.kislova_i_v;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double sumOfCredit = inputSumOfCredit();
        int creditTermInMonths = inputCreditTermInMonths();
        double fixedInterestRate = inputFixedInterestRate();
        int creditRepaymentMethod = chooseCreditRepaymentMethod();

        Credit credit = new Credit(sumOfCredit, creditTermInMonths, fixedInterestRate, creditRepaymentMethod);

        int nMonth = inputNMonth(creditTermInMonths);

        if (creditRepaymentMethod == 0) { //дифференцированный платеж
            double sumOfPaymentInNMonthDifferentiated = Credit.calculateSumOfPaymentInNMonthDifferentiated(nMonth, credit);
            System.out.printf("Сумма платежа за %s месяц составляет %s рублей "
                    + "при дифференцированном способе погашения кредита", nMonth, sumOfPaymentInNMonthDifferentiated);
            double totalSumOfPaymentDifferentiated = Credit.calculateTotalSumOfPaymentDifferentiated(credit);
            System.out.println();
            System.out.printf("Общая сумма платежей по кредиту составляет %s рублей при дифференцированном способе "
                    + "погашения кредита", totalSumOfPaymentDifferentiated);
        } else { //аннуитетный платеж
            double sumOfPaymentInNMonthAnnuity = Credit.calculateSumOfPaymentInNMonthAnnuity(credit);
            System.out.printf("Сумма платежа за %s месяц составляет %s рублей "
                    + "при аннуитетном способе погашения кредита", nMonth, sumOfPaymentInNMonthAnnuity);
            double totalSumOfPaymentAnnuity = Credit.calculateTotalSumOfPaymentAnnuity(credit);
            System.out.println();
            System.out.printf("Общая сумма платежей по кредиту составляет %s рублей при аннуитетном способе "
                    + "погашения кредита", totalSumOfPaymentAnnuity);
        }
    }

    private static int inputNMonth(int creditTermInMonth) {
        System.out.println("Введите номер месяца, чтобы рассчитать сумму платежей в этот месяц");
        System.out.println("Месяц: ");
        Scanner scanner = new Scanner(System.in);
        int nMonth = scanner.nextInt();

        if (nMonth < 1 || nMonth > creditTermInMonth) {
            System.out.println("Неверно указан номер месяца. Попробуйте снова");
            return inputNMonth(creditTermInMonth);
        }

        return nMonth;
    }

    private static double inputSumOfCredit() {
        System.out.println("Укажите сумму кредита: ");
        Scanner scanner = new Scanner(System.in);
        double sumOfCredit = scanner.nextDouble();

        if (sumOfCredit < 1) {
            System.out.println("Неверно указана сумма кредита. Попробуйте снова");
            return inputSumOfCredit();
        }

        System.out.println();
        return sumOfCredit;
    }

    private static int inputCreditTermInMonths() {
        System.out.println("Укажите срок кредита в месяцах: ");
        Scanner scanner = new Scanner(System.in);
        int creditTermInMonths = scanner.nextInt();

        if (creditTermInMonths < 1) {
            System.out.println("Неверно указан срок кредита в месяцах. Попробуйте снова");
            return inputCreditTermInMonths();
        }

        System.out.println();
        return creditTermInMonths;
    }

    private static double inputFixedInterestRate() {
        System.out.println("Укажите фиксированную процентную ставку: ");
        Scanner scanner = new Scanner(System.in);
        double fixedInterestRate = scanner.nextDouble();

        if (fixedInterestRate <= 0) {
            System.out.println("Неверно указана фиксированная процентная ставка. Попробуйте снова");
            return inputFixedInterestRate();
        }

        System.out.println();
        return fixedInterestRate;
    }

    private static int chooseCreditRepaymentMethod() {
        System.out.println("Выберите способ погашения кредита:");
        System.out.println("1) Если платеж дифференцированный - введите 0");
        System.out.println("2) Если платеж аннуитетный - введите 1");
        Scanner scanner = new Scanner(System.in);
        int typeOfCredit = scanner.nextInt();

        if ((typeOfCredit != 0) && (typeOfCredit != 1)) {
            System.out.println("Неверно выбран способ погашения кредита. Попробуйте снова");
            return chooseCreditRepaymentMethod();
        }

        System.out.println();
        return typeOfCredit;
    }
}
