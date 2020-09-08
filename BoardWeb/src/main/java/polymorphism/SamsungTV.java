package polymorphism;

public class SamsungTV implements TV{
	private Speaker speaker;
	private int price;
	
	public void print(String str) {
		System.out.println(str);
	}
	public void initMethod() {
		print("��ü �ʱ�ȭ �۾� ó��..");
	}
	
	public void destroyMethod() {
		print("��ü ���� ���� ó���� ���� ó��...");
	}
	
	public SamsungTV() {
		print("===> SamsungTV(1) ��ü ����");
	}
	public void setSpeaker(Speaker speaker) {
		print("===> setSpeaker() ȣ��");
		this.speaker=speaker;
	}
	public void setPrice(int price) {
		print("===> setPrice() ȣ��");
		this.price=price;
	}
	public void powerOn() {
		print("SamsungTV---���� Ų��.(����:"+price+")");
	}
	public void powerOff() {
		print("SamsungTV---���� ����.");
	}
	public void volumeUp() {
		speaker.volumeDown();
	}
	public void volumeDown() {
		speaker.volumeUp();
	}
	

}
