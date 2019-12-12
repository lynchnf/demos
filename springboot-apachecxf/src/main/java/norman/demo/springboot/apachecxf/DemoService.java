package norman.demo.springboot.apachecxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "DemoService")
public interface DemoService {
    @WebMethod
    @WebResult(name = "DemoBean")
    DemoBean hello(@WebParam(name = "name") String name);
}
