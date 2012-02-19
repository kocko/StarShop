package org.jboss.samples.db.mongo;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class MongoTest {
	public static void main(String[] args) throws UnknownHostException, MongoException {
		Mongo mongo = new Mongo();
		DB db = mongo.getDB("db");
		DBCollection test = db.getCollection("test");
		BasicDBObject insert = new BasicDBObject();
		insert.put("x", 1);
		insert.put("y", "foo");
		test.insert(insert);
		DBObject object = test.findOne();
		System.out.println(object.toString());
	}
}
