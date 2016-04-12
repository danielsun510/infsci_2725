/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DA.assignment1.Query;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static java.util.Arrays.asList;
import org.bson.Document;

/**
 *
 * @author Dan
 */
public class Question4 {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");
    public void Answer(){
        
    
    
        AggregateIterable<Document> iterable = db.getCollection("ratings").aggregate(asList(
        new Document("$group", new Document("_id", "$movieID").append("AVR_Rating", new Document("$avg", "$rating"))),
                new Document("$sort",new Document("AVR_Rating",-1))));

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
               String movie_id = document.getString("_id");
               double rating =document.getDouble("AVR_Rating");
               System.out.print("Movie_id: "+movie_id+"  Rating: "+rating+"  Title: ");
                findMovie(movie_id);
              //  System.out.println(document);
            }
        });
    }
    
    public void findMovie(String MymovieID ){
        
        //String MyRating =document.getString("AVR_Rating");
       
        
        FindIterable<Document> userID = db.getCollection("movies").find(eq("movieID",MymovieID));
           userID.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
               // String Mytitle =document;
                //System.out.println("hah");
               String titles = document.getString("title");
              
               System.out.println(titles);
                
            }
        });
        
        
        
    }
    
}
