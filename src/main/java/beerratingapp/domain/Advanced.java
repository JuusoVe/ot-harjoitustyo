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
    
    int id;
    int[] hopScores;
    int[] maltScores;
    String notes;
    String reviewName;

    public Advanced(String reviewName) {
        
        this.reviewName = reviewName;
        this.hopScores = new int[8]; //0 floral, 1 fruity, 2 citrus, 3 herbal, 4 grassy, 5 earthy, 6 piney, 7 spicy
        this.maltScores = new int[8]; //0 caramel, 1 biscuit, 2 earthy, 3 nutty, 4 chocolate, 5 coffe, 6 roast, 7 tart
        this.notes = "";
        this.id = reviewName.hashCode();
    }

    public Advanced(int id, String reviewName, int[] hopScores, int[] maltScores, String notes) {
        this.id = id;
        this.hopScores = hopScores;
        this.maltScores = maltScores;
        this.notes = notes;
        this.reviewName = reviewName;
    }

    public int getId() {
        return id;
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
