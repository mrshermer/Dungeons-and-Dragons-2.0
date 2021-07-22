import java.util.Scanner;

public class Sorecor extends Hero implements Comparable<Hero>{
   

  public void decideAttackMove(){
     Scanner scan = new Scanner(System.in);
     int hT = 0;
     boolean valid = false;
     
      System.out.println(getHeroName() + " attack moves");
      System.out.println("1) Knock Two Monsters Heads together");
      System.out.println("2) Arcne Blast");
      System.out.println("3) Fire and Ice");
      System.out.println("*******************************");

     
     int userChoice = scan.nextInt();
     
     while(!valid){
     
     if(userChoice == 1){
           attackMove = new KnockTwoHeads();
           hT = getHeroTurn(); 
           hT++;
           setHeroTurn(hT);
           valid = true;
     }
     else if(userChoice == 2){
           attackMove = new ArcneBlast();
           hT = getHeroTurn();
           hT++;
           setHeroTurn(hT);
           valid = true;
     }
     else if(userChoice == 3 && getHeroTurn() >= 2){
           attackMove = new FireAndIce();
           setHeroTurn(0);
           valid = true;
     } 
     else{
           System.out.println("I'm sorry, that is not attack that's is avaible at the moment");
           System.out.println("Please make another choice");
           System.out.println(getHeroName() + " attack moves");
           System.out.println("1) Knock Two Monsters Heads together");
           System.out.println("2) Arcne Blast");
           System.out.println("3) Fire and Ice");

           System.out.println("*******************************");
           userChoice = scan.nextInt();
       }
     } 
     
  }
  public String getHeroName(){
     return "Sorecor";
  } 
  public int compareTo(Hero h){
    int compareHealth=(int)((Hero)h).getHeroHealth();
    /* For Ascending order*/
    return (int)getHeroHealth() - compareHealth;
  }
   
}