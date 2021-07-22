import java.util.HashMap;
import java.util.Map;

public class BallChainSection extends Store{
   private HashMap<String, BallChainSection> mapBallChainSection = new HashMap<String, BallChainSection>();
   private Store store = null;
   private BallChainFactory bF = null;
   private Weapon weapon = null;
  
   public BallChainSection(){
      
   }
  
   public BallChainSection(int wL, int wC, boolean wLInd, boolean wA, String wAH){
         weaponLevel = wL;
         weaponCost = wC;
         weaponLevelInd = wLInd;
         weaponAvaibilty = wA;
         weaponApplyHero = wAH; 
   }
   public void addWeapons(){
      mapBallChainSection.put("Ball Chain", new BallChainSection(1, 5, true, true, "Mage"));
      mapBallChainSection.put("BallSpikesChain", new BallChainSection(1, 10, true, true, "Mage"));
      mapBallChainSection.put("SteelBallChain", new BallChainSection(1, 15, true, true, "Mage"));
   }
   public void setStoreVarible(Store s){
      this.store = s;
   }
   public Store getStore(){
      return store;
   }
   
   public BallChainSection returnWeaponStats(String weapon){
      BallChainSection ballChainSec = mapBallChainSection.get(weapon);
      return ballChainSec;
   }
   public boolean doesWeaponExists(String weapon){
      return mapBallChainSection.containsKey(weapon);
   }
   public void applyStats(String weapon){
      mapBallChainSection.put(weapon, new BallChainSection(store.getWeaponLevel(), 
      store.getWeaponCost(), store.getWeaponLevelInd(), store.getWeaponAvaibility(), store.getWeaponApplyHero()));
   }
   public void listWeapons(){
       System.out.println("---------------------------");
       BallChainSection bcSec = null;
       bF = new BallChainFactory();
       
       for(Map.Entry<String, BallChainSection> mapElement: mapBallChainSection.entrySet()){
          String weaponName =  mapElement.getKey();
          bcSec = mapElement.getValue();
          weapon = bF.createWeapon(weaponName);
          
          System.out.println(weaponName + "\nWeapon Cost: " + bcSec.getWeaponCost() + 
          "\nWeapon Damage: " + weapon.getWeaponDamage() + "\nWeapon Avaibility: " + bcSec.getWeaponAvaibility() +
          "\nHeroWeaponCategory: " + bcSec.getWeaponApplyHero());  
          System.out.println("*******************************");
          System.out.println();
       }
       System.out.println("---------------------------");
   }
   public void levelUpWeapons(){
       bF = new BallChainFactory();
      
      for(Map.Entry mapElement: mapBallChainSection.entrySet()){
           String weaponName = (String) mapElement.getKey();
           BallChainSection sSec = (BallChainSection)mapElement.getValue();
           Weapon weapon = bF.createWeapon(weaponName);
           
           if(sSec.getWeaponLevel() == 1 && sSec.getWeaponAvaibility()){
               weapon.setWeaponDamage(weapon.getWeaponDamage() + 1);
               
           }
           else if(sSec.getWeaponLevel() == 2 && sSec.getWeaponAvaibility()){
               weapon.setWeaponDamage(weapon.getWeaponDamage() + 1.5);
           }
           else if(sSec.getWeaponLevel() == 3 && sSec.getWeaponAvaibility()){
               weapon.setWeaponDamage(weapon.getWeaponDamage() + 2);
           }
           mapBallChainSection.put(weaponName, new BallChainSection(weaponLevel+1, sSec.getWeaponCost(), sSec.getWeaponLevelInd(), 
           sSec.getWeaponAvaibility(), sSec.getWeaponApplyHero()));
        }
   }
   public boolean doesStoreHaveWeaponsHero(Hero h){
      boolean valid = false;
      BallChainSection sSec = null;
      
      for(Map.Entry<String, BallChainSection> mapElement: mapBallChainSection.entrySet()){
         sSec = mapElement.getValue();
         
         if(sSec.getWeaponApplyHero().equals(h.getHeroName()) && sSec.getWeaponAvaibility()
         && sSec.getWeaponCost() <= h.getHeroGold()){
            valid = true;
         }
      }
      return valid;
   }
}