public class CheckingAccount extends Account {
    private double overdraftLimit; // example: 1000.0
    public CheckingAccount(String accountNumber, String ownerName,
                           double openingBalance, double overdraftLimit) {
// TODO 1: super(...) first, then store overdraftLimit
    }
    @Override
    public String getAccountType() {
// TODO 2: return &quot;CHECKING&quot;;
        return "";;
    }
    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
// TODO 3: reject amounts that are zero or negative first.
//
// A checking account MAY go negative, but never past the overdraft
// limit. So refuse the withdrawal when:
// (getBalance() - amount) &lt; -overdraftLimit
// and throw a new InsufficientFundsException with the shortfall.
//
// Otherwise call the protected helper you wrote in Task 1:
// applyWithdrawal(amount);
//
// NOTE: do NOT call super.withdraw(amount) here -- the parent
// version refuses any negative balance, which is exactly the
// rule this account is meant to relax.
    }
}