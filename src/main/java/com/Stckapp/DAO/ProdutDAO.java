package com.Stckapp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Stckapp.model.ProduitModel;

public class ProdutDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/stockmaster?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    private static final String INSERT_PRODUITS_SQL = "INSERT INTO produits" + "  (nom, description, quantite_en_stock,prix_unitaire,categorie) VALUES " +
        " (?, ?, ?,?,?);";

    private static final String SELECT_PRODUITS_BY_ID = "select id,nom,description,quantite_en_stock,prix_unitaire,categorie from produits where id =?";
    private static final String SELECT_ALL_PRODUITS = "select * from produits";
    private static final String DELETE_PRODUITS_SQL = "delete from produits where id = ?;";
    private static final String UPDATE_PRODUITS_SQL = "update produits set nom = ?,description= ?, quantite_en_stock =?,prix_unitaire=?,categorie=? where id = ?;";
    public ProdutDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    
}
