package rovpp.standalone2.hijacks_api.Model;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;

public class ModelActive {
    private final List<String> dates;
    private final List<Integer> counts;
    public ModelActive(@JsonProperty("dates") List<String> dates, @JsonProperty("counts") List<Integer> counts){
        this.dates = dates;
        this.counts = counts; 

    }
    public List<String> getDates(){
        return dates;
    }
    public List<Integer> getCounts(){
        return counts;
    }
}