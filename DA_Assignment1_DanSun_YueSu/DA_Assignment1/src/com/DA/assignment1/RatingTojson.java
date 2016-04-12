
package com.DA.assignment1;

import com.mongodb.BasicDBObject;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Dan
 */
public class RatingTojson {
    
    
    private String title;
    private BufferedReader br;
    private FileWriter wr;
    public RatingTojson(String title,String from,String to)throws Exception{
        
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
        BasicDBObject doc;
   
        String line = br.readLine();
        
        if (line != null) {
            String[] items = line.split("::");
            String userID = items[0];
            String movieID = items[1];
            double rating = Double.parseDouble(items[2]);
            String timeStamp = items[3];
            
            doc = new BasicDBObject();
            doc.put("userID", userID);
            doc.put("movieID", movieID);
            doc.put("rating", rating);
            doc.put("timestamp", timeStamp);
            
            return doc.toString();
        }
        return null;
    }
    
}
