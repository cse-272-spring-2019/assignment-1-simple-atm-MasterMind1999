package sample;

import java.util.Date;
import java.util.ArrayList;
public class Transaction {
    private double amount;
    private Date timeTamp;
    private String memo;
    private Account inAccount ;
    public Transaction(double amount ,Account inAccount) {
        this.amount=amount;
        this.inAccount=inAccount;
        this.timeTamp=new Date();
        this.memo="";
    }
    public Transaction(double amount ,String memo,Account inAccount) {
        this.amount=amount;
        this.inAccount=inAccount;
        this.timeTamp=new Date();
        this.memo=memo;
    }
    public double getAmount() {
        // TODO Auto-generated method stub
        return this.amount;
    }
    public String getSummaryLine() {
        // TODO Auto-generated method stub
        if(this.amount >=0 )
            return String.format("\n%s : %02fEGP : %s\n",
                    this.timeTamp.toString(),this.amount,this.memo );
        else return String.format("\n%s : -%02fEGP : %s\n",
                this.timeTamp.toString(),this.amount,this.memo );

    }


}
