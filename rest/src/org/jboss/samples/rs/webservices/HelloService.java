package org.jboss.samples.rs.webservices;

import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlElement;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * A simple RESTful service.
 * @author kocko
 */
@Path("/hello")
public class HelloService {

	/**
	 * Says 'hello'.
	 * @return
	 */
	@GET()
	@Produces("text/plain")
	public String sayHello() {
		return "Hello World!";
	}

	@GET
	@Path("/kocko")
	@XmlElement(name="kocko")
	public String kocko() {
		return "Kocko says Hi!";
	}
	
	@GET
	@Path("/insert/{x}/{y}")
	@Produces("text/plain")
	public String insert(@PathParam(value = "x") Integer x, @PathParam(value = "y") String y) throws UnknownHostException, MongoException{
		Mongo mongo = new Mongo();
		DB db = mongo.getDB("db");
		DBCollection test = db.getCollection("test");
		BasicDBObject insert = new BasicDBObject();
		insert.put("x", x);
		insert.put("y", y);
		test.ensureIndex(insert);
		test.insert(insert);
		mongo.close();
		return "success";
	}
	
	@GET
	@Path("/mongo")
	@Produces("text/plain")
	public String mongo() throws UnknownHostException, MongoException {
		Mongo mongo = new Mongo();
		DB db = mongo.getDB("db");
		DBCollection test = db.getCollection("test");
		BasicDBObject insert = new BasicDBObject();
		insert.put("x", 1);
		insert.put("y", "foo");
		test.insert(insert);
		DBObject object = test.findOne();
		mongo.close();
		return "x = " + object.get("x").toString() + "; y = " + object.get("y").toString();
	}
}
