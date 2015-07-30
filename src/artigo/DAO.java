/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Rodrigo
 */
public class DAO {

    private String databaseURL = "jdbc:postgresql://10.4.7.201:5432/CNRM";
    private String usuario = "postgres";
    private String senha = "pgadmin";
    private String driverName = "org.postgresql.Driver";
    private Connection db;
    private Statement stmt;
    
    
    public DAO() throws SQLException {
        this.db = DriverManager.getConnection(this.databaseURL, this.usuario, this.senha);
        this.stmt = this.db.createStatement();
    }

    public LinkedList<Estado> getAllStates(){
        LinkedList<Estado> estados = new LinkedList<>();
        
        
        
        return estados;
    }
    
    
}
