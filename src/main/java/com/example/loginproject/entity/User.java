package com.example.loginproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    
    //Default Constructor 
    public User(){

    }

    //Parameterized Constructor
    public User(Long id,String fullName,String email,String password){
        this.id=id;
        this.fullName=fullName;
        this.email=email;
        this.password=password;
    }

    //Getter and setters
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getfullName(){
        return fullName;
    }

    public void setfullName(String fullName){
        this.fullName=fullName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
