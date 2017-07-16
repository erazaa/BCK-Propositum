package pe.edu.utp.tesissupportapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by KEVIN on 11/07/2017.
 */
public class Message {
    private int id;
    private Student student;
    private ThesisAssessor thesisAssessor;
    private Career career;
    private Level level;
    private String degreeTitleToGet;
    private StudiesCenter studiesCenter;
    private String thesisTopic;
    private Date thesisExpositionDate;
    private String type;
    private Status status;

    public Message() {

    }

    public Message(int id, Student student, ThesisAssessor thesisAssessor, Career career, Level level, String degreeTitleToGet, StudiesCenter studiesCenter, String thesisTopic, Date thesisExpositionDate, String type, Status status) {
        this.id = id;
        this.student = student;
        this.thesisAssessor = thesisAssessor;
        this.career = career;
        this.level = level;
        this.degreeTitleToGet = degreeTitleToGet;
        this.studiesCenter = studiesCenter;
        this.thesisTopic = thesisTopic;
        this.thesisExpositionDate = thesisExpositionDate;
        this.type = type;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Message setId(int id) {
        this.id = id;
        return this;
    }

    public Student getStudent() {
        return student;
    }

    public Message setStudent(Student student) {
        this.student = student;
        return this;
    }

    public ThesisAssessor getThesisAssessor() {
        return thesisAssessor;
    }

    public Message setThesisAssessor(ThesisAssessor thesisAssessor) {
        this.thesisAssessor = thesisAssessor;
        return this;
    }

    public Career getCareer() {
        return career;
    }

    public Message setCareer(Career career) {
        this.career = career;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public Message setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getDegreeTitleToGet() {
        return degreeTitleToGet;
    }

    public Message setDegreeTitleToGet(String degreeTitleToGet) {
        this.degreeTitleToGet = degreeTitleToGet;
        return this;
    }

    public StudiesCenter getStudiesCenter() {
        return studiesCenter;
    }

    public Message setStudiesCenter(StudiesCenter studiesCenter) {
        this.studiesCenter = studiesCenter;
        return this;
    }

    public String getThesisTopic() {
        return thesisTopic;
    }

    public Message setThesisTopic(String thesisTopic) {
        this.thesisTopic = thesisTopic;
        return this;
    }

    public Date getThesisExpositionDate() {
        return thesisExpositionDate;
    }

    public Message setThesisExpositionDate(Date thesisExpositionDate) {
        this.thesisExpositionDate = thesisExpositionDate;
        return this;
    }

    public String getType() {
        return type;
    }

    public Message setType(String type) {
        this.type = type;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Message setStatus(Status status) {
        this.status = status;
        return this;
    }

    public static Message build(ResultSet rs, StudentsEntity studentsEntity, ThesisAssessorsEntity thesisAssessorsEntity, CareersEntity careersEntity, LevelsEntity levelsEntity, StudiesCentersEntity studiesCentersEntity, StatusesEntity statusesEntity, CategoriesEntity categoriesEntity) {
        try {
            return (new Message())
                    .setId(rs.getInt("id"))
                    .setStudent(studentsEntity.findById(rs.getInt("student_id")))
                    .setThesisAssessor(thesisAssessorsEntity.findById(rs.getInt("assessor_id")))
                    .setCareer(careersEntity.findById(rs.getInt("career_id"),categoriesEntity))
                    .setLevel(levelsEntity.findById(rs.getInt("level_id")))
                    .setDegreeTitleToGet(rs.getString("degree_title_to_get"))
                    .setStudiesCenter(studiesCentersEntity.findById(rs.getInt("studies_center_id")))
                    .setThesisTopic(rs.getString("thesis_topic"))
                    .setThesisExpositionDate(rs.getDate("thesis_exposition_date"))
                    .setType(rs.getString("type"))
                    .setStatus(statusesEntity.findById(rs.getInt("status_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }





}
