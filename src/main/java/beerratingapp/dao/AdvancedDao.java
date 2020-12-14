package beerratingapp.dao;

import beerratingapp.domain.Advanced;

 /**
  * Interface class for ReviewDaos
  * 
  */ 

public interface AdvancedDao {
    
    Advanced saveAdvanced(Advanced advanced) throws Exception;
    
    Advanced getByReviewId(int reviewId);
    
}
