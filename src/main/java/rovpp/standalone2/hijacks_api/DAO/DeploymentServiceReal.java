package rovpp.standalone2.hijacks_api.DAO;

import rovpp.standalone2.hijacks_api.Model.ModelDeployment;
import rovpp.standalone2.hijacks_api.Model.ModelActive;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.sql.ResultSet;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Array;
import java.text.*;
@Repository
public class DeploymentServiceReal implements DeploymentDao{
    //private final JdbcTemplate jdbcTemplate;
    //@Autowired
    //public DeploymentServiceReal(JdbcTemplate jdbcTemplate){
    //    this.jdbcTemplate = jdbcTemplate;
    //}
    @Override
    public List<ModelDeployment> getHijacks(){
        Connection c = null;
      Statement stmt = null;
      try {
	String username = System.getenv("usname");
	String password = System.getenv("psword");
	String database = System.getenv("dabase");
	String table = System.getenv("tble");
        Class.forName("org.postgresql.Driver");
        c = DriverManager
           .getConnection("jdbc:postgresql://localhost:5432/" + database,
           username, password);
        c.setAutoCommit(false);
        

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM " + table + ";");
        int id;
        String country;
        Array as_path_array;
        //String prefix;
        String detected_origin_name;
        int detected_origin_number;
        String time_detected;
        String time_seen;
        //String blacklist_source;
	//String whitelisted_cdn;
	String roa_validity;
        //String event_type;
        String expected_origin_name;
        int expected_origin_number;
        String expected_prefix;
        String detected_prefix;
	//boolean non_routed;
        List<ModelDeployment> mlist = new ArrayList<>();
        while ( rs.next() ) {
           id = rs.getInt("id");
           country = rs.getString("country");
           as_path_array  = rs.getArray("as_path");
           Long[] as_path = (Long[])as_path_array.getArray();
           //prefix = rs.getString("prefix");
           detected_origin_name = rs.getString("detected_origin_name");
           detected_origin_number = rs.getInt("detected_origin_number");
           time_detected = rs.getString("time_detected");
           time_seen = rs.getString("time_seen");
           //blacklist_source = rs.getString("blacklist_source");
	   //whitelisted_cdn = rs.getString("whitelisted_cdn");
	   roa_validity = rs.getString("roa_validity");
           //event_type = rs.getString("event_type");
           expected_origin_name = rs.getString("expected_origin_name");
           expected_origin_number = rs.getInt("expected_origin_number");
           expected_prefix = rs.getString("expected_prefix");
           detected_prefix = rs.getString("detected_prefix");
	   //non_routed = rs.getBoolean("non_routed");
           ModelDeployment curModel = new ModelDeployment(id, country, as_path, detected_origin_name, detected_origin_number, time_detected, time_seen, roa_validity, expected_origin_name, expected_origin_number, expected_prefix, detected_prefix);
            mlist.add(curModel);
        }
        rs.close();
        stmt.close();
        c.close();
        return mlist;
     } catch ( Exception e ) {
         
        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        System.exit(0);
        return null;

     }
        
    }
    @Override
    public ModelActive hijackTimeSummary(){
        Connection c = null;
        Statement stmt = null;
        try {
          String username = System.getenv("usname");
        String password = System.getenv("psword");
        String database = System.getenv("dabase");
        String table = System.getenv("tble");
        Class.forName("org.postgresql.Driver");
        c = DriverManager
           .getConnection("jdbc:postgresql://localhost:5432/" + database,
           username, password);
        c.setAutoCommit(false);


        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM " + table + ";");
          int id;
          String country;
          Array as_path_array;
          //String prefix;
          String detected_origin_name;
          int detected_origin_number;
          String time_detected;
          String time_seen;
          //String blacklist_source;
	  //String whitelisted_cdn;
	  String roa_validity;
         // String event_type;
          String expected_origin_name;
          int expected_origin_number;
          String expected_prefix;
          String detected_prefix;
	  //boolean non_routed;
          List<ModelDeployment> mlist = new ArrayList<>();
          while ( rs.next() ) {
             id = rs.getInt("id");
             country = rs.getString("country");
             as_path_array  = rs.getArray("as_path");
             Long[] as_path = (Long[])as_path_array.getArray();
             //prefix = rs.getString("prefix");
             detected_origin_name = rs.getString("detected_origin_name");
             detected_origin_number = rs.getInt("detected_origin_number");
             time_detected = rs.getString("time_detected");
             time_seen = rs.getString("time_seen");
             //blacklist_source = rs.getString("blacklist_source");
	     //whitelisted_cdn = rs.getString("whitelisted_cdn");
	     roa_validity = rs.getString("roa_validity");
             //event_type = rs.getString("event_type");
             expected_origin_name = rs.getString("expected_origin_name");
             expected_origin_number = rs.getInt("expected_origin_number");
             expected_prefix = rs.getString("expected_prefix");
             detected_prefix = rs.getString("detected_prefix");
	     //non_routed = rs.getBoolean("non_routed");
             ModelDeployment curModel = new ModelDeployment(id, country, as_path, detected_origin_name, detected_origin_number, time_detected, time_seen, roa_validity, expected_origin_name, expected_origin_number, expected_prefix, detected_prefix);
              mlist.add(curModel);
          }
          rs.close();
          stmt.close();
          c.close();
          
          List<String> listOfDates = new ArrayList<>();
          List<Integer> listOfCounts = new ArrayList<>();
          Set<String>indivDates = new HashSet<String>();
          List<Date> dateList = new ArrayList<>();
          for (int i = 0; i < mlist.size(); i++){
              ModelDeployment curModel = mlist.get(i);
              String endtime = curModel.getEnd();
              
              
                    
                    listOfDates.add(curModel.getStart().substring(0,10));
                    
              
          }
          Collections.sort(listOfDates);
          Map<String, Integer> hm = new HashMap<String, Integer>(); 
  
        for (String i : listOfDates) { 
            Integer j = hm.get(i); 
            hm.put(i, (j == null) ? 1 : j + 1); 
        } 
        for (int j = 0; j < listOfDates.size(); j++){
            indivDates.add(listOfDates.get(j));
        }
        listOfDates.clear();
        listOfDates = new ArrayList<>(indivDates);
        Collections.sort(listOfDates);
        //Iterator<String> itr = indivDates.iterator();
        //while (itr.hasNext()){
            //listOfDates.add(itr.next());
        //}
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSSZ");
        for (int j = 0; j < (int)listOfDates.size(); j++){
            String curString = listOfDates.get(j);
            Date curDate = df.parse(curString);
            dateList.add(curDate);
        }
        for (int j = 0; j < hm.size(); j++){
            listOfCounts.add(hm.get(listOfDates.get(j)));
        }
        
        return new ModelActive(dateList, listOfCounts);
       } catch ( Exception e ) {
           
          System.err.println( e.getClass().getName()+": "+ e.getMessage() );
          System.exit(0);
          
          return null;
       }
       
    }
}
