package pe.edu.utp.tesissupportapp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by George on 17/06/2017.
 */
public class LanguagesEntity extends BaseEntity {

    public LanguagesEntity(Connection connection){
        super(connection,"languages");

    }
    public LanguagesEntity() {super ();}

    List<Language> findAll(){
        return findByCriteria("");
    }

    public Language findById (int id) {
        String criteria = "id = " + String.valueOf(id);
        return findByCriteria(criteria).get(0);
    }
        public List<Language> findAllOrderedByName(){
            String criteria ="true ORDER BY name";
            return findByCriteria(criteria);
        }

        public List<Language> findByCriteria(String criteria){
            String sql = getDefaultQuery() +
                    criteria == "" ? "" : " WHERE " + criteria;
            List <Language> languages = new ArrayList<>();
            try{
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                if (resultSet==null) return null;
                while (resultSet.next()){
                    languages.add((new Language())
                            .setId(resultSet.getInt("id"))
                            .setName(resultSet.getString("name"))
                            .setDescription(resultSet.getString("description"))

                    );
                }
                return languages;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }


    public boolean add(Language language){
        String sql = "INSERT INTO languages(id, name, description) " +
                "VALUES(" +
                language.getIdAsString() + ", " +
                language.getNameAsValue() + ", " +
                language.getDescriptionAsValue() + ")";
        return change(sql);

    }

    public boolean delete(Language language) {
        String sql = "DELETE FROM languages WHERE id = " + language.getIdAsString();
        return change(sql);
    }

    public boolean delete(String name) {
        return change("DELETE FROM languages WHERE name = " + "'" + name + "'");
    }

    public boolean update(Language language) {
        String sql = "UPDATE languages SET " +
                "name = " + language.getNameAsValue() + ", " +
                "description = " + language.getDescriptionAsValue() +
                " WHERE id = " + language.getIdAsString();
        return change(sql);
    }









}
