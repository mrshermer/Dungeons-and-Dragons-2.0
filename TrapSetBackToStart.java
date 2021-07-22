public class TrapSetBackToStart extends Traps{
   public void performTrapEffect(int currRow, int currCol, Object[][] maze){
      setUserRow(1);
      setUserCol(1);
   }
   public void trapDescription(){
      System.out.println("Welcome to the transportation trap, you will be transporated to the start, sorry:(");
      System.out.println("*******************************");
   }

}