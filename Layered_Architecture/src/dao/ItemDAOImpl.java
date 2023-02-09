package dao;

import db.DBConnection;
import model.CustomerDTO;
import model.ItemDTO;
import view.tdm.ItemTM;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO{

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Item");
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        while (rst.next()) {
            allItems.add(new ItemDTO(rst.getString(1), rst.getString(2), rst.getBigDecimal(3), rst.getInt(4)));
        }
        return allItems;
    }
    
    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
           return SQLUtil.executeUpdate("DELETE FROM Item WHERE code=?",code);
    }
    
    @Override
    public boolean insertItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
          return SQLUtil.executeUpdate("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
    }
    
    @Override
    public Boolean Update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {        
          return SQLUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand(), itemDTO.getCode());        
    }
    @Override
    public Boolean existItems(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT code FROM Item WHERE code=?", code);
        return rst.next();

    }
    @Override
    public  String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }
}
