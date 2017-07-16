package pe.edu.utp.tesissupportapp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 17/06/2017.
 */
public class StudiesCentersEntity extends BaseEntity {


    public StudiesCentersEntity (Connection connection){
        super(connection,"studies_centers");

    }
    public StudiesCentersEntity () {super ();}

    List<StudiesCenter> findAll(){
        return findByCriteria("");
    }

    public StudiesCenter findById (int id) {

        String criteria = "id = " +
                String.valueOf(id);
        return findByCriteria(criteria).get(0);
    }
    public List<StudiesCenter> findAllOrderedByName(){
        String criteria ="true ORDER BY name";
        return findByCriteria(criteria);
    }

    public List<StudiesCenter> findByCriteria(String criteria){
        String sql = getDefaultQuery() +
                criteria == "" ? "" : " WHERE " + criteria;
        List <StudiesCenter> studiesCenters = new ArrayList<>();
        try{
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if (resultSet==null) return null;
            while (resultSet.next()){
                studiesCenters.add((new StudiesCenter())
                        .setId(resultSet.getInt("id"))
                        .setName(resultSet.getString("name"))
                        .setDescription(resultSet.getString("description"))
                        .setStreet(resultSet.getString("street"))
                        .setCity(resultSet.getString("city"))
                        .setCountry(resultSet.getString("country"))
                        .setPhone(resultSet.getString("phone"))
                        .setPhotoPath(resultSet.getString("photo_path"))

                );




            }
            return studiesCenters;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean add(StudiesCenter studiesCenter){
        String sql = "INSERT INTO studies_centers(id, name, description, street, city, country, phone, photo_path) " +
                "VALUES(" +
                studiesCenter.getIdAsString() + ", " +
                studiesCenter.getNameAsValue() + ", " +
                studiesCenter.getDescriptionAsValue() + ", " +
                studiesCenter.getStreetAsValue() + ", " +
                studiesCenter.getCityAsValue() + ", " +
                studiesCenter.getCountryAsValue() + ", " +
                studiesCenter.getPhoneAsValue() + ", " +
                studiesCenter.getPhotoPathAsValue() + ")";
        return change(sql);

    }
    public boolean delete(StudiesCenter studiesCenter) {
        String sql = "DELETE FROM studies_centers WHERE id = " + studiesCenter.getIdAsString();
        return change(sql);
    }
    public boolean delete(String name) {
        return change("DELETE FROM studies_centers WHERE name = " +
                "'" + name + "'");
    }

    public boolean update(StudiesCenter studiesCenter) {
        String sql = "UPDATE studies_centers SET " +
                "name = " + studiesCenter.getNameAsValue() + ", " +
                "description = " + studiesCenter.getDescriptionAsValue() + ", " +
                "street = " + studiesCenter.getStreetAsValue() + ", " +
                "city = " + studiesCenter.getCityAsValue() + ", " +
                "country = " + studiesCenter.getCountryAsValue() + ", " +
                "phone = " + studiesCenter.getPhoneAsValue() + ", " +
                "photo_path = " + studiesCenter.getPhotoPathAsValue() +
                " WHERE id = " + studiesCenter.getIdAsString();
        return change(sql);
    }







}
