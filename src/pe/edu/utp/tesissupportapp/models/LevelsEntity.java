package pe.edu.utp.tesissupportapp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by George on 17/06/2017.
 */
public class LevelsEntity extends BaseEntity {


    public LevelsEntity (Connection connection){
        super(connection,"levels");

    }
    public LevelsEntity () {super ();}

    List<Level> findAll(){
        return findByCriteria("");
    }

    public Level findById (int id) {

        String criteria = "id = " +
                String.valueOf(id);
        return findByCriteria(criteria).get(0);
    }
    public List<Level> findAllOrderedByName(){
        String criteria ="true ORDER BY name";
        return findByCriteria(criteria);
    }

    public List<Level> findByCriteria(String criteria){
        String sql = getDefaultQuery() +
                criteria == "" ? "" : " WHERE " + criteria;
        List <Level> levels = new ArrayList<>();
        try{
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if (resultSet==null) return null;
            while (resultSet.next()){
                levels.add((new Level())
                        .setId(resultSet.getInt("id"))
                        .setName(resultSet.getString("name"))
                        .setDescription(resultSet.getString("description"))

                );

            }
            return levels;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean add(Level level){
        String sql = "INSERT INTO levels(id, name, description) " +
                "VALUES(" + level.getIdAsString() + ", " +
                level.getNameAsValue() +
                level.getDescriptionAsValue() + ")";
        return change(sql);

    }
    public boolean delete(Level level) {
        String sql = "DELETE FROM levels WHERE id = " + level.getIdAsString();
        return change(sql);
    }
    public boolean delete(String name) {
        return change("DELETE FROM level WHERE name = " +
                "'" + name + "'");
    }

    public boolean update(Level level) {
        String sql = "UPDATE levels SET " +
                "name = " + level.getNameAsValue() + ", " +
                "description = " + level.getDescriptionAsValue() + ", " +
                " WHERE id = " + level.getIdAsString();
        return change(sql);
    }





}
