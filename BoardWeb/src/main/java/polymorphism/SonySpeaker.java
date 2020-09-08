package polymorphism;

import org.springframework.stereotype.Component;

public class SonySpeaker implements Speaker{
	public void print(String str) {
		System.out.println(str);
	}
	public SonySpeaker() {
		print("===> SonySpeaker ��ü ����");
	}
	
	public  void volumeUp() {
		print("SonySpeaker---�Ҹ� �ø���.");
	}
	public void volumeDown() {
		print("SonySpeaker---�Ҹ� ������.");
	}
}