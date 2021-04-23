/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author madala
 */
public class Patient {
    String firstName,lastName,street,town,province,commibity,result;
    int age,practionerID,patientID;

    public Patient() {
        firstName = "";
        lastName = "";
        street = "";
        town = "";
        province = "";
        commibity = "";
        result = "";
        age =0;
        practionerID= 0;
    }

    public Patient(String firstName, String lastName, String street, String town
            , String province, String commibity, String result, int age, 
            int practionerID, int patientID) {
       setAge(age);
        setCommibity(commibity);
        setFirstName(firstName);
        setLastName(lastName);
        setPractionerID(practionerID);
        setProvince(province);
        setResult(result);
        setStreet(street);
        setTown(town);
        setPatientID(patientID);
         
    }
    
    
    

    public Patient(String firstName, String lastName, String street, String town,
            String province, String commibity, String result, int age, int practionerID) {
        setAge(age);
        setCommibity(commibity);
        setFirstName(firstName);
        setLastName(lastName);
        setPractionerID(practionerID);
        setProvince(province);
        setResult(result);
        setStreet(street);
        setTown(town);
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() <4) {
            throw new IllegalArgumentException("First Name cannot be less than 4"
                    + "characters");
            
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() <4) {
            throw new IllegalArgumentException("Last Name cannot be less than 4"
                    + "characters");
            
        }
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
         if (street.length() <9) {
            throw new IllegalArgumentException("street cannot be less than 4"
                    + "characters");
            
        }
        this.street = street;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }
    

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
         if (town.length() < 3) {
            throw new IllegalArgumentException("Town Name cannot be less than 4"
                    + "characters");
            
        }
        this.town = town;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCommibity() {
        return commibity;
    }

    public void setCommibity(String commibity) {
        this.commibity = commibity;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<= 0 ) {
            throw  new IllegalArgumentException("Invalid age");
        }
        this.age = age;
    }

    public int getPractionerID() {
        return practionerID;
    }

    public void setPractionerID(int practionerID) {
        this.practionerID = practionerID;
    }
    
   public static void initConnection() throws DataStorageException{
       PatientDA.initConnection();
   } 
   
   public static void terminate() throws DataStorageException{
       PatientDA.terminate();
   }
 public static void addNewPatient(Patient objPatient) throws 
         DuplicateException{
     PatientDA.addNewPatient(objPatient);
 }
 public static ArrayList<Patient> getAllPatients() throws 
              NotFoundException{
        return PatientDA.getAllPatients();
     
 }
 public static ArrayList<Patient> getCertainPatients(String result) throws 
              NotFoundException{
        return PatientDA.getCertainPatients(result);
     
 }
 public static void addNewPractioner(Practioner objPractioner) throws 
             DuplicateException{
     PatientDA.addNewPractioner(objPractioner);
 }
 
 public static Practioner returnPractioner(String username) throws 
         NotFoundException{
        return PatientDA.returnPractioner(username);
     
 }
  public static ArrayList<Patient> searchPatientByPractioner(int practionerID)
      throws NotFoundException{
        return PatientDA.searchPatientByPractioner(practionerID);
      
  }
public static ArrayList<Patient> getPatientsByProvince(String province) 
              throws NotFoundException{
        return PatientDA.getPatientsByProvince(province);
    
}

public static int getNoOfPatientsWithCommibidities() throws NotFoundException{
        return PatientDA.getNoOfPatientsWithCommibidities();
    
}
public static int getNoOfNegativePatients() throws NotFoundException{
        return PatientDA.getNoOfNegativePatients();
    
}
public static int getNoOfPositivePatients() throws NotFoundException{
        return PatientDA.getNoOfPositivePatients();
    
}
public static  ArrayList<Patient> getSearchedPatients(String searchedName) 
              throws NotFoundException{
        return PatientDA.getSearchedPatients(searchedName);
    
}
    @Override
    public String toString() {
        return patientID+"\t" +firstName + "\t" + lastName + "\t" + age 
                + "\t" + street + "\t" + town + "\t" + province+ "\t" +
                commibity + "\t" + result + "\t" + practionerID + "\n";
    }
 
 
    
}
