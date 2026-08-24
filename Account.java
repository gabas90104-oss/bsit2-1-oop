public abstract class Account {
    // TODO 1: change these three fields to private
    String accountNumber;
    String ownerName;
    double balance;
    public Account(String accountNumber, String ownerName, double openingBalance) {
// TODO 2: validate before assigning. Example:
// if (ownerName == null || ownerName.isBlank()) {
// throw new IllegalArgumentException(&quot;Owner name is required&quot;);
// }
// Do the same for accountNumber, and reject openingBalance &lt; 0.
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = openingBalance;
    }

    // TODO 3: write the three getters here.
// Remember: NO setBalance().
    public void deposit(double amount) {
// TODO 4: if amount &lt;= 0 -&gt; throw new IllegalArgumentException(&quot;...&quot;)
// otherwise -&gt; balance = balance + amount;
    }
    public void withdraw(double amount) throws InsufficientFundsException {
// TODO 5: if amount &lt;= 0 -&gt; throw new IllegalArgumentException(&quot;...&quot;)
// if amount &gt; balance -&gt; throw new InsufficientFundsException(amount - balance)
// otherwise -&gt; balance = balance - amount;
    }
    // TODO 6: leave this abstract. Each child class will answer it differently.
    public abstract String getAccountType();
    // TODO 7: this helper is for your subclasses only.
// protected means: visible to child classes, hidden from everyone else.
    protected void applyWithdrawal(double amount) {
// balance = balance - amount;
    }
    @Override
    public String toString() {
        return getAccountType() + ""; ""; + accountNumber + ""; (""; + ownerName + "";)"";;
    }
}