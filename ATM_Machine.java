package CodeSoftProject;

import java.util.Scanner;

interface ATM{
    double withdrawing();
    double depositing(double amount);
    void checkingBalance();
}

class userAccount implements ATM{

    double value = 0;

    @Override
    public double withdrawing() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Amount to withdraw in your account: ");
        double withrow = sc.nextInt();
        if (withrow<=value){
            value = value - withrow;
            System.out.println("Successfully Withdraw amount of "+withrow);
            System.out.println("Thank You...");
        }else {
            System.out.println("You have not sufficient balance in your account for withdrawal...");
            System.out.println("Thank You...");
        }
        return value;
    }

    @Override
    public double depositing(double amount) {
         value = value + amount;
         return value;
    }

    @Override
    public void checkingBalance() {
        System.out.println("Total Balance in your account is: "+value);
        System.out.println("Thank You...");
    }
}

public class ATM_Machine extends userAccount {
    public static void main(String[] args) {
        ATM_Machine am = new ATM_Machine();
        Scanner sc = new Scanner(System.in);
        int a;
        double amount;
        do {
            System.out.print("1.Depositing the amount\n2.Withdraw the amount\n3.Checking Balance\nEnter Your Choice: ");
            int choice = sc.nextInt();
            // using enhance switch case
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Deposit Amount: ");
                    amount = sc.nextDouble();
                    am.depositing(amount);
                    System.out.println("Successfully Deposit your Amount in your Account...");
                    System.out.println("Thank You...");
                }
                case 2 -> {
                    am.withdrawing();
                }
                case 3 -> {
                    am.checkingBalance();
                }
                default -> {
                    System.out.println("Please Choice one of the options...");
                }
            }
            System.out.print("Enter 1 if you want to deposit and throw thw amount otherwise press any other number: ");
            a = sc.nextInt();
        }while (a==1);
        System.out.print("Successfully Exit to the ATM Machine.\nThank You...");

    }
}
