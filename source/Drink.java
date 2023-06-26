package source;

public class Drink {
   private String drinkName = "";
   private int itemCount = 1; // 선택한 메뉴의 개수
   private int addShotCount = 0; // 샷 추가 개수
   private int vCount = 0; // 바닐라 시럽 개수
   private int hCount = 0; // 헤이즐넛 시럽 개수
   private int wCount = 0; // 휘핑 추가 개수
   private int itemPrice = 0;
   
   // 접근자
   public int getItemCount() {return itemCount;}
   public int getShotCount() {return addShotCount;}
   public int getVCount() {return vCount;}
   public int getHCount() {return hCount;}
   public int getWCount() {return wCount;}
   public String getDrinkName() {return drinkName;}
   public int getPrice() {return itemPrice;}
   public int getTotalPrice() {
      return this.itemCount * this.itemPrice
            + (500 * (vCount + wCount + hCount + addShotCount));
   }
   public boolean getOptionIsEmpty(){return(addShotCount==0&&vCount==0&&hCount==0&&wCount==0);}
   // 설정자
   public void setItemCount(int count) {this.itemCount = count;}
   
   // 내용 초기화
   public void init() {
      this.itemCount = 1;
      this.addShotCount = 0;
      this.vCount=0;
      this.hCount=0;
      this.wCount=0;
   }
   
   // Constructor
    public Drink(String drinkName, int itemCount, int addShotCount, int vCount, int hCount, int wCount, int price) {
       this.drinkName = drinkName;
       this.itemCount = itemCount;
       this.addShotCount = addShotCount;
       this.vCount = vCount;
       this.wCount = wCount;
       this.hCount = hCount;
       this.itemPrice = price;
       System.out.println("Drink>>"+itemPrice);
    }
}
