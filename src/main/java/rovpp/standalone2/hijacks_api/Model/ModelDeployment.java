package rovpp.standalone2.hijacks_api.Model;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ModelDeployment {
    private final int id;
    private final String country;
    private final Long[] detected_as_path;
    private final int detected_by_bgpmon_peers;
    private final String detected_origin_name;
    private final int detected_origin_number;
    private final String start_time;
    private final String end_time;
    private final int event_number;
    private final String event_type;
    private final String expected_origin_name;
    private final int expected_origin_number;
    private final String expected_prefix;
    private final String more_specific_prefix;
    private final String urlHelp;
    public ModelDeployment(@JsonProperty("id") int id, @JsonProperty("country") String country, @JsonProperty("detected_as_path") Long[] detected_as_path, @JsonProperty("detected_by_bgpmon_peers") int detected_by_bgpmon_peers, @JsonProperty("detected_origin_name") String detected_origin_name, @JsonProperty("detected_origin_number") int detected_origin_number, @JsonProperty("start_time") String start_time, @JsonProperty("end_time") String end_time, @JsonProperty("event_number") int event_number, @JsonProperty("event_type") String event_type, @JsonProperty("expected_origin_name") String expected_origin_name, @JsonProperty("expected_origin_number") int expected_origin_number, @JsonProperty("expected_prefix") String expected_prefix, @JsonProperty("more_specific_prefix") String more_specific_prefix, @JsonProperty("url") String urlHelp){
        this.id = id;
        this.country = country;
        this.detected_as_path = detected_as_path;
        this.detected_by_bgpmon_peers = detected_by_bgpmon_peers;
        this.detected_origin_name = detected_origin_name;
        this.detected_origin_number = detected_origin_number;
        this.start_time = start_time;
        this.end_time = end_time;
        this.event_number = event_number;
        this.event_type = event_type;
        this.expected_origin_name = expected_origin_name;
        this.expected_origin_number = expected_origin_number;
        this.expected_prefix = expected_prefix;
        this.more_specific_prefix = more_specific_prefix;
        this.urlHelp = urlHelp;

    }
    public int getId(){
        return id;
    }
    public String getCountry(){
        return country;
    }
    public Long[] getDap(){
        return detected_as_path;
    }
    public int getDbbp(){
        return detected_by_bgpmon_peers;
    }
    public String getDona(){
        return detected_origin_name;
    }
    public int getDonu(){
        return detected_origin_number;
    }
    public String getStart(){
        return start_time;
    }
    public String getEnd(){
        return end_time;
    }
    public int getEn(){
        return event_number;
    }
    public String getEt(){
        return event_type;
    }
    public String getEon(){
            return expected_origin_name;
    }
    public int getEop(){
            return expected_origin_number;
    }
    public String getEp(){
            return expected_prefix;
    }
    public String getMsp(){
            return more_specific_prefix;
    }
    public String getUrl(){
            return urlHelp;
    }

}