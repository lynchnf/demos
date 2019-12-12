package norman.demo.springboot.apachecxf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public DemoBean hello(String name) {
        LOGGER.debug("Received request with name=\"" + name + "\"");
        DemoBean bean = new DemoBean();
        bean.setDemoString("Hello " + name + ".");
        return bean;
    }
}
