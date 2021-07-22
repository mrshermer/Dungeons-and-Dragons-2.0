import java.util.Scanner;

public class Robot extends Hero implements Comparable<Hero>{
   
   
   public void decideAttackMove(){
      Scanner scan = new Scanner(System.in);
      
      System.out.println(getHeroName() + " attack moves");
      System.out.println("1) Pull and Hit");
      System.out.println("2) Static Shock");
      System.out.println("3) The Big One");
      System.out.println("*******************************");

      
      int hT = 0;
      boolean valid = false;
      int userChoice = scan.nextInt();
      
      while(!valid){
      
         if(userChoice == 1){
           attackMove = new PullAndHit();
           hT = getHeroTurn(); 
           hT++;
           setHeroTurn(hT);
           valid = true;
         }
         else if(userChoice == 2){
           attackMove = new StaticShock();
           hT = getHeroTurn(); 
           hT++;
           setHeroTurn(hT);
           valid = true;
         }
         else if(userChoice == 3 && getHeroTurn() >= 2){
           attackMove = new PullThenStaticShock();
           setHeroTurn(0);
           valid = true;
         }
         else{
           System.out.println("I'm sorry, that is not attack that's is avaible at the moment");
           System.out.println("Please make another choice");
           System.out.println(getHeroName() + " attack moves");
           System.out.println("1) Pull and Hit");
           System.out.println("2) Static Shock");
           System.out.println("3) The Big One");
           System.out.println("*******************************");
           userChoice = scan.nextInt();
            
         }
     }    
   }
   public String getHeroName(){
      return "Robot";
   }
   public int compareTo(Hero h){
         int compareHealth=(int)((Hero)h).getHeroHealth();
         /* For Ascending order*/
         return (int)getHeroHealth() - compareHealth;
   } 

}