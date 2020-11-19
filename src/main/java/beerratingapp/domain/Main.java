package beerratingapp.domain;

public class Main {
    public static void main(String[] args) {
        //do something to start the app;
        
        Review rev = new Review();
        int[] mmTest = {3,0,4,5};
        rev.setPartScores(mmTest);
        int[] tp = rev.getPartScores();
        for(int i:tp) System.out.println(i);
        rev.updateAverage();
        
        System.out.println(rev.getAverage());
        
        
        
    }
}
