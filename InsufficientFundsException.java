public class InsufficientFundsException extends Exception {

    private final double shortfall;

    public InsufficientFundsException(double shortfall) {
        super("Insufficient funds. You are short by PHP";
        + String.format("%.2f";, shortfall));

// TODO 1: store the shortfall value in the field above
    }
// TODO 2: add a public getter named getShortfall()
}
try {
    System.out.print("Enter amount to withdraw:");
    double amount = Double.parseDouble(input.nextLine());
    account.withdraw(amount);
    System.out.printf("Withdrew PHP %.2f. New balance: PHP %.2f%",
                      amount, account.getBalance());
        try {
        System.out.print("Enter amount to withdraw: ");
        double amount = Double.parseDouble(input.nextLine());
        account.withdraw(amount);
        System.out.printf("Withdrew PHP %.2f. New balance: PHP %.2f%n",
                      amount, account.getBalance());

        } catch (InsufficientFundsException e) {
        System.out.println("Error: " + e.getMessage());
        System.out.printf("You need PHP %.2f more.%n", e.getShortfall());

        } catch (NumberFormatException e) {
        System.out.println("Error: Please type a number, not letters.");

        } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());

        } finally {
        System.out.println("---------------------------------");
}

