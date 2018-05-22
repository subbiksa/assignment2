package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.scene.control.Label;

class MainTest {

	@Test
	void test() {
		String str = "Junit is working fine";
	    assertEquals("Junit is working fine",str);
	  }
	void test1() {
		  	Label label1 = new Label("Welcome to MININET!");
		    Label label2=new Label("Welcome to MININET!"); 
		    assertEquals(label2, label1);	
	}
}
