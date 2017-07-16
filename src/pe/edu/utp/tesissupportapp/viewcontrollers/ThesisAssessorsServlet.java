package pe.edu.utp.tesissupportapp.viewcontrollers;

import pe.edu.utp.tesissupportapp.models.Student;
import pe.edu.utp.tesissupportapp.models.ThesisAssessor;
import pe.edu.utp.tesissupportapp.services.TAService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by USER on 15/07/2017.
 */
@WebServlet(name = "ThesisAssessorsServlet" ,  urlPatterns = "/thesis_assessors")
public class ThesisAssessorsServlet extends HttpServlet {

    TAService service =new TAService();


    public static String THESISASSESSORS_EDIT_URI = "/editThesisassessors.jsp";
    public static String THESISASSESSORS_ADD_URI = "/newThesisassessors.jsp";
    public static String THESISASSESSORS_INDEX_URI = "/listThesisassessors.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action) {
            case "update": {
                ThesisAssessor thesisAssessor = service.getThesisAssessorById(request.getParameter("id"));
                thesisAssessor.setUsername(request.getParameter("username"));
                thesisAssessor.setPassword(request.getParameter("password"));
                thesisAssessor.setLastName(request.getParameter("last_name"));
                thesisAssessor.setFirstName(request.getParameter("first_name"));
                thesisAssessor.setEmail(request.getParameter("email"));
                thesisAssessor.setPhotoPath(request.getParameter("photo_path"));
                thesisAssessor.setPhoneNumber(Integer.parseInt(request.getParameter("phone_number")));
                thesisAssessor.setGender(request.getParameter("gender"));
                thesisAssessor.setDegreeDocument(request.getParameter("degree_document"));
                thesisAssessor.setStreet(request.getParameter("country"));
                thesisAssessor.setCity(request.getParameter("city"));
                thesisAssessor.setCountry(request.getParameter("street"));
                thesisAssessor.setCountry(request.getParameter("cv_path"));

                String message = service.updateThesisAssessor(thesisAssessor) ?
                        "Update success" :
                        "Error while updating";
                log(message);
            }
        }
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(THESISASSESSORS_INDEX_URI);
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String actionUri;
        switch(action) {
            case "add": {
                actionUri = THESISASSESSORS_ADD_URI;
                request.setAttribute("action", "add");
                break;
            }
            case "edit": {
                ThesisAssessor thesisAssessor = service.getThesisAssessorById(request.getParameter("id"));
                request.setAttribute("username", thesisAssessor);
                request.setAttribute("password", thesisAssessor);
                request.setAttribute("last_name", thesisAssessor);
                request.setAttribute("first_name", thesisAssessor);
                request.setAttribute("email", thesisAssessor);
                request.setAttribute("photo_psth", thesisAssessor);
                request.setAttribute("phone_number", thesisAssessor);
                request.setAttribute("gender", thesisAssessor);
                request.setAttribute("degree_document", thesisAssessor);
                request.setAttribute("country", thesisAssessor);
                request.setAttribute("city", thesisAssessor);
                request.setAttribute("street", thesisAssessor);
                request.setAttribute("cv_path", "edit");
                actionUri = THESISASSESSORS_EDIT_URI;
                break;
            }
            default:
                actionUri = THESISASSESSORS_INDEX_URI;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(actionUri);
        dispatcher.forward(request, response);
    }
    }

