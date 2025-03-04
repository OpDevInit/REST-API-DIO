package com.opdevinit.rest_api_dio.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.opdevinit.rest_api_dio.model.User;

public class UserSaveDTO {
        @JsonProperty("name") String name;
        @JsonProperty("email") String email;
       
    public UserSaveDTO() {
    }

    public UserSaveDTO(String name, String email ) {
        this.name = name;
        this.email = email;
        
    }

    public UserSaveDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        
    }

   
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    

}
