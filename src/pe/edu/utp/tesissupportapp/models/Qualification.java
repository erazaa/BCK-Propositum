package pe.edu.utp.tesissupportapp.models;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by KEVIN on 1/07/2017.
 */
public class Qualification {
    private int id;
    private Student student;
    private ThesisAssessor thesisAssessor;
    private Date date;
    private int nroStars;
    private String comment;

    public Qualification() {
    }

    public Qualification(int id, Student student, ThesisAssessor thesisAssessor, Date date, int nroStars, String comment) {
        this.id = id;
        this.student = student;
        this.thesisAssessor = thesisAssessor;
        this.date = date;
        this.nroStars = nroStars;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public Qualification setId(int id) {
        this.id = id;
        return this;
    }

    public Student getStudent() {
        return student;
    }

    public Qualification setStudent(Student student) {
        this.student = student;
        return this;
    }

    public ThesisAssessor getThesisAssessor() {
        return thesisAssessor;
    }

    public Qualification setThesisAssessor(ThesisAssessor thesisAssessor) {
        this.thesisAssessor = thesisAssessor;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Qualification setDate(Date date) {
        this.date = date;
        return this;
    }

    public int getNroStars() {
        return nroStars;
    }

    public Qualification setNroStars(int nroStars) {
        this.nroStars = nroStars;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Qualification setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public static Qualification build(ResultSet rs,  StudentsEntity studentsEntity, ThesisAssessorsEntity thesisAssessorsEntity) {
        try {
            return (new Qualification())
                    .setId(rs.getInt("id"))
                    .setStudent(studentsEntity.findById(rs.getInt("student_id")))
                    .setThesisAssessor(thesisAssessorsEntity.findById(rs.getInt("assessor_id")))
                    .setDate(rs.getDate("date"))
                    .setNroStars(rs.getInt("nro_stars"))
                    .setComment(rs.getString("comment"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
