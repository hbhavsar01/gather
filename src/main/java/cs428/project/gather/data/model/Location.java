package cs428.project.gather.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import cs428.project.gather.data.Coordinates;

/**
 * 
 * @author Team Gather
 * 
 *         This is the Location class used for constructing Location objects
 *         which are then used for Events
 *
 */

@Entity
public class Location {
	private @Id @GeneratedValue Long id;
	private double latitude;
	private double longitude;
	private String streetAddr;
	private String city;
	private String state;
	private String zipCode;
	private String description;

	protected Location() {
	}

	public Location(Coordinates coords) {
		this.latitude = coords.getLatitude();
		this.longitude = coords.getLongitude();
	}

	public Location(String description, String streetAddr, String city, String state, String zipCode, double latitude,
			double longitude) {
		this.description = description;
		this.streetAddr = streetAddr;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longtitude) {
		this.longitude = longtitude;
	}

	public String getStreetAddr() {
		return streetAddr;
	}

	public void setStreetAddr(String streetAddr) {
		this.streetAddr = streetAddr;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Coordinates getCoordinates() {
		Coordinates coords = new Coordinates();
		coords.setLatitude(latitude);
		coords.setLongitude(longitude);
		return coords;
	}
}
