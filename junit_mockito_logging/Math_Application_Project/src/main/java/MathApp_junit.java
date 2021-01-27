import junit.framework.TestCase;
import org.junit.Test;

public class MathApp_junit extends TestCase {

    Math_Application_Main junitobj;
    public void setUp(){
        junitobj= new Math_Application_Main();
    }

    @Test
    public  void testubtract(){
        double res =junitobj.subtract(20.0,10.0);
        assertEquals(10.0,res);
    }

    @Test
    public  void testMultiply(){
        double res =junitobj.multiply(20.0,10.0);
        assertEquals(200.0,res);
    }
    @Test
    public  void testAdd(){
        double res =junitobj.add(20.0,10.0);
        assertEquals(30.0,res);
    }
    @Test
    public  void testDivide(){
        double res =junitobj.divide(20.0,10.0);
        assertEquals(2.0,res);
    }

}
