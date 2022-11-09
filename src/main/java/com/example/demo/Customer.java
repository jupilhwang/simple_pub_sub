package com.example.demo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

public class Customer {
  private String firstname;
  private String lastname;
  private int age;

  public void setAge(int age) {
    this.age = age;
  }
  public void setFirstname(String firstname)  {
    this.firstname = firstname;
  }
  public void setLastname(String lastname)  {
    this.lastname = lastname;
  }
  public String getFirstname()  {
    return this.firstname;
  }
  public String getLastname() {
    return this.lastname;
  }
  public int getAge() {
    return this.age;
  }

  public Customer(String firstname, String lastname, int age) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.age = age;
  }
}
