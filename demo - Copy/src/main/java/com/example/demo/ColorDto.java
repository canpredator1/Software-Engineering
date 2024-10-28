package com.example.demo;

public class ColorDto {
    private String name;
    private String hex;



    public ColorDto(){

    }

    public ColorDto(String name, String hex){
        this.name = name;
        this.hex=hex;

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHex() {
        return hex;
    }
public void setHex(String hex) {
        this.hex = hex;
}


}
