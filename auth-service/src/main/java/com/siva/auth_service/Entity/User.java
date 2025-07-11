package com.siva.auth_service.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String username;
    public String password;
    public String securekey;
    public void setusername(String username){
        this.username=username;
    }
    public void setpassword(String password){
        this.password=password;
    }
    public void setsecurekey(String securekey){
        this.securekey=securekey;
    }
    public String getusername(){
        return this.username;
    }
    public String getpassword(){
        return this.password;
    }
    public String getsecurekey(){
        return this.securekey;
    }
}
