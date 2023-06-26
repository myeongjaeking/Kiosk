package source;

public class Kiosk extends Menu{
   private PaymentDevice payDev; //결제쳌,
   private OrderNumber numDev;  //번호표 
   private PurchaseOrder posDev; //
   public static Kiosk k;
   public static boolean onOff=false;
   public int num;
   private int numCard;
   private int dateYYExpired;
   private int dateMMExpired;
   public void setnumCard(int num){this.numCard=num;}
   public void setdateYYExpired(int Y){this.dateYYExpired=Y;}
   public void setdateMMExpired(int M){this.dateMMExpired=M;}
   
   public Kiosk(){}
   public Kiosk(PaymentDevice payDev,OrderNumber numDev,PurchaseOrder posDev){
      
      this.numDev=numDev;
      this.payDev=payDev;
      this.posDev=posDev;
      new First(); //첫시작
      
   }

   public static void main(String[] args) {
      System.out.println("--------");
      OrderDevice  numDev =new OrderDevice();
      PaymentDevice payDev=new PaymentDevice();
      PosDevice posDev=new PosDevice();
      k=new Kiosk(payDev,numDev,posDev);
      
   }

  public void Excution(){
     boolean res=this.payDev.sendPaymentReq(numCard, dateYYExpired,dateMMExpired); //카드 정보
     System.out.println(res);
    
     if(res==true) {
         num=numDev.getOrderNumber();
         for(int i=0;i<50;i++){
                System.out.println(i+1);
                if(payDev.receivePaymentRes()==PaymentReq.RES_WAIT)continue;
                else if(payDev.receivePaymentRes()==PaymentReq.RES_SUCCESS){System.out.println("성공");break;}
             }
              posDev.sendOrder(num, Menu.menuArea.getText());
               new OrderMange();
               Menu.menuArea.setText("");
               Menu.menuSum=0;
               Menu.selectedTop=0;  

      }
      else {
         System.out.println("등록된 카드가 아닙니다. 처음부터 다시 선택해주세요.");
         new ChooseCardNumber();
      }
  }
}
