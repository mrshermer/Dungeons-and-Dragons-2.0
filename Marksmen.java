import java.util.Scanner;

public class Marksmen extends Hero implements Comparable<Hero> {
     
   public void decideAttackMove(){
       Scanner scan = new Scanner(System.in);
       
      System.out.println(getHeroName() + " attack moves");
      System.out.println("1) Gotcha");
      System.out.println("2) I Spit on You");
      System.out.println("3) The Stunner");
       
       int hT = 0;
       int userChoice = scan.nextInt();
       
      
         if(userChoice == 1){
            attackMove = new Gotcha();
            hT = getHeroTurn();
            hT++;
            setHeroTurn(hT);
         }
         else if(userChoice == 2){
            attackMove = new ISpitOnYou();
            hT = getHeroTurn();
            hT++;
            setHeroTurn(hT);
         }
         else if(userChoice == 3 && getHeroTurn() >= 2){
            attackMove = new TheStunner();
            setHeroTurn(0);
         } 
   }
   public String getHeroName(){
      return "Marksmen";
   }
   public int compareTo(Hero h){
      int compareHealth=(int)((Hero)h).getHeroHealth();
         /* For Ascending order*/
         return (int)getHeroHealth() - compareHealth;
   }
}