package polymorphism;

import org.springframework.stereotype.Component;

public class SonySpeaker implements Speaker{
	public void print(String str) {
		System.out.println(str);
	}
	public SonySpeaker() {
		print("===> SonySpeaker 按眉 积己");
	}
	
	public  void volumeUp() {
		print("SonySpeaker---家府 棵赴促.");
	}
	public void volumeDown() {
		print("SonySpeaker---家府 郴赴促.");
	}
}