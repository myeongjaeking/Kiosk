package source;


public class PaymentDevice implements PaymentReq{ //결제기기
	private int delay = 0; 
	int p1;
	
	@Override
	public boolean sendPaymentReq(int numCard, int dateYYExpired, int dataMMExpired){
		delay = dateYYExpired;
		this.p1=numCard;
		System.out.println(p1);
		if(numCard % 2 == 1) {
			return false;
		}  
		else if(dateYYExpired < 23) {  //기한
			return false;
		}
		else if(dateYYExpired == 23 && dataMMExpired < 6) { //기한
			return false;
		}
		
		else {
			return true;
		}
	}
	@Override
	public int receivePaymentRes() { //이게 머라고?
		if(delay--<0) {
			return RES_SUCCESS;
		}
		else {
			return RES_WAIT;
		}
	}
}