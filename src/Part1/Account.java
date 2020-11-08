package Part1;

public class Account {
    private int id;
    private double balance;
    private double  annualInterestRate;
    private Date dateCreate;

    public Account()
    {
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreate = new Date("January", 1,  1000);
    }
    public Account(Account otherObject)
    {
        if(otherObject == null)
        {
            System.out.println("Account object cannot be null");
            System.exit(0);
        }
        id = otherObject.id;
        balance = otherObject.balance;
        annualInterestRate = otherObject.annualInterestRate;
        dateCreate = otherObject.dateCreate;
    }
    public Account(String aID, double aBalance) {

        try {
            setBalance(aBalance);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        setID(aID);
    }
    public Account(String aID, double aBalance, Double aInterestRate, Date aDate) throws Exception
    {

        try {
            setBalance(aBalance);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        setID(aID);

        setAnnualInterestRate(aInterestRate);

        if (aDate == null)
        {
            System.out.println("Fatal Error creating employee.");
            System.exit(0);
        }
        setDate(aDate);
    }

    public void setID(String aID)
    {

        if(aID.length() != 1 || aID.indexOf("-") > -1) {
            System.out.println("Invalid ID: " + aID);
            System.out.println("Id number contain 1 digit and cannot be negative.");
            System.out.println("Try again.");
        }

        try{
            Integer.parseInt(aID);
            id = Integer.parseInt(aID);

        }
        catch (NumberFormatException notInt) {
            System.out.println("Not a valid integer");
            System.out.println("Try again.");
        }
    }
    public int getID()
    {
        return id;
    }

    public void setBalance(double aBalance) throws Exception
    {
        if(aBalance < 0)
        {
            throw new Exception(" Initial deposit cannot be less than 0.");
        }

        balance = aBalance;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setAnnualInterestRate(double aInterestRate)
    {
        if(aInterestRate < 0)
        {
            System.out.println("Interest rate cannot be less than zero.");
        }
        annualInterestRate = aInterestRate/100;
    }

    public double getAnnualInterestRate()
    {
        return annualInterestRate;
    }

    public void setDate(Date aDate)
    {
        dateCreate = new Date(aDate);
    }

    public Date getDate()
    {
        return dateCreate;
    }

    public double getMonthlyInterestRate()
    {
        double monthlyinterest = annualInterestRate/12;
        return (balance * monthlyinterest);
    }

    public double deposit(double amount) throws Exception {
        if (amount > 0) {
            balance += amount;
            return balance;
        }
        else
            throw new Exception("Deposit cannot be least than or equal 0.");
    }

    public double withdraw(double amount) throws  Exception
    {
        if((amount > balance) || (amount < 0))
        {
            throw new Exception("Incapable withdrawal. Withdraw amount: $" + amount + ", Balance amount $" + balance + ".");
        }
        else
            balance -=amount;
        return balance;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null)
            return false;

        else if (getClass() != otherObject.getClass())
            return false;

        Account otherAccount = (Account) otherObject;
        return (id == otherAccount.id && balance == otherAccount.balance
                && annualInterestRate == otherAccount.annualInterestRate
                && dateCreate == otherAccount.dateCreate);
    }

    @Override
    public String toString()
    {
        return ("Id number: " + id + "\n" + "Initial balance: $" + balance + "\n" + "Entry of funds was completed on " + dateCreate + "\n" + "Annual interest rate: $" + annualInterestRate);
    }

}
