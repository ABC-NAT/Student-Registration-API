public class BankTransferPayment extends Payment {

    private String bankName;

    public BankTransferPayment(String transactionID, double amount, String bankName) {
        super(transactionID, amount);
        this.bankName = bankName;
    }

    public void processPayment(){
        System.out.println("Processing bank transfer...");
    }
    
}
