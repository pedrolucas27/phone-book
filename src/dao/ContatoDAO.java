package dao;

import dominio.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContatoDAO {

    public boolean inserir(Contato c) {
        boolean resultado = false;

        String query = "INSERT INTO Contato (dd,numero,nome) VALUES (?,?,?)";
        Connection conexao = Conexao.conectar();

        try {

            PreparedStatement ps = conexao.prepareStatement(query);

            ps.setString(1, c.getDd());
            ps.setString(2, c.getNumero());
            ps.setString(3, c.getNome());

            ps.execute();
            resultado = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }

        return resultado;
    }
    
    

    public boolean remover(String numero) {
        boolean resultado = false;

        String query = "DELETE FROM Contato WHERE numero = ?";
        Connection conexao = Conexao.conectar();

        try {

            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setString(1, numero);

            ps.execute();
            resultado = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }

        return resultado;
    }

    public Contato buscar(String numero) {
        Contato c = null;

        String query = "SELECT * FROM Contato WHERE numero = ?";
        Connection conexao = Conexao.conectar();

        try {

            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setString(1, numero);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c = new Contato();

                c.setDd(rs.getString("dd"));
                c.setNumero(rs.getString("numero"));
                c.setNome(rs.getString("nome"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }

        return c;
    }

    public ArrayList<Contato> listar() {
        ArrayList<Contato> list = null;

        String query = "SELECT * FROM Contato";
        Connection conexao = Conexao.conectar();

        try {

            PreparedStatement ps = conexao.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Contato c = new Contato();
                
                c.setDd(rs.getString("dd"));
                c.setNumero(rs.getString("numero"));
                c.setNome(rs.getString("nome"));
               
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }

        return list;
    }

    public boolean atualizar(String n_atualizar,Contato c) {
        boolean resultado = false;
        
        String query = "UPDATE Contato SET dd = ?, nome = ?, numero = ? WHERE numero = ?";
        Connection conexao = Conexao.conectar();
        
        try{
            
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setString(1, c.getDd());
            ps.setString(2, c.getNome());
            ps.setString(3, c.getNumero());
            ps.setString(4, n_atualizar);
            
            if(ps.executeUpdate() > 1){
                resultado = true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return resultado;
    }

}
