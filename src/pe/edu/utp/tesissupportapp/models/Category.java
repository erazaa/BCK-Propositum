package pe.edu.utp.tesissupportapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by USER on 16/06/2017.
 */
public class Category {

    private int id;
    private String name;
    private String description;
    private String photoPath;

    public Category() {
    }

    public Category(int id, String name, String description, String photoPhat) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photoPath = photoPhat;
    }


    public int getId() {
        return id;
    }

    public String getIdAsString() {
        return String.valueOf(getId());
    }

    public Category setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getNameAsValue() {
        return "'" + getName() + "'";
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }



    public String getDescription() {
        return description;
    }

    public String getDescriptionAsValue() {
        return "'"+getDescription()+"'";
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }

       public String getPhotoPath() {
        return photoPath;
    }

    public String getPhotoPathAsValue() {
        return "'"+getPhotoPath()+"'";}

    public Category setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
        return this;
    }

    public static Category build(ResultSet resultSet) {
        try {
            return (new Category())
                    .setId(resultSet.getInt("id"))
                    .setName(resultSet.getString("name"))
                            .setName(resultSet.getString("description"))
                                    .setName(resultSet.getString("photo_path")

                    );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }





}
