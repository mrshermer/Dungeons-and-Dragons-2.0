import java.util.HashMap;
import java.util.Map;

public class SwoardSection extends Store{
   private HashMap<String, SwoardSection> mapSwoardSection = new HashMap<String, SwoardSection>();
   private Store store = null;
   private SwoardFactory sF = null;
   private Weapon weapon = null;
  
   public SwoardSection(){
   
   }
   
   public SwoardSection(int wL, int wC, boolean wLInd, boolean wA, String wAH){
  
         weaponLevel = wL;
         weaponCost = wC;
         weaponLevelInd = wLInd;
         weaponAvaibilty = wA;
         weaponApplyHero = wAH;     
   }
   public void addWeapons(){
      mapSwoardSection.put("Bronze Swoard", new SwoardSection(1, 5, true, true, "Mage"));
      mapSwoardSection.put("Silver Swoard", new SwoardSection(1, 10, true, true, "Mage"));
      mapSwoardSection.put("Golden Swoard", new SwoardSection(1, 15, true, true, "Mage"));
   }
   public void setStoreVarible(Store s){
      this.store = s;
   }
   public Store getStore(){
      return store;
   }
   
   public SwoardSection returnWeaponStats(String weapon){
      SwoardSection swoardSec = mapSwoardSection.get(weapon);
      return swoardSec;
   }
   public boolean doesWeaponExists(String weapon){
      return mapSwoardSection.containsKey(weapon);
   }
   public void applyStats(String weapon){
      mapSwoardSection.put(weapon, new SwoardSection(store.getWeaponLevel(), 
      store.getWeaponCost(), store.getWeaponLevelInd(), store.getWeaponAvaibility(), store.getWeaponApplyHero()));
   }
   public void listWeapons(){
       System.out.println("---------------------------");
       SwoardSection swSec = null;
       sF = new SwoardFactory();
       
       for(Map.Entry<String, SwoardSection> mapElement: mapSwoardSection.entrySet()){
          String weaponName = mapElement.getKey();
          swSec = mapElement.getValue();
          weapon = sF.createWeapon(weaponName);
          
          System.out.println(weaponName + "\nWeapon Cost: " + swSec.getWeaponCost() + 
          "\nWeapon Damage: " + weapon.getWeaponDamage() + "\nWeapon Avaibility: " + swSec.getWeaponAvaibility() + 
          "\nHeroWeaponCategory: " + swSec.getWeaponApplyHero());  
          System.out.println("*******************************");
          System.out.println();
       }
       System.out.println("---------------------------");
   }
   public void levelUpWeapons(){
       sF = new SwoardFactory();
       SwoardSection sSec = null;
       
       for(Map.Entry<String, SwoardSection> mapElement: mapSwoardSection.entrySet()){
           String weaponName =  mapElement.getKey();
           sSec = mapElement.getValue();
           weapon = sF.createWeapon(weaponName);
           
           if(sSec.getWeaponLevel() == 1 && sSec.getWeaponAvaibility()){
               weapon.setWeaponDamage(weapon.getWeaponDamage() + 1);
           }
           else if(sSec.getWeaponLevel() == 2 && sSec.getWeaponAvaibility()){
               weapon.setWeaponDamage(weapon.getWeaponDamage() + 1.5);
           }
           else if(sSec.getWeaponLevel() == 3 && sSec.getWeaponAvaibility()){
               weapon.setWeaponDamage(weapon.getWeaponDamage() + 2);
           }
           mapSwoardSection.put(weaponName, new SwoardSection(weaponLevel+1, sSec.getWeaponCost(), sSec.getWeaponLevelInd(), 
           sSec.getWeaponAvaibility(), sSec.getWeaponApplyHero()));
       }
   }
   public boolean doesStoreHaveWeaponsHero(Hero h){
      boolean valid = false;
      SwoardSection sSec = null;
      
      for(Map.Entry<String, SwoardSection> mapElement: mapSwoardSection.entrySet()){
         sSec = mapElement.getValue();
         
         if(sSec.getWeaponApplyHero().equals(h.getHeroName()) && sSec.getWeaponAvaibility()
         && sSec.getWeaponCost() <= h.getHeroGold()){
            valid = true;
         }
      }
      return valid;
   }
   
}