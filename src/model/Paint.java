
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paints")
/**
 * @author Jeremy Brannen - jrbrannen CIS175 Feb 11, 2021
 */
public class Paint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// Properties
	@Column(name = "id")
	private int id;
	@Column(name = "BrandName")
	private String brand;
	@Column(name = "ColorName")
	private String color;
	@Column(name = "Medium")
	private String medium;

	// Default no arg constructor required by entity
	public Paint() {
		super();
	}

	// constructor with arguments
	public Paint(String brand, String color, String medium) {
		super();
		this.brand = brand;
		this.color = color;
		this.medium = medium;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	// print method used to output paint details
	public String returnPaintDetails() {
		return brand + " --- " + color + " --- " + medium;
	}

}
