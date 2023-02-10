package bo;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {
     ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException ;

    boolean inserCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

    boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

    boolean customerExite(String id) throws SQLException, ClassNotFoundException ;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    String generateNewCustomerNewID() throws SQLException, ClassNotFoundException ;

}
