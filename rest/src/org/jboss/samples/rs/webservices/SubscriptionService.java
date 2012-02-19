/**
* @author kocko
*/
package org.jboss.samples.rs.webservices;

import java.util.Date;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
* Sibscription service;
* @author kocko
*/
@Path("/subscribe")
public class SubscriptionService {	
	@POST
	@Path("/{email}")
	public String subscribe(@PathParam(value = "email") String email) throws MongoException {
		try {
			Mongo mongo = new Mongo();
			DB db = mongo.getDB("db");
			DBCollection subscriptionsCollection = db.getCollection("subscriptions");
			BasicDBObject newSubscription = new BasicDBObject();
			newSubscription.put("email", email);
			newSubscription.put("date", new Date());
			subscriptionsCollection.ensureIndex(newSubscription);
			subscriptionsCollection.insert(newSubscription);
			mongo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "OK";
	}
}
