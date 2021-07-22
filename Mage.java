import java.util.Scanner;

public class Mage extends Hero implements Comparable<Hero> {
  

   public void decideAttackMove(){
      System.out.println(getHeroName() + " attack moves");
      System.out.println("1) Mage Charge");
      System.out.println("2) Mage Spin Attack");
      System.out.println("3) Mage Surprise Attack");
      System.out.println("*******************************");
      
      int hT = 0;
      boolean validChoice = false;
      
      Scanner scan = new Scanner(System.in);
      int userChoice = scan.nextInt();
      
      while(!validChoice){
      
        if(userChoice == 1){
           attackMove = new MageCharge();
           hT = getHeroTurn(); 
           hT++;
           setHeroTurn(hT);
           validChoice = true;
        }
        else if(userChoice == 2){
           attackMove = new SpinAttack();
           hT = getHeroTurn();
           hT++;
           setHeroTurn(hT);
           validChoice = true;
        }
        else if(userChoice == 3 && getHeroTurn() >= 2){
           attackMove = new MageSurpriseAttack();
           setHeroTurn(0);
           validChoice = true;
        }
        else{
           System.out.println("I'm sorry, that is not attack that's is avaible at the moment");
           System.out.println("Please make another choice");
           System.out.println(getHeroName() + " attack moves");
           System.out.println("1) Mage Charge");
           System.out.println("2) Mage Spin Attack");
           System.out.println("3) Mage Surprise Attack");

           System.out.println("*******************************");
           userChoice = scan.nextInt();
        }
     }   
   } 
   public String getHeroName(){
      return "Mage";
   }
   
   public int compareTo(Hero h){
         int compareHealth=(int)((Hero)h).getHeroHealth();
         /* For Ascending order*/
         return (int)getHeroHealth() - compareHealth;
   } 

  
}