package norman.demo.springboot.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig extends ResourceConfig {
    public DemoConfig() {
        register(DemoService.class);
    }
}
