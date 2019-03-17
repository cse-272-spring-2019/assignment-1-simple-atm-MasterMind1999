package sample;
import  javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.sql.rowset.spi.TransactionalWriter;
import javax.swing.*;

public class Main extends Application {
     ATM atm = new ATM();

     /**
    * enzilzation
    *
    * */
   Stage w;


    Button button;
    Button Showhistory;
    Button transfer;
    Button Deposit;
    Button Withdrawl;
    Button exit;
    Stage  windos;
    Scene Mainmenu,Showhistory1,transfer1,Deposit1,Withdrawl1,button1;
    public static void main(String[] args)
    {
        launch(args);
    }
    public void start(Stage primaryStage) throws Exception{

        atm.atm();
        w=primaryStage;
        VBox layout= new VBox(30);
       // Label button1=new Label("button");
        button1=new Scene(layout,200,400);

        w.setTitle("ATM");
        w.setScene(button1);

        VBox layoutShowhistory= new VBox(30);
       // Label Showhistory1=new Label("Showhistory");
        Showhistory1=new Scene(layoutShowhistory,200,400);

        VBox layouttransfer= new VBox(30);
       // Label transfer1=new Label("transfer");
        transfer1=new Scene(layouttransfer,200,400);

        VBox layoutDeposit= new VBox(30);
        //Label Deposit1=new Label("Deposit");
        Deposit1=new Scene(layoutDeposit,200,400);


        VBox layoutWithdraw= new VBox(30);
       // Label Withdrawl1=new Label("Withdraw");
        Withdrawl1=new Scene(layoutWithdraw,200,400);



        w.show();
        Label Mainmenu=new Label("Mainmenu");

        /** siting buttons
         */
        button =new Button();
        Withdrawl=new Button();
        exit=new Button();
        Deposit=new Button();
        transfer =new Button();
        Showhistory =new Button();

        /**
         * ste names for button
         */
        button.setText("Back to Main Menu");
        Showhistory.setText("Showhistory");
        transfer.setText("transfer");
        Deposit.setText("Deposit");
        Withdrawl.setText("Withdrawl");
        exit.setText("exit ATM");
        /**
         * adding buttons
         */

        //layout.getChildren().add(button);
       // layout.getChildren().addAll(Withdrawl,Deposit,transfer,Showhistory,exit);
        layout.getChildren().add(button);
       layout.getChildren().add(Withdrawl);
        layout.getChildren().add(Deposit);
        layout.getChildren().add(transfer);
        layout.getChildren().add(Showhistory);
        layout.getChildren().add(exit);
        layoutShowhistory.getChildren().addAll(button,exit);
        layoutDeposit.getChildren().addAll(button,exit);
        layouttransfer.getChildren().addAll(button,exit);
        layoutWithdraw.getChildren().addAll(button,exit);


        /**
         * button fanction
         */
        button.setOnAction(e -> {
            System.out.println("i am button");
            w.setScene(button1);
        });

        Withdrawl.setOnAction(e ->{
           // primaryStage.setScene(Withdrawl1);
            System.out.println("wwwwwww");
            w.setScene(Withdrawl1);
           // atm.Withdrawl();
        });

        Deposit.setOnAction(e -> {
            w.setScene(Deposit1);
           // atm.Deposit();
         System.out.println("ddddddd");});

        exit.setOnAction(e -> {
            System.out.println("dddddd");
            System.exit(1);
        });

        transfer.setOnAction(e ->{
            w.setScene(transfer1);
         //   atm.transfer();
            System.out.println("ttttttttt");
        });

        Showhistory.setOnAction(e -> {System.out.println("sssssssss");
            w.setScene(Showhistory1);
           // atm.Showhistory();
        });







       /* Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    */

    }


  /*  @Override
    public void handle(ActionEvent event) {
        if(event.getSource()==Showhistory){
            System.out.println("sssssssss");


        }
        if(event.getSource()==Deposit){
            System.out.println("ddddddd");
        }if(event.getSource()==Withdrawl){
            System.out.println("wwwwwww");
        }if(event.getSource()==exit){
            System.out.println("xxxxxxx");
        }if(event.getSource()==transfer){
            System.out.println("tttttttttttttttttt");
}        }
*/



    }

