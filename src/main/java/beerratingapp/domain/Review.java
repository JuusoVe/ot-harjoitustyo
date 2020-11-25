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
    private int[] partScores; //0 appearance, 1 smell, 2 taste, 3 mouthfeel
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
    
    public Review(int id, int[] partScores) {
        this.id = id;
        this.partScores = new int[4];
    }
    
    public Review() {
        this.partScores = new int[4];
    }
    
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

    public void setPartScores(int[] partScores) { //force minimums and maximums before setting
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

    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public int getId() {
        return id;
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
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
    
}
