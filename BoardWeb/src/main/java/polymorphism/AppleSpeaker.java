package polymorphism;

import org.springframework.stereotype.Component;



public class AppleSpeaker implements Speaker{
	public void print(String str) {System.out.println(str);}
	
	public AppleSpeaker() {
		print("===> AppleSpeaker 按眉 积己");
	}
	public void volumeUp() {
		print("AppleSpeaker---家府 棵赴促.");
	}

	public void volumeDown() {
		print("AppleSpeaker---家府 郴赴促.");
	}
	
}
