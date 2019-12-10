package norman.demo.spring.jersey;

import org.glassfish.jersey.server.ResourceConfig;

public class DemoConfig extends ResourceConfig {
    public DemoConfig() {
        register(DemoService.class);
    }
}
