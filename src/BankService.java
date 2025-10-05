import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BankService {

    private Map<Integer, BankAccount> accounts = new TreeMap<>();
    private int initialId = 1;


    public BankAccount addAccount(String ownerName, double startBalance) {
        BankAccount account = new BankAccount(initialId++, ownerName, startBalance);
        accounts.put(account.getId(), account);
        return account;
    }


    public List<BankAccount> findAccountByName(String owner) {
        return accounts.values().stream()
                .filter(name -> name.getOwner().equalsIgnoreCase(owner))
                .collect(Collectors.toList());
    }


    public BankAccount findAccountByID(int id) {
        return accounts.get(id);
    }

    public void transfer(int firstAccount, int secondAccount, double amount) throws InsufficientFundsException {
        BankAccount sourceAccount = findAccountByID(firstAccount);
        BankAccount destinationAccount = findAccountByID(secondAccount);

        if (sourceAccount == null && destinationAccount == null) {
            throw new IllegalArgumentException("Один из счетов не найден");
        }
        sourceAccount.withdraw(amount);
        destinationAccount.deposit(amount);
    }

    public List<BankAccount> getAllAccounts(){
        return new ArrayList<>(accounts.values());
    }

    public Map<String, List<BankAccount>> getAccountsByOwner() {
        return accounts.values().stream()
                .collect(Collectors.groupingBy(BankAccount::getOwner));
    }
}
