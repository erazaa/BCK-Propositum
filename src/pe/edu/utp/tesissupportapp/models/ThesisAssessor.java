package pe.edu.utp.tesissupportapp.models;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by KEVIN on 1/07/2017.
 */
public class ThesisAssessor {
    private int id;
    private String username;
    private String password;
    private String lastName;
    private String firstName;
    private String email;
    private String photoPath;
    private int phoneNumber;
    private String gender;
    private String degreeDocument;
    private String country;
    private String city;
    private String street;
    private String cvPath;

    public ThesisAssessor() {
    }

    public ThesisAssessor(int id, String username, String password, String lastName, String firstName, String email, String photoPath, int phoneNumber, String gender, String degreeDocument, String country, String city, String street, String cvPath) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.photoPath = photoPath;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.degreeDocument = degreeDocument;
        this.country = country;
        this.city = city;
        this.street = street;
        this.cvPath = cvPath;
    }

    public int getId() {
        return id;
    }
    public String getIdAsValue() { return "'" + getId() + "'";}

    public ThesisAssessor setId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ThesisAssessor setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ThesisAssessor setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ThesisAssessor setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ThesisAssessor setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ThesisAssessor setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public ThesisAssessor setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
        return this;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getPhoneNumberAsString(){
        return String.valueOf(getPhoneNumber());
    }

    public ThesisAssessor setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public ThesisAssessor setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getDegreeDocument() {
        return degreeDocument;
    }

    public ThesisAssessor setDegreeDocument(String degreeDocument) {
        this.degreeDocument = degreeDocument;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public ThesisAssessor setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCity() {
        return city;
    }

    public ThesisAssessor setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public ThesisAssessor setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCvPath() {
        return cvPath;
    }

    public ThesisAssessor setCvPath(String cvPath) {
        this.cvPath = cvPath;
        return this;
    }

    public static ThesisAssessor build(ResultSet resultSet) {
        try {
            return (new ThesisAssessor())
                    .setId(resultSet.getInt("id"))
                    .setUsername(resultSet.getString("username"))
                    .setPassword(resultSet.getString("password"))
                    .setLastName(resultSet.getString("last_name"))
                    .setFirstName(resultSet.getString("first_name"))
                    .setEmail(resultSet.getString("email"))
                    .setPhotoPath(resultSet.getString("photo_path"))
                    .setPhoneNumber(resultSet.getInt("phone_number"))
                    .setGender(resultSet.getString("gender"))
                    .setDegreeDocument(resultSet.getString("degree_document"))
                    .setStreet(resultSet.getString("country"))
                    .setCity(resultSet.getString("city"))
                    .setCountry(resultSet.getString("street"))
                    .setCvPath(resultSet.getString("cv_path"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
