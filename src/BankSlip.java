import java.time.LocalDate;

public class BankSlip extends PaymentMethod{

    private String number;
    private final LocalDate creationDate;
    private final LocalDate expirationDate;

    public BankSlip() {
        this.creationDate = LocalDate.now();
        this.expirationDate = getCreationDate().plusDays(7);
    }

    public BankSlip(String number) {
        this();
        this.number = number;
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

}


