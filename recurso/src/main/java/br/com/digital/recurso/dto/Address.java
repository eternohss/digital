package br.com.digital.recurso.dto;

import java.util.List;

public class Address {

    private String type;

    private List<Double> coordinates;

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setCoordinates(List<Double> coordinates){
        this.coordinates = coordinates;
    }
    public List<Double> getCoordinates(){
        return this.coordinates;
    }
}
