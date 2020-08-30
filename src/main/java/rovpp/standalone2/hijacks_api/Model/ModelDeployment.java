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
    private final Long[] as_path;
    private final String prefix;
    private final String detected_origin_name;
    private final int detected_origin_number;
    private final String time_detected;
    private final String last_time_checked;
    private final String blacklist_source;
    private final String whitelisted_cdn;
    private final String roa_validity;
    private final String event_type;
    private final String expected_origin_name;
    private final int expected_origin_number;
    private final String expected_prefix;
    private final String more_specific_prefix;
    private final boolean non_routed;    
    public ModelDeployment(@JsonProperty("id") int id, @JsonProperty("country") String country, @JsonProperty("as_path") Long[] as_path, @JsonProperty("prefix") String prefix, @JsonProperty("detected_origin_name") String detected_origin_name, @JsonProperty("detected_origin_number") int detected_origin_number, @JsonProperty("time_detected") String time_detected, @JsonProperty("last_time_checked") String last_time_checked, @JsonProperty("blacklist_source") String blacklist_source, @JsonProperty("whitelisted_cdn") String whitelisted_cdn, @JsonProperty("roa_validity") String roa_validity, @JsonProperty("event_type") String event_type, @JsonProperty("expected_origin_name") String expected_origin_name, @JsonProperty("expected_origin_number") int expected_origin_number, @JsonProperty("expected_prefix") String expected_prefix, @JsonProperty("more_specific_prefix") String more_specific_prefix, @JsonProperty("non_routed") boolean non_routed){
        this.id = id;
        this.country = country;
        this.as_path = as_path;
	this.prefix = prefix;
        this.detected_origin_name = detected_origin_name;
        this.detected_origin_number = detected_origin_number;
        this.time_detected = time_detected;
        this.last_time_checked = last_time_checked;
        this.blacklist_source = blacklist_source;
	this.whitelisted_cdn = whitelisted_cdn;
	this.roa_validity = roa_validity;
        this.event_type = event_type;
        this.expected_origin_name = expected_origin_name;
        this.expected_origin_number = expected_origin_number;
        this.expected_prefix = expected_prefix;
        this.more_specific_prefix = more_specific_prefix;
	this.non_routed = non_routed;
    }
    public int getId(){
        return id;
    }
    public String getCountry(){
        return country;
    }
    public Long[] getAp(){
        return as_path;
    }
    public String getBs(){
        return blacklist_source;
    }
    public String getWlcdn(){
        return whitelisted_cdn;
    }
    public String getRoav(){
        return roa_validity;
    }
    public String getDona(){
        return detected_origin_name;
    }
    public int getDonu(){
        return detected_origin_number;
    }
    public String getStart(){
        return time_detected;
    }
    public String getEnd(){
        return last_time_checked;
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
    public boolean getNr(){
	    return non_routed;	
    }

}
