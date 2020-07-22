import java.time.LocalDate;

public class BankSlip extends PaymentMethod{

    private String number;
    private LocalDate creationDate;
    private LocalDate expirationDate;

     public BankSlip(String number, LocalDate creationDate, LocalDate expirationDate) {
        this.number = number;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
