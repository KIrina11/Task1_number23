package ru.vsu.cs.kislova_i_v;

public class Credit {
    public double sumOfCredit;
    public int creditTermInMonths;
    public double fixedInterestRate;
    public int creditRepaymentMethod;

    public Credit(double sumOfCredit, int creditTermInMonths, double fixedInterestRate, int creditRepaymentMethod) {
        this.sumOfCredit = sumOfCredit;
        this.creditTermInMonths = creditTermInMonths;
        this.fixedInterestRate = fixedInterestRate;
        this.creditRepaymentMethod = creditRepaymentMethod;
    }

    public static double calculateSumOfPaymentInNMonthDifferentiated(int nMonth, Credit credit) {
        double monthFixedInterestRate = credit.fixedInterestRate / 100 / 12;
        double monthlyPayment = 0;
        double debtPartOfMonthlyPayment = credit.sumOfCredit / credit.creditTermInMonths;
        double sum = credit.sumOfCredit;

        for (int i = 0; i < nMonth; i++) {
            double percentagePartOfMonthlyPayment = sum * monthFixedInterestRate;
            monthlyPayment = debtPartOfMonthlyPayment + percentagePartOfMonthlyPayment;
            sum = sum - debtPartOfMonthlyPayment;
        }

        return monthlyPayment;
    } //долговая часть всегда остается одинаковой для каждого месяца

    public static double calculateSumOfPaymentInNMonthAnnuity(Credit credit) {
        double monthFixedInterestRate = credit.fixedInterestRate / 100 / 12;
        double monthlyPayment = 0;

        return monthlyPayment = credit.sumOfCredit * (monthFixedInterestRate +
                (monthFixedInterestRate / (Math.pow(1 + monthFixedInterestRate, credit.creditTermInMonths) - 1)));
    } //ежемесячный платеж при аннуитетном способе погашения кредита одинаковый для каждого месяца

    public static double calculateTotalSumOfPaymentDifferentiated(Credit credit) {
        double monthFixedInterestRate = credit.fixedInterestRate / 100 / 12;
        double totalSumOfPayment = 0;
        double debtPartOfMonthlyPayment = credit.sumOfCredit / credit.creditTermInMonths;

        for (int i = 0; i < credit.creditTermInMonths; i++) {
            double percentagePartOfMonthlyPayment = credit.sumOfCredit * monthFixedInterestRate;
            double monthlyPayment = debtPartOfMonthlyPayment + percentagePartOfMonthlyPayment;
            credit.sumOfCredit = credit.sumOfCredit - debtPartOfMonthlyPayment;

            totalSumOfPayment = totalSumOfPayment + monthlyPayment;
        }

        return totalSumOfPayment;
    }

    public static double calculateTotalSumOfPaymentAnnuity(Credit credit) {
        double monthFixedInterestRate = credit.fixedInterestRate / 100 / 12;
        double totalSumOfPayment = 0;
        double monthlyPayment = credit.sumOfCredit * (monthFixedInterestRate +
                (monthFixedInterestRate / (Math.pow(1 + monthFixedInterestRate, credit.creditTermInMonths) - 1)));

        for (int i = 0; i < credit.creditTermInMonths; i++) {
            double percentagePartOfMonthlyPayment = credit.sumOfCredit * monthFixedInterestRate;
            double debtPartOfMonthlyPayment = monthlyPayment - percentagePartOfMonthlyPayment;
            credit.sumOfCredit = credit.sumOfCredit - debtPartOfMonthlyPayment;

            totalSumOfPayment = totalSumOfPayment + monthlyPayment;
        }

        return totalSumOfPayment;
    }
}
