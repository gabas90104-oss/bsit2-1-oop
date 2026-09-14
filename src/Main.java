import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PaymentGateway gateway = new PaymentGateway();

        int choice;

        do {
            System.out.println();
            System.out.println("=================================");
            System.out.println("          LICEO PAY");
            System.out.println("=================================");
            System.out.println("1. Make Payment");
            System.out.println("2. Show All Receipts");
            System.out.println("3. Find Payment");
            System.out.println("4. Total Collected");
            System.out.println("5. Refund All");
            System.out.println("6. Service Fees");
            System.out.println("0. Exit");
            System.out.println("=================================");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.println();
                    System.out.println("--- MAKE PAYMENT ---");

                    System.out.print("Enter payment ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println();
                    System.out.println("Choose payment method:");
                    System.out.println("1. GCash");
                    System.out.println("2. Maya");
                    System.out.println("3. Cash");
                    System.out.print("Enter choice: ");

                    int method = scanner.nextInt();
                    scanner.nextLine();

                    Payment payment;

                    if (method == 1) {
                        System.out.print("Enter mobile number: ");
                        String mobile = scanner.nextLine();

                        payment = new GCashPayment(id, name, amount, mobile);
                        gateway.add(payment);

                        payment.printReceipt();
                        payment.pay();
                        payment.printThankYou();

                    } else if (method == 2) {
                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();

                        payment = new MayaPayment(id, name, amount, email);
                        gateway.add(payment);

                        payment.printReceipt();
                        payment.pay();
                        payment.printThankYou();

                    } else if (method == 3) {

                        payment = new CashPayment(id, name, amount);
                        gateway.add(payment);

                        payment.printReceipt();
                        payment.pay();
                        payment.printThankYou();

                    } else {
                        System.out.println("Invalid payment method.");
                    }

                    break;

                case 2:
                    System.out.println();
                    System.out.println("--- ALL RECEIPTS ---");

                    gateway.printAllReceipts();

                    break;

                case 3:
                    System.out.println();
                    System.out.println("--- FIND PAYMENT ---");

                    System.out.print("Enter payment ID: ");
                    int searchId = scanner.nextInt();

                    Payment found = gateway.findById(searchId);

                    if (found != null) {
                        found.printReceipt();
                    } else {
                        System.out.println("Payment not found.");
                    }

                    break;

                case 4:
                    System.out.println();
                    System.out.println("--- TOTAL COLLECTED ---");

                    System.out.printf(
                            "Total collected: PHP %.2f%n",
                            gateway.totalCollected()
                    );

                    break;

                case 5:
                    System.out.println();
                    System.out.println("--- REFUND ALL ---");

                    gateway.refundAll();

                    break;

                case 6:
                    System.out.println();
                    System.out.println("--- SERVICE FEES ---");

                    System.out.printf(
                            "Standard service fee (2%%): PHP %.2f%n",
                            gateway.totalCollected() * 0.02
                    );

                    System.out.printf(
                            "Student service fee (1%%): PHP %.2f%n",
                            gateway.totalCollected() * 0.01
                    );

                    break;

                case 0:
                    System.out.println();
                    System.out.println("Thank you for using Liceo Pay!");

                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}