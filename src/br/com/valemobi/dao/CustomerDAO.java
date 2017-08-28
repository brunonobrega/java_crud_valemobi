package br.com.valemobi.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import br.com.valemobi.ValemobiConnection;
import br.com.valemobi.model.Customer;

public class CustomerDAO {
    public void save(Customer customer){
 
 /*
 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar
 * na base de dados
 */
 
 String sql = "INSERT INTO tb_customer_account(id_customer,cpf_cnpj,nm_customer,is_active,vl_total)" +
 " VALUES(?,?,?,?,?)";
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 //Cria uma conexão com o banco
 conn = ValemobiConnection.createConnectionToMySQL();
 
 //Cria um PreparedStatment, classe usada para executar a query
 pstm = conn.prepareStatement(sql);
 
 //Adiciona o valor do primeiro parâmetro da sql
 pstm.setInt(1, customer.getId());
 //Adiciona o valor do primeiro parâmetro da sql
 pstm.setLong(1, customer.getCpfCnpj());
 //Adiciona o valor do primeiro parâmetro da sql
 pstm.setString(1, customer.getCustomerName());
 //Adiciona o valor do primeiro parâmetro da sql
 pstm.setInt(1, customer.getActive());
 //Adiciona o valor do primeiro parâmetro da sql
 pstm.setInt(1, customer.getTotal());
 
 //Executa a sql para inserção dos dados
 pstm.execute();
 
 } catch (Exception e) {
 
 e.printStackTrace();
 }finally{
 
 //Fecha as conexões
 
 try{
 if(pstm != null){
 
 pstm.close();
 }
 
 if(conn != null){
 conn.close();
 }
 
 }catch(Exception e){
 
 e.printStackTrace();
 }
 }
 }
    
    
 
 public void removeById(int id_customer){
 
 String sql = "DELETE FROM valemobi WHERE id_customer = ?";
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 conn = ValemobiConnection.createConnectionToMySQL();
 
 pstm = conn.prepareStatement(sql);
 
 pstm.setInt(1, id_customer);
 
 pstm.execute();
 
 } catch (Exception e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }finally{
 
 try{
 if(pstm != null){
 
 pstm.close();
 }
 
 if(conn != null){
 conn.close();
 }
 
 }catch(Exception e){
 
 e.printStackTrace();
 }
 }
 }
 
 public void update(Customer customer){
 
 String sql = "UPDATE valemobi SET nm_customer = ?, cpf_cnpj = ?, nm_customer = ?, is_active = ?, vl_total = ?" +
 " WHERE id_customer = ?";
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 //Cria uma conexão com o banco
 conn = ValemobiConnection.createConnectionToMySQL();
 
 //Cria um PreparedStatment, classe usada para executar a query
 pstm = conn.prepareStatement(sql);
 
 //Adiciona o valor do primeiro parâmetro da sql
 pstm.setInt(1, customer.getId());
 //Adiciona o valor do primeiro parâmetro da sql
 pstm.setLong(1, customer.getCpfCnpj());
 //Adiciona o valor do primeiro parâmetro da sql
 pstm.setString(1, customer.getCustomerName());
 //Adiciona o valor do primeiro parâmetro da sql
 pstm.setInt(1, customer.getActive());
 //Adiciona o valor do primeiro parâmetro da sql
 pstm.setInt(1, customer.getTotal());
 
 pstm.setInt(4, customer.getId());
 
 //Executa a sql para inserção dos dados
 pstm.execute();
 
 } catch (Exception e) {
 
 e.printStackTrace();
 }finally{
 
 //Fecha as conexões
 
 try{
 if(pstm != null){
 
 pstm.close();
 }
 
 if(conn != null){
 conn.close();
 }
 
 }catch(Exception e){
 
 e.printStackTrace();
 }
 }
 }
 
 public List<Customer> getCustomers(){
 
 String sql = "SELECT * FROM valemobi";
 
 List<Customer> customers = new ArrayList<Customer>();
 
 Connection conn = null;
 PreparedStatement pstm = null;
 //Classe que vai recuperar os dados do banco de dados
 ResultSet rset = null;
 
 try {
 conn = ValemobiConnection.createConnectionToMySQL();
 
 pstm = conn.prepareStatement(sql);
 
 rset = pstm.executeQuery();
 
 //Enquanto existir dados no banco de dados, faça
 while(rset.next()){
 
 Customer customer = new Customer();
 
 //Recupera o id do banco e atribui ele ao objeto
 customer.setId(rset.getInt("id_customer"));
 
 //Recupera o nome do banco e atribui ele ao objeto
 customer.setCpfCnpj(rset.getLong("cpf_cnpj"));
 
 //Recupera a idade do banco e atribui ele ao objeto
 customer.setCustomerName(rset.getString("nm_customer"));
 
 //Recupera a data do banco e atribui ela ao objeto
 customer.setActive(rset.getInt("is_active"));
 
 //Recupera a data do banco e atribui ela ao objeto
 customer.setTotal(rset.getInt("vl_total"));
 
 //Adiciono o contato recuperado, a lista de contatos
 customers.add(customer);
 }
 } catch (Exception e) {
 
 e.printStackTrace();
 }finally{
 
 try{
 
 if(rset != null){
 
 rset.close();
 }
 
 if(pstm != null){
 
 pstm.close();
 }
 
 if(conn != null){
 conn.close();
 }
 
 }catch(Exception e){
 
 e.printStackTrace();
 }
 }
 
 return customers;
 }

}
