package sample;

import java.util.ArrayList;
import java.util.Random;
public class Bank {
    private String  name;
    private ArrayList<User> users ;
    private ArrayList<Account>  accounts;
    public  Bank (String  name) {
        this.name=name;
        this.accounts=new ArrayList<Account>();
        this.users=new ArrayList<User>();
    }
    public String getNewUserUUID() {
        // TODO Auto-generated method stub
        String uuid;
        Random id=new Random ();
        boolean unic=false;
        int lengh=4;
        do {
            uuid="";
            for(int i=0;i<lengh;i++) {
                uuid +=((Integer)id.nextInt(10)).toString();
            }for(User u:this.users) {
                if(uuid.compareTo(u.getUUID())==0){
                    unic=true;
                    break;
                }}}while(unic);
        return uuid;	}
    public String getNewAccountUUID() {
        // TODO Auto-generated method stub
        String acc;
        Random ac=new Random ();
        boolean uni=false;
        int lengh=12;
        do {
            acc="";
            for(int i=0;i<lengh;i++) {
                acc +=((Integer)ac.nextInt(10)).toString();
            }for(Account a:this.accounts) {

                if(acc.compareTo(a.getAcc())==0){
                    uni=true;
                    break;
                }}}while(uni);

        return acc;	}

    public User addUser(String firstName,
                        String lastName,String pin) {

        User newUser=new User(firstName,lastName,pin,this);

        this.users.add(newUser);

        Account newAccount=new Account("Savings",newUser,this);
        newUser.addAccount(newAccount);
        //this.addAccount(newAccount);
        this.accounts.add(newAccount);
        return newUser;

    }

    public User login(String UserId,String pin) {
        for(User u:this.users) {
            if((u.getUUID().compareTo(UserId) == 0)
                    && (u.tPin(pin))) {
                return u;}
        }
        return null;
    }
    public Object getName() {
        // TODO Auto-generated method stub
        return this.name;
    }

    public void addAccount(Account anAccount) {
        this.accounts.add(anAccount);
    }


}
