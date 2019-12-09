package norman.demo.springboot.webmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/hello/{name}")
    public ResponseEntity<DemoBean> hello(@PathVariable("name") String name) {
        LOGGER.debug("Received request with name=\"" + name + "\"");
        DemoBean bean = new DemoBean();
        bean.setDemoString("Hello " + name + ".");
        return new ResponseEntity<>(bean, HttpStatus.OK);
    }
}
