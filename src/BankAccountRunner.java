

public class BankAccountRunner {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1, "Петров", 1482);
        System.out.println(bankAccount.getTransactionHistory());
    }
}