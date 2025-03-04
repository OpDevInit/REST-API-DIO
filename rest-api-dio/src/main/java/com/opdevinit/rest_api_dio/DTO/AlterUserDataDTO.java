package com.opdevinit.rest_api_dio.DTO;

public class AlterUserDataDTO {
    private String name;
    private String email;

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

    public AlterUserDataDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public AlterUserDataDTO() {
    }

}
