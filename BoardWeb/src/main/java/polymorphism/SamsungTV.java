package polymorphism;

public class SamsungTV implements TV{
	private Speaker speaker;
	private int price;
	
	public void print(String str) {
		System.out.println(str);
	}
	public void initMethod() {
		print("객체 초기화 작업 처리..");
	}
	
	public void destroyMethod() {
		print("객체 삭제 전에 처리할 로직 처리...");
	}
	
	public SamsungTV() {
		print("===> SamsungTV(1) 객체 생성");
	}
	public void setSpeaker(Speaker speaker) {
		print("===> setSpeaker() 호출");
		this.speaker=speaker;
	}
	public void setPrice(int price) {
		print("===> setPrice() 호출");
		this.price=price;
	}
	public void powerOn() {
		print("SamsungTV---전원 킨다.(가격:"+price+")");
	}
	public void powerOff() {
		print("SamsungTV---전원 끈다.");
	}
	public void volumeUp() {
		speaker.volumeDown();
	}
	public void volumeDown() {
		speaker.volumeUp();
	}
	

}
