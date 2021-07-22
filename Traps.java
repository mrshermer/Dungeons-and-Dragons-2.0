public abstract class Traps
{
   private int userCol = 0;
   private int userRow = 0;
   
   public abstract void performTrapEffect(int currRow, int currCol, Object[][] maze);

   public void setUserCol(int col){
      this.userCol = col;
   }
   public int getUserCol(){
      return userCol;
   }
   public void setUserRow(int row){
      this.userRow = row;
   }
   public int getUserRow(){
      return userRow;
   }
   public abstract void trapDescription();

}