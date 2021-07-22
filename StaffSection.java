import java.util.HashMap;
import java.util.Map;

public class StaffSection extends Store{
   private HashMap<String, StaffSection> mapStaffSection = new HashMap<String, StaffSection>();
   private Store store = null;
   private StaffFactory sF = null;
   private Weapon weapon = null;
  
   public StaffSection(){
      
   }
  
   public StaffSection(int wL, int wC, boolean wLInd, boolean wA, String wAH){
          weaponLevel = wL;
         weaponCost = wC;
         weaponLevelInd = wLInd;
         weaponAvaibilty = wA;
         weaponApplyHero = wAH; 
   }
   public void addWeapons(){
      mapStaffSection.put("Heal Staff", new StaffSection(1, 5, true, true, "Healer"));
      mapStaffSection.put("Damage Staff", new StaffSection(1, 5, true, true, "Sorecor"));
      mapStaffSection.put("StaffOfDestuction", new StaffSection(1, 15, true, true, "Sorecor"));
   }
   public void setStoreVarible(Store s){
      this.store = s;
   }
   public Store getStore(){
      return store;
   }
   
   public StaffSection returnWeaponStats(String weapon){
      StaffSection staffSec = mapStaffSection.get(weapon);
      return staffSec;
   }
   public boolean doesWeaponExists(String weapon){
      return mapStaffSection.containsKey(weapon);
   }
   public void applyStats(String weapon){
      mapStaffSection.put(weapon, new StaffSection(store.getWeaponLevel(), 
      store.getWeaponCost(), store.getWeaponLevelInd(), store.getWeaponAvaibility(), store.getWeaponApplyHero()));
   }
   public void listWeapons(){
       System.out.println("---------------------------");
       StaffSection stSec = null;
       sF = new StaffFactory();
       
       for(Map.Entry<String, StaffSection> mapElement: mapStaffSection.entrySet()){
          String weaponName = mapElement.getKey();
          stSec = mapElement.getValue();
          weapon = sF.createWeapon(weaponName);
          
          System.out.println(weaponName + "\nWeapon Cost: " + stSec.getWeaponCost() + 
          "\nWeapon Damage: " + weapon.getWeaponDamage() + "\nWeapon Avaibility: " + stSec.getWeaponAvaibility() +
          "\nHeroWeaponCategory: " + stSec.getWeaponApplyHero());  
          System.out.println("*******************************");
          System.out.println();
       }
       System.out.println("---------------------------");
   }
   public void levelUpWeapons(){
      sF = new StaffFactory();
      
      for(Map.Entry mapElement: mapStaffSection.entrySet()){
           String weaponName = (String) mapElement.getKey();
           StaffSection sSec = (StaffSection)mapElement.getValue();
           Weapon weapon = sF.createWeapon(weaponName);
           
           if(sSec.getWeaponLevel() == 1 && sSec.getWeaponAvaibility()){
               weapon.setWeaponDamage(weapon.getWeaponDamage() + 1);
               
           }
           else if(sSec.getWeaponLevel() == 2 && sSec.getWeaponAvaibility()){
               weapon.setWeaponDamage(weapon.getWeaponDamage() + 1.5);
           }
           else if(sSec.getWeaponLevel() == 3 && sSec.getWeaponAvaibility()){
               weapon.setWeaponDamage(weapon.getWeaponDamage() + 2);
           }
           mapStaffSection.put(weaponName, new StaffSection(weaponLevel+1, sSec.getWeaponCost(), sSec.getWeaponLevelInd(), 
           sSec.getWeaponAvaibility(), sSec.getWeaponApplyHero()));
        }
   }
   public boolean doesStoreHaveWeaponsHero(Hero h){
      boolean valid = false;
      StaffSection sSec = null;
      
      for(Map.Entry<String, StaffSection> mapElement: mapStaffSection.entrySet()){
         sSec = mapElement.getValue();
         
         if(sSec.getWeaponApplyHero().equals(h.getHeroName()) && sSec.getWeaponAvaibility()
         && sSec.getWeaponCost() <= h.getHeroGold()){
            valid = true;
         }
      }
      return valid;
   }
}