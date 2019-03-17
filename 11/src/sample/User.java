package sample;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {
    private String firstName;
    private String lastName;
    private String uuid;
    private byte pinHash[];
    private ArrayList<Account> accounts;
    public User(String firstName,String lastName,
                String pin,Bank theBank) {
        this.firstName= firstName;
        this.lastName=lastName;
        try {
            MessageDigest md=MessageDigest.getInstance("MD5");
            this.pinHash=md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("\nlogic error\n");			// TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(5);
        }

        this.uuid= theBank.getNewUserUUID();
        this.accounts=new ArrayList<Account>() ;

        System.out.printf("\nnew user %s ,%s whit ID:  %s  created\n",lastName
                ,firstName,this.uuid);
    }
    public void addAccount(Account account) {
        // TODO Auto-generated method stub
        this.accounts.add(account);
    }
    public String getUUID() {
        return this.uuid;
    }
    public ArrayList<Account> getAcc() {
        return this.accounts;
    }
    public boolean tPin(String pin) {
        // TODO Auto-generated method stub
        try {
            MessageDigest md=MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(
                    md.digest(pin.getBytes()),this.pinHash);
        } /**there somting rong.....
         */
        catch (NoSuchAlgorithmException e) {
            System.err.println("\nlogic error\n");			// TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);
        }
        return false;
    }
    public void printAccountHistory() {
        System.out.printf("\nName of User %s\n",this.firstName );
        int x=1;
        for(int i=0; i<this.accounts.size();i++) {
            System.out.printf("%d-%s ."
                    ,	x,this.accounts.get(i).getSummary());
            x++;}
    }
    public void printAccHistory(int acc) {
        // TODO Auto-generated method stub
        this.accounts.get(acc).printTransactionHistory();

    }
    public double getAccBalacnce(int fromAcc) {
        // TODO Auto-generated method stub
        return this.accounts.get(fromAcc).getBalance();
    }
    public Object getUUID(int toAcc) {
        // TODO Auto-generated method stub
        return this.accounts.get(toAcc).getAcc();
    }
    public void addAccountTransaction(int fromAcc, double d, String format) {
        // TODO Auto-generated method stub
        this.accounts.get(fromAcc).addTransaction(d,format);
    }
    public int numAccount() {
        // TODO Auto-generated method stub
        return this.accounts.size();
    }

}

