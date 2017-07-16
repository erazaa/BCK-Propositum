package pe.edu.utp.tesissupportapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by USER on 16/06/2017.
 */
public class Status {

    private int id;
    private String name;
    private String description;

    public Status(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Status() {

    }

    public int getId() {
        return id;
    }

    public String getIdAsString() {
        return String.valueOf(getId());
    }

    public Status setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }
    public String getNameAsValue() {
        return "'"+getName()+"'";
    }

    public Status setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionAsValue() {
        return "'"+getDescription()+"'";
    }
    public Status setDescription(String description) {
        this.description = description;
        return this;
    }

    public static Status build(ResultSet resultSet) {
        try {
            return (new Status())
                    .setId(resultSet.getInt("id"))
                    .setName(resultSet.getString("name"))
                    .setName(resultSet.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
