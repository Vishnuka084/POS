package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDTO;
import dto.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PurchaseOrderBO  extends SuperBO {
    boolean purchaseOrder(OrderDTO dto) throws SQLException, ClassNotFoundException ;

    CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;

    ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException ;

    boolean checkItemsIsAvailabel(String code) throws SQLException, ClassNotFoundException ;

    boolean checkCustomerIsAvailabel(String id) throws SQLException, ClassNotFoundException ;

    String generateNewOrderID() throws SQLException, ClassNotFoundException ;

    ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException ;

    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;
}
