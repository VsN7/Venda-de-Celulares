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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Celular;

public class CelularDAO{
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public CelularDAO() {
    }
    
   private Connection getConnection() throws SQLException{
       Connection conn;
       conn = ConnectionFactory.getInstance().getConnection();
       return conn;
   }
   
   public boolean add(Celular celular) throws Exception{
       try{
           String queryString = "INSERT INTO celular(descricao, marca, modelo,valor,serie,quantidade,quantidade_reservada)"
                   + "VALUES(?,?,?,?,?,?,?)";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           ptmt.setString(1,celular.getDescricao());
           ptmt.setString(2,celular.getMarca());
           ptmt.setString(3,celular.getModelo());
           ptmt.setDouble(4,celular.getValor());
           ptmt.setString(5,celular.getSerie());
           ptmt.setInt(6, celular.getQuantidade());
           ptmt.setInt(7, celular.getQuantidadeReservada());
           ptmt.executeUpdate();
           return true;                   
       } catch (SQLException e){
           e.printStackTrace();
           return false;
       }finally{
           closeConnection(connection,ptmt,resultSet);
       }
   }
   
   public int verificaSerie(String serie) throws SQLException{
       String queryString = "SELECT serie FROM celular where serie = '"+serie+"'";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery(queryString);
           resultSet.getRow();
           String serieVerifica= "";
           while(resultSet.next()){
                serieVerifica = resultSet.getString("serie");
                }
           if(!serieVerifica.equals(serie)){
               return 1;
           }else{
               return 0;
           }
   }
   
   public int verificaDescricao(String descricao) throws SQLException{
       String queryString = "SELECT descricao FROM celular where descricao = '"+descricao+"'";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery(queryString);
           resultSet.getRow();
           String descricaoVerifica= "";
           while(resultSet.next()){
                descricaoVerifica = resultSet.getString("descricao");
                }
           if(!descricaoVerifica.equals(descricao)){
               return 1;
           }else{
               return 0;
           }
   }
   
   public boolean update(Celular celular, int id) throws Exception{
       try{ ///UPDATE `usuario` SET `login`='v',`senha`='4',`cpf`='new' WHERE cpf = '056.647.421-27'
           String queryString = "UPDATE celular SET descricao = ?, marca = ?, modelo = ?, valor = ?, serie = ?, quantidade = ? WHERE id ="+id;
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           ptmt.setString(1, celular.getDescricao());
           ptmt.setString(2, celular.getMarca());
           ptmt.setString(3, celular.getModelo());
           ptmt.setDouble(4, celular.getValor());
           ptmt.setString(5, celular.getSerie());
           ptmt.setInt(6, celular.getQuantidade());
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
           String queryString = "DELETE FROM celular WHERE id=?";
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
   
   
   public double buscaValor(String descricao) throws SQLException{
       
       Component rootPane = null;
       double id = 0;
       String queryString = "SELECT valor FROM celular where descricao = '"+descricao+"'";
       connection = getConnection();
       ptmt = connection.prepareStatement(queryString);
       resultSet = ptmt.executeQuery(queryString);
       resultSet.getRow();
       while(resultSet.next()){
                    id = resultSet.getDouble("valor");
                }
       return id;
   }
   
   public List<Celular> findAll() throws Exception{
       List<Celular> celulares = new ArrayList<>();
       try{
           String queryString = "SELECT * FROM celular";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery();
           while(resultSet.next()){
               celulares.add(new Celular(resultSet.getInt("id"),resultSet.getString("descricao"),
                       resultSet.getString("marca"),resultSet.getString("modelo"),resultSet.getDouble("valor"), resultSet.getString("serie"), resultSet.getInt("quantidade"), resultSet.getInt("quantidade_reservada")));
           }
           return celulares;
       } catch (SQLException e){
           e.printStackTrace();
           return celulares;
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   public int primeiroPasso() throws Exception{
       List<Celular> celulares = new ArrayList<>();
       try{
           int i=0;
           String queryString = "SELECT * FROM celular";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery();
           while(resultSet.next()){
               i++;
           }
           if(i>0)
            return 1;
           else
             return 0;  
       } catch (SQLException e){
           e.printStackTrace();
           return 2;
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   
   public void buscaId(int id) throws Exception{
       List<Celular> celulares = new ArrayList<>();
       try{
           int i=0;
           String queryString = "SELECT * FROM celular";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery();
           while(resultSet.next()){
               if(id == celulares.get(i).getId()){
                   System.out.println(celulares.get(i).getId());
               }
               i++;
           }
       } catch (SQLException e){
           e.printStackTrace();
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   
   public int getId(String serie){
       String queryString = "SELECT id FROM celular where serie = '"+serie+"'";
        try {
            connection = getConnection();
        
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery(queryString);
            resultSet.getRow();
            int getId= 0;
            while(resultSet.next()){
                    getId = resultSet.getInt("id");
                }
            return getId;
           } catch (SQLException ex) {
            return 0;
        } 
   }
   
   public List<Celular> findAlldesc() throws Exception{
       List<Celular> celulares = new ArrayList<>();
       try{
           String queryString = "SELECT * FROM celular order by nome desc";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery();
           while(resultSet.next()){
               celulares.add(new Celular(resultSet.getInt("id"),resultSet.getString("descricao"),
                       resultSet.getString("marca"),resultSet.getString("modelo"),resultSet.getDouble("valor"),resultSet.getString("serie"), resultSet.getInt("quantidade"), resultSet.getInt("quantidade_reservada")));
           }
           return celulares;
       } catch (SQLException e){
           e.printStackTrace();
           return celulares;
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
