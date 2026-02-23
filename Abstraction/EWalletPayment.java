public class EWalletPayment extends CreditCardPayment {
    
    private String phoneNumber;

    public EWalletPayment(String transactionId, double amount, String phoneNumber) {
        super(transactionId, amount, phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public void processPayment() {
        System.out.println("Processing e-wallet payment..");
    }
}
