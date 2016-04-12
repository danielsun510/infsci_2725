package com.DA.assignment1.Query;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoDatabase;
import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.List;
import org.bson.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dan
 */
public class Question2 {
    
    public void Answer(){
        
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");
       
       
        
        AggregateIterable<Document> iterable = db.getCollection("movies").aggregate(asList(new Document("$unwind","$generes"),
        new Document("$group", new Document("_id", "$generes").append("count", new Document("$sum", 1))),
        new Document("$sort",new Document("count",-1))));
        
          iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        });
          
          
          
       
    }
     
    
    
}
