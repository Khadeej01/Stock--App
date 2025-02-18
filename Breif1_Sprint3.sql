CREATE DATABASE stockmaster;
USE stockmaster;
select * from produits;
CREATE TABLE produits (
    id INT AUTO_INCREMENT PRIMARY KEY,  
    nom VARCHAR(10) NOT NULL,           
    description TEXT,                    
    quantite_en_stock INT NOT NULL CHECK (quantite_en_stock >= 0),  
    prix DECIMAL(10, 2) NOT NULL CHECK (prix_unitaire > 0), 
    categorie VARCHAR(100)              
);






