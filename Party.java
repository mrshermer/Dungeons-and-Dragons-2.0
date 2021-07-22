import java.util.ArrayList;

public class Party
{
   private ArrayList<Hero> heroParty   = new ArrayList<Hero>();
   private ArrayList<Monster> monsterParty = new ArrayList<Monster>(); 

   
   public ArrayList getHeroPartyList(){
      return heroParty;
   }
   public void setHeroPartyList(ArrayList hP){
      this.heroParty = hP;
   }
   public ArrayList getMonsterPartyList(){
      return monsterParty;
   }
   public void setMonsterPartyList(ArrayList monster){
      this.monsterParty = monster;
   }
   
   public void addHeroToParty(Hero hero){
      heroParty.add(hero);
   }
   public void addMonsterParty(Monster monster){
      monsterParty.add(monster);
   }
   public void awardGoldToAllHerosAfterDefeatMonster(){
      for(int a = 0; a < heroParty.size(); a++){
         Hero hero = heroParty.get(a);
         
         hero.setHeroGold(hero.getHeroGold() + 10);
      }
   }
   public void removeHeroFromParty(Hero h){
      heroParty.remove(h);
   }
   public void clearHeroEffects(){
      for(int i = 0; i < heroParty.size(); i++){
         Hero hero = (Hero)heroParty.get(i);
         hero.clearHeroEffects();
         hero.setHeroTurn(0);
         hero.setHeroImmobolized(false);
      }
   }
   public void clearMonsterPartyList(){
      monsterParty.clear();
   }

}