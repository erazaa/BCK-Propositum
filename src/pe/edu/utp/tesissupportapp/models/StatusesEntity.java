package pe.edu.utp.tesissupportapp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 17/06/2017.
 */
public class StatusesEntity extends BaseEntity {

    public StatusesEntity(Connection connection){
        super(connection,"statuses");

}
    public StatusesEntity() {super ();}

    List<Status> findAll(){
        return findByCriteria("");
    }

    public Status findById (int id) {

        String criteria = "id = " +
                String.valueOf(id);
        return findByCriteria(criteria).get(0);
    }
    public List<Status> findAllOrderedByName(){
        String criteria ="true ORDER BY name";
        return findByCriteria(criteria);
    }

    public List<Status> findByCriteria(String criteria){
        String sql = getDefaultQuery() +
                criteria == "" ? "" : " WHERE " + criteria;
        List <Status> statuses = new ArrayList<>();
        try{
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if (resultSet==null) return null;
            while (resultSet.next()){
                statuses.add((new Status())
                        .setId(resultSet.getInt("id"))
                        .setName(resultSet.getString("name"))
                        .setDescription(resultSet.getString("description"))

                );




            }
            return statuses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean add(Status status){
        String sql = "INSERT INTO statuses(id, name, description) " +
                "VALUES(" +
                status.getIdAsString() + ", " +
                status.getNameAsValue() + ", " +
                status.getDescriptionAsValue() + ")";
        return change(sql);

    }
    public boolean delete(Status status) {
        String sql = "DELETE FROM statuses WHERE id = " + status.getIdAsString();
        return change(sql);
    }
    public boolean delete(String name) {
        return change("DELETE FROM statuses WHERE name = " + "'" + name + "'");
    }

    public boolean update(Status status) {
        String sql = "UPDATE statuses SET " +
                "name = " + status.getNameAsValue() + ", " +
                "description = " + status.getDescriptionAsValue() +
                " WHERE id = " + status.getIdAsString();
        return change(sql);
    }









}

