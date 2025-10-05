

public class BankAccountRunner {
    public static void main(String[] args) {
        BankService bankService = new BankService();

        bankService.addAccount("Сидоров", 1000);
        bankService.addAccount("Петров", 1500);


        System.out.println(bankService.getAllAccounts());
        System.out.println(bankService.findAccountByID(1).getTransactionHistory());

        bankService.transfer(1, 2, 300);

        System.out.println(bankService.findAccountByID(1).getTransactionHistory());
        System.out.println(bankService.findAccountByID(2).getTransactionHistory());

        System.out.println(bankService.getAllAccounts());
    }
}