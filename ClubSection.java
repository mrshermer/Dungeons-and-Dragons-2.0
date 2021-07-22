import java.util.HashMap;

public class ClubSection extends Store{
   private HashMap<String, ClubSection> mapClubSection = new HashMap<String, ClubSection>();
   private Store store = null;

  
   public ClubSection(){
      
   }
  
   public ClubSection(int wL, int wC, boolean wLInd, boolean wA, String wAH){
         weaponLevel = wL;
         weaponCost = wC;
         weaponLevelInd = wLInd;
         weaponAvaibilty = wA;
         weaponApplyHero = wAH; 
   }
   public void addWeapons(){
      mapClubSection.put("WoodenClub", new ClubSection(1, 5, true, true, "Mage"));
      mapClubSection.put("SpikeClub", new ClubSection(1, 10, true, true, "Mage"));
      mapClubSection.put("DoubleHitWhammyClub", new ClubSection(1, 15, true, true, "Mage"));
   }
   public void setStoreVarible(Store s){
      this.store = s;
   }
   public Store getStore(){
      return store;
   }
   
   public ClubSection returnWeaponStats(String weapon){
      ClubSection clubSec = mapClubSection.get(weapon);
      return clubSec;
   }
   public boolean doesWeaponExists(String weapon){
      return mapClubSection.containsKey(weapon);
   }
   public void applyStats(String weapon){
      System.out.println(store.getWeaponLevel());
   }
}