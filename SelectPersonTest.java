package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.scene.control.Label;

class SelectPersonTest {

	@Test
	void test() {
		String str = "Junit is working!";
	    assertEquals("Junit is working fine",str);
	  }
	void test1() {
		  	Label label1 = new Label("Select a Profile");
		    Label label2=new Label("Select a Profile"); 
		    assertEquals(label2, label1);	
	}
}
