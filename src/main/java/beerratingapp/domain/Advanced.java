
package beerratingapp.domain;

/**
 *
 * Object Class representing the Advanced data. Always attached to a Review by reviewId
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
 * @param   reviewId   id of the Review object attached to this Advanced object 
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
    
    private String removeBannedCharacters(String input) {
        return input.replaceAll("[;]", "");
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
        this.notes = removeBannedCharacters(notes);
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }
    
    
    
    
    
    
    
}
