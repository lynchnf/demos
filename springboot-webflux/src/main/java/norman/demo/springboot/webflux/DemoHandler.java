package norman.demo.springboot.webflux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class DemoHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoHandler.class);

    public Mono<ServerResponse> hello(ServerRequest request) {
        String name = request.pathVariable("name");
        LOGGER.debug("Received request with name=\"" + name + "\"");
        DemoBean bean = new DemoBean();
        bean.setDemoString("Hello " + name + ".");
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(BodyInserters.fromObject(bean));
    }
}
