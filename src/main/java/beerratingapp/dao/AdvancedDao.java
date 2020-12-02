package beerratingapp.dao;

import java.util.ArrayList;
import beerratingapp.domain.Advanced;

public interface AdvancedDao {
    
    Advanced create(Advanced advanced) throws Exception;
    
    Advanced getByBeerName(String name);
    
    void setAdvancedList(ArrayList<Advanced> advancedList) throws Exception;
    
}
