/*
 * Java Web Programming
 * Modul 6: Klijentsko programiranje
 * Assignment:  Kreiranje web prodavnice    
 */

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Aleksandar Stosic / ita16.aleksandarstosic
 * 
 */


@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_client;
     @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String  username;
    @Column(name = "personal_number")
    private String personalNumber;
    private String addres;
    private String phone;
    private String city;
    @Column(name = "account_Number")
    private String accountNumber;
    private String email;
    private String password;

    public Client(int id_client, String firstName, String lastName, String username, String personalNumber, String addres, String phone, String city, String accountNumber, String email, String password) {
        this.id_client = id_client;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.personalNumber = personalNumber;
        this.addres = addres;
        this.phone = phone;
        this.city = city;
        this.accountNumber = accountNumber;
        this.email = email;
        this.password = password;
    }

 

   

    public Client() {

    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
    
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Client{" + "id_client=" + id_client + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", personalNumber=" + personalNumber + ", addres=" + addres + ", phone=" + phone + ", city=" + city + ", accountNumber=" + accountNumber + ", email=" + email + ", password=" + password + '}';
    }

    
    
    
   
    
    

   

   
    
    


}
