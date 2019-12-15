package norman.demo.spring.webmvc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

import static org.junit.Assert.*;

public class RestTemplateIT {
    private String port = System.getProperty("servlet.port");
    private RestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        restTemplate = new RestTemplate();
    }

    @After
    public void tearDown() throws Exception {
        restTemplate = null;
    }

    @Test
    public void hello() throws Exception {
        URL url = new URL(("http://localhost:" + port + "/spring-webmvc") + "/hello/foobar");
        ResponseEntity<DemoBean> response = restTemplate.getForEntity(url.toURI(), DemoBean.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Hello foobar.", response.getBody().getDemoString());
    }
}
