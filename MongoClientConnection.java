package org.alpha;

import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoClientConnection {
    private static MongoClient mongoClient;
    public static synchronized MongoClient getMongoClient(){
        if(mongoClient == null){
            String uri = "mongodb://localhost:27017";
            try{
                mongoClient = MongoClients.create(uri);
            }catch (Exception err){
                System.err.println(err);
            }
        }
        return mongoClient;
    }

    public static MongoDatabase getDatabase(MongoClient mongoclient){
        MongoDatabase database = mongoClient.getDatabase("stockdb");
        return database;
    }
}
