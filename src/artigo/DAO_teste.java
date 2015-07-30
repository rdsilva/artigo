/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artigo;

/**
 *
 * @author Rodrigo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_teste {

    public static void main(String[] args) {
        // strings de conexão
        String databaseURL = "jdbc:postgresql://10.4.7.201:5432/CNRM";
        String usuario = "postgres";
        String senha = "pgadmin";
        String driverName = "org.postgresql.Driver";

        try {
            Connection db = DriverManager.getConnection(databaseURL, usuario, senha);

            Statement sq_stmt = db.createStatement();

            String sql_str = "SELECT id, co_cbo, irh_familia_cbo FROM _irh_cnes_cnrm";

            ResultSet rs = sq_stmt.executeQuery(sql_str);

            while (rs.next()) {

                int id = rs.getInt("id");

                String cbo = rs.getString("co_cbo");

                String familia = rs.getString("irh_familia_cbo");

                System.out.println("ID : " + id);
                System.out.println("CBO : " + cbo);
                System.out.println("Família CBO : " + familia);

            }

            System.out.println("Consulta efetuada.");
            sq_stmt.close();
            rs.close();
            db.close();
            System.out.println("Conexão fechada.");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

}
