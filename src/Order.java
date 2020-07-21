import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

public class Order {

    private Product product;
    private Client client;
    private PaymentMethod paymentMethod;
    private LocalDate orderDate;
    private int quantitaty;
    private BigDecimal orderTotal;

    public Order(){

    }

    public Order(Product product, int quantitaty, PaymentMethod paymentMethod, Client client, LocalDate orderDate) {
        this.product = product;
        this.quantitaty = quantitaty;
        paymentMethodValidation(paymentMethod, orderDate);
        this.client = client;
        this.orderDate = orderDate;
        this.orderTotal = getOrderTotal(this.quantitaty, this.product.getPrice());
    }

    public void paymentMethodValidation(PaymentMethod paymentMethod, LocalDate orderDate){
        if (paymentMethod instanceof CreditCard) {
            YearMonth creditCardValidThru = ((CreditCard) paymentMethod).getValidThru();
            YearMonth convertOrderDate = YearMonth.from(orderDate);
            try {
                if (creditCardValidThru.isAfter(convertOrderDate)) {
                    this.paymentMethod = paymentMethod;
                    this.paymentMethod.setPaymentValue(getOrderTotal(this.quantitaty, this.product.getPrice()));
                } else {
                    throw new CreditCardException("Cartão de crédito expirado");
                }
            } catch (CreditCardException e) {
                System.out.println(e.getExceptionMsg());
            }
        } else {
            this.paymentMethod = paymentMethod;
            this.paymentMethod.setPaymentValue(getOrderTotal(this.quantitaty, this.product.getPrice()));
        }

    }

    public void increaseAmount() {
        this.orderTotal = getOrderTotal(this.quantitaty +=1, product.getPrice());
    }

    public void decreaseAmount(){
       this.orderTotal = getOrderTotal(this.quantitaty -=1, product.getPrice());
    }


    public void setQuantitaty(int quantitaty) {
        this.quantitaty = quantitaty;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        paymentMethodValidation(paymentMethod, this.orderDate);
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.getPaymentMethod().setPaymentValue(orderTotal);
        this.orderTotal = orderTotal;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public BigDecimal getOrderTotal(int quantitaty, BigDecimal productPrice) {
        BigDecimal convertQuantitaty = new BigDecimal(quantitaty);
        BigDecimal orderTotal = convertQuantitaty.multiply(productPrice);
        return orderTotal;
    }

    public Client getClient() {
        return client;
    }

    public int getQuantitaty() {
        return quantitaty;
    }

    public Product getProduct() {
        return product;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }


}
