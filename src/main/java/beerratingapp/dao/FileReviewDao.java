package beerratingapp.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import beerratingapp.domain.Review;
/**
 *
 * @author juuso
 */
public class FileReviewDao implements ReviewDao {
    
    public ArrayList<Review> reviewsList;
    private String file;
    
    public FileReviewDao(String file) throws Exception {
        reviewsList = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                String name = parts[0];
                String brewery = parts[1];
                String style = parts[2];
                String date = parts[3];
                String notes = parts[4];   
                double abv = Double.parseDouble(parts[5]);
                double ibu = Double.parseDouble(parts[6]);
                double og = Double.parseDouble(parts[7]);
                int[] partScores = new int[4];
                String[] partialParts = parts[8].split(",");
                for (int i = 0; i < partialParts.length; i++) {
                    partialParts[i] = partialParts[i].trim(); 
                    partScores[i] = Integer.parseInt(partialParts[i]);
                }
                double average = Double.parseDouble(parts[9]);
                Review review = new Review(name, brewery, style, date, notes, abv, ibu, og, partScores, average);
                reviewsList.add(review);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
        
    }
    
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Review review: reviewsList) {
                writer.write(review.getName() + ";" + review.getBrewery() + ";" +
                    review.getStyle() + ";" + review.getDate() + ";" + review.getNotes() + ";" + review.getAbv() + ";" +
                    review.getIbu() + ";" + review.getOg() + ";" + review.getPartScores()[0] + "," + review.getPartScores()[1] +
                    "," + review.getPartScores()[2] + "," + review.getPartScores()[3] + ";" + review.getAverage() + "\n");
            }
        }
    }    

    
    @Override
    public ArrayList<Review> getAll() {
        return reviewsList;
    }
    

    @Override
    public void saveReviewsList(ArrayList<Review> reviewsList) throws Exception {
        this.reviewsList = reviewsList;
        save();
    }
    
    
    

    
    
    
}
