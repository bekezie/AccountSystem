package Part2;

import Part1.Account;
import Part1.Date;

import java.util.Scanner;
public class AccountDemo {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        Account account1;
        boolean start = true;
        boolean validate1 = true;
        boolean validate;
        boolean validate2;
        String bankinput;



        while(start) {
            System.out.println("Account");
            System.out.println("Enter id number and initial Deposit:");
            String id = keyboard.next();
            String userID = IdCheck(id);
            double userInput;

            validate = true;
            while (validate)
            {

                if(userID == null)
                {
                    System.out.println("Id number contain 1 digit and cannot be negative.");
                    System.out.println("Try again.");
                    id = keyboard.next();
                    userID = IdCheck(id);
                }
                else
                    validate = false;
            }

            String input = keyboard.next();
            userInput = IntegerCheck(input);
            double initial = userInput;

            //For the purpose of this midterm my assumption is that I am using a default date
            Date theDate = new Date("November", 1, 2020);

            //For the purpose of this midterm my assumption is that I am using a default annual interest rate
            account1 = new Account(id, initial, 4.5, theDate);
            //account1.setDate(theDate);
            //account1.setAnnualInterestRate(Interest);

            System.out.println("Id number: " + account1.getID());
            System.out.printf("Initial balance: $%.2f", account1.getBalance());
            System.out.println();
            System.out.println("Entry of funds was completed on " + account1.getDate() + ".");
            System.out.printf("Annual interest rate: $%.3f", account1.getAnnualInterestRate());
            System.out.println();
            System.out.printf("Monthly interest rate: $%.3f", account1.getMonthlyInterestRate());
            System.out.println();
            //////////////////////////////////Second Half////////////////////////////////////
            validate2 = true;
            do {
                System.out.println("Select the following:");
                System.out.println("1: withdraw");
                System.out.println("2: deposit");
                System.out.println("3: exit");
                System.out.println("Enter a choice:");
                bankinput = keyboard.next();

                if (bankinput.equals("1")) {
                    //withdrawal
                    System.out.println("Enter Withdrawal amount:");
                    String input2 = keyboard.next();
                    userInput = IntegerCheck(input2);
                    double withdraw = userInput;
                    validate2 = true;

                    while (validate2)
                        try {
                            account1.withdraw(withdraw);
                            System.out.printf("Remaining balance: $%.2f", account1.getBalance());
                            System.out.println();
                            validate2 = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Try again.");
                            input2 = keyboard.next();
                            userInput = IntegerCheck(input2);
                            withdraw = userInput ;
                            System.out.println();
                        }
                }
                else if (bankinput.equals("2")) {
                    //deposit
                    System.out.println("Enter Deposit amount:");
                    String input3 = keyboard.next();
                    userInput = IntegerCheck(input3);
                    double deposit = userInput;
                    validate2 = true;

                    while (validate2)
                        try {
                            account1.deposit(deposit);
                            System.out.printf("Total balance: $%.2f", account1.getBalance());
                            System.out.println();
                            validate2 = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Try again.");
                            input3 = keyboard.next();
                            userInput = IntegerCheck(input3);
                            deposit = userInput;
                            System.out.println();
                        }
                    System.out.println();
                }
                else if (bankinput.equals("3")) {
                    System.out.println("Exiting bank account. Good Bye.");
                    validate1 = false;
                    start = true;
                }
                else {
                    System.out.println("Invalid response!");
                    System.out.println("Try again.");
                    System.out.println();
                    start = false;
                }

            }while (validate1);
        }
    }

    private static double IntegerCheck(String validInt)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean validate = true;
        while(validate)


            try {
                Float.parseFloat(validInt);
                //Integer.valueOf(validInt);
                validate = false;
                return Float.parseFloat(validInt);

            }

            catch (IllegalArgumentException e)
            {
                System.out.println("Not a valid integer.");
                System.out.println("Try again.");
                validInt =  keyboard.next();
            }

        return -1;
    }

    private static String IdCheck(String usersID) {

        switch (usersID) {
            case "0":

                return usersID;
            case "1":

                return usersID;
            case "2":

                return usersID;
            case "3":

                return usersID;
            case "4":

                return usersID;
            case "5":

                return usersID;
            case "6":

                return usersID;
            case "7":

                return usersID;
            case "8":

                return usersID;
            case "9":

                return usersID;
            default:
                return null;

        }
    }

}
