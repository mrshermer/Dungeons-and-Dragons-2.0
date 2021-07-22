public class HighLevelChest extends TreasureChest{
   public void awardGold(Party party){
      for(int a = 0; a < party.getHeroPartyList().size(); a++){
         Hero h = (Hero)party.getHeroPartyList().get(a);
         h.setHeroGold(30 + h.getHeroGold());
      }
   }
   public int treasureGoldAmount(){
      return 30;
   }

}