
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private int id;
    private final String owner;
    private double balance;
    private final List<String> transactionHistory;

    public BankAccount(int id, String owner, double startBalance) {
        this.id = id;
        this.owner = owner;
        this.balance = startBalance;
        this.transactionHistory = new ArrayList<>();
        addToHistory("| Cчёт создан с начальным балансом: " + startBalance);
    }

    private void addToHistory(String operation) {
        transactionHistory.add(LocalDateTime.now() + ": " + operation + " | Баланс: " + balance);
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
