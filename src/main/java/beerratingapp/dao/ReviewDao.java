 /**
 * Abstract DAO class for the Review class
 * 
 *
 */

package beerratingapp.dao;

import java.util.ArrayList;
import beerratingapp.domain.Review;


 /**
  * Interface class for ReviewDaos
  * 
  */ 

public interface ReviewDao {
    
    ArrayList<Review> getAll();
    
    void saveReviewsList(ArrayList<Review> reviewsList) throws Exception;
    
}
