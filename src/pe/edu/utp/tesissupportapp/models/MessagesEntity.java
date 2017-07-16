package pe.edu.utp.tesissupportapp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KEVIN on 11/07/2017.
 */
public class MessagesEntity extends BaseEntity {
    public MessagesEntity(Connection connection) {
        super(connection, "messages");
    }

    public MessagesEntity() {
        super();
    }

    public List<Message> findAll(StudentsEntity studentsEntity, ThesisAssessorsEntity thesisAssessorsEntity, CareersEntity careersEntity, LevelsEntity levelsEntity, StudiesCentersEntity studiesCentersEntity, StatusesEntity statusesEntity, CategoriesEntity categoriesEntity) {
        return findByCriteria("",studentsEntity,thesisAssessorsEntity,careersEntity, levelsEntity, studiesCentersEntity, statusesEntity, categoriesEntity);
    }

    public Message findById(String id, StudentsEntity studentsEntity, ThesisAssessorsEntity thesisAssessorsEntity, CareersEntity careersEntity, LevelsEntity levelsEntity, StudiesCentersEntity studiesCentersEntity, StatusesEntity statusesEntity, CategoriesEntity categoriesEntity) {
        String criteria = "id = " + "'" + id + "'";
        return findByCriteria(criteria,studentsEntity,thesisAssessorsEntity,careersEntity, levelsEntity, studiesCentersEntity, statusesEntity, categoriesEntity).get(0);
    }

    public List<Message> findByCriteria(String criteria, StudentsEntity studentsEntity, ThesisAssessorsEntity thesisAssessorsEntity, CareersEntity careersEntity, LevelsEntity levelsEntity, StudiesCentersEntity studiesCentersEntity, StatusesEntity statusesEntity, CategoriesEntity categoriesEntity) {
        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Message> messages = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            if(rs == null) return null;
            while(rs.next()) messages.add(Message.build(rs,studentsEntity,thesisAssessorsEntity,careersEntity, levelsEntity, studiesCentersEntity, statusesEntity, categoriesEntity));
            return messages;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }

    public List<Message> findByStudent(Student student, StudentsEntity studentsEntity, ThesisAssessorsEntity thesisAssessorsEntity, CareersEntity careersEntity, LevelsEntity levelsEntity, StudiesCentersEntity studiesCentersEntity, StatusesEntity statusesEntity, CategoriesEntity categoriesEntity) {
        String criteria = "student_id = " + student.getIdAsString();
        return findByCriteria(criteria,studentsEntity,thesisAssessorsEntity,careersEntity, levelsEntity, studiesCentersEntity, statusesEntity, categoriesEntity);
    }

    public List<Message> findAllOrderByNroStars(StudentsEntity studentsEntity, ThesisAssessorsEntity thesisAssessorsEntity, CareersEntity careersEntity, LevelsEntity levelsEntity, StudiesCentersEntity studiesCentersEntity, StatusesEntity statusesEntity, CategoriesEntity categoriesEntity, boolean isAscending) {
        return findByCriteria("true ORDER BY nro_stars" + (isAscending ? "" : " DESC"),studentsEntity,thesisAssessorsEntity,careersEntity, levelsEntity, studiesCentersEntity, statusesEntity, categoriesEntity);
    }

    public boolean add(Message message) {
        String sql = "INSERT INTO messages(id, student_id, assessor_id, career_id, level_id, degree_title_to_get, studies_center_id, thesis_topic, thesis_exposition_date, type, status_id) VALUES(" +
                message.getId() + ", " +
                message.getStudent().getId() + ", " +
                message.getThesisAssessor().getId() + ", " +
                message.getCareer().getId() + ", " +
                message.getLevel().getId() + ", " +
                "'" + message.getDegreeTitleToGet() + "'" + ", " +
                message.getStudiesCenter().getId() + ", " +
                "'" + message.getThesisTopic() + "'" + ", " +
                "'" + message.getThesisExpositionDate() + "'" + ", " +
                "'" + message.getType() + "'" + ", " +
                message.getStatus().getId() + ")";
        return change(sql);
    }

    public boolean update(Message message) {
        String sql = "UPDATE messages SET " +
                "id = " + message.getId() + ", " +
                "student_id = " + message.getStudent().getId() + ", " +
                "assessor_id = " + message.getThesisAssessor().getId() + ", " +
                "career_id= " + message.getCareer().getId() + ", " +
                "level_id= " + message.getLevel().getId() + ", " +
                "degree_title_to_get= " + "'"+ message.getDegreeTitleToGet() + "'" + ", " +
                "studies_center_id= " + message.getStudiesCenter().getId() + ", " +
                "thesis_topic= " + "'" + message.getThesisTopic() + "'" + ", " +
                "thesis_exposition_date= " + "'" + message.getThesisExpositionDate() + "'" + ", " +
                "type= " + "'" + message.getType() + "'" + ", " +
                "status_id= " + message.getStatus().getId() +
                " WHERE id = " + message.getId();
        return change(sql);
    }

    public boolean delete(Message message) {
        String sql = "DELETE FROM messages WHERE id = " + message.getId();
        return change(sql);
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM messages WHERE id = " + id;
        return change(sql);
    }


}
