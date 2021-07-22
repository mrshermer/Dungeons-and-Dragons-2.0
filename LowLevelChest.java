import java.util.ArrayList;

public class LowLevelChest extends TreasureChest{
   public void awardGold(Party party){
      for(int a = 0; a < party.getHeroPartyList().size(); a++){
         Hero h = (Hero)party.getHeroPartyList().get(a);
         h.setHeroGold(10 + h.getHeroGold());
      }
   }
   public int treasureGoldAmount(){
      return 10;
   }
}