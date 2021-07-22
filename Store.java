import java.util.Scanner;

public class Store{
   private Store storeInstanceVarible = null;
    private SwoardSection    swoardSection = null;
    private BowSection       bowSection    = null;
    private StaffSection     staffSection  = null;
    private BallChainSection bcSection     = null;
    private GunsSection      gunSection    = null;
    private ClubSection      clubSection   = null;
   //////////////////////////////////////////////////////////////
   protected int weaponLevel, weaponCost;
   protected boolean weaponLevelInd, weaponAvaibilty;
   protected String weaponApplyHero;
   
   
   public Store(){
       
      
   }
   
   public void loadUpWeaponsToStore(){
      swoardSection.addWeapons();
      bowSection.addWeapons();
      staffSection.addWeapons();
      bcSection.addWeapons();
      gunSection.addWeapons();
      clubSection.addWeapons();
   }
  
   
   
   public Weapon buyWeaponInStore(Hero hero){
       Scanner scan = new Scanner(System.in);
       Weapon uWeapon = null;
       
          listWeapons();
          System.out.println("Please indicate the weapon you would like to buy?");
          System.out.println("Your current gold amount: " + hero.getHeroGold());
          hero.listHeroWeapons();          
          System.out.println("*******************************");
          String userChoice = scan.nextLine();
          uWeapon = getWeapon(userChoice);

          while(!isWeaponValid(uWeapon, hero)){
               userChoice = scan.nextLine();
               uWeapon = getWeapon(userChoice);
            }
            hero.setHeroGold(hero.getHeroGold() - storeInstanceVarible.getWeaponCost());
            storeInstanceVarible.setWeaponAvaibility(false);
            storeInstanceVarible.setWeaponLevelInd(false);
            applyNewWeaponStats(uWeapon.getWeaponName());
       
       
       return uWeapon;
   }
   public void applyWeaponStatsAfterUserDropsWeapon(String weapon){
       Weapon weap = getWeapon(weapon);
       
       if(weap.getWeaponHealth() <= 0){
          storeInstanceVarible.setWeaponAvaibility(false);
          storeInstanceVarible.setWeaponLevelInd(false);
          applyNewWeaponStats(weap.getWeaponName());
       }
       else{
          storeInstanceVarible.setWeaponAvaibility(true);
          storeInstanceVarible.setWeaponLevelInd(true);
          applyNewWeaponStats(weap.getWeaponName());
       }
   }
   private Weapon getWeapon(String weapon){
       Weapon weaponChosen = null;
       
       if(swoardSection.doesWeaponExists(weapon)){
           SwoardFactory sF = new SwoardFactory();
           storeInstanceVarible = swoardSection.returnWeaponStats(weapon);
           swoardSection.setStoreVarible(storeInstanceVarible);
           weaponChosen = sF.createWeapon(weapon);
       }
       else if(bowSection.doesWeaponExists(weapon)){
           BowFactory bF = new BowFactory();
           storeInstanceVarible = bowSection.returnWeaponStats(weapon);
           bowSection.setStoreVarible(storeInstanceVarible);
           weaponChosen = bF.createWeapon(weapon);
       }
       else if(staffSection.doesWeaponExists(weapon)){
           StaffFactory sF = new StaffFactory();
           storeInstanceVarible = staffSection.returnWeaponStats(weapon);
           staffSection.setStoreVarible(storeInstanceVarible);
           weaponChosen = sF.createWeapon(weapon);
            
       }
       else if(bcSection.doesWeaponExists(weapon)){
           BallChainFactory bcFactory = new BallChainFactory();
           storeInstanceVarible = bcSection.returnWeaponStats(weapon);
           bcSection.setStoreVarible(storeInstanceVarible);
           weaponChosen = bcFactory.createWeapon(weapon);
       }
       else if(gunSection.doesWeaponExists(weapon)){
           GunFactory gFactory = new GunFactory(); 
           storeInstanceVarible = gunSection.returnWeaponStats(weapon);
           gunSection.setStoreVarible(storeInstanceVarible);
           weaponChosen = gFactory.createWeapon(weapon); 
       }   

      return weaponChosen; 
   }
   public void levelUpAllWeapons(){
      swoardSection.levelUpWeapons();
      bowSection.levelUpWeapons();
      staffSection.levelUpWeapons();
      bcSection.levelUpWeapons();
      gunSection.levelUpWeapons();
   }
   private void listWeapons(){
      swoardSection.listWeapons();
      bowSection.listWeapons();
      staffSection.listWeapons();
      bcSection.listWeapons();
      gunSection.listWeapons();
   }
   public boolean areWeaponsApplicableToHero(Hero h){
      boolean valid = false;
      if(swoardSection.doesStoreHaveWeaponsHero(h)){
         valid = true;
      }
      else if(bowSection.doesStoreHaveWeaponsHero(h)){
         valid = true;
      }
      else if(staffSection.doesStoreHaveWeaponsHero(h)){
         valid = true;
      }
      else if(bcSection.doesStoreHaveWeaponsHero(h)){
         valid = true;
      }
      else if(gunSection.doesStoreHaveWeaponsHero(h)){
         valid = true;
      }
      return valid;
   }
   private boolean isWeaponValid(Weapon weapon, Hero hero){
      boolean valid = true;
      if(weapon == null){
           System.out.println("I'm sorry, that is not a valid weapon");
           System.out.println("*******************************");
           valid = false;
      }
      else if(!hero.getHeroName().equals(storeInstanceVarible.getWeaponApplyHero())){
           System.out.println("I'm sorry, you are restricted from buying this weapon" + 
           " as your hero type does not correspond that the hero type that the weapon is " + 
           " applicable too");
           System.out.println("Your hero type: " + hero.getHeroName());
           System.out.println("*******************************");
           valid = false;
      }
      else if(hero.getHeroGold() < storeInstanceVarible.getWeaponCost()){
           System.out.println("I'm sorry, you don't have enough gold to purchase this weapon");
           System.out.println("Your gold amount: " + hero.getHeroGold());
           System.out.println("*******************************");
           valid = false;
      }
      else if(!storeInstanceVarible.getWeaponAvaibility()){
           System.out.println("I'm sorry, this weapon is currently unavaible at the moment");
           valid = false;
      }
      return valid;
   }
   public void applyNewWeaponStats(String weapon){
       if(swoardSection.doesWeaponExists(weapon)){
          swoardSection.applyStats(weapon);
       }
       else if(bowSection.doesWeaponExists(weapon)){
          bowSection.applyStats(weapon);
       }
       else if(staffSection.doesWeaponExists(weapon)){
          staffSection.applyStats(weapon);
       }
       else if(bcSection.doesWeaponExists(weapon)){
          bcSection.applyStats(weapon);
       }
       else if(gunSection.doesWeaponExists(weapon)){
          gunSection.applyStats(weapon);
       }   
   }
   public void setWeaponLevel(int wL){
      this.weaponLevel = wL;
   }
   public int getWeaponLevel(){
      return weaponLevel;
   }
   public void setWeaponCost(int wC){
      this.weaponCost = wC;
   }
   public int getWeaponCost(){
      return weaponCost;
   }
   public void setWeaponLevelInd(boolean weaponLevelIndicator){
      this.weaponLevelInd = weaponLevelIndicator;
   }
   public boolean getWeaponLevelInd(){
      return weaponLevelInd;
   }
   public void setWeaponAvaibility(boolean wA){
      this.weaponAvaibilty = wA;
   }
   public boolean getWeaponAvaibility(){
      return weaponAvaibilty;
   }
   public void setWeaponApplyHero(String wAH){
      this.weaponApplyHero = wAH;   
   }
   public String getWeaponApplyHero(){
      return weaponApplyHero;
   }
   public void initlizeStoreInstanceVaribles(){
     swoardSection   = new SwoardSection();
     bowSection    = new BowSection();
     staffSection  = new StaffSection();
     bcSection     = new BallChainSection();
     gunSection    = new GunsSection();
     clubSection   = new ClubSection();
     storeInstanceVarible = new Store();
   }
     
}