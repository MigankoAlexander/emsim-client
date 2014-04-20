/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emsimclient;

import wsdl2java.Incident;
import wsdl2java.RequestProcess;
import wsdl2java.RequestProcessService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
/**
 *
 * @author Miganko
 */
public class ClientRequest {
    final QName qName = new QName("http://wsdl2java", "RequestProcess");

	public static List<Incident> runRequest(String serverURL, List<Double> params) {
       
		URL url = getWSDLURL(serverURL);
		ClientRequest client = new ClientRequest();
                return client.processRequest(url, params);
	}

	private static URL getWSDLURL(String urlStr) {
		URL url = null;
		try {
			url = new URL(urlStr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return url;
	}

	public List<Incident> processRequest(URL url, List<Double> params) {

		RequestProcess requestProcessingService = new RequestProcess(url, qName);

		System.out.println("Service is" + requestProcessingService);

		RequestProcessService port = requestProcessingService.getRequestProcessPort();
		List<Incident> orderResponse = port.processRequest(params);
               
        return orderResponse;

	}
}
