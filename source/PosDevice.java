package source;

public class PosDevice implements PurchaseOrder{  //주문서
   @Override
   public void sendOrder(int OrderNum, String menuName) { //주문번호 //메누이름//개수
      System.out.println("Order["+OrderNum+"]"+'\n'+menuName);
      return;
   };

}