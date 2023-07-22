package project_laboratory.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import project_laboratory.models.dao.MaterialDao;
import project_laboratory.models.entities.Material;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet(urlPatterns =  {"/MaterialController", "/main", "/insert", "/select", "/update", "/delete"})
public class MaterialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Material material = new Material();
	MaterialDao dao = new MaterialDao();
       
    public MaterialController() {
        super();
    }

	protected void doGet
	(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		
		String action = request.getServletPath();
		

		
		if (action.equals("/main")) {
			materials(request, response);
		}else if (action.equals("/insert")) {
			addMaterial(request, response);
		} else if (action.equals("/select")) {
			listMaterials(request, response);
		} else if (action.equals("/update")) {
			editMaterial(request, response);
		} else if (action.equals("/delete")) {
			removeMaterial(request, response);
		} else {
			response.sendRedirect("index.html");
		}
		
		
	}

	protected void doPost
	(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	
	public void materials
	(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		ArrayList<Material> list = dao.readMaterials();
		request.setAttribute("listofmaterials", list);
		RequestDispatcher rd = request.getRequestDispatcher("Materials.jsp");
		rd.forward(request, response);
		
	}
	
	
	public void addMaterial
	(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		material.setName(request.getParameter("materialname"));
		material.setManufacturer(request.getParameter("manufacturer"));
		material.setUnits(Integer.parseInt(request.getParameter("units")));
		material.setManufacturingDate(request.getParameter("manufacturingdate"));
		material.setExpirationDate(request.getParameter("expirationdate"));
		
		dao.addMaterial(material);
		response.sendRedirect("main");
		
	}
	
	
	public void listMaterials
	(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		Long idcon = Long.parseLong(request.getParameter("id"));
		
		material.setId(idcon);
		
		dao.selectMaterial(material);
		
		//set attributes
		request.setAttribute("id", material.getId());
		request.setAttribute("materialname", material.getName());
		request.setAttribute("manufacturer", material.getManufacturer());
		request.setAttribute("units", material.getUnits());
		request.setAttribute("manufacturingdate", material.getManufacturingDate());
		request.setAttribute("expirationdate", material.getExpirationDate());
		
		//to the edit.jsp
		RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
		rd.forward(request, response);
		
	}
	
	
	public void editMaterial
	(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		material.setName(request.getParameter("materialname"));
		material.setManufacturer(request.getParameter("manufacturer"));
		material.setUnits(Integer.parseInt(request.getParameter("units")));
		material.setManufacturingDate(request.getParameter("manufacturingdate"));
		material.setExpirationDate(request.getParameter("expirationdate"));
		
		dao.updateMaterial(material);
		
		response.sendRedirect("main");
		
		
	}
	
	public void removeMaterial
	(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		Long idcon = Long.parseLong(request.getParameter("id"));
		material.setId(idcon);
		
		dao.deleteMaterial(material);
		response.sendRedirect("main");
	}

}
