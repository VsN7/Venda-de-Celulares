package dao;

import conectar.ConnectionFactory;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Usuario;

public class UsuarioDAO{
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public UsuarioDAO() {
    }
    
   private Connection getConnection() throws SQLException{
       Connection conn;
       conn = ConnectionFactory.getInstance().getConnection();
       return conn;
   }
   
   public boolean add(Usuario usuario) throws Exception{
       try{
           String queryString = "INSERT INTO usuario(login, senha, cpf)"
                   + "VALUES(?,?,?)";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           ptmt.setString(1,usuario.getLogin());
           ptmt.setString(2,usuario.getSenha());
           ptmt.setString(3, usuario.getCpf());
           ptmt.executeUpdate();
           return true;                   
       } catch (SQLException e){
           e.printStackTrace();
           return false;
       }finally{
           closeConnection(connection,ptmt,resultSet);
       }
   }
   public int verifica(String login, String senha) throws SQLException{
       
        Component rootPane = null;
       
       String queryString = "SELECT login FROM usuario where senha = '"+senha+"'"+" AND login = '"+login+"'";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery(queryString);
           resultSet.getRow();
           String nomee= "";
           while(resultSet.next()){
                nomee = resultSet.getString("login");
                }
           if(nomee.equals(login)){
               return 1;
           }else{
               return 0;
           }
   }
   
   public int verificaCpf(String cpf) throws SQLException{
       
        Component rootPane = null;
       
       String queryString = "SELECT cpf FROM usuario where cpf = '"+cpf+"'";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery(queryString);
           resultSet.getRow();
           String cpfVerifica= "";
           while(resultSet.next()){
                cpfVerifica = resultSet.getString("cpf");
                }
           if(!cpfVerifica.equals(cpf)){
               return 1;
           }else{
               return 0;
           }
   }
   
   
   public int verificaLogin(String login) throws SQLException{
       
        Component rootPane = null;
       
       String queryString = "SELECT login FROM usuario where login = '"+login+"'";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery(queryString);
           resultSet.getRow();
           String loginVerifica= "";
           while(resultSet.next()){
                loginVerifica = resultSet.getString("login");
                }
           if(!loginVerifica.equals(login)){
               return 1;
           }else{
               return 0;
           }
   }
   
   
   
    public int retornaId(String login, String senha) throws SQLException{
       
        Component rootPane = null;
       int id = 0;
       String queryString = "SELECT id FROM usuario where login = '"+login+"' AND senha = '"+senha+"'";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery(queryString);
           resultSet.getRow();
           while(resultSet.next()){
                id = resultSet.getInt("id");
                }
           return id;
   }
   
   
   
   public boolean update(Usuario usuario) throws Exception{
       try{
           String queryString = "UPDATE usuario SET login = ? WHERE id = ?";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           ptmt.setString(1, usuario.getLogin());
           ptmt.setInt(2, usuario.getId());
           ptmt.executeUpdate();
           return true;
       } catch (SQLException e){
           e.printStackTrace();
           return false;
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   public int delete(int id) throws Exception{
       try{
           String queryString = "DELETE FROM usuario WHERE id=?";
           connection = getConnection();
           ptmt= connection.prepareStatement(queryString);
           ptmt.setInt(1,id);
           int val = ptmt.executeUpdate();
           return val;
       } catch (SQLException e){
           e.printStackTrace();
           return -1;
       }finally {
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   public List<Usuario> findAll() throws Exception{
       List<Usuario> usuarios = new ArrayList<>();
       try{
           String queryString = "SELECT * FROM usuario";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery();
           while(resultSet.next()){
               usuarios.add(new Usuario(resultSet.getInt("id"),resultSet.getString("login"),
                       resultSet.getString("senha"),resultSet.getString("cpf")));
           }
           return usuarios;
       } catch (SQLException e){
           e.printStackTrace();
           return usuarios;
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
   public List<Usuario> findAlldesc() throws Exception{
       List<Usuario> usuarios = new ArrayList<>();
       try{
           String queryString = "SELECT * FROM usuario order by nome desc";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery();
           while(resultSet.next()){
               usuarios.add(new Usuario(resultSet.getInt("id"),resultSet.getString("login"),
                       resultSet.getString("senha"),resultSet.getString("cpf")));
           }
           return usuarios;
       } catch (SQLException e){
           e.printStackTrace();
           return usuarios;
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   public void closeConnection(Connection conn, Statement st, ResultSet rs) throws Exception{
       close(conn, st, null);
   }
   
   public void closeConnection(Connection conn) throws Exception{
       close(conn,null,null);
   }
   
   public void close(Connection conn, Statement st, ResultSet rs) throws Exception{
       try{
           if(rs != null) rs.close();
           if(st != null) st.close();
           if(conn != null) conn.close();
       } catch (Exception e){
           
           throw new Exception(e.getMessage());
       }
   }
}
