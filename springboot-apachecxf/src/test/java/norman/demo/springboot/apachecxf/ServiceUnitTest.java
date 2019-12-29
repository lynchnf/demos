package norman.demo.springboot.apachecxf;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceUnitTest {
    private DemoService service;

    @Before
    public void setUp() throws Exception {
        service = new DemoServiceImpl();
    }

    @After
    public void tearDown() throws Exception {
        service = null;
    }

    @Test
    public void hello() {
        DemoBean bean = service.hello("foobar");
        assertEquals("Hello foobar.", bean.getDemoString());
    }
}