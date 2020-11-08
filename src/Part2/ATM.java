package Part2;

import java.util.Scanner;

import Part1.Account;

public class ATM {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean start = true;
        boolean validate1;
        boolean validate2 = true;
        String bankinput;

        Account account[] = new Account[10];
        account[0] = new Account("0", 100);
        account[1] = new Account("1", 100);
        account[2] = new Account("2", 100);
        account[3] = new Account("3", 100);
        account[4] = new Account("4", 100);
        account[5] = new Account("5", 100);
        account[6] = new Account("6", 100);
        account[7] = new Account("7", 100);
        account[8] = new Account("8", 100);
        account[9] = new Account("9", 100);


        while (start) {

            System.out.println("ATM");
            System.out.println("Enter an id:");
            String id = keyboard.next();

            Account usersAccount = IdCheck(id, account);
            while (usersAccount == null) {
                System.out.println("Invalid response!");
                System.out.println("Id must be between 0 and 9.");
                System.out.println("Try again.");
                id = keyboard.next();
                usersAccount = IdCheck(id, account);
            }
            validate1 = true;

            do {
                System.out.println("Account: " + id);
                System.out.println("Main menu");
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.println("Enter a choice:");

                bankinput = keyboard.next();
                if (bankinput.equals("2")) {
                    //withdrawal
                    System.out.println("Enter an amount to withdraw:");
                    String input = keyboard.next();
                    while (validate2)
                        try {
                            Float.parseFloat(input);
                            validate2 = false;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid response!");
                            System.out.println("Try again.");
                            System.out.println();
                            System.out.println("Enter an amount to withdraw:");
                            input = keyboard.next();
                        }

                    double withdraw = Float.parseFloat(input);

                    try {
                        usersAccount.withdraw(withdraw);
                        //System.out.printf("Remaining balance: $%.2f", usersAccount.getBalance());
                        //System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Try again.");

                    }

                }

                else if (bankinput.equals("1")) {
                    System.out.printf("The balance is $%.2f", usersAccount.getBalance());
                    System.out.println();
                }

                else if (bankinput.equals("3")) {
                    System.out.println("Enter an amount to deposit:");
                    String input3 = keyboard.next();
                    validate2 = true;
                    while (validate2)
                        try {
                            Float.parseFloat(input3);
                            validate2 = false;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid response!");
                            System.out.println("Try again.");
                            System.out.println("Enter an amount to deposit:");
                            input3 = keyboard.next();
                            System.out.println();
                        }


                    double deposit = Float.parseFloat(input3);

                    try {
                        usersAccount.deposit(deposit);
                        //System.out.printf("Total balance: $%.2f", usersAccount.getBalance());
                        //System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Try again.");

                    }
                    System.out.println();
                }

                else if (bankinput.equals("4")) {
                    System.out.println("Exiting bank account. Good Bye account " + id + ".");
                    validate1 = false;

                }

                else {
                    System.out.println("Invalid response!");
                    System.out.println("Try again.");
                    System.out.println();
                }

            } while (validate1);
        }
    }

    private static Account IdCheck(String usersID, Account[] account) {

        switch (usersID) {
            case "0":

                return account[0];
            case "1":

                return account[1];
            case "2":

                return account[2];
            case "3":

                return account[3];
            case "4":

                return account[4];
            case "5":

                return account[5];
            case "6":

                return account[6];
            case "7":

                return account[7];
            case "8":

                return account[8];
            case "9":

                return account[9];
            default:
                return null;

        }
    }
}
