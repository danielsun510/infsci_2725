/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DA.assignment1.Query;

import com.mongodb.BasicDBList;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.Block;
import static com.mongodb.client.model.Filters.eq;

/**
 *
 * @author Dan
 */
public class Question1 {
    
    public void Answer(){
        
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");
       
       
        FindIterable<Document> iterable1 = db.getCollection("movies").find(new Document("title", "Copycat (1995)"));
        iterable1.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
                //System.out.println("hah");
                
            }
        });
        
        
        
    }
    
}
