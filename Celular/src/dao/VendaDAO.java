package dao;

import conectar.ConnectionFactory;
import controller.UsuarioController;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Venda;

public class VendaDAO{
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public VendaDAO() {
    }
    
   private Connection getConnection() throws SQLException{
       Connection conn;
       conn = ConnectionFactory.getInstance().getConnection();
       return conn;
   }
   
   public boolean add(Venda venda) throws Exception{
       try{
           String queryString = "INSERT INTO venda(data, situacao, cliente,id_user,valor_total)"
                   + "VALUES(?,?,?,?,?)";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
           ptmt.setDate(1,new Date(venda.getData().getTime()));
           ptmt.setString(2,venda.getSituacao());
           ptmt.setString(3,venda.getCliente());
           ptmt.setInt(4,venda.getId_user());
           ptmt.setDouble(5,venda.getValorTotal());
           ptmt.executeUpdate();
           return true;                   
       } catch (SQLException e){
           e.printStackTrace();
           return false;
       }finally{
           closeConnection(connection,ptmt,resultSet);
       }
   }
   
   
   
   public int id_celular(String descricao) throws SQLException{
       
       Component rootPane = null;
       int id_celular = 0;
       String queryString = "SELECT id FROM celular where descricao = '"+descricao+"'";
       connection = getConnection();
       ptmt = connection.prepareStatement(queryString);
       resultSet = ptmt.executeQuery(queryString);
       resultSet.getRow();
       while(resultSet.next()){
                    id_celular = resultSet.getInt("id");
                }
       return id_celular;
   }
   
   
   public boolean updateSituacao(String descricao, int id) throws Exception{
       try{ ///UPDATE `usuario` SET `login`='v',`senha`='4',`cpf`='new' WHERE cpf = '056.647.421-27'
           String queryString = "UPDATE venda SET situacao = ? WHERE id = "+id;
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           ptmt.setString(1,descricao);
           ptmt.executeUpdate();
           return true;
       } catch (SQLException e){
           e.printStackTrace();
           return false;
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }  
   
   
   public boolean updateValorTotalSomado(int id, double valorT) throws Exception{
       try{ ///UPDATE `usuario` SET `login`='v',`senha`='4',`cpf`='new' WHERE cpf = '056.647.421-27'
           String queryString = "UPDATE venda SET valor_total = ? WHERE id = "+id;
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           ptmt.setDouble(1,valorT);
           ptmt.executeUpdate();
           return true;
       } catch (SQLException e){
           e.printStackTrace();
           return false;
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   
   public boolean updateData(Venda venda,int id) throws Exception{
       try{ ///UPDATE `usuario` SET `login`='v',`senha`='4',`cpf`='new' WHERE cpf = '056.647.421-27'
           String queryString = "UPDATE venda SET data = ? WHERE id = "+id;
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           ptmt.setDate(1,new Date(venda.getData().getTime()));
           ptmt.executeUpdate();
           return true;
       } catch (SQLException e){
           e.printStackTrace();
           return false;
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   
   public String buscaSerie(String descricao) throws SQLException{
       
       Component rootPane = null;
       String serie = "";
       String queryString = "SELECT serie FROM celular where descricao = '"+descricao+"'";
       connection = getConnection();
       ptmt = connection.prepareStatement(queryString);
       resultSet = ptmt.executeQuery(queryString);
       resultSet.getRow();
       while(resultSet.next()){
                    serie = resultSet.getString("serie");
                }
       return serie;
   }
   
   
   
   
   public int verifica(String login, String senha) throws SQLException{
       
        Component rootPane = null;
       
       String queryString = "SELECT login FROM venda where senha = '"+senha+"'";
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
   
   
   
   
   
   public boolean update(Venda venda, int id) throws Exception{
       try{
           String queryString = "UPDATE venda SET cliente = ? WHERE id = "+id;
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           ptmt.setString(1, venda.getCliente());
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
           String queryString = "DELETE FROM venda WHERE id=?";
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
   
   public List<Venda> findAll() throws Exception{
       List<Venda> vendas = new ArrayList<>();
       UsuarioController uc = new UsuarioController();
       try{
           String queryString = "SELECT * FROM venda where id_user = "+uc.getId();
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery();
           while(resultSet.next()){
               vendas.add(new Venda(resultSet.getInt("id"),resultSet.getDate("data"),
                       resultSet.getString("situacao"),resultSet.getString("cliente"),resultSet.getDouble("valor_total")));
           }
           return vendas;
       } catch (SQLException e){
           e.printStackTrace();
           return vendas;
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
      
   public int primeiroPasso() throws Exception{
       List<Venda> vendas = new ArrayList<>();
       try{
           UsuarioController uc = new UsuarioController();
           int i=0;
           String queryString = "SELECT * FROM venda WHERE id_user = "+uc.getId();
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
       List<Venda> vendas = new ArrayList<>();
       try{
           int i=0;
           String queryString = "SELECT * FROM venda";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery();
           while(resultSet.next()){
               if(id == vendas.get(i).getId()){
                   System.out.println(vendas.get(i).getId());
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
       String queryString = "SELECT id FROM venda where serie = '"+serie+"'";
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
   
   
   public double retornaValorTotal(int id) throws SQLException{
       
       Component rootPane = null;
        double qnt = 0;
       String queryString = "SELECT valor_total FROM venda where id = "+id;
       connection = getConnection();
       ptmt = connection.prepareStatement(queryString);
       resultSet = ptmt.executeQuery(queryString);
       resultSet.getRow();
       while(resultSet.next()){
                    qnt = resultSet.getDouble("valor_total");
                }
       return qnt;
   }
   
   public List<String> getCelular() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT descricao FROM celular ORDER BY descricao ASC";
        
        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(sql);
            resultSet = ptmt.executeQuery();
            while(resultSet.next()){
                list.add(resultSet.getString("descricao"));
            }
            this.ptmt.close();
            connection.close();
        } catch(SQLException Erro){
            JOptionPane.showMessageDialog(null, "Erro ao buscar a lista" + Erro + "SQL" + sql);
        }
        
        return list;
    }
   
}
