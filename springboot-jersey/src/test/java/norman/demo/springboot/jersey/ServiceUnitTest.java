package norman.demo.springboot.jersey;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

public class ServiceUnitTest {
    private DemoService service;

    @Before
    public void setUp() throws Exception {
        service = new DemoService();
    }

    @After
    public void tearDown() throws Exception {
        service = null;
    }

    @Test
    public void hello() {
        Response response = service.hello("foobar");
        assertEquals(Response.Status.OK, response.getStatusInfo());
        assertEquals("Hello foobar.", ((DemoBean) response.getEntity()).getDemoString());
    }
}
