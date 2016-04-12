/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DA.assignment1.Query;


import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.bson.Document;


public class Demonstrate {
    public void Answer() throws Exception{
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> tag = db.getCollection("tags");
        MongoCollection<Document> movie = db.getCollection("movies");
        MongoCollection<Document> rating = db.getCollection("ratings");
        
        
        sum(movie);
        
        //selectMovie(rating);
        
        Tag(tag);
        
   
    }
    public static void sum(MongoCollection<Document> movie){
        long sum = movie.count();
        System.out.println("the total movies are: "+sum);
    }
    
    public static void selectMovie(MongoCollection<Document> rating) throws IOException{
        System.out.println("Please enter userID: you can check the rating records ");
	BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        String userID = br1.readLine();
        
            FindIterable<Document> movies = rating.find(
            new Document("userID", userID));
            
            movies.forEach(new Block<Document>() {
                @Override
                public void apply(final Document document) {
                    System.out.println(document);
                }
            });
             
    }
    
    public static void Tag(MongoCollection<Document> tag) throws IOException{
        System.out.println("Please enter movieID:");
        
        
	BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        String movieID = br1.readLine();
       
            FindIterable<Document> tags = tag.find(new Document("movieID", movieID));
            tags.forEach(new Block<Document>() {
                @Override
                public void apply(final Document document) {
                    System.out.println(document);
                }
            });
        }
        
    }

        
       

