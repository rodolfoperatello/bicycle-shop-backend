import java.time.LocalDate;

public class BankSlip extends PaymentMethod{

    private int number;
    private LocalDate creationDate, expirationDate;

    public BankSlip(){

    }

    public BankSlip(int number, LocalDate creationDate, LocalDate expirationDate) {
        this.number = number;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getNumber() {
        return number;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

}
