/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Rodrigo
 */
public class DAO {

    //localhost
    private String databaseURL = "jdbc:postgresql://localhost:5432/cnrm";
    private String usuario = "Rodrigo";
    private String senha = "rsilva";

    //bd dev
//    private String databaseURL = "jdbc:postgresql://10.4.7.201:5432/CNRM";
//    private String usuario = "postgres";
//    private String senha = "pgadmin";
    private String driverName = "org.postgresql.Driver";
    private Connection db;

    public DAO() throws SQLException {
        this.db = DriverManager.getConnection(this.databaseURL, this.usuario, this.senha);
    }

    public void closeConn() throws SQLException {
        db.close();
    }

    public LinkedList<Estado> getAllStates() throws SQLException {
        LinkedList<Estado> estados = new LinkedList<>();

        String sql = "SELECT sg_estado as estado FROM tb_cnrm_regiao_ufs order by estado";

        Statement stmt = this.db.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {

            String estado = rs.getString("estado");

            Estado dado = new Estado(estado);

            estados.add(dado);

        }

        stmt.close();
        rs.close();

        return estados;
    }

    public LinkedList<Estado> setTotalEstados(LinkedList<Estado> list) throws SQLException {

        for (Estado dado : list) {
            String sql = "select count(*) as total from _irh_cnrm_medicos_historico "
                    + "where estado_graduacao ilike '" + dado.getSigla()
                    + "' and estado_residencia is not null "
                    + "and estado_atuacao is not null";

            Statement stmt = this.db.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int total = rs.getInt("total");

                dado.setTotal(total);

            }

            stmt.close();
            rs.close();
        }

        return list;

    }

    public LinkedList<Estado> setSuporteEstados(LinkedList<Estado> list) throws SQLException {
        
        int total = 0;
        
        for (Estado dado : list) {
            total += dado.getTotal();
        }
        
        System.out.println("Total " + total);

        for (Estado dado : list) {
            double suporte = (dado.getTotal()*1.0 / total)*100;
            dado.setSuporte(suporte);
        }

        return list;

    }

}
