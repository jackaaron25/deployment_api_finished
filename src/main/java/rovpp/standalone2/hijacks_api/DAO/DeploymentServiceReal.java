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
        Class.forName("org.postgresql.Driver");
        c = DriverManager
           .getConnection("jdbc:postgresql://localhost:5432/bgp",
           "postgres", "password");
        c.setAutoCommit(false);
        

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM hijacks;" );
        int id;
        String country;
        Array detected_as_path_array;
        int detected_by_bgpmon_peers;
        String detected_origin_name;
        int detected_origin_number;
        String start_time;
        String end_time;
        int event_number;
        String event_type;
        String expected_origin_name;
        int expected_origin_number;
        String expected_prefix;
        String more_specific_prefix;
        String url;
        List<ModelDeployment> mlist = new ArrayList<>();
        while ( rs.next() ) {
           id = rs.getInt("id");
           country = rs.getString("country");
           detected_as_path_array  = rs.getArray("detected_as_path");
           Long[] detected_as_path = (Long[])detected_as_path_array.getArray();
           detected_by_bgpmon_peers = rs.getInt("detected_by_bgpmon_peers");
           detected_origin_name = rs.getString("detected_origin_name");
           detected_origin_number = rs.getInt("detected_origin_number");
           start_time = rs.getString("start_time");
           end_time = rs.getString("end_time");
           event_number = rs.getInt("event_number");
           event_type = rs.getString("event_type");
           expected_origin_name = rs.getString("expected_origin_name");
           expected_origin_number = rs.getInt("expected_origin_number");
           expected_prefix = rs.getString("expected_prefix");
           more_specific_prefix = rs.getString("more_specific_prefix");
           url = rs.getString("url");
           ModelDeployment curModel = new ModelDeployment(id, country, detected_as_path, detected_by_bgpmon_peers, detected_origin_name, detected_origin_number, start_time, end_time, event_number, event_type, expected_origin_name, expected_origin_number, expected_prefix, more_specific_prefix, url);
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
    public ModelActive activeHijacksSummary(){
        Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.postgresql.Driver");
          c = DriverManager
             .getConnection("jdbc:postgresql://localhost:5432/bgp",
             "postgres", "password");
          c.setAutoCommit(false);
          
  
          stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM deployment;" );
          int id;
          String country;
          Array detected_as_path_array;
          int detected_by_bgpmon_peers;
          String detected_origin_name;
          int detected_origin_number;
          String start_time;
          String end_time;
          int event_number;
          String event_type;
          String expected_origin_name;
          int expected_origin_number;
          String expected_prefix;
          String more_specific_prefix;
          String url;
          List<ModelDeployment> mlist = new ArrayList<>();
          while ( rs.next() ) {
             id = rs.getInt("id");
             country = rs.getString("country");
             detected_as_path_array  = rs.getArray("detected_as_path");
           Long[] detected_as_path = (Long[])detected_as_path_array.getArray();
             detected_by_bgpmon_peers = rs.getInt("detected_by_bgpmon_peers");
             detected_origin_name = rs.getString("detected_origin_name");
             detected_origin_number = rs.getInt("detected_origin_number");
             start_time = rs.getString("start_time");
             end_time = rs.getString("end_time");
             event_number = rs.getInt("event_number");
             event_type = rs.getString("event_type");
             expected_origin_name = rs.getString("expected_origin_name");
             expected_origin_number = rs.getInt("expected_origin_number");
             expected_prefix = rs.getString("expected_prefix");
             more_specific_prefix = rs.getString("more_specific_prefix");
             url = rs.getString("url");
             ModelDeployment curModel = new ModelDeployment(id, country, detected_as_path, detected_by_bgpmon_peers, detected_origin_name, detected_origin_number, start_time, end_time, event_number, event_type, expected_origin_name, expected_origin_number, expected_prefix, more_specific_prefix, url);
              mlist.add(curModel);
          }
          rs.close();
          stmt.close();
          c.close();
          
          List<String> listOfDates = new ArrayList<>();
          List<Integer> listOfCounts = new ArrayList<>();
          Set<String>indivDates = new HashSet<String>();
          
          for (int i = 0; i < mlist.size(); i++){
              ModelDeployment curModel = mlist.get(i);
              String endtime = curModel.getEnd();
              
              if (endtime != null){
                    
                    listOfDates.add(curModel.getStart().substring(0,10));
                    
              }
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
        
        for (int j = 0; j < hm.size(); j++){
            listOfCounts.add(hm.get(listOfDates.get(j)));
        }
        
        return new ModelActive(listOfDates, listOfCounts);
       } catch ( Exception e ) {
           
          System.err.println( e.getClass().getName()+": "+ e.getMessage() );
          System.exit(0);
          
          return null;
       }
       
    }
}
