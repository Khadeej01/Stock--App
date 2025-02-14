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
    public void insertProduit(ProduitModel produit) throws SQLException {
        System.out.println(INSERT_PRODUITS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUITS_SQL)) {
            preparedStatement.setString(1, produit.getNom());
            preparedStatement.setString(2, produit.getDescription());
            preparedStatement.setInt(3, produit.getQuantite());
            preparedStatement.setInt(4, produit.getPrix());
            preparedStatement.setString(5, produit.getCategorie());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    public List<ProduitModel> selectAllProduits() {
    	
        List<ProduitModel> produits = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUITS);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {

                        int id = rs.getInt("id");
                       String nom =  rs.getString("nom");
                        String description = rs.getString("description");
                        int quantite = rs.getInt("quantite_en_stock");
                        int prix  = rs.getInt("prix_unitaire");
                        String categorie = rs.getString("categorie");
                        produits.add(new ProduitModel(id,nom, description, quantite, prix, categorie));
                        System.out.println("testmodel");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println( produits);

        return produits;
    }
    
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
        }
}
