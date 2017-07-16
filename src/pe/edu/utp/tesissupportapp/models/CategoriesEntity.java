package pe.edu.utp.tesissupportapp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 16/06/2017.
 */
public class CategoriesEntity extends BaseEntity {

    public CategoriesEntity(Connection connection) {
        super(connection, "categories");
    }

    public CategoriesEntity(){ super();}

    List<Category> findAll() {
        return findByCriteria("");
    }

    public Category findById(int id) {
        String criteria = " id = " + String.valueOf(id);
        return findByCriteria(criteria).get(0);
    }

    public List<Category> findAllOrderedByName() {
        String criteria = "true ORDER BY name";
        return findByCriteria(criteria);
    }

    public List<Category> findByCriteria(String criteria) {
        String sql = getDefaultQuery() +
                criteria == "" ? "" : " WHERE " + criteria;
        List<Category> categories = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if(resultSet == null) return null;
            while(resultSet.next()) {
                categories.add((new Category())
                        .setId(resultSet.getInt("id"))
                        .setName(resultSet.getString("name"))
                        .setDescription(resultSet.getString("description"))
                        .setPhotoPath(resultSet.getString("photo_path"))
                );
            }
            return categories;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(Category category) {
        String sql = "INSERT INTO categories(id, name,description, photo_path) " +
                "VALUES(" + category.getIdAsString() + ", " +
                category.getNameAsValue() + ", " +
                category.getDescriptionAsValue() + ", " +
                category.getPhotoPathAsValue() + ")";
        return change(sql);
    }

    public boolean delete(Category category) {
        String sql = "DELETE FROM categories WHERE id = " + category.getIdAsString();
        return change(sql);
    }

    public boolean delete(String name) {
        return change("DELETE FROM categories WHERE name = " +
                "'" + name + "'");
    }



       public boolean update(Category category) {
        String sql = "UPDATE categories SET " +
                "name = " + category.getNameAsValue() + ", " +
                "description = " + category.getDescriptionAsValue() + ", " +
                "photo_path = " + category.getPhotoPathAsValue() + ", " +
                " WHERE category_id = " + category.getIdAsString();
        return change(sql);
    }



}
