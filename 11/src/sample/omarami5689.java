package sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import  java.util.UnknownFormatConversionException;
public class omarami5689 {
    public void omar (){
        Scanner s=new Scanner(System.in);
        Bank theBank=new Bank("king");
        User cUser;
        while(true) {
            cUser=omarami5689.mainMenuPrompt(s,theBank);
            omarami5689.printUserMenu(cUser,s);
        }
    }
    private static User mainMenuPrompt(Scanner s, Bank theBank) {
        // TODO Auto-generated method stub
        String userId;
        String pin;
        User authUser;
        do {System.out.printf("\n----Welcome to %s----\n",
                theBank.getName());
            System.out.println("\n\npleas enter your ID:  \n");
            userId=s.nextLine();
            System.out.println("\n\npleas enter your password:  \n");
            pin=s.nextLine();
            authUser =theBank.login(userId, pin);
            if(authUser==null) {
                System.out.println("\n\n******you entered "
                        + "wrong  ID or password pleas try agin****\n\n\n ");
            }
        }while(authUser==null);
        return authUser;
    }
    private static void printUserMenu(
            User cUser, Scanner s) {
        cUser.printAccountHistory();
        // TODO Auto-generated method stub
        System.out.println("\n\n    ****menu****\n\n");
        System.out.println("1-Withdrawl.\n");
        System.out.println("2-Deposit.\n");
        System.out.println("3-transfer.\n");
        System.out.println("4-Show history.\n");
        System.out.println("5-Any Problems.\n");
        System.out.println("6-exit.\n");
        int numberItem=s.nextInt();
        if((numberItem<1) && (numberItem>5)) {
            System.out.println("\npleas re-enter a choice\n");
            omarami5689.printUserMenu(cUser, s);
        }
        switch(numberItem) {
            case 1:omarami5689.Withdrawl(cUser, s);
                break;
            case 2:omarami5689.Deposit(cUser, s);
                break;
            case 3:omarami5689.transfer(cUser, s);
                break;
            case 4:omarami5689.Showhistory(cUser, s);
                break;
            case 5:{System.out.println("\nOur number is 019909516151 pleas call us\n");
                break;
            }

            case 6:System.exit(1);
        }if(numberItem !=6) {
            System.out.println("\nDo you want anther transaction???\n1-yes.\n"
                    + "\n-2-no thank you.");
            int x=s.nextInt();
            if(x==1) {
            }
            else System.exit(1);
        }}
    private static void Showhistory(User cUser, Scanner s) {
        // TODO Auto-generated method stub
        int acc;
        do {
            System.out.printf("\npleas enter the number"
                    + "(1-%d) of account\n ", cUser.numAccount());
            acc=s.nextInt()-1;
            if((acc < 0) || (acc >=   cUser.numAccount())) {
                System.out.println("\nThe number you entered "
                        + "dosenot exiest  \npleas try again");
            }

        }while((acc < 0) || (acc >=   cUser.numAccount()));

		/*
		System.out.println("\npleas enter the number of you account\n ");
		acc=s.nextInt()-1;*/
        cUser.printAccHistory(acc);
    }
    private static void transfer(User cUser, Scanner s) {
        // TODO Auto-generated method stub
        int fromAcc,toAcc;
        double amount,accBalance;
        do {
            System.out.println("\npleas enter the number of your account \n");
            fromAcc=s.nextInt()-1;
            if((fromAcc < 0) || (fromAcc >=   cUser.numAccount())) {
                System.out.println("\nThe number you entered "
                        + "dosenot exiest  \npleas try again");
            }

        }while((fromAcc < 0) || (fromAcc >=   cUser.numAccount()));

        accBalance =cUser.getAccBalacnce(fromAcc);

        do {
            System.out.println("\npleas enter the number of "
                    + "the  account you want transfer to\n");
            toAcc=s.nextInt()-1;
            if((toAcc < 0) || (toAcc >=   cUser.numAccount())) {
                System.out.println("\nThe number you entered "
                        + "dosenot exiest  \npleas try again");
            }

        }while((toAcc < 0) || (toAcc >=   cUser.numAccount()));

        do {
            System.out.printf("\nenter the amount you want to trnsfer (max %02fEGP)",
                    accBalance);
            amount=s.nextInt();

            if(amount<=0) {
                System.out.println("\n the amount must be more than zero");
            }else if(amount > accBalance) {
                System.out.printf("\nYou dont have that much you  (max is %02fEGP)",
                        accBalance);

            }

        }while((toAcc < 0) || (toAcc >=   cUser.numAccount()));

	/*	System.out.println("\npleas enter the amount of the you want to Transaction\n ");
	amount =s.nextInt();*/
        cUser.addAccountTransaction(fromAcc,-1*amount,
                String.format("\nThe account transeferd to %s\n", cUser.getUUID(toAcc)));
        cUser.addAccountTransaction(fromAcc,-1*amount,
                String.format("\nThe account transeferd from %s\n", cUser.getUUID(fromAcc)));


    }
    private static void Deposit(User cUser, Scanner s) {
        // TODO Auto-generated method stub
        int toAcc;
        double amount,accBalance;
        String memo;
        do {
            System.out.println("\npleas enter the number of your account \n");
            toAcc=s.nextInt()-1;
            if((toAcc < 0) || (toAcc >=   cUser.numAccount())) {
                System.out.println("\nThe number you entered "
                        + "dosenot exiest  \npleas try again");
            }

        }while((toAcc < 0) || (toAcc >=   cUser.numAccount()));

        accBalance =cUser.getAccBalacnce(toAcc);
        do {
            System.out.printf("\nenter the amount you want to diboset (max %02fEGP)",
                    accBalance);
            amount=s.nextInt();

            if(amount<=0) {
                System.out.println("\n the amount must be more than zero");
            }

        }while((toAcc < 0) || (toAcc >=   cUser.numAccount()));


        s.nextLine();
        System.out.println("\npleas enter a memo : \n");
        memo = s.nextLine();
        cUser.addAccountTransaction(toAcc, amount, memo);





    }
    private static void Withdrawl(User cUser, Scanner s) {
        // TODO Auto-generated method stub
        int fromAcc;
        double amount,accBalance;
        String memo;
        do {
            System.out.println("\npleas enter the number of your account \n");
            fromAcc=s.nextInt()-1;
            if((fromAcc < 0) || (fromAcc >=   cUser.numAccount())) {
                System.out.println("\nThe number you entered "
                        + "dosenot exiest  \npleas try again");
            }

        }while((fromAcc < 0) || (fromAcc >=   cUser.numAccount()));

        accBalance =cUser.getAccBalacnce(fromAcc);
        do {
            System.out.printf("\nenter the amount you want to trnsfer (max %02fEGP)",
                    accBalance);
            amount=s.nextInt();

            if(amount<=0) {
                System.out.println("\n the amount must be more than zero");
            }else if(amount > accBalance) {
                System.out.printf("\nYou dont have that much you  (max is %02fEGP)",
                        accBalance);

            }

        }while((fromAcc < 0) || (fromAcc >=   cUser.numAccount()));


        s.nextLine();
        System.out.println("\npleas enter a memo : \n");
        memo = s.nextLine();
        cUser.addAccountTransaction(fromAcc, -1*amount, memo);

		/*int fromAcc;
		String memo;
		double amount,accBalance;
		System.out.println("\npleas enter the number of your account \n");
		fromAcc =s.nextInt()-1;
		accBalance =cUser.getAccBalacnce(fromAcc);
		System.out.println("\npleas enter the amount of your Withdrawl\n ");
		amount=s.nextDouble();
		*/

    }


}
