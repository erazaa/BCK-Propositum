package pe.edu.utp.tesissupportapp.models;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KEVIN on 1/07/2017.
 */
public class StudentsEntity extends BaseEntity {

    public StudentsEntity(Connection connection) {
        super(connection, "students");
    }

    public StudentsEntity() {
        super();
    }

    List<Student> findAll() {
        return findByCriteria("");
    }

    public Student findById(int id) {
        String criteria = " id = " + String.valueOf(id);
        return findByCriteria(criteria).get(0);
    }

    public Student findByName(String name) {
        String criteria = " fist_name = '" + name + "'";
        return findByCriteria(criteria).get(0);
    }

    public List<Student> findAllOrderedByName() {
        String criteria = "true ORDER BY first_name";
        return findByCriteria(criteria);
    }


    public List<Student> findByCriteria(String criteria) {
        String sql = getDefaultQuery() + (criteria.equalsIgnoreCase("") ? "" : " WHERE " + criteria);
        List<Student> students = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if(resultSet == null) return null;
            while(resultSet.next()) {
                students.add((new Student())
                        .setId(resultSet.getInt("id"))
                        .setName(resultSet.getString("name"))
                        .setPassword(resultSet.getString("password"))
                        .setLastName(resultSet.getString("last_name"))
                        .setFirstName(resultSet.getString("first_name"))
                        .setEmail(resultSet.getString("email"))
                        .setUserPhoto(resultSet.getString("user_photo"))
                        .setPhoneNumber1(resultSet.getInt("phone_number1"))
                        .setPhoneNumber2(resultSet.getInt("phone_number2"))
                        .setGender(resultSet.getString("gender"))
                        .setDegreeDocument(resultSet.getString("degree_document"))
                        .setStreet(resultSet.getString("country"))
                        .setCity(resultSet.getString("city"))
                        .setCountry(resultSet.getString("street")));
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(Student student) {
        String sql = "INSERT INTO thesis_assessors(id, name, password, last_name, first_name, email, user_photo, phone_number1, phone_number1, gender, degree_document, street, city, country) " +
                "VALUES(" +
                student.getId() + ", " +
                "'"+student.getName()+"'" + ", " +
                "'"+student.getPassword()+"'" + ", " +
                "'"+student.getLastName()+"'" + ", " +
                "'"+student.getFirstName()+"'" + ", " +
                "'"+student.getEmail()+"'" + ", " +
                "'"+student.getUserPhoto()+"'" + ", " +
                student.getPhoneNumber1() + ", " +
                student.getPhoneNumber2() + ", " +
                "'"+student.getGender()+"'" + ", " +
                "'"+student.getDegreeDocument()+"'" + ", " +
                "'"+student.getStreet()+"'" + ", "+
                "'"+student.getCity()+"'" + ", " +
                "'" + student.getCountry()+"'" + ")";
        return change(sql);
    }

    public boolean delete(Student student) {
        String sql = "DELETE FROM students WHERE id = " + student.getIdAsString();
        return change(sql);
    }

    public boolean delete(String name) {
        return change("DELETE FROM students WHERE name = " + "'" + name + "'");
    }

    public boolean update(Student student) {
        String sql = "UPDATE students SET "+
                "id = " + student.getId() + ", " +
                "name = " + "'" +student.getName() + "'" + ", " +
                "password = " + "'" +student.getPassword() + "'" + ", " +
                "last_name = " + "'" +student.getLastName() + "'" + ", " +
                "first_name = " + "'" +student.getFirstName() + "'" + ", " +
                "email = " + "'" +student.getEmail() + "'" + ", " +
                "user_photo = " + "'" +student.getUserPhoto() + "'" + ", " +
                "phone_number1 = " + student.getPhoneNumber1() + ", " +
                "phone_number2 = " + student.getPhoneNumber2() + ", " +
                "gender = " + "'" +student.getGender() + "'" + ", " +
                "degree_document = " + "'" +student.getDegreeDocument() + "'" + ", " +
                "street = " + "'" +student.getStreet() + "'" + ", " +
                "city = " + "'" +student.getCity() + "'" + ", " +
                "country = " + "'" +student.getCountry() + "'" +
                " WHERE id= " + student.getIdAsString();
        return change(sql);
    }



}
