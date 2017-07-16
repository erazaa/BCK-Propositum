package pe.edu.utp.tesissupportapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by USER on 16/06/2017.
 */
public class Career {

    private int id;
    private String name;
    private String description;
    private Category category;
    private String photoPath;

    public Career(int id, String name, String description, Category category, String photoPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.photoPath = photoPath;
    }

    public Career() {

    }


    public int getId() {
        return id;
    }
    public String getIdAsValue() { return "'" + getId() + "'";}
    public Career setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }
    public String getNameAsValue() { return "'" + getName() + "'";}
    public Career setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }
    public String getDescriptionAsValue() {
        return "'"+getDescription()+"'";
    }
    public Career setDescription(String description) {
        this.description = description;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Career setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getPhotoPath() {
        return photoPath;
    }
    public String getPhotoPathAsValue() {
        return "'"+getPhotoPath()+"'";}
    public Career setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
        return this;
    }

    public static Career build(ResultSet rs, CategoriesEntity categoriesEntity) {
        try {
            return (new Career())
                    .setId(rs.getInt("id"))
                    .setName(rs.getString("name"))
                    .setDescription(rs.getString("description"))
                    .setCategory(categoriesEntity.findById(rs.getInt("category_id")))
                    .setPhotoPath(rs.getString("photo_path"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
