package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
	
	@Autowired
	private Speaker speaker;
	
	public void print(String str) {
		System.out.println(str);
	}
	
	public void powerOn() {
		print("LgTV---전원 킨다.");
	}
	public void powerOff() {
		print("LgTV---전원 끈다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	
	
}
