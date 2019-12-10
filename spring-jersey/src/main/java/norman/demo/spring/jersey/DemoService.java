package norman.demo.spring.jersey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/")
public class DemoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoService.class);

    @GET
    @Path("/hello/{name}")
    @Produces("application/json")
    public Response hello(@PathParam("name") String name) {
        LOGGER.debug("Received request with name=\"" + name + "\"");
        DemoBean bean = new DemoBean();
        bean.setDemoString("Hello " + name + ".");
        return Response.ok().entity(bean).build();
    }
}
