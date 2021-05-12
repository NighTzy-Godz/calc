import java.text.DecimalFormat;
import java.util.Scanner;

class Try{
    public static void main(String[] args){

      // GLOBAL VARIABLES
      final int MONTHS = 12; 
      int principal = 0;
      float final_interest = 0;
      int years_pay = 0;
      int years = 0;


      Scanner scan = new Scanner(System.in);

      // PRINCIPAL
      while(true){
        int max = 1000000;
        int limit = 100000;
        System.out.print("Your Desire Principal: $");
        principal = scan.nextInt();
        if(principal < limit || principal > max){
          System.out.println("Please Try Again");
        }else{
          break;
        }
       
      }

      // INTEREST RATE

      while(true){
        System.out.print("Interest: ");
        float interest = scan.nextFloat();
        int limit = 1;
        int max = 10;

        if(interest < limit || interest > max){
          System.out.println("Please Try Again");
        }else{           
          final_interest = interest / 100 / MONTHS;
          break;
        }
        
      }

      // YEARS TO PAY
      while(true){
        System.out.print("Years to Pay: ");
        years = scan.nextInt();
        int limit = 1;
        int max = 20;

        if(years < limit || years >= max){
          System.out.println("Please Try Again");
        }else{
          years_pay = years * MONTHS;
          break;
        }

      }

      double payment = principal * ((final_interest * Math.pow(1 + final_interest, years_pay)
       / (Math.pow(1 + final_interest, years_pay) -1 )));
      
      DecimalFormat places = new DecimalFormat("###.##");
      System.out.println("Your Monthly Payment for " + years + "years is $" + places.format(payment));
      
      }
 
 

  }
