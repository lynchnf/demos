package norman.demo.springboot.webflux;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class WebClientTest {
    @Autowired
    private WebTestClient webClient;

    @Test
    public void hello() {
        //@formatter:off
        webClient.get().uri("/hello/foobar").accept(APPLICATION_JSON).exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("$.demoString").isEqualTo("Hello foobar.");
        //@formatter:on
    }
}
