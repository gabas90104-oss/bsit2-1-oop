public class ATMService {

    // ---------- OVERLOADING: same name, different parameter lists ----------

    public void deposit(Account account, double amount) {
        account.deposit(amount);
        System.out.printf("Deposited PHP %.2f%n", amount);
    }

    public void deposit(Account account, double amount, String note) {
        // TODO 1: deposit the amount, then also print the note
    }

    // ---------- VARARGS: any number of amounts ----------

    public double depositAll(Account account, double... amounts) {
        double total = 0;
        // TODO 2: loop through amounts with a for-each loop,
        //         deposit each one, and add it to total
        return total;
    }
    // ---------- PASS-BY-VALUE: mutation vs. reassignment ----------

    public void tryToReplace(Account account) {
        account = new SavingsAccount("XX-000", "Ghost Account", 0, 0);
        System.out.println("Inside the method  : " + account);
        // TODO 3: in a comment, explain why the account variable in main()
        //         still points to the ORIGINAL account after this returns.
    }

    public void addBonus(Account account, double bonus) {
        account.deposit(bonus);
        // TODO 4: in a comment, explain why THIS change IS visible to main(),
        //         even though Java is pass-by-value.
    }

    // ---------- TRANSFER ----------

    public void transfer(Account from, Account to, double amount)
            throws InsufficientFundsException {
        // TODO 5: withdraw from 'from', then deposit into 'to'.
        //         Withdraw FIRST so that a failed withdrawal does not
        //         create money out of nowhere.
    }
}
