package servlet;

import Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 预约操作
 * @author Yui
 */
@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("user");
        ArrayList<String> order = new ArrayList<String>();
        if (request.getParameter("basketball")!= null && request.getParameter("basketball").equals("yes")){
            order.add("basketball");
        }
        if (request.getParameter("football")!= null && request.getParameter("football").equals("yes")){
            order.add("football");
        }
        if (request.getParameter("tabletennis")!= null && request.getParameter("tabletennis").equals("yes")){
            order.add("tabletennis");
        }
        if (request.getParameter("selfstudy")!= null && request.getParameter("selfstudy").equals("yes")){
            order.add("selfstudy");
        }
        if (request.getParameter("coach")!= null && request.getParameter("coach").equals("yes")){
            order.add("coach");
        }
        System.out.println(order);
        UserDao dao = new UserDao();
        try {
            dao.insql(username,order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/A1/Ordersuccess.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
