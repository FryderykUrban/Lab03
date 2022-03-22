package pakiecik;

public class Declaration {
    private String what;

    public String getWhat() {
        return what;
    }

    public int getAmount() {
        return amount;
    }

    public String getWho() {
        return who;
    }

    private int amount;
    private String who;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public Declaration( String who, String what, int amount,String status) {
        this.who = who;
        this.what = what;
        this.amount = amount;
        this.status=status;
    }
}
