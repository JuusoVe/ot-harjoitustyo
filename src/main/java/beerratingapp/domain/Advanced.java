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
    int[] tasteChars;
    int[] smellChars;
    String tastesNotes;
    String smellNotes;

    public Advanced() {
    }

    public Advanced(int id, int[] tasteChars, int[] smellChars, String tastesNotes, String smellNotes) {
        this.id = id;
        this.tasteChars = tasteChars;
        this.smellChars = smellChars;
        this.tastesNotes = tastesNotes;
        this.smellNotes = smellNotes;
    }
    
    
    
}
