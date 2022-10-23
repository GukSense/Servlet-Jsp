package practice;

public enum Country2 {
	
	
	KOREA(82, 1.1f),
	USA(1, 1.2f),
	UK(44, 1.3f),
	ETC(0, 1.5f);
	
	private final int code;
	private final float tax;
	
	Country2(int code, float tax){
		this.code = code;
		this.tax = tax;
	}
	
	public float getRefundTax() {
		float refundTax = tax;
		
		if (code != 0) 
			refundTax = tax - 0.1f;
			
		
		
		return refundTax;
			

	}
	
	public float getTax() {
		return tax;
	}
	
	public String getString() {
		
		String returnToHangul = "";
		
		switch(Country2.this) {
		case KOREA:
			returnToHangul = "[대한민국] ";
			break;
		case USA:
			returnToHangul = "[미국] ";
			break;
		case UK:
			returnToHangul = "[영국] ";
			break;
		default:
			returnToHangul = "";
			break;
		}
		
		return returnToHangul;
	}
	
}
