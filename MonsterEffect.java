import java.util.ArrayList;

public abstract class MonsterEffect{
   private boolean monsterEffectOver = false;

   public abstract ArrayList<Monster> performEffect(ArrayList<Monster> m, Monster h);

   public boolean getMonsterEffectOver(){
      return monsterEffectOver;
   }
   public void setMonsterEffectOver(boolean mEffectOver){
      this.monsterEffectOver = mEffectOver;
   }
}