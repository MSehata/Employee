/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employee;

/**
 *
 * @author MolokoSehata
 */

import java.util.Scanner;

public class Employee {
    private String name;
    private String surname;
    private double taxRate;
    private double salary;

    public Employee(String name, String surname, double taxRate, double salary) {
        this.name = name;
        this.surname = surname;
        this.taxRate = taxRate;
        this.salary = salary;
    }
    
    public static int findSmallest(int a, int b, int c) {
        int smallest = a;

        if (b < smallest) {
            smallest = b;
        }

        if (c < smallest) {
            smallest = c;
        }

        return smallest;
    }
    
    public static boolean isValidSalary(double salary) {
        return salary > 0;
    }

    public void displayInfo() {
        double monthlySalary = roundToTwoDecimalPlaces(salary);
        double yearlySalary = roundToTwoDecimalPlaces(salary * 12);
        double percentageOfTax = roundToTwoDecimalPlaces(taxRate * 100);
        double monthlyTax = roundToTwoDecimalPlaces(salary * taxRate);
        double annualTax = roundToTwoDecimalPlaces(monthlyTax * 12);
        double salaryAfterDeductionMonthly = roundToTwoDecimalPlaces(monthlySalary - monthlyTax);
        double salaryAfterDeductionAnnual = roundToTwoDecimalPlaces(yearlySalary - annualTax);

        System.out.printf("Name: %s\n", name);
        System.out.printf("Surname: %s\n", surname);
        System.out.printf("Monthly Salary: R%.2f\n", monthlySalary);
        System.out.printf("Yearly Salary: R%.2f\n", yearlySalary);
        System.out.printf("Percentage of Tax: %.2f%%\n", percentageOfTax);
        System.out.printf("Monthly Tax: R%.2f\n", monthlyTax);
        System.out.printf("Annual Tax: R%.2f\n", annualTax);
        System.out.printf("Salary after Deduction (Monthly): R%.2f\n", salaryAfterDeductionMonthly);
        System.out.printf("Salary after Deduction (Annual): R%.2f\n", salaryAfterDeductionAnnual);
    }

    private double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Surname: ");
        String surname = scanner.nextLine();        
        
        double taxRate;        
        
        double salary = 0;
        boolean validSalary = false ;        
        
        do {
            System.out.print("Enter Gross Monthly Salary: ");
            if (scanner.hasNextDouble()) {
                salary = scanner.nextDouble();
                validSalary = isValidSalary(salary);

                if (!validSalary) {
                    System.out.println("Invalid salary. Please enter a positive value.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid double value.");
                scanner.next(); 
            }
        } 
        while (!validSalary);
        
        
        if (salary >=1 && salary <= 226000/12)
        {
           taxRate = 0.18; 
        }
        else if(salary >=226001/12 && salary <= 353100/12)
        {
            taxRate = 0.26;
        }
        else if(salary >= 353101/12 && salary <= 488700/12)
        {
           taxRate = 0.31; 
        }
        else if(salary >=488701/12 && salary <= 641400/12)
        {
           taxRate = 0.36; 
        }
        else if(salary >=641401/12 && salary <= 817600/12)
        {
           taxRate = 0.38; 
        }
        else if(salary >=817601/12 && salary <= 1731600/12)
        {
           taxRate = 0.41; 
        }
        else
        {
           taxRate = 0.45;
        }

        Employee employee = new Employee(name, surname, taxRate, salary);
        employee.displayInfo();         
        

        System.out.print("\nEnter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter the third number: ");
        int num3 = scanner.nextInt();

        int smallest = findSmallest(num1, num2, num3);

        System.out.println("\nThe smallest number is: " + smallest); 
        
        double average = calculateAverage(num1, num2, num3);

        System.out.println("\nThe average is: " + average);
        
        average = Math.round(average);
        checkOddEven(average);
        
        scanner.close(); 
    }
    
     public static void checkOddEven(double average) {
        if (average % 2 == 0) {
            System.out.println("The average is not odd (it is even).");
        } else {
            System.out.println("The average is odd.");
        }
    }
     
      public static double calculateAverage(int a, int b, int c) {
        return (a + b + c) / 3.0;        
    }
}
