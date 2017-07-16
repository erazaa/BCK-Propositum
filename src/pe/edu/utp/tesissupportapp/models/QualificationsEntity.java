package pe.edu.utp.tesissupportapp.models;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KEVIN on 1/07/2017.
 */
public class QualificationsEntity extends BaseEntity {

    public QualificationsEntity(Connection connection) {
        super(connection, "qualifications");
    }

    public QualificationsEntity() {
        super();
    }

    public List<Qualification> findAll(StudentsEntity studentsEntity,ThesisAssessorsEntity thesisAssessorsEntity) {
        return findByCriteria("",studentsEntity,thesisAssessorsEntity);
    }

    public Qualification findById(String id,  StudentsEntity studentsEntity, ThesisAssessorsEntity thesisAssessorsEntity) {
        String criteria = "id = " + "'" + id + "'";
        return findByCriteria(criteria,studentsEntity,thesisAssessorsEntity).get(0);
    }

    public List<Qualification> findByCriteria(String criteria, StudentsEntity studentsEntity, ThesisAssessorsEntity thesisAssessorsEntity) {
        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Qualification> qualifications = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            if(rs == null) return null;
            while(rs.next()) qualifications.add(Qualification.build(rs,studentsEntity,thesisAssessorsEntity));
            return qualifications;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return qualifications;
    }

    public List<Qualification> findByStudent(Student student,  StudentsEntity studentsEntity, ThesisAssessorsEntity thesisAssessorsEntity) {
        String criteria = "student_id = " + student.getIdAsString();
        return findByCriteria(criteria,studentsEntity,thesisAssessorsEntity);
    }

    public List<Qualification> findAllOrderByNroStars( StudentsEntity studentsEntity,ThesisAssessorsEntity thesisAssessorsEntity, boolean isAscending) {
        return findByCriteria("true ORDER BY nro_stars" + (isAscending ? "" : " DESC"), studentsEntity, thesisAssessorsEntity );
    }

    public boolean add(Qualification qualification) {
        String sql = "INSERT INTO qualifications(id, student_id, assessor_id, date, nro_stars, comment) VALUES(" +
                qualification.getId() + ", " +
                qualification.getStudent().getId() + ", " +
                qualification.getThesisAssessor().getId() +
                "'"+qualification.getDate()+"'"+
                qualification.getNroStars()+
                "'"+qualification.getComment()+"'"+")";
        return change(sql);
    }

    public boolean update(Qualification qualification) {
        String sql = "UPDATE qualifications SET " +
                "id = " + qualification.getId() + ", " +
                "student_id = " + qualification.getStudent().getId() + ", " +
                "assessor_id = " + qualification.getThesisAssessor().getId() + ", " +
                "date = " +"'" + qualification.getDate() + "'" + ", " +
                "nro_stars = " + qualification.getNroStars() + ", " +
                "comment = " + "'" + qualification.getComment() + "'" +
                " WHERE id = " + qualification.getId();
        return change(sql);
    }

    public boolean delete(Qualification qualification) {
        String sql = "DELETE FROM qualifications WHERE id = " + qualification.getId();
        return change(sql);
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM qualifications WHERE id = " + id;
        return change(sql);
    }
}
