package pe.edu.utp.tesissupportapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by George on 01/07/2017.
 */
public class Announcement {

    private int id;
    private ThesisAssessor thesisAssessor;
    private String title;
    private String methodology;
    private String experience;
    private String videoUrl;
    private String communicationMedia;
    private String communicationTool;
    private double price;
    private String photoPath;


    public Announcement(int id, ThesisAssessor thesisAssessor, String title, String methodology, String experience, String videoUrl, String communicationMedia, String communicationTool, double price, String photoPath) {
        this.setId(id);
        this.setThesisAssessor(thesisAssessor);
        this.setTitle(title);
        this.setMethodology(methodology);
        this.setExperience(experience);
        this.setVideoUrl(videoUrl);
        this.setCommunicationMedia(communicationMedia);
        this.setCommunicationTool(communicationTool);
        this.setPrice(price);
        this.setPhotoPath(photoPath);
    }

    public Announcement() {

    }

    public int getId() {
        return id;
    }

    public Announcement setId(int id) {
        this.id = id;
        return this;
    }
    public String getIdAsValue() { return "'" + getId() + "'";}
    public ThesisAssessor getThesisAssessor() {
        return thesisAssessor;
    }

    public Announcement setThesisAssessor(ThesisAssessor thesisAssessor) {
        this.thesisAssessor = thesisAssessor;
        return this;
    }

    public String getTitle() {
        return title;
    }
    public String getTitleAsValue() { return "'" + getTitle() + "'";}
    public Announcement setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getMethodology() {
        return methodology;
    }
    public String getMethodologyAsValue() { return "'" + getMethodology() + "'";}
    public Announcement setMethodology(String methodology) {
        this.methodology = methodology;
        return this;
    }

    public String getExperience() {
        return experience;
    }
    public String getExperienceAsValue() { return "'" + getExperience() + "'";}
    public Announcement setExperience(String experience) {
        this.experience = experience;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
    public String getVideoUrlAsValue() { return "'" + getVideoUrl() + "'";}
    public Announcement setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getCommunicationMedia() {
        return communicationMedia;
    }
    public String getCommunicationMediaAsValue() { return "'" + getCommunicationMedia() + "'";}
    public Announcement setCommunicationMedia(String communicationMedia) {
        this.communicationMedia = communicationMedia;
        return this;
    }

    public String getCommunicationTool() {
        return communicationTool;
    }
    public String getCommunicationToolAsValue() { return "'" + getCommunicationTool() + "'";}
    public Announcement setCommunicationTool(String communicationTool) {
        this.communicationTool = communicationTool;
        return this;
    }

    public double getPrice() {
        return price;
    }
    public String getPriceAsValue() { return "'" + getPrice() + "'";}
    public Announcement setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getPhotoPath() {
        return photoPath;
    }
    public String getPhotoPathAsValue() { return "'" + getPhotoPath() + "'";}
    public Announcement setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
        return this;
    }

    public static Announcement build(ResultSet rs, ThesisAssessorsEntity thesisAssessorsEntity) {
        try {
            return (new Announcement())
                    .setId(rs.getInt("id"))
                    .setThesisAssessor(thesisAssessorsEntity.findById(rs.getInt("assessor_id")))
                    .setTitle(rs.getString("title"))
                    .setMethodology(rs.getString("methodology"))
                    .setExperience(rs.getString("experience"))
                    .setVideoUrl(rs.getString("video_url"))
                    .setCommunicationMedia(rs.getString("communication_media"))
                    .setCommunicationTool(rs.getString("communication_tool"))
                    .setPrice(rs.getDouble("price"))
                    .setPhotoPath(rs.getString("photo_path"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

