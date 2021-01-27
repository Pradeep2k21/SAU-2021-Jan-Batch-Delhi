import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

    @RunWith(MockitoJUnitRunner.class)
    public class Math_application_tester{

        @InjectMocks
        Math_Application_Main m_Application = new Math_Application_Main();

        @Mock
        ServiceCalculator calcService;


        @Test
        public void testAdd(){

            when(calcService.add(10.0,20.0)).thenReturn(30.0);
            when(calcService.add(20.0,30.0)).thenReturn(50.0);

            Assert.assertEquals(m_Application.add(10.0,20.0),30.0,0);
            Assert.assertEquals(m_Application.add(20.0,30.0),50.0,0);

            Mockito.verify(calcService,atLeast(1)).add(10.0,20.0);

        }

        @Test
        public void testSubtract(){

            when(calcService.subtract(40.0,20.0)).thenReturn(60.0);
            when(calcService.subtract(40.0,30.0)).thenReturn(10.0);

            Assert.assertEquals(m_Application.subtract(40.0,20.0),60.0,0);
            Assert.assertEquals(m_Application.subtract(40.0,30.0),10.0,0);

            Mockito.verify(calcService,atLeast(1)).subtract(40.0,20.0);

        }

        @Test
        public void testMultiply(){

            when(calcService.multiply(10.0,20.0)).thenReturn(200.0);
            when(calcService.multiply(20.0,30.0)).thenReturn(600.0);

            Assert.assertEquals(m_Application.multiply(10.0,20.0),200.0,0);
            Assert.assertEquals(m_Application.multiply(20.0,30.0),600.0,0);

            Mockito.verify(calcService,atLeast(1)).multiply(10.0,20.0);

        }

        @Test
        public void testDivide(){

            when(calcService.divide(40.0,20.0)).thenReturn(2.0);
            when(calcService.divide(90.0,30.0)).thenReturn(3.0);

            Assert.assertEquals(m_Application.divide(40.0,20.0),2.0,0);
            Assert.assertEquals(m_Application.divide(90.0,30.0),3.0,0);

            Mockito.verify(calcService,atLeast(1)).divide(40.0,20.0);

        }


    }
