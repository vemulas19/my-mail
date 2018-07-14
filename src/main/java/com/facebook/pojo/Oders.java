package com.facebook.pojo;

/**
 * @author Rahulbodapatla
 *
 */
public class Oders {

	private Integer oser_id;
	private String oder_name;
	private String oder_price;
	private String oder_location;
	
	
	
	
	public Oders(Integer oser_id, String oder_name, String oder_price, String oder_location) {
		super();
		this.oser_id = oser_id;
		this.oder_name = oder_name;
		this.oder_price = oder_price;
		this.oder_location = oder_location;
	}
	public Integer getOser_id() {
		return oser_id;
	}
	public void setOser_id(Integer oser_id) {
		this.oser_id = oser_id;
	}
	public String getOder_name() {
		return oder_name;
	}
	public void setOder_name(String oder_name) {
		this.oder_name = oder_name;
	}
	public String getOder_price() {
		return oder_price;
	}
	public void setOder_price(String oder_price) {
		this.oder_price = oder_price;
	}
	public String getOder_location() {
		return oder_location;
	}
	public void setOder_location(String oder_location) {
		this.oder_location = oder_location;
	}
	
	
	
	
}
