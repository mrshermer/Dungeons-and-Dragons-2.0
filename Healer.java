import java.util.Scanner;

public class Healer extends Hero implements Comparable<Hero>
{
     
    public void decideAttackMove(){
       Scanner scan = new Scanner(System.in);
       int hT = 0;
       boolean valid = false;
       
       System.out.println(getHeroName() + " attack moves");
       System.out.println("1) Heal Yourself");
       System.out.println("2) Heal a Member of your Party");
       System.out.println("3) Heal all memebers of your Party");
       System.out.println("*******************************");

       
       int userChoice = scan.nextInt();
       
       while(!valid){
       
       if(userChoice == 1){
           attackMove = new HealHealer();
           hT = getHeroTurn(); 
           hT++;
           setHeroTurn(hT);
           valid = true;
       }
       else if(userChoice == 2){
           attackMove = new HealHero();
           hT = getHeroTurn(); 
           hT++;
           setHeroTurn(hT);
           valid = true; 
       }
       else if(userChoice == 3 && getHeroTurn() >= 2){
           attackMove = new GlobalHeal();
           setHeroTurn(0);
           valid = true;
       }  
       else{
           System.out.println("I'm sorry, that is not attack that's is avaible at the moment");
           System.out.println("Please make another choice");
           System.out.println(getHeroName() + " attack moves");
           System.out.println("1) Heal Yourself");
           System.out.println("2) Heal a Member of your Party");
           System.out.println("3) Heal all memebers of your Party");
           System.out.println("*******************************");
           userChoice = scan.nextInt();
       }
     }        
    }
    public String getHeroName(){
        return "Healer";
    }
    public int compareTo(Hero h){
         int compareHealth=(int)((Hero)h).getHeroHealth();
         /* For Ascending order*/
         return (int)getHeroHealth() - compareHealth;
 
    } 

}