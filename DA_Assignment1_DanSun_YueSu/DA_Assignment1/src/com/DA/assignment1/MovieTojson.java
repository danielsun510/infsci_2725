/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DA.assignment1;

import com.mongodb.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author Dan
 */
public class MovieTojson {
    
    
    private String title;
    private BufferedReader br;
    private FileWriter wr;
    public MovieTojson(String title,String from,String to)throws Exception{
        
        this.title  = title;
        this.br=new BufferedReader(new InputStreamReader(new FileInputStream(from)));
        this.wr = new FileWriter(to);
        generateJson();
    } 
    
    private void generateJson()throws Exception{
        String row = this.addRows();
        int count = 0;
        while (row != null) {
            wr.append(row + "\n");
            row = this.addRows();
            count++;
            if (count % 10000 == 0) {
                System.out.println("finished------" + count);
            }
        }

        wr.close();
    }
        
       private String addRows() throws Exception {
        
       
        BasicDBObject doc=null;
       
        String line = br.readLine();
        
        if (line != null) {
            String[] items = line.split("::");
            String movieID = items[0];
            String movieTitle = items[1];
            String[] generes = items[2].split("\\|");
            
            doc = new BasicDBObject();
            doc.put("movieID", movieID);
            doc.put("title", movieTitle);
            doc.put("generes", generes);
            
            return doc.toString();
        }
        return null;
    }  
    
}
