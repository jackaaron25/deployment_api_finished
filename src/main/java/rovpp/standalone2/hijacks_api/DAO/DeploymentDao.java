package rovpp.standalone2.hijacks_api.DAO;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
import java.util.*;
import rovpp.standalone2.hijacks_api.Model.ModelDeployment;
import rovpp.standalone2.hijacks_api.Model.ModelActive;
//import org.springframework.beans.factory.annotation.Qualifier;

public interface DeploymentDao {



    public List<ModelDeployment> getHijacks();
    public ModelActive hijackTimeSummary();
}