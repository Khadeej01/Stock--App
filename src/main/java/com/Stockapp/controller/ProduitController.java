package com.Stockapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Stckapp.DAO.ProdutDAO;
import com.Stckapp.model.ProduitModel;
@WebServlet("/")

public class ProduitController extends HttpServlet {
	private ProdutDAO prDAO;

    public void init() {
    	prDAO = new ProdutDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
               
                case "/insert":
                	insertProduit(request, response);
                    break;
                    
                case "/":
                	listProduit(request, response);
                	break;

               
                default:
                	listProduit(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
   



}
