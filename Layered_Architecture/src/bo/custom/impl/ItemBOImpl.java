package bo.custom.impl;

import bo.custom.ItemBO;
import dao.custom.ItemDAO;
import dao.custom.impl.ItemDAOImpl;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    private final ItemDAO itemDAO = new ItemDAOImpl();

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }
    @Override
    public boolean inserItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return  itemDAO.insert(dto);
    }
    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.Update(dto);
    }
    @Override
    public boolean itemExite(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(id);
    }
    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(id);
    }
    @Override
    public String generateNewItemNewID() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewId();
    }
}