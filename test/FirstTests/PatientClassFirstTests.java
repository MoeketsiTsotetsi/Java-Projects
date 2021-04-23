package FirstTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import data.Patient;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author madala
 */
public class PatientClassFirstTests {
    
    public PatientClassFirstTests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    
    public void correctAge(){
        Patient objPatient = new Patient();
        objPatient.setAge(22);
        assertEquals(22, objPatient.getAge(),0);
    }
    
     @Test(expected = IllegalArgumentException.class)
    
    public void wrongAge(){
        Patient objPatient = new Patient();
        objPatient.setAge(0);
       
    }
    
     @Test
    
    public void correctFirstName(){
        Patient objPatient = new Patient();
        objPatient.setFirstName("Moeketsi");
        assertEquals("Moeketsi", objPatient.getFirstName());
    }
    
     @Test(expected = IllegalArgumentException.class)
    
    public void WrongFirstName(){
        Patient objPatient = new Patient();
        objPatient.setFirstName("Moe");
        
    }
    
     @Test(expected = IllegalArgumentException.class)
    
    public void WrongLastName(){
        Patient objPatient = new Patient();
        objPatient.setLastName("Tso");
        
    }
    
       @Test
    
    public void correctLastName(){
        Patient objPatient = new Patient();
        objPatient.setLastName("Tsotetsi");
        assertEquals("Tsotetsi", objPatient.getLastName());
    }
    
    @Test
    public void correctStreet(){
        Patient objPatient = new Patient();
        objPatient.setStreet("207 A  Sedibeng Village");
        assertEquals("207 A  Sedibeng Village", objPatient.getStreet()); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    
    public void WrongStreet(){
        Patient objPatient = new Patient();
        objPatient.setStreet("207");
        
    }
}
