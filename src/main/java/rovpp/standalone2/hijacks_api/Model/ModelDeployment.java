package rovpp.standalone2.hijacks_api.Model;
import java.util.Date;

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
    //private final String prefix;
    private final String detected_origin_name;
    private final int detected_origin_number;
    //private final String time_detected;
    private final Date time_seen;
    //private final String blacklist_source;
    //private final String whitelisted_cdn;
    private final String roa_validity;
    //private final String event_type;
    private final String expected_origin_name;
    private final int expected_origin_number;
    private final String expected_prefix;
    private final String detected_prefix;
    //private final boolean non_routed;    
    public ModelDeployment(@JsonProperty("id") int id, @JsonProperty("country") String country, @JsonProperty("as_path") Long[] as_path, @JsonProperty("detected_origin_name") String detected_origin_name, @JsonProperty("detected_origin_number") int detected_origin_number, @JsonProperty("time_seen") Date time_seen, @JsonProperty("roa_validity") String roa_validity, @JsonProperty("expected_origin_name") String expected_origin_name, @JsonProperty("expected_origin_number") int expected_origin_number, @JsonProperty("expected_prefix") String expected_prefix, @JsonProperty("detected_prefix") String detected_prefix){
        this.id = id;
        this.country = country;
        this.as_path = as_path;
	//this.prefix = prefix;
        this.detected_origin_name = detected_origin_name;
        this.detected_origin_number = detected_origin_number;
       // this.time_detected = time_detected;
        this.time_seen = time_seen;
    //    this.blacklist_source = blacklist_source;
	//this.whitelisted_cdn = whitelisted_cdn;
	this.roa_validity = roa_validity;
    //    this.event_type = event_type;
        this.expected_origin_name = expected_origin_name;
        this.expected_origin_number = expected_origin_number;
        this.expected_prefix = expected_prefix;
        this.detected_prefix = detected_prefix;
	//this.non_routed = non_routed;
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
    //public String getBs(){
      //  return blacklist_source;
    //}
    //public String getWlcdn(){
      //  return whitelisted_cdn;
    //}
    public String getRoav(){
        return roa_validity;
    }
    public String getDona(){
        return detected_origin_name;
    }
    public int getDonu(){
        return detected_origin_number;
    }
    //public String getStart(){
      //  return time_detected;
    //}
    public Date getEnd(){
        return time_seen;
    }
    //public String getEt(){
      //  return event_type;
    //}
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
            return detected_prefix;
    }
    //public boolean getNr(){
	  //  return non_routed;	
    //}

}
