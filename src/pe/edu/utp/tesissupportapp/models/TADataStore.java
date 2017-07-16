package pe.edu.utp.tesissupportapp.models;
import java.sql.Connection;
import java.util.List;

/**
 * Created by KEVIN on 11/07/2017.
 */
public class TADataStore {
    private Connection connection;
    private AnnouncementEntity announcementEntity;
    private CareersEntity careersEntity;
    private CategoriesEntity categoriesEntity;
    private LanguagesEntity languagesEntity;
    private LevelsEntity levelsEntity;
    private MessagesEntity messagesEntity;
    private QualificationsEntity qualificationsEntity;
    private StatusesEntity statusesEntity;
    private StudentsEntity studentsEntity;
    private StudiesCentersEntity studiesCentersEntity;
    private ThesisAssessorsEntity thesisAssessorsEntity;

    public TADataStore(Connection connection) {
        this.connection = connection;
    }

    public TADataStore() {
    }

    public Connection getConnection() {
        return connection;
    }

    public TADataStore setConnection(Connection connection) {
        this.connection = connection;
        return this;
    }


    public AnnouncementEntity getAnnouncementEntity(){

        if(announcementEntity == null){

            announcementEntity = new AnnouncementEntity(getConnection());
        }

        return announcementEntity;

    }

    public List<Announcement> findAllAnnouncements() {
        return getAnnouncementEntity().findAll(getThesisAssessorsEntity());
    }




    public CareersEntity getCareersEntity() {
        if(careersEntity == null){
            careersEntity = new CareersEntity(getConnection());
        }
        return careersEntity;
    }

    public List<Career> findAllCareers() {

        return getCareersEntity().findAll(getCategoriesEntity());
    }


    public CategoriesEntity getCategoriesEntity() {
        if(categoriesEntity == null){
            categoriesEntity = new CategoriesEntity(getConnection());
        }
        return categoriesEntity;
    }

    public List<Category> findAllCategories() {

        return getCategoriesEntity().findAll();
    }

    public LanguagesEntity getLanguagesEntity() {
        if(languagesEntity == null){
            languagesEntity = new LanguagesEntity(getConnection());
        }
        return languagesEntity;
    }

    public LevelsEntity getLevelsEntity() {
        if(levelsEntity == null){
            levelsEntity = new LevelsEntity(getConnection());
        }
        return levelsEntity;
    }

    public MessagesEntity getMessagesEntity() {
        if(messagesEntity == null){
            messagesEntity = new MessagesEntity(getConnection());
        }
        return messagesEntity;
    }

    public List<Message> findAllMessages() {

        return getMessagesEntity().findAll(getStudentsEntity(),getThesisAssessorsEntity(),getCareersEntity(),getLevelsEntity(),getStudiesCentersEntity(),getStatusesEntity(),getCategoriesEntity());
    }

    public QualificationsEntity getQualificationsEntity() {
        if(qualificationsEntity == null){
            qualificationsEntity = new QualificationsEntity(getConnection());
        }
        return qualificationsEntity;
    }

    public List<Qualification> findAllQualifications() {

        return getQualificationsEntity().findAll(getStudentsEntity(), getThesisAssessorsEntity());

    }


    public StatusesEntity getStatusesEntity() {
        if(statusesEntity == null){
            statusesEntity = new StatusesEntity(getConnection());
        }
        return statusesEntity;
    }

    public StudentsEntity getStudentsEntity() {
        if(studentsEntity == null){
            studentsEntity = new StudentsEntity(getConnection());
        }
        return studentsEntity;
    }

    public List<Student> findAllStudents() {

        return getStudentsEntity().findAll();
    }

    public StudiesCentersEntity getStudiesCentersEntity() {
        if(studiesCentersEntity == null){
            studiesCentersEntity = new StudiesCentersEntity(getConnection());
        }
        return studiesCentersEntity;
    }

    public ThesisAssessorsEntity getThesisAssessorsEntity() {
        if(thesisAssessorsEntity == null){
            thesisAssessorsEntity = new ThesisAssessorsEntity(getConnection());
        }
        return thesisAssessorsEntity;
    }

    public List<ThesisAssessor> findAllThesis_assessors() {

        return getThesisAssessorsEntity().findAll();
    }

    public Student findStudentById(int id) {
        return getStudentsEntity().findById(id);
    }

    public boolean updateStudent(Student student) {
        return getStudentsEntity().update(student);
    }


    public boolean updateThesisAssessor(ThesisAssessor thesisAssessor) {
        
        return getThesisAssessorsEntity().update(thesisAssessor);
    }

    public ThesisAssessor findThesisAssessorById(int id) {
        return getThesisAssessorsEntity().findById(id);
    }

   }
