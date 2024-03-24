import java.util.Scanner;

public class oopDesignBankingSystem {
    static class account {
        private int accountNumber;
        private String accountHolderName;
        private double balance;
        private String accountType;
        private boolean accountStatus;
        private String accountOpenDate;

        // Default Constructor
        account() {
            accountNumber = generateAccountNumber();
            accountHolderName = "John Doe";
            balance = 100.00;
            accountType = "Savings";
            accountStatus = true;
            accountOpenDate = "3/18/2024";
        }

        // Parameterized Constructor
        account(String accountHolderName, double balance, String accountType, boolean accountStatus, String accountOpenDate) {
            this.accountNumber = generateAccountNumber();
            this.accountHolderName = accountHolderName;
            this.balance = balance;
            this.accountType = accountType;
            this.accountStatus = accountStatus;
            this.accountOpenDate = accountOpenDate;
        }

        private int generateAccountNumber() {
            // Generate a random 8-digit account number
            int min = 10000000;
            int max = 99999999;
            return (int) (Math.random() * (max - min + 1) + min);
        }
        public int getAccountNumber(){
            int min = 5;
            int max = 8;

            System.out.println("Random value in int from "+min+" to "+max+ ":");
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            System.out.println(random_int);
            return min;
        }

        public double deposit(double depositAdd) {
            balance = balance + depositAdd;
            return balance;
        }

        public double withdraw(double depositMinus) {
            balance = balance - depositMinus;
            if (depositMinus > balance) {
                System.out.println("You cannot withdraw," +
                        " more than you have");

            }
            return balance;

        }

        public String getAccountHolderName() {
            System.out.println(accountHolderName);
            return accountHolderName;
        }

        public String getAccountType() {
            System.out.println(accountType);
            return accountType;
        }

        public String setAccountType(String accountType) {
            this.accountType = accountType;
            System.out.println("Your new account type is " + accountType);
            return accountType;
        }

        public String getAccountOpenDate() {
            System.out.println(accountOpenDate);
            return accountOpenDate;
        }

        public double getBalance() {
            System.out.println(balance);
            return balance;
        }

        public boolean getAccountStatus() {
            System.out.println(accountStatus);
            return accountStatus;
        }

        public boolean setAccountStatus(boolean accountStatus) {
            this.accountStatus = accountStatus;
            System.out.println("Your new account status is " + accountStatus);
            return accountStatus;
        }

        public void closeAccount() {
            accountOpenDate = null;
            accountStatus = false;
            accountType = null;
            balance = 0;
            accountHolderName = null;
            accountNumber = 0;
            System.out.println("Account has been successfully deleted");
        }

        public void viewStatement() {
            System.out.println("Your account status is" + accountStatus);
            System.out.println("Your account type is" + accountType);
            System.out.println("Your account number is " + accountNumber);
            System.out.println("You opened your account on " + accountOpenDate);
            System.out.println("You have" + balance + "in the account ");
        }

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Please enter your name:");
                String accountHolderName = scanner.nextLine();
                System.out.println("Your account has R50 in credit.");
                double balance = 50;
                System.out.println("Please choose an account type:\n1.) Savings\n2.) Cheque\n3.) Credit");
                int accountType = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                String selectAccount;

                switch (accountType) {
                    case 1:
                        selectAccount = "Savings";
                        break;
                    case 2:
                        selectAccount = "Cheque";
                        break;
                    case 3:
                        selectAccount = "Credit";
                        break;
                    default:
                        selectAccount = "Unknown"; // Handle unexpected input
                        break;
                }

                boolean accountStatus = true;
                String accountOpenDate = "3/18/2024";
                System.out.println("Do you want to add the user? (yes/no)");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("yes")) {
                    account newUser = new account(accountHolderName, balance, selectAccount, accountStatus, accountOpenDate);
                    System.out.println("User Successfully Created!\n");
                    System.out.println("Do you want to perform any transactions? (yes/no)");
                    choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("yes")) {
                        while (true) {
                            System.out.println("1.) Deposit Money\n2.) Withdraw\n3.) Get Account Holder Name\n4.) Get Account Type\n5.) Get Account Open Date\n6.) Get Account Balance\n7.) Get Account Status\n8.) Set Account Status\n9.) Close Account\n10.) View Statement\n11.) Exit");
                            int choice1 = scanner.nextInt();
                            scanner.nextLine(); // Consume newline character

                            switch (choice1) {
                                case 1:
                                    System.out.println("How much would you like to deposit?");
                                    double depositAmount = scanner.nextDouble();
                                    newUser.deposit(depositAmount);
                                    break;
                                case 2:
                                    System.out.println("How much would you like to withdraw?");
                                    double withdrawAmount = scanner.nextDouble();
                                    newUser.withdraw(withdrawAmount);
                                    break;
                                case 3:
                                    System.out.println("Account Holder Name: " + newUser.getAccountHolderName());
                                    break;
                                case 4:
                                    System.out.println("Account Type: " + newUser.getAccountType());
                                    break;
                                case 5:
                                    System.out.println("Account Open Date: " + newUser.getAccountOpenDate());
                                    break;
                                case 6:
                                    System.out.println("Account Balance: " + newUser.getBalance());
                                    break;
                                case 7:
                                    System.out.println("Account Status: " + newUser.getAccountStatus());
                                    break;
                                case 8:
                                    System.out.println("Enter new account status (true/false):");
                                    boolean newStatus = scanner.nextBoolean();
                                    newUser.setAccountStatus(newStatus);
                                    break;
                                case 9:
                                    newUser.closeAccount();
                                    return;
                                case 10:
                                    newUser.viewStatement();
                                    break;
                                case 11:
                                    return;
                                default:
                                    System.out.println("Invalid choice.");
                            }
                        }
                    } else if (choice.equalsIgnoreCase("no")) {
                        break; // Exit loop if the user chooses not to perform transactions
                    }
                } else if (choice.equalsIgnoreCase("no")) {
                    break; // Exit loop if the user chooses not to add a new user
                }
            }
        }}}
