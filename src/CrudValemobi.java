import br.com.valemobi.dao.CustomerDAO;
import br.com.valemobi.model.Customer;

public class CrudValemobi {
    public static void main(String args[]){
 
    CustomerDAO customerDAO = new CustomerDAO();

    //Cria um contato e salva no banco
    Customer customer = new Customer();
    customer.setId(1);
    customer.setCpfCnpj(01234567);
    customer.setCustomerName("Bruno Nobrega");
    customer.setActive(0);
    customer.setTotal(503);

    customerDAO.save(customer);

    //Atualiza o contato com id = 1 com os dados do objeto contato1
    Customer customer1 = new Customer();
    customer1.setId(1);
    customer1.setCpfCnpj(01234567);
    customer1.setCustomerName("NOVO NOME");
    customer1.setActive(1);
    customer1.setTotal(503);

    customerDAO.update(customer1);

    //Remove o contato com id = 1

    customerDAO.removeById(1);

    //Lista todos os contatos do banco de dados

    for(Customer c : customerDAO.getCustomers()){

    System.out.println("NOME: " + c.getCustomerName());
    }
    }
}
