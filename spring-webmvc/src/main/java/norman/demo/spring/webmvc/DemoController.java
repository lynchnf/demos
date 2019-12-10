package norman.demo.spring.webmvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);
    private static ObjectMapper mapper = new ObjectMapper();

    @GetMapping(value = "/hello/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> hello(@PathVariable("name") String name) {
        LOGGER.debug("Received request with name=\"" + name + "\"");
        DemoBean bean = new DemoBean();
        bean.setDemoString("Hello " + name + ".");
        try {
            return new ResponseEntity<>(mapper.writeValueAsString(bean), HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting bean to JSON", e);
        }
    }
}
