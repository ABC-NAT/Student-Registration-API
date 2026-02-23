public class CreditCardPayment extends Payment {

    private String cardNumber;

    public CreditCardPayment(String transactionID, double amount, String cardNumber){
        super(transactionID, amount);
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(){
        System.out.println("Processing credit card payment...");
    }
    
}
