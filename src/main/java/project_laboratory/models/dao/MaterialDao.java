package project_laboratory.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import project_laboratory.models.entities.Material;



public class MaterialDao extends DAO{
	
	//CREATE
	public void addMaterial(Material material) {
		
		String create = "insert into materials (MaterialName, Manufacturer, Units, ManufacturingDate, ExpirationDate) values(?, ?, ?, ?, ?)";
		
		try {
			Connection connection = connect();
			PreparedStatement pst = connection.prepareStatement(create);
			pst.setString(1, material.getName());
			pst.setString(2, material.getManufacturer());
			pst.setInt(3, material.getUnits());
			pst.setString(4, material.getManufacturingDate());
			pst.setString(5, material.getExpirationDate());
			
			pst.executeUpdate();
			
			connection.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//READ
	public ArrayList<Material> readMaterials() {
		ArrayList<Material> materials = new ArrayList<>();
		
		String read = "SELECT * FROM materials ORDER BY MaterialName";
		
		try {
			Connection connection = connect();
			PreparedStatement pst = connection.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				Long id = rs.getLong("MaterialId");
				String name = rs.getString("MaterialName");
				String manufacturer = rs.getString("Manufacturer");
				Integer units = rs.getInt("Units");
				String manufacturingDate = rs.getString("ManufacturingDate");
				String expirationDate = rs.getString("ExpirationDate");
				
				materials.add(new Material(id, name, manufacturer, units, manufacturingDate, expirationDate));
				
			}
			
			connection.close();
			return materials;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		
		
	}
	
	
	//SELECT BY ID
	public void selectMaterial(Material material) {
		
		String read = "SELECT * FROM materials WHERE MaterialId= ?";
		
		try {
			Connection connection = connect();
			PreparedStatement pst = connection.prepareStatement(read);
			pst.setLong(1, material.getId());
			
			ResultSet rs =  pst.executeQuery();
			
			while (rs.next()) {
				material.setId(rs.getLong(1));
				material.setName(rs.getString(2));
				material.setManufacturer(rs.getString(3));
				material.setUnits(rs.getInt(4));
				material.setManufacturingDate(rs.getString(5));
				material.setExpirationDate(rs.getString(6));
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//UPDATE
	public void updateMaterial(Material material) {
		
		String update = "UPDATE materials SET MaterialName=?, Manufacturer=?, Units=?, ManufacturingDate=?, ExpirationDate=? WHERE MaterialId= ?";
		
		try {
			Connection connection = connect();
			PreparedStatement pst = connection.prepareStatement(update);
			pst.setString(1, material.getName());
			pst.setString(2, material.getManufacturer());
			pst.setInt(3, material.getUnits());
			pst.setString(4, material.getManufacturingDate());
			pst.setString(5, material.getExpirationDate());
			pst.setLong(6, material.getId());
			
			pst.executeUpdate();
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public void deleteMaterial(Material material) {
		
		String delete = "DELETE FROM materials WHERE MaterialId= ?";
		
		try {
			Connection connection = connect();
			PreparedStatement pst = connection.prepareStatement(delete);
			pst.setLong(1, material.getId());
			
			pst.executeUpdate();
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
