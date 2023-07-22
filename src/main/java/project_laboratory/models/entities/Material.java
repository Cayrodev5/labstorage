package project_laboratory.models.entities;

public class Material {
	
	private Long id;
	private String name;
	private String manufacturer;
	private Integer units;
	private String manufacturingDate;
	private String expirationDate;
	
	public Material() {
		
	}
	
	public Material(
			Long id, 
			String name, 
			String manufacturer, 
			Integer units, 
			String manufacturingDate, 
			String expirationDate) {
		
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.units = units;
		this.manufacturingDate = manufacturingDate;
		this.expirationDate = expirationDate;
	}
	
	//Getters

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public Integer getUnits() {
		return units;
	}

	public String getManufacturingDate() {
		return manufacturingDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}
	
	
	//Setters

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return "Material "
				+ "[id=" + id + 
				", name=" + name + 
				", manufacturer=" + manufacturer + 
				", units=" + units
				+ ", manufacturingDate=" + manufacturingDate + 
				", expirationDate=" + expirationDate + "]";
	}
	
	
}
