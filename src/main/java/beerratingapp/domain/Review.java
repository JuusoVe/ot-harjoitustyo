
package beerratingapp.domain;

//This class represents a single review
public class Review {
    
    private int id;
    
    private String name;
    private String brewery;
    private String style;
    private String date;
    private String notes;   
    
    private double ABV;
    private double IBU;
    private double OG;
    
    private int[] partScores; //0 appearance, 1 smell, 2 taste, 3 mouthfeel
    private final int[] weights = {1,3,5,1};
    private double average;

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
        int count = 0;
        for (int i = 0; i < this.partScores.length; i++) {
            if(this.partScores[i] > 0) {
                count++;
                sum = sum + weights[i]*partScores[i];
                weiSum = weiSum + weights[i];
            }
        }
        this.average = 1.0*sum/weiSum;   
    }

    public void setPartScores(int[] partScores) {//force minimums and maximums before setting
        for(int i = 0; i < partScores.length; i++) {
            if (partScores[i] < 0) partScores[i] = 0;
            if (partScores[i] > 5) partScores[i] = 5;
        }
        this.partScores = partScores;
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

    public void setABV(double ABV) {
        this.ABV = ABV;
    }

    public void setIBU(double IBU) {
        this.IBU = IBU;
    }

    public void setOG(double OG) {
        this.OG = OG;
    }

    public int[] getPartScores() {
        return partScores;
    }

    public double getAverage() {
        return average;
    }
    
    
    
    
    
    
    
    
}
