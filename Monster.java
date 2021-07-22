import java.util.ArrayList;


public abstract class Monster{
   protected ArrayList<MonsterEffect> mEffect = new ArrayList<MonsterEffect>(); 
   MonsterAttack attackMove = null;
   private boolean monsterImmbolized = false;
   protected int monsterTurn = 0;
   
   public Party performMonsterAttack(Party heroParty){
      heroParty = attackMove.attack(heroParty);
      return heroParty;
   }  
   public abstract void decideMonsterAttack();
   public abstract String getMonsterName();
   public abstract void setMonsterHealth(double mH);
   public abstract double getMonsterHealth();
   
   public boolean isMonsterImmobilized(){
      return monsterImmbolized;
   }
   public void setMonsterImmbolized(boolean imbolile){
      this.monsterImmbolized = imbolile;
   }
   public void addToEffects(MonsterEffect ef){
      mEffect.add(ef);    
   }
   public ArrayList<MonsterEffect> getMonsterEffects(){
      return mEffect;
   }
   public void removeMonsterEffect(int index){
      mEffect.remove(index);  
   }
   public void clearMonsterEffect(){
      mEffect.clear();
   }
   
}