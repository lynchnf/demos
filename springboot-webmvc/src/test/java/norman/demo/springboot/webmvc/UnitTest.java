package norman.demo.springboot.webmvc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest {
    private DemoController controller;

    @Before
    public void setUp() throws Exception {
        controller = new DemoController();
    }

    @After
    public void tearDown() throws Exception {
        controller = null;
    }

    @Test
    public void hello() {
        DemoBean bean = controller.hello("foobar");
        assertEquals("Hello foobar.", bean.getDemoString());
    }
}