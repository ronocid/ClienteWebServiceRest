package com.client;

import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class UserClient {
	public static final String BASE_URI = "http://localhost:8080/WebServiceRest";
	public static final String PATH_NAME = "/InfoService/saludo/";
	public static final String PATH_AGE = "/InfoService/suma/";
	
	public static void main (String [] args){
		String name ="Pepe";
		int n1 = 2;
		int n2 = 4;
		
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource resource = client.resource(BASE_URI);
		
		WebResource nameResource = resource.path("restService").path(PATH_NAME+"name="+name);
		System.out.println("Cliente Response \n" + getClientResponse(nameResource));
		System.out.println("Response \n" + getResponse(nameResource) +"\n\n");
		
		WebResource ageResource = resource.path("restService").path(PATH_AGE+"n1="+n1+"&n2="+n2);
		System.out.println("Cliente Response \n" + getClientResponse(ageResource));
		System.out.println("Response \n" + getResponse(ageResource) +"\n\n");
	}
	
	private static String getClientResponse(WebResource resource){
		return resource.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();
	}
	
	private static String getResponse(WebResource resource){
		return resource.accept(MediaType.TEXT_XML).get(String.class);
	}
}
