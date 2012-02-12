package service.subscription;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class SubscribtionService {
	
	public static void subscribe(String email){
		Client client = Client.create();
		WebResource r = client.resource("http://78.90.148.47:7245/rest/subscribe/"+email);
		String resp = r.post(String.class);
		System.out.println(resp);
	}
}
