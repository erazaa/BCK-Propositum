package pe.edu.utp.tesissupportapp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 13/07/2017.
 */
public class AnnouncementEntity extends BaseEntity{

    public AnnouncementEntity(Connection connection) {
        super(connection, "announcements");
    }
    public AnnouncementEntity() {    super();}

    public List<Announcement> findAll(ThesisAssessorsEntity thesisAssessorsEntity) {
        return findByCriteria("", thesisAssessorsEntity);
    }

    public Announcement findById(int id, ThesisAssessorsEntity thesisAssessorsEntity) {
        try {
            String criteria = "id = " + String.valueOf(id);
            return findByCriteria(criteria, thesisAssessorsEntity).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }



    public List<Announcement> findByCriteria(
            String criteria,
            ThesisAssessorsEntity thesisAssessorsEntity) {
        String sql = getDefaultQuery() +
                (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Announcement> announcements = new ArrayList<>();
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if(rs == null) return null;
            while(rs.next()) {
                announcements.add(
                        Announcement.build(rs, thesisAssessorsEntity));
                return announcements;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(Announcement announcement) {
        String sql = "INSERT INTO announcements(id, assessor_id, title, methodology, experience, video_url, communication_media, communication_tool, price, photo_path) VALUES(" +
                announcement.getIdAsValue() + ", " +
                announcement.getThesisAssessor().getIdAsValue() + ", " +
                announcement.getMethodologyAsValue() + ", " +
                announcement.getExperienceAsValue() + ", " +
                announcement.getVideoUrlAsValue() + ", " +
                announcement.getCommunicationMediaAsValue() + ", " +
                announcement.getCommunicationToolAsValue() + ", " +
                announcement.getPriceAsValue() + ", " +
                announcement.getPhotoPathAsValue() + ")";

        return change(sql);
    }

    public boolean update(Announcement announcement) {
        String sql = "UPDATE announcements SET " +
                "assessor_id = " + announcement.getThesisAssessor().getIdAsValue() +
                "title = " + announcement.getTitleAsValue()+ ", " +
                "methodology = " + announcement.getMethodologyAsValue() + ", " +
                "experience = " + announcement.getExperienceAsValue() +
                "video_url = " + announcement.getVideoUrlAsValue() + ", " +
                "communication_media = " + announcement.getCommunicationMediaAsValue() + ", " +
                "communication_tool = " + announcement.getCommunicationToolAsValue() + ", " +
                "price = " + announcement.getPriceAsValue() + ", " +
                "photo_path = " + announcement.getPhotoPathAsValue() + ", " +
                " WHERE id = " + announcement.getIdAsValue();
        return change(sql);
    }

    public boolean delete(Announcement announcement) {
        String sql = "DELETE FROM announcements WHERE id = " +
                announcement.getIdAsValue();
        return change(sql);
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM announcements WHERE id = " +
                "'" + id + "'";
        return change(sql);
    }



}
