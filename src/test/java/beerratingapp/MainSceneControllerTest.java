/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beerratingapp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import beerratingapp.domain.ReviewController;
import beerratingapp.domain.BeerRatingService;
import beerratingapp.domain.Review;

/**
 *
 * @author juuso
 */
public class MainSceneControllerTest {
    
    ReviewController testRevCon; 
    MainSceneController mainSceCon;
    ArrayList<Review> revList;
    
    
    public MainSceneControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        mainSceCon = new MainSceneController();
//        mainSceCon.setBeerRatingService(new BeerRatingService(new FakeFileReviewDao("fake")));
        revList = new ArrayList<>();
        Review rev1 = new Review("pisuli", "olari", "popo" , "date here", "notes here", 7.2, 50, 1.044, new int[]{1, 2, 3, 4}, 0.0);
        Review rev2 = new Review("pisulia", "olaria", "popopo" , "2nd date here", "notes here", 6.2, 40, 1.064, new int[]{4, 2, 1, 4}, 4.0);
        revList.add(rev1);
        revList.add(rev2);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        
    }
    
}
