package norman.demo.springboot.webmvc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

public class ControllerUnitTest {
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
        ResponseEntity<DemoBean> response = controller.hello("foobar");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Hello foobar.", response.getBody().getDemoString());
    }
}
