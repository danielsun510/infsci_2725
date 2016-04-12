/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DA.assignment1.Query;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.util.JSON;
import org.bson.Document;



/**
 *
 * @author Dan
 */
public class Question3 {
    
      MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");
    public void Answer(){
      
      
     
        
        //find MovieID
         FindIterable<Document> movieID = db.getCollection("movies").find(eq("title", "2001: A Space Odyssey (1968)"));
          movieID.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
               // String Mytitle =document;
                //System.out.println("hah");
                 String MymovieID = document.getString("movieID");
               
                 findTag(MymovieID);
                
            }
        });
        
        
    }
    
    
    public void findTag(String movieID){
        
          //find tags
           FindIterable<Document> userID = db.getCollection("tags").find(and(eq("userID", "146"),eq("movieID",movieID)));
           userID.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
               // String Mytitle =document;
                //System.out.println("hah");
               String tags = document.getString("tag");
               
               System.out.println(tags);
                
            }
        });
        
        
    }
    
    
    
    
}
