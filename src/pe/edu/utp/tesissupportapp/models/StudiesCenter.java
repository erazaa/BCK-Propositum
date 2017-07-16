package pe.edu.utp.tesissupportapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by USER on 16/06/2017.
 */
public class StudiesCenter {

    private int id;
    private String name;
    private String description;
    private String street;
    private String city;
    private String country;
    private String phone;
    private String photoPath;

    public StudiesCenter(int id, String name, String description, String street, String city, String country, String phone, String photoPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.street = street;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.photoPath = photoPath;
    }

    public StudiesCenter() {

    }

    public int getId() {
        return id;
    }

    public String getIdAsString() {
        return String.valueOf(getId());
    }

    public StudiesCenter setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getNameAsValue() {
        return "'"+getName()+"'";
    }

    public StudiesCenter setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }
    public String getDescriptionAsValue() {
        return "'"+getDescription()+"'";
    }
    public StudiesCenter setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getStreet() {
        return street;
    }
    public String getStreetAsValue() {
        return "'"+getStreet()+"'";
    }
    public StudiesCenter setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }
    public String getCityAsValue() {
        return "'"+getCity()+"'";
    }
    public StudiesCenter setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }
    public String getCountryAsValue() {
        return "'"+getCountry()+"'";
    }
    public StudiesCenter setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getPhone() {
        return phone;
    }
    public String getPhoneAsValue() {
        return "'"+getPhone()+"'";
    }
    public StudiesCenter setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPhotoPath() {
        return photoPath;
    }
    public String getPhotoPathAsValue() {
        return "'"+getPhotoPath()+"'";
    }
    public StudiesCenter setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
        return this;
    }

    public static StudiesCenter build(ResultSet resultSet) {
        try {
            return (new StudiesCenter())
                    .setId(resultSet.getInt("id"))
                    .setName(resultSet.getString("name"))
                    .setDescription(resultSet.getString("description"))
                    .setStreet(resultSet.getString("street"))
                    .setCity(resultSet.getString("city"))
                    .setCountry(resultSet.getString("country"))
                    .setPhone(resultSet.getString("phone"))
                    .setPhotoPath(resultSet.getString("photo_path"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
