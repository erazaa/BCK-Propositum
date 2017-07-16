package pe.edu.utp.tesissupportapp.viewcontrollers;

import pe.edu.utp.tesissupportapp.models.Student;
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
@WebServlet(name = "StudentsServlet",  urlPatterns = "/students")
public class StudentsServlet extends HttpServlet {

    TAService service =new TAService();

    public static String STUDENTS_EDIT_URI = "/editStudent.jsp";
    public static String STUDENTS_ADD_URI = "/newStudent.jsp";
    public static String STUDENTS_INDEX_URI = "/listStudents.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        switch(action) {
            case "update": {
                Student student = service.getStudentById(request.getParameter("id"));
                student.setName(request.getParameter("name"));
                student.setPassword(request.getParameter("password"));
                student.setLastName(request.getParameter("last_name"));
                student.setFirstName(request.getParameter("first_name"));
                student.setEmail(request.getParameter("email"));
                student.setUserPhoto(request.getParameter("user_photo"));
                student.setPhoneNumber1(Integer.parseInt(request.getParameter("phone_number1")));
                student.setPhoneNumber2(Integer.parseInt(request.getParameter("phone_number2")));
                student.setGender(request.getParameter("gender"));
                student.setDegreeDocument(request.getParameter("document_degree"));
                student.setStreet(request.getParameter("street"));
                student.setCity(request.getParameter("city"));
                student.setCountry(request.getParameter("country"));

                String message = service.updateStudent(student) ?
                        "Update success" :
                        "Error while updating";
                log(message);
            }
        }
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(STUDENTS_INDEX_URI);
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String actionUri;
        switch(action) {
            case "add": {
                actionUri = STUDENTS_ADD_URI;
                request.setAttribute("action", "add");
                break;
            }
            case "edit": {
                Student student = service.getStudentById(request.getParameter("id"));
                request.setAttribute("name", student);
                request.setAttribute("password", student);
                request.setAttribute("last_name", student);
                request.setAttribute("first_name", student);
                request.setAttribute("email", student);
                request.setAttribute("user_photo", student);
                request.setAttribute("phone_number1", student);
                request.setAttribute("phone_number2", student);
                request.setAttribute("gender", student);
                request.setAttribute("document_degree", student);
                request.setAttribute("street", student);
                request.setAttribute("city", student);
                request.setAttribute("country", student);
                request.setAttribute("action", "edit");
                actionUri = STUDENTS_EDIT_URI;
                break;
            }
            default:
                actionUri = STUDENTS_INDEX_URI;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(actionUri);
        dispatcher.forward(request, response);
    }

}
