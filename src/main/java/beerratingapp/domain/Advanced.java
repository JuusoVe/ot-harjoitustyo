/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beerratingapp.domain;

/**
 *
 * @author juuso
 */
public class Advanced {
    
    int reviewId;
    int[] hopScores;
    int[] maltScores;
    String notes;
    String reviewName;

/**
 * Creates an advanced object to represent the additional data
 * attached to a Review Object
 * 
 *
 * @param   reviewName   Name of the Review Object 
 */
    
    public Advanced(int reviewId) {
        
        this.reviewId = reviewId;
        this.hopScores = new int[8]; //0 floral, 1 fruity, 2 citrus, 3 herbal, 4 grassy, 5 earthy, 6 piney, 7 spicy
        this.maltScores = new int[8]; //0 caramel, 1 biscuit, 2 earthy, 3 nutty, 4 chocolate, 5 coffe, 6 roast, 7 tart
        this.notes = "";
    }

    public Advanced(int reviewId, String reviewName, int[] hopScores, int[] maltScores, String notes) {
        this.reviewId = reviewId;
        this.hopScores = hopScores;
        this.maltScores = maltScores;
        this.notes = notes;
        this.reviewName = reviewName;
    }

    public int getReviewId() {
        return reviewId;
    }

    public int[] getHopScores() {
        return hopScores;
    }

    public int[] getMaltScores() {
        return maltScores;
    }

    public String getNotes() {
        return notes;
    }

    public String getReviewName() {
        return reviewName;
    }

    public void setHopScores(int[] hopScores) {
        this.hopScores = hopScores;
    }

    public void setMaltScores(int[] maltScores) {
        this.maltScores = maltScores;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    
    
    
    
}
