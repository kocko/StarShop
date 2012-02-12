package com.stars.client.subscribtion;


public class User {
   private String email;
   private String name;
   private String password;

   public String getEmail() {
      return email;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getName() {
      return name;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getPassword() {
      return password;
   }

   @Override
   public String toString() {
      return "User (email= " + email + ", name = " + name + ")";
   }

}
