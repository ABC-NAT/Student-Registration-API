public abstract class Payment {

    private String transactionId;
    private double amount;


    public Payment(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public void printReceipt() {
        System.out.printf("Transaction ID: %s | Amount: %s", transactionId, amount);

    }

    public abstract void processPayment();

}