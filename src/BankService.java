import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BankService {

    private Map<Integer, BankAccount> accounts = new TreeMap<>();
    private int initialId = 1;


    public BankAccount addAccount (String ownerName, double startBalance){
        BankAccount account = new BankAccount(initialId++, ownerName, startBalance);
        accounts.put(initialId, account);
        return account;
    }


    public List<BankAccount> findAccountByName(String owner){
        return accounts.values().stream()
                .filter(a -> a.getOwner().equalsIgnoreCase(owner))
                .collect(Collectors.toList());
    }


    public BankAccount findAccountByID(int id){
        return accounts.get(id);
    }
}
