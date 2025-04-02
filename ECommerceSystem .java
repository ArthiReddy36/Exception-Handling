public class ECommerceSystem {

    public static void main(String[] args) {
        ECommerceSystem system = new ECommerceSystem();
        
        
        try {
            system.purchaseProduct(1001, "creditCard");
            system.purchaseProduct(1005, "debitCard");
            system.purchaseProduct(1002, "bitcoin");
        } catch (ProductNotFoundException | InvalidPaymentMethodException e) {
            
            System.out.println("Error: " + e.getMessage());
        }
    }

    
    public void purchaseProduct(int productId, String paymentMethod) throws ProductNotFoundException, InvalidPaymentMethodException {
        
        if (productId == 1005) {
            throw new ProductNotFoundException("Product with ID " + productId + " not found.");
        }
        
       
        if (!paymentMethod.equals("creditCard") && !paymentMethod.equals("debitCard")) {
            throw new InvalidPaymentMethodException("Payment method " + paymentMethod + " is not supported.");
        }
        
        
        System.out.println("Product with ID " + productId + " purchased using " + paymentMethod + "!");
    }
}


class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}


class InvalidPaymentMethodException extends Exception {
    public InvalidPaymentMethodException(String message) {
        super(message);
    }
}
