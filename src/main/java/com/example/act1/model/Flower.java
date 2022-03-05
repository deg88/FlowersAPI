package com.example.act1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import com.example.act1.dto.FlowerDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="flower_data")
public class Flower {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "sepal_length")
	private double sepalLength;
	
	@Column(name = "sepal_width")
	private double sepalWidth;
	
	@Column(name = "petal_length")
	private double petalLength;
	
	@Column(name = "petal_width")
	private double petalWidth;
	
	@Column(name = "species")
	private String specie;	
	
	public Flower() {
		
	}
	
	public Flower(FlowerDTO dto) {
		this.petalLength = dto.getPetalLength();
		this.petalWidth = dto.getPetalWidth();
		this.sepalLength = dto.getSepalLength();
		this.sepalWidth = dto.getPetalWidth();
		this.specie = dto.getSpecies();
	}

	public Flower(int id, double sepalLength, double sepalWidth, double petalLength, double petalWidth, String specie) {
		super();
		this.id = id;
		this.sepalLength = sepalLength;
		this.sepalWidth = sepalWidth;
		this.petalLength = petalLength;
		this.petalWidth = petalWidth;
		this.specie = specie;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSepalLength() {
		return sepalLength;
	}

	public void setSepalLength(double sepalLength) {
		this.sepalLength = sepalLength;
	}

	public double getSepalWidth() {
		return sepalWidth;
	}

	public void setSepalWidth(double sepalWidth) {
		this.sepalWidth = sepalWidth;
	}

	public double getPetalLength() {
		return petalLength;
	}

	public void setPetalLength(double petalLength) {
		this.petalLength = petalLength;
	}

	public double getPetalWidth() {
		return petalWidth;
	}

	public void setPetalWidth(double petalWidth) {
		this.petalWidth = petalWidth;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	

}
