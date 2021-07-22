import java.util.ArrayList;

public class MonsterIceEffect extends MonsterEffect{
   private int effectTurn = 0;
   
   
   public ArrayList<Monster> performEffect(ArrayList<Monster> m, Monster h){
      System.out.println("The monster is stunned for one turn");         
      System.out.println("*******************************");
      
      
      if(effectTurn != 1 && !h.isMonsterImmobilized()){
         System.out.println(h.getMonsterName() + " is now stunned for one turn ");
         System.out.println("The monster is unable to perform any attacks for one turn");         
         System.out.println("*******************************");
         h.setMonsterImmbolized(true);
         effectTurn++;
      }
      else if(effectTurn == 1 && h.isMonsterImmobilized()){
         h.setMonsterImmbolized(false);
         setMonsterEffectOver(true);
                  
      }
      return m;
   }
}