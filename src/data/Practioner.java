/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author madala
 */
public class Practioner {

    String username, firstName, lastName, password, position;
    int practionerID;

    public int getPractionerID() {
        return practionerID;
    }

    public void setPractionerID(int practionerID) {
        this.practionerID = practionerID;
    }

    public Practioner() {
        username = "";
        firstName = "";
        lastName = "";
        password = "";
        position = "";

    }

    public Practioner(String username, String firstName, String lastName, 
            String password, String position, int practionerID) {
       setUsername(username);
        setFirstName(firstName);
        setLastName(lastName);
        setPassword(password);
        setPosition(position);
        setPractionerID(practionerID);
    }
    

    public Practioner(String username, String firstName, String lastName,
            String password, String position) {
        setUsername(username);
        setFirstName(firstName);
        setLastName(lastName);
        setPassword(password);
        setPosition(position);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(!username.contains("@")){
            throw new IllegalArgumentException("Please enter an email address");
        }
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        if (firstName.length() < 4) {
            throw new IllegalArgumentException("First Name cant be less than 4 "
                    + "characters");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 4) {
            throw new IllegalArgumentException("Name cant be less than 4 "
                    + "characters");
        }
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        if (password.length() >= 8) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Password cant have less than 8"
                    + "characters");
        }

    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
