package sample;

import java.util.ArrayList;
public class Account {
    private String name;
    private String uuid;
    private User holder;
    private ArrayList<Transaction> Transactions;
    public Account(String name,User holder,Bank theBank) {
        this.holder=holder;
        this.name=name;
        this.uuid=theBank.getNewAccountUUID();
        this.Transactions=new ArrayList<Transaction>();

    }
    public String getAcc() {
        return this.uuid;
    }
    public double getBalance() {
        double balance =0 ;
        for(Transaction t:this.Transactions) {
            balance +=t.getAmount();
        }
        return balance;
    }
    public Object getSummary() {
        // TODO Auto-generated method stub
        double balance=this.getBalance();
        if(balance>=0)
            return String.format("%s : %.02fEGP : %s"
                    , this.uuid,balance,this.name);
        else return String.format("%s : -%.02fEGP : %s"
                , this.uuid,balance,this.name);

    }
    public void printTransactionHistory() {
        // TODO Auto-generated method stub
        System.out.printf("\nTransaction history of the ."
                + "account %s\n",this.uuid);
        for(int t=this.Transactions.size()-1;t>=0;t--) {
            System.out.printf("",this.Transactions.get(t)
                    .getSummaryLine());

        }
        System.out.println();

    }
    public void addTransaction(double d, String format) {
        // TODO Auto-generated method stub
        Transaction newtransaction = new Transaction (d,format,this);
        this.Transactions.add(newtransaction);

    }
}
