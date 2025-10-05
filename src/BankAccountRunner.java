

public class BankAccountRunner {
    public static void main(String[] args) {
        BankService bankService = new BankService();

        bankService.addAccount("Сидоров", 1000);

        bankService.getAllAccounts();

    }
}