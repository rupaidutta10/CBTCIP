import java.util.Scanner;
import java.util.ArrayList;


public class Atm {
    private static int balance = 100000;
    private static ArrayList<String> transactionHistory = new ArrayList<>();
    private static final int CORRECT_USER_ID = 1234;
    private static final int CORRECT_PIN = 5678;
    private static boolean isLoggedIn = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

         while (true) {
            System.out.println("ATM");

            if (!isLoggedIn) {
                System.out.print("Enter Your User ID : ");
                int userId = sc.nextInt();
                System.out.print("Enter Correct PIN Number : ");
                int pin = sc.nextInt();
                isLoggedIn = authenticateUser(userId, pin);

                if (!isLoggedIn) {
                    if(userId!=CORRECT_USER_ID)
                    System.out.println("Invalid User ID .Please try again.");
                    if(pin!=CORRECT_PIN)
                    System.out.println("Invalid User PIN .Please try again.");
                    if(userId!=CORRECT_USER_ID && pin!=CORRECT_PIN)
                    System.out.println("You entered invalid  user id and pin .Please try again.");

                    continue;
                }
            }
            System.out.println("*_*_*_*_*_Welcome to ABC Bank ATM_*_*_*_*_*");
            System.out.println("Press 1 to Withdraw Cash");
            System.out.println("Press 2 to Deposit Cash");
            System.out.println("Press 3 to Check Your Account's Balance");
            System.out.println("Press 4 for Viewing Transaction History");
            System.out.println("Press 5 for Transfering Amount");
            System.out.println("Press 6 for LogOut");
            System.out.print("Select the operation that you want to perform: ");

            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter the amount to be withdrawn: ");
                    int withdrawAmount = sc.nextInt();
                    withdrawMoney(withdrawAmount);
                    break;

                case 2:
                    System.out.print("Enter the amount to be deposited: ");
                    int depositAmount = sc.nextInt();
                    depositMoney(depositAmount);
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    viewTransactionHistory();
                    break;

                case 5:
                    System.out.print("Enter the amount to transfer: ");
                    int transferAmount = sc.nextInt();
                    System.out.print("Enter the recipient's Account Number: ");
                    sc.nextLine(); // Consume the newline character after the previous input
                    String recipientAcNum = sc.nextLine();
                    transferAmount(transferAmount, recipientAcNum);
                    break;

                case 6:
                    System.out.println("Thank you for using our ATM. Visit Again ");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Your choice is Invalid ! Please try again later.");
                    break;
            }
        }
    }

    private static void withdrawMoney(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Your Cash is ready to be collected : ");
            transactionHistory.add("Withdrawal: -" + amount);
        } else {
            System.out.println("You have Insufficient Balance in your account ");
        }
        System.out.println();
    }

    private static void depositMoney(int amount) {
        balance += amount;
        System.out.println("Your money has been successfully deposited.");
        transactionHistory.add("Deposit: +" + amount);
        System.out.println();
    }

    private static void checkBalance() {
        System.out.println("Balance: " + balance);
        System.out.println();
    }

    private static void viewTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("Transaction history is empty.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
        System.out.println();
    }

    private static void transferAmount(int amount, String recipientAcNum) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Successfully transferred " + amount + " to " + recipientAcNum);
            transactionHistory.add("Transfer to " + recipientAcNum + ": -" + amount);
        } else {
            System.out.println("You have not sufficient Balance in your account ");
        }
        System.out.println();
    }
    private static boolean authenticateUser(int userId, int pin) {
        return (userId == CORRECT_USER_ID) && (pin == CORRECT_PIN);
    }
}
