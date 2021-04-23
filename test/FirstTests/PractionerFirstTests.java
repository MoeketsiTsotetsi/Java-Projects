/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstTests;

import data.Patient;
import data.Practioner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author madala
 */
public class PractionerFirstTests {
    
    public PractionerFirstTests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    
    public void correctPassword(){
        Practioner objPractioner = new Practioner();
        objPractioner.setPassword("Mac'007'KHLK");
        assertEquals("Mac'007'KHLK", objPractioner.getPassword());
    }
    
    @Test(expected = IllegalArgumentException.class)
    
    public void incorrectPassword(){
        Practioner objPractioner = new Practioner();
        objPractioner.setPassword("Mac");
        
    }
    
    @Test 
    public void  correctUsername(){
        Practioner objPractioner = new Practioner();
        objPractioner.setUsername("tmoeketsid@gmail.com");
    }
    
      @Test(expected = IllegalArgumentException.class)
    public void  incorrectUsername(){
        Practioner objPractioner = new Practioner();
        objPractioner.setUsername("tmoeketsidgmail.com");
    }
    
    
    @Test
    
    public void correctFirstName(){
        Practioner objPractioner = new Practioner();
        objPractioner.setFirstName("Moeketsi");
        assertEquals("Moeketsi", objPractioner.getFirstName());
    }
    
     @Test(expected = IllegalArgumentException.class)
    
    public void WrongFirstName(){
        Practioner objPractioner = new Practioner();
        objPractioner.setFirstName("Moe");
        
    }
    
     @Test(expected = IllegalArgumentException.class)
    
    public void WrongLastName(){
        Practioner objPractioner = new Practioner();
        objPractioner.setLastName("Tso");
        
    }
    
       @Test
    
    public void correctLastName(){
        Practioner objPractioner = new Practioner();
        objPractioner.setLastName("Tsotetsi");
        assertEquals("Tsotetsi", objPractioner.getLastName());
    }
}
