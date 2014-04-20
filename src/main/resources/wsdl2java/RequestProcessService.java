package wsdl2java;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.0-milestone2
 * 2014-04-20T12:43:11.108+04:00
 * Generated source version: 3.0.0-milestone2
 * 
 */
@WebService(targetNamespace = "http://wsdl2java", name = "RequestProcessService")
@XmlSeeAlso({ObjectFactory.class})
public interface RequestProcessService {

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://wsdl2java/RequestProcessService/processRequestRequest", output = "http://wsdl2java/RequestProcessService/processRequestResponse")
    @RequestWrapper(localName = "processRequest", targetNamespace = "http://wsdl2java", className = "wsdl2java.ProcessRequest")
    @WebMethod
    @ResponseWrapper(localName = "processRequestResponse", targetNamespace = "http://wsdl2java", className = "wsdl2java.ProcessRequestResponse")
    public java.util.List<wsdl2java.Incident> processRequest(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<java.lang.Double> arg0
    );
}