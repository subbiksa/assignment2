package application;
/**
* 
*  
* @author  Richa Rawat
* @version 2.0
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class parent_ChildrenTest {

    @Test
    void test() {//default
        fail("Not yet implemented");
    }
    
    void viewChildrenTest() { //test to check if children of a couple is valid
        String fatherName = "Ross Geller";
        String motherName = "Monica Geller";
        String child = "Rachel Geller";
        System.out.println(fatherName +" and " + motherName +" have child "+ child);
    }
    

}