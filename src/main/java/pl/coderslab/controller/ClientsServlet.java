package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.coderslab.dao.ClientDAO;
import pl.coderslab.model.Client;

/**
 *
 * @author Tomek
 */
@WebServlet(name = "ClientsServlet", urlPatterns = {"/clients"})
public class ClientsServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ClientDAO clientDAO = new ClientDAO();
        //List<Client> clients = ClientDAO.findAll();
        //request.setAttribute("clients", clients);

        request.getRequestDispatcher("clients.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
