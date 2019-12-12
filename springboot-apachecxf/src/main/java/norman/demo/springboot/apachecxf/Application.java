package norman.demo.springboot.apachecxf;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.xml.ws.Endpoint;

@SpringBootApplication
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.debug("Starting Application");
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus getSpringBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint getEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(getSpringBus(), new DemoServiceImpl());
        endpoint.publish("/DemoService");
        return endpoint;
    }
}
