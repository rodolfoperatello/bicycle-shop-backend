import java.time.YearMonth;


public class CreditCard extends PaymentMethod{

    private String number, name;
    private int cvv;
    private YearMonth validThru;

    public CreditCard(){

    }

    public CreditCard(String number, String name, int cvv, YearMonth validThru) {
        this.number = number;
        this.name = name;
        this.cvv = cvv;
        this.validThru = validThru;
    }


    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getCvv(){
        return cvv;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public YearMonth getValidThru() {
        return validThru;
    }

    public void setValidThru(YearMonth validThru) {
        this.validThru = validThru;
    }
}
