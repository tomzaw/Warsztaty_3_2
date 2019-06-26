package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.model.Employee;

/**
 *
 * @author Tomek
 */
@WebServlet(name = "EmployeesServlet", urlPatterns = {"/employees"})
public class EmployeesServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployeeDAO employeeDAO = new EmployeeDAO();
        //List<Employee> employees = EmployeeDAO.findAll();
        //request.setAttribute("employees", employees);

        request.getRequestDispatcher("employees.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
