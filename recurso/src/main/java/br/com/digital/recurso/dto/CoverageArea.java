package br.com.digital.recurso.dto;

import java.util.List;

public class CoverageArea {

	private String type;

	private List<List<List<List<Double>>>> coordinates;

	public void setType(String type){
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setCoordinates(List<List<List<List<Double>>>> coordinates){
		this.coordinates = coordinates;
	}
	
	public List<List<List<List<Double>>>>	getCoordinates(){
		return this.coordinates;
	}
}
