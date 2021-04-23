/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.*;
import java.util.ArrayList;

/**
 * 
 * @author madala
 */
public class PatientDA {
   private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    private static final  ArrayList<Patient>arParient= new ArrayList<>(); 
    
     public static void initConnection() throws DataStorageException{
        
         final String USERNAME = "root";
        final String PASSWORD ="";
        final String URL ="jdbc:mysql://localhost/dbpatients";
        final String DRIVER="com.mysql.jdbc.Driver";
        
   
      
        
        try {
          Class.forName(DRIVER); 
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new DataStorageException("Driver missing" +e.getMessage());
        }catch(SQLException ex){
            throw  new DataStorageException("Connection failed " + 
                    ex.getMessage());
        }
    }
     
     
    public static void terminate() throws DataStorageException{
        try {
         if(conn!=null){
            conn.close();
        }   
        } catch (SQLException e) {
            throw new DataStorageException(e.getMessage());
        }
        
    }
    
     public static void addNewPatient(Patient objPatient) throws DuplicateException{
        
        
        try {
          ps = conn.prepareStatement("Insert into tblpatients(firstname,lastname,age,street,town,province,Commibity,result,PractionerID)"
                + "values(?,?,?,?,?,?,?,?,?)");
          ps.setString(1, objPatient.getFirstName());
          ps.setString(2, objPatient.getLastName());
          ps.setInt(3, objPatient.getAge());
          ps.setString(4, objPatient.getStreet());
          ps.setString(5, objPatient.getTown());
          ps.setString(6,objPatient.getProvince());
          ps.setString(7,objPatient.getCommibity());
          ps.setString(8,objPatient.getResult());
          ps.setInt(9,objPatient.getPractionerID());
          
          
          ps.executeUpdate();
          
        } catch (SQLException e) {
            throw new DuplicateException(e.getMessage());
        }
    }
     
     public static void addNewPractioner(Practioner objPractioner) throws 
             DuplicateException{
        
        
        try {
          ps = conn.prepareStatement("Insert into tblpractioner(username,firstname,lastname,password,position) "
                  + "values(?,?,?,?,?)");
          ps.setString(1, objPractioner.getUsername());
          ps.setString(2, objPractioner.getFirstName());
          ps.setString(3, objPractioner.getLastName());
          ps.setString(4, objPractioner.getPassword());
          ps.setString(5, objPractioner.getPosition());
          
          
          
          ps.executeUpdate();
          
        } catch (SQLException e) {
            throw new DuplicateException(e.getMessage());
        }
    }
     
      public static Practioner returnPractioner(String username) throws NotFoundException{
        Practioner objPractioner = null ;
        
        try {
            ps = conn.prepareStatement("Select * "
                    + "from tblpractioner where Username =? ");
            
            ps.setString(1,username);
            
            rs = ps.executeQuery();
            
            
            while (rs.next()) {                
                objPractioner = new Practioner(rs.getString("Username"),
                        rs.getString("Firstname"),rs.getString("Lastname"),
                        rs.getString("password"),rs.getString("position"),
                        rs.getInt("practionerID"));
            }
        } catch (SQLException e) {
            throw new NotFoundException(e.getMessage());
        }
        
        return objPractioner;
    }
      
      public static ArrayList<Patient> getAllPatients() throws 
              NotFoundException{
          arParient.clear();
       try {
           ps = conn.prepareStatement("select * from tblpatients");
           
           rs = ps.executeQuery();
           
           while (rs.next()) {
               arParient.add(new Patient(rs.getString("firstname"), 
                       rs.getString("Lastname"), rs.getString("street"), 
                       rs.getString("town"), rs.getString("province"), 
                       rs.getString("Commibity"), rs.getString("result"), 
                       rs.getInt("age"), rs.getInt("PractionerID"),
                       rs.getInt("patientID")));
               
           }
       } catch (SQLException ex) {
           throw new NotFoundException(ex.getMessage());
       }
       return arParient;
       
      }
      
      public static ArrayList<Patient> getCertainPatients(String result) throws 
              NotFoundException{
          arParient.clear();
       try {
           ps = conn.prepareStatement("select * from tblpatients "
                   + "where result=?");
           
           ps.setString(1, result);
           
           rs = ps.executeQuery();
           
           while (rs.next()) {
               arParient.add(new Patient(rs.getString("firstname"), 
                       rs.getString("Lastname"), rs.getString("street"), 
                       rs.getString("town"), rs.getString("province"), 
                       rs.getString("Commibity"), rs.getString("result"), 
                       rs.getInt("age"), rs.getInt("PractionerID"),
                       rs.getInt("patientID")));
               
           }
       } catch (SQLException ex) {
           throw new NotFoundException(ex.getMessage());
       }
       return arParient;
       
      }
      
      public static ArrayList<Patient> searchPatientByPractioner(int practionerID)
      throws NotFoundException{
          arParient.clear();
       try {
           ps = conn.prepareStatement("select * from tblpatients "
                   + "where practionerID = ?");
           ps.setInt(1, practionerID);
           
           rs = ps.executeQuery();
           
           while (rs.next()) {
              arParient.add(new Patient(rs.getString("firstname"), 
                       rs.getString("Lastname"), rs.getString("street"), 
                       rs.getString("town"), rs.getString("province"), 
                       rs.getString("Commibity"), rs.getString("result"), 
                       rs.getInt("age"), rs.getInt("PractionerID"),
                       rs.getInt("patientID")));
           }
       } catch (SQLException ex) {
           throw new NotFoundException(ex.getMessage());
       }
          
       return  arParient;
      }
      
      public static int getNoOfPositivePatients() throws NotFoundException{
          int total = 0;
       try {
           ps = conn.prepareStatement("select count(*) as total from tblpatients "
                   + "where result='positive'");
           rs = ps.executeQuery();
           
           while (rs.next()) {
               
              total = rs.getInt("total");
           }
                   
       } catch (SQLException ex) {
          throw  new NotFoundException(ex.getMessage());
       }
       
       return  total;
      }
       public static int getNoOfNegativePatients() throws NotFoundException{
          int total = 0;
       try {
           ps = conn.prepareStatement("select count(*) as total from tblpatients where result = 'negative' ");
           rs = ps.executeQuery();
           
           while (rs.next()) {
               
              total = rs.getInt("total");
           }
                   
       } catch (SQLException ex) {
          throw  new NotFoundException(ex.getMessage());
       }
       
       return  total;
      }
       
       public static int getNoOfPatientsWithCommibidities() throws NotFoundException{
          int total = 0;
       try {
           ps = conn.prepareStatement("select count(*) as total from tblpatients where Commibity='yes'");
           rs = ps.executeQuery();
           
           while (rs.next()) {
               
              total = rs.getInt("total");
           }
                   
       } catch (SQLException ex) {
          throw  new NotFoundException(ex.getMessage());
       }
       
       return  total;
      }
      

      
      public static ArrayList<Patient> getPatientsByProvince(String province) 
              throws NotFoundException{
          arParient.clear();
          
       try {
           ps = conn.prepareStatement("select * from tblpatients "
                   + "where province=?");
           ps.setString(1, province);
           rs = ps.executeQuery();
           
           while (rs.next()) {
               arParient.add(new Patient(rs.getString("firstname"), 
                       rs.getString("Lastname"), rs.getString("street"), 
                       rs.getString("town"), rs.getString("province"), 
                       rs.getString("Commibity"), rs.getString("result"), 
                       rs.getInt("age"), rs.getInt("PractionerID"),
                       rs.getInt("patientID")));
               
           }
       } catch (SQLException ex) {
           throw  new NotFoundException(ex.getMessage());
       }
       
       return  arParient;
          
      }
      
      public static  ArrayList<Patient> getSearchedPatients(String searchedName) 
              throws NotFoundException{
          arParient.clear();
       try {
           ps = conn.prepareStatement("Select * from tblpatients "
                   + "where firstname = ? ");
           ps.setString(1, searchedName);
           
           rs = ps.executeQuery();
           
           while(rs.next()){
                  arParient.add(new Patient(rs.getString("firstname"), 
                       rs.getString("Lastname"), rs.getString("street"), 
                       rs.getString("town"), rs.getString("province"), 
                       rs.getString("Commibity"), rs.getString("result"), 
                       rs.getInt("age"), rs.getInt("PractionerID"),
                       rs.getInt("patientID")));
           }
       } catch (SQLException ex) {
           throw new NotFoundException(ex.getMessage());
       }
          
          return arParient;
      }
}
