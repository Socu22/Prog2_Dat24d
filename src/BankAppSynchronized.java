import java.time.LocalDate;
import java.util.ArrayList;

public class BankAppSynchronized {
    public static void main(String[] args) {
        Account a1 = new Account("Account", 1.5);
        Customer c1 = new Customer(a1);
        Customer c2 = new Customer(a1);
        c1.start();
        c2.start();

        try {
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        a1.printTransactions();



    }
}
class Customer extends Thread {
    Account acc;

    Customer(Account acc) {
        this.acc=acc;
    }

    @Override
    public void run() {
        acc.deposit(1000);
        acc.withdraw(10);
        acc.deposit(1000);
    }
}

class Account {
    private int accountNo;
    protected String owner;
    protected double balance;
    protected double interestRate;
    private ArrayList<Transactions> transactions = new ArrayList<>();
    static private int noOfAccount=1;



    Account(String ow, double rate) {
        accountNo = noOfAccount++;;
        owner = ow;
        interestRate = rate;
        balance = 0;

    }

   /* Account(String ow, int acc, double rate) {
        accountNo = acc;
        owner = ow;
        intRate = rate;
        balance = 0;

    }

    */

    public synchronized void deposit(double amount) {
        balance += amount;
        transactions.add(new Transactions("Indsat(+)",amount,balance));
    }

    public synchronized void withdraw(double amount) {
        balance -= amount;
        transactions.add(new Transactions("Indsat(-)",amount,balance));

    }

    public synchronized int annualInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        transactions.add(new Transactions("Rente", interestRate,balance));
        return 0;
    }

    public synchronized void amountNAnnualInterest(int years) {
        for (int i = 1; i <= years; i++) {
            annualInterest();


        }
        System.out.println(toString());
    }


    public void printTransactions(){
        System.out.println(this);
        System.out.println("Tekst\t\tDato\t\t\tbeløb\t\t\tsaldo");
        for (Transactions t: transactions) {
            System.out.println(t);

        }

    }


    public double getBalance() {
        return balance;
    }

    public int getAccountNo() {
        return accountNo;
    }

    @Override
    public String toString() {
        return String.format("kontonr %d: %s Balance: %fkr", accountNo, owner, balance);
    }
}
class Transactions {
    String text="";
    LocalDate localDate;
    double amount;
    double newBalance;

        public Transactions(String text, double amount, double newBalance) {
        this.text=text;
        localDate=LocalDate.now();
        this.amount=amount;
        this.newBalance=newBalance;

    }



    @Override
    public String toString() {
            //return text+"\t"+localDate+"\t"+amount+"\t"+newBalance;
            return String.format("%-5s: %-5s  %-15f %-5f",this.text,localDate,this.amount,this.newBalance);
    }


}
