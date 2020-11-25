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
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String brewery = parts[2];
                String style = parts[3];
                String date = parts[4];
                String notes = parts[5];   
                double abv = Double.parseDouble(parts[6]);
                double ibu = Double.parseDouble(parts[7]);
                double og = Double.parseDouble(parts[8]);
                int[] partScores = new int[4];
                String[] partialParts = parts[9].split(",");
                for (int i = 0; i < partialParts.length; i++) {
                    partialParts[i] = partialParts[i].trim(); 
                    partScores[i] = Integer.parseInt(partialParts[i]);
                }
                double average = Double.parseDouble(parts[10]);
                Review review = new Review(id, name, brewery, style, date, notes, abv, ibu, og, partScores, average);
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
                writer.write(review.getId() + ";" + review.getName() + ";" + review.getBrewery() + ";" +
                    review.getStyle() + ";" + review.getDate() + ";" + review.getNotes() + ";" + review.getAbv() + ";" +
                    review.getIbu() + ";" + review.getOg() + ";" + review.getPartScores()[0] + "," + review.getPartScores()[1] +
                    "," + review.getPartScores()[2] + "," + review.getPartScores()[3] + ";" + review.getAverage() + "\n");
            }
        }
    }    
    
    private int generateId() {
        return reviewsList.size() + 1;
    }
    
    @Override
    public ArrayList<Review> getAll() {
        return reviewsList;
    }
    
    @Override
    public Review create(Review review) throws Exception {
        review.setId(generateId());
        reviewsList.add(review);
        save();
        return review;
    }

    @Override
    public void setReviewsList(ArrayList<Review> reviewsList) throws Exception {
        this.reviewsList = reviewsList;
        save();
    }
    
    
    

    
    
    
}
