import java.util.HashMap;
import java.util.Map;

public class BowSection extends Store{

   private HashMap<String, BowSection> mapBowSection = new HashMap<String, BowSection>();
   private Store store = null;
   private BowFactory bF = null;
   private Weapon weapon = null;
  
   public BowSection(){
         
   }
  
   public BowSection(int wL, int wC, boolean wLInd, boolean wA, String wAH){
         weaponLevel = wL;
         weaponCost = wC;
         weaponLevelInd = wLInd;
         weaponAvaibilty = wA;
         weaponApplyHero = wAH;  
   }
   public void addWeapons(){
      mapBowSection.put("Wooden Bow", new BowSection(1, 5, true, true, "Marksmen"));
      mapBowSection.put("CooperBowSpikes", new BowSection(1, 10, true, true, "Marksmen"));
      mapBowSection.put("BowGrappleHook", new  BowSection(1, 15, true, true, "Marksmen"));
   }
   public void setStoreVarible(Store s){
      this.store = s;
   }
   public Store getStore(){
      return store;
   }
   public BowSection returnWeaponStats(String weapon){
      BowSection bowSec = mapBowSection.get(weapon);
      return bowSec;
   }
   public boolean doesWeaponExists(String weapon){
      return mapBowSection.containsKey(weapon);
   }
   public void applyStats(String weapon){
      mapBowSection.put(weapon, new BowSection(store.getWeaponLevel(), 
      store.getWeaponCost(), store.getWeaponLevelInd(), store.getWeaponAvaibility(), store.getWeaponApplyHero()));
   }
   public void listWeapons(){
       System.out.println("---------------------------");
       BowSection bowSec = null;
       bF = new BowFactory();
       
       for(Map.Entry<String, BowSection> mapElement: mapBowSection.entrySet()){
          String weaponName = mapElement.getKey();
          bowSec = mapElement.getValue();
          weapon = bF.createWeapon(weaponName);
          
          System.out.println(weaponName + "\nWeapon Cost: " + bowSec.getWeaponCost() + 
          "\nWeapon Damage: " + weapon.getWeaponDamage() + "\nWeapon Avaibility: " + bowSec.getWeaponAvaibility() +
          "\nHeroWeaponCategory: " + bowSec.getWeaponApplyHero());  
          System.out.println("*******************************");
          System.out.println();
       }
       System.out.println("---------------------------");
   }
   public void levelUpWeapons(){
      String weaponName = null;
      BowSection sSec = null;
      Weapon weapon = null;
      bF = new BowFactory();
      
      for(Map.Entry mapElement: mapBowSection.entrySet()){
           weaponName = (String) mapElement.getKey();
           sSec = (BowSection)mapElement.getValue();
           weapon = bF.createWeapon(weaponName);
           
           if(sSec.getWeaponLevel() == 1 && sSec.getWeaponAvaibility()){
               weapon.setWeaponDamage(weapon.getWeaponDamage() + 1);
               
           }
           else if(sSec.getWeaponLevel() == 2 && sSec.getWeaponAvaibility()){
               weapon.setWeaponDamage(weapon.getWeaponDamage() + 1.5);
           }
           else if(sSec.getWeaponLevel() == 3 && sSec.getWeaponAvaibility()){
               weapon.setWeaponDamage(weapon.getWeaponDamage() + 2);
           }
           mapBowSection.put(weaponName, new BowSection(weaponLevel+1, sSec.getWeaponCost(), sSec.getWeaponLevelInd(), 
           sSec.getWeaponAvaibility(), sSec.getWeaponApplyHero()));
        }   
   }
   public boolean doesStoreHaveWeaponsHero(Hero h){
      boolean valid = false;
      BowSection sSec = null;
      
      for(Map.Entry<String, BowSection> mapElement: mapBowSection.entrySet()){
         sSec = mapElement.getValue();
         
         if(sSec.getWeaponApplyHero().equals(h.getHeroName()) && sSec.getWeaponAvaibility()
         && sSec.getWeaponCost() <= h.getHeroGold()){
            valid = true;
         }
      }
      return valid;
   }

}