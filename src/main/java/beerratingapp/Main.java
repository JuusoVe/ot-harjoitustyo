package beerratingapp.domain;

import java.io.File;
import java.util.ArrayList;
import beerratingapp.dao.FileReviewDao;
import beerratingapp.dao.ReviewDao;



public class Main {
    public static void main(String[] args) throws Exception {
        
        File file = new File("resources/TestFile.txt");
        System.out.println("file we're passing to dao: " + file.toString());
        ReviewDao brdao = new FileReviewDao(file.toString());
        ArrayList<Review> reviews = brdao.getAll();
        
        System.out.println("number of reviews before writing: " + reviews.size());
        
        Review rev = reviews.get(0);
        System.out.println("some content from first review: " + rev.getNotes());
        
        int[] parts = new int[4];
        Review newRev = new Review(666, "myBeer", "myBrewery", "myStyle", 
                "June 6th 2020", "tastes like well fermented piss", 
                4.8, 13, 1.046, new int[]{1, 2, 3, 4}, 2.2);
        brdao.create(newRev);
       
        
        

    }
}
