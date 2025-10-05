
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        addToHistory("| Cчет создан с начальным балансом: " + startBalance);
    }

    private void addToHistory(String operation) {
        transactionHistory.add(LocalDateTime.now() + ": " + operation + " | Баланс: " + balance);
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Вносимая сумма должна быть положительной");
        }
        this.balance += amount;
        addToHistory("Пополнение: " + amount);

    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Снимаемая сумма должна быть положительной");
        }
        if(amount > balance){
            throw new InsufficientFundsException("На балансе не достаточно средств");
        }
        this.balance -= amount;
        addToHistory("Снятие: " + amount);

    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BankAccount that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("Счёт #%d | Владелец: %s | Баланс: %.2f", id, owner, balance);
    }

    public int getId() {
        return id;
    }
    public String getOwner() {
        return owner;
    }
    public List<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }
    public double getBalance() {
        return balance;
    }

}
