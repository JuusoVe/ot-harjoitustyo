package beerratingapp.dao;

import java.util.ArrayList;
import beerratingapp.domain.Advanced;

public interface AdvancedDao {
    
    Advanced saveAdvanced(Advanced advanced) throws Exception;
    
    Advanced getByBeerName(String name);
    
}
