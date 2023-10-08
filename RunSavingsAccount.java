/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package runsavingsaccount;
import java.util.*;
/**
 *
 * @author Acer
 */
public class RunSavingsAccount {

    public static void main(String[] args) {
        Scanner balance = new Scanner (System.in);
        SavingsAccount savings = new SavingsAccount();
        
        System.out.println("\tWelcome to your Savings Account Check");
        System.out.println("\nEnter amount of interest rate: ");
        double interestRate = balance.nextDouble();
        
        SavingsAccount.setInterestRate(interestRate);
        
        while(true){
            System.out.println("\nPress D for deposit | Press W to withdraw | Press X to exit");
            char choice = balance.next().charAt(0);
            
            switch(choice){
                case 'D':
                case 'd':
                    System.out.println("\nPlease enter an amount to be deposited: ");
                    double depositAmount = balance.nextDouble();
                    savings.deposit(depositAmount);
                    SavingsAccount.showBalance(savings);
                    break;
                    
                case 'W':
                case 'w':
                    System.out.println("\nPlease enter an amount to withdraw: ");
                    double withdrawAmount = balance.nextDouble();
                    double withdraw = savings.withdraw(withdrawAmount);
                    if(withdraw == 0){
                        System.out.println("Cannot withdraw. You have insufficient balance.");
                    }else{
                        System.out.println("Withdrawn amount: " + withdraw);
                        
                        SavingsAccount.showBalance(savings);
                        if(savings.getBalance() >1000){
                            savings.addInterest();
                            System.out.println("Your new balance:  " + savings.getBalance());
                        }
                    }
                    break;
                    
                case 'X':
                case 'x':
                    System.out.println("\nSavings Account Check Exit");
                    balance.close();
                    System.exit(0);
                    
                default:
                    
                    System.out.println("Invalid key. Please Enter D, W or X");
            }
        }
        
    }
    
}
