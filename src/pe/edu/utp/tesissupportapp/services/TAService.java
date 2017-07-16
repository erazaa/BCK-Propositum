package pe.edu.utp.tesissupportapp.services;
import pe.edu.utp.tesissupportapp.models.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by KEVIN on 11/07/2017.
 */
public class TAService {
    private Connection connection;
    private TADataStore dataStore;
    private ThesisAssessorsEntity thesisAssessorsEntity;

    public TAService(InitialContext ctx) {
        try {
            connection = ((DataSource) ctx.lookup("jdbc/MySQLDataSource")).getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public TAService() {
        try {
            InitialContext ctx = new InitialContext();
            connection = ((DataSource) ctx.lookup("jdbc/MySQLDataSource")).getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Connection getConnection() {
        return connection;
    }

    private TADataStore getDataStore() {
        if(dataStore == null){
            dataStore = new TADataStore(getConnection());
        }
        return dataStore;
    }


    public List<Announcement> getAnnouncements(){
        return getDataStore().findAllAnnouncements();
    }

    public List<Career> getCareers(){

        return getDataStore().findAllCareers();
    }

    public List<Category> getCategories(){

        return getDataStore().findAllCategories();
    }

  public List<Message> getMessages(){

        return getDataStore().findAllMessages();
    }


    public List<Qualification> getQualifications(){

        return getDataStore().findAllQualifications();
    }

    public List<Student> getStudents(){

        return getDataStore().findAllStudents();
    }

    public List<ThesisAssessor> getThesis_assessors(){

        return getDataStore().findAllThesis_assessors();
    }


    public Student getStudentById(String id) {
        return getDataStore().findStudentById(
                Integer.parseInt(id));
    }

    public boolean updateStudent(Student student) {
        return getDataStore().updateStudent(student);
    }

    public ThesisAssessor getThesisAssessorById(String id) {
        return getDataStore().findThesisAssessorById(
                Integer.parseInt(id));
    }

    public boolean updateThesisAssessor(ThesisAssessor thesisAssessor) {
        return getDataStore().updateThesisAssessor(thesisAssessor);
    }




    }
