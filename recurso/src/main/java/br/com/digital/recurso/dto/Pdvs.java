package br.com.digital.recurso.dto;


public class Pdvs {

	  private int id;

	    private String tradingName;

	    private String ownerName;

	    private String document;

	    private CoverageArea coverageArea;

	    private Address address;

	    public void setId(int id){
	        this.id = id;
	    }
	    public int getId(){
	        return this.id;
	    }
	    public void setTradingName(String tradingName){
	        this.tradingName = tradingName;
	    }
	    public String getTradingName(){
	        return this.tradingName;
	    }
	    public void setOwnerName(String ownerName){
	        this.ownerName = ownerName;
	    }
	    public String getOwnerName(){
	        return this.ownerName;
	    }
	    public void setDocument(String document){
	        this.document = document;
	    }
	    public String getDocument(){
	        return this.document;
	    }
	    public void setCoverageArea(CoverageArea coverageArea){
	        this.coverageArea = coverageArea;
	    }
	    public CoverageArea getCoverageArea(){
	        return this.coverageArea;
	    }
	    public void setAddress(Address address){
	        this.address = address;
	    }
	    public Address getAddress(){
	        return this.address;
	    }
}
