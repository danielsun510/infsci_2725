/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DA.assignment1;

import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import java.io.FileWriter;

/**
 *
 * @author Dan
 */
public class Main {
    
    
       public static void main(String[] args) throws Exception{
           
           
        MovieTojson mJson = new MovieTojson("movies","data//movies.dat","data//movies.json");   
        RatingTojson ratingJson = new RatingTojson("ratings","data//ratings.dat","data//ratings.json"); 
        TagTojson tagJson = new TagTojson("tags","data//tags.dat","data//tags.json");
        
   
    }
    

    
    
    
}
