package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Tax payer #" + (i+1) + " data: ");
            System.out.print("Individual or company ( i / c ) ?");
            char iOrC = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();
            if (iOrC == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name, anualIncome, healthExpenditures));
            }
            else {
                System.out.print("Number of employees: ");
                int numberOfEmployee = sc.nextInt();
                list.add(new Company(name, anualIncome, numberOfEmployee));
            }
        }

        // displays taxes paid.
        System.out.println();
        System.out.println("TAX PAID: ");
        for (TaxPayer tp : list) {
            System.out.println(tp.getName() +" $ " +String.format("%.2f", tp.tax()));
        }

        // sum display taxes paid.
        double sum = 0;
        for (TaxPayer sumTax : list) {
            sum += sumTax.tax();
        }
        System.out.println();
        System.out.println("TOTAL TAXES: " + " $ " + sum);
    }
}
