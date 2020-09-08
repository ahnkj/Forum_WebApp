package polymorphism;

import org.springframework.stereotype.Component;



public class AppleSpeaker implements Speaker{
	public void print(String str) {System.out.println(str);}
	
	public AppleSpeaker() {
		print("===> AppleSpeaker ��ü ����");
	}
	public void volumeUp() {
		print("AppleSpeaker---�Ҹ� �ø���.");
	}

	public void volumeDown() {
		print("AppleSpeaker---�Ҹ� ������.");
	}
	
}
