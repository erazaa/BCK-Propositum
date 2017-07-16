package pe.edu.utp.tesissupportapp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 16/06/2017.
 */
public class CareersEntity extends BaseEntity {

    public CareersEntity(Connection connection) {
        super(connection, "careers");
    }
    public CareersEntity() {    super();}

    public List<Career> findAll(CategoriesEntity categoriesEntity) {
        return findByCriteria("", categoriesEntity);
    }

    public Career findById(int id, CategoriesEntity categoriesEntity) {
        try {
            String criteria = "id = " + String.valueOf(id);
            return findByCriteria(criteria, categoriesEntity).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Career> findByCriteria(
            String criteria,
            CategoriesEntity categoriesEntity) {
        String sql = getDefaultQuery() +
                (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Career> careers = new ArrayList<>();
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if(rs == null) return null;
            while(rs.next()) {
                careers.add(
                        Career.build(rs, categoriesEntity));
                return careers;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return careers;
    }

    public boolean add(Career career) {
        String sql = "INSERT INTO careers(id, name, description, category_id, photo_path) VALUES(" +
                career.getIdAsValue() + ", " +
                career.getNameAsValue() + ", " +
                career.getDescriptionAsValue() + ", " +
                career.getPhotoPathAsValue() + ", " +
                career.getCategory().getIdAsString() + ")";

        return change(sql);
    }

    public boolean update(Career career) {
        String sql = "UPDATE careers SET " +
                "name = " + career.getNameAsValue() + ", " +
                "description = " + career.getDescriptionAsValue() + ", " +
                "category_id = " + career.getCategory().getIdAsString() +
                "photo_path = " + career.getPhotoPathAsValue() + ", " +
                " WHERE id = " + career.getIdAsValue();
        return change(sql);
    }

    public boolean delete(Career career) {
        String sql = "DELETE FROM careers WHERE id = " +
                career.getIdAsValue();
        return change(sql);
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM careers WHERE id = " +
                "'" + id + "'";
        return change(sql);
    }











}
