package beerratingapp.domain;

//This class represents a single review

import java.util.Objects;
import java.util.Random;

public class Review {
    
    private int id;
    private String name;
    private String brewery;
    private String style;
    private String date;
    private String notes;   
    private double abv;
    private double ibu;
    private double og; 
    private int[] partScores; 
    private final int[] weights = {1, 3, 5, 1};
    private double average;

    
    
    public Review(int id, String name, String brewery, String style, String date, String notes, double abv, double ibu, double og, int[] partScores, double average) {
        this.id = id;
        this.name = name;
        this.brewery = brewery;
        this.style = style;
        this.date = date;
        this.notes = notes;
        this.abv = abv;
        this.ibu = ibu;
        this.og = og;
        this.partScores = partScores;
        this.average = average;
    }
    
    public Review() {
        Random r = new Random();
        this.id = r.nextInt(Integer.MAX_VALUE);
        this.partScores = new int[4];
    }
    
 /**
 * Updates the Weighted average score of this Review Object
 * 
 */
    
    public void updateAverage() { //update the weighted average of partScores
        int sum = 0;
        int weiSum = 0;
        for (int i = 0; i < this.partScores.length; i++) {
            if (this.partScores[i] > 0) {
                sum = sum + weights[i] * partScores[i];
                weiSum = weiSum + weights[i];
            }
        }
        this.average = 1.0 * sum / weiSum;   
    }
 /**
 * Sets the partial scores of this Review Object and validates the values to be between 0-5.
 * @param partScores int[] of length 4 with partial scores in order:
 * 0 appearance, 1 smell, 2 taste, 3 mouthfeel
 */
    
    
    
    public void setPartScores(int[] partScores) {
        for (int i = 0; i < partScores.length; i++) {
            if (partScores[i] < 0) {
                partScores[i] = 0;
            }
            if (partScores[i] > 5) {
                partScores[i] = 5;
            }
        }
        this.partScores = partScores;
    }
    
    private String removeBannedCharacters(String input) {
        return input.replaceAll("[;]", "");
    }
    
    public void setName(String name) {
        this.name = removeBannedCharacters(name);
    }

    public void setBrewery(String brewery) {
        this.brewery = removeBannedCharacters(brewery);
    }

    public void setStyle(String style) {
        this.style = removeBannedCharacters(style);
    }
    
    public void setDate(String date) {
        this.date = removeBannedCharacters(date);
    }

    public void setNotes(String notes) {
        this.notes = removeBannedCharacters(notes);
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public void setIbu(double ibu) {
        this.ibu = ibu;
    }

    public void setOg(double og) {
        this.og = og;
    }

    public int[] getPartScores() {
        return partScores;
    }

    public double getAverage() {
        return average;
    }

    public String getName() {
        return name;
    }

    public String getBrewery() {
        return brewery;
    }

    public String getStyle() {
        return style;
    }

    public String getDate() {
        return date;
    }

    public String getNotes() {
        return notes;
    }

    public double getAbv() {
        return abv;
    }

    public double getIbu() {
        return ibu;
    }

    public double getOg() {
        return og;
    }

    public int getId() {
        return id;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Review other = (Review) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }



    
    
    
}
