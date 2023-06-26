package source;

public class OrderDevice implements OrderNumber{ //번호표 장치
	private static int orderNumber = 0;
	
	@Override
	public int getOrderNumber() {  //추상메소드 구현함
		if(orderNumber > 100) {  
			orderNumber = 1;
		} else {
			orderNumber++;
		}
		return orderNumber;
	}
}
