package servlet;

import Dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/myydServlet")
public class MyydServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        User user1 = dao.findsql(user);
        ArrayList<String> list = new ArrayList<>();
        if (user1.getBasketball().equals("yes")){
            list.add("篮球");
        }
        if (user1.getFootball().equals("yes")){
            list.add("足球");
        }
        if (user1.getTabletennis().equals("yes")){
            list.add("乒乓球");
        }
        if (user1.getSelfstudy().equals("yes")){
            list.add("自习");
        }
        if (user1.getCoach().equals("yes")){
            list.add("辅导");
        }
        session.setAttribute("Myyd",list);
        response.sendRedirect(request.getContextPath()+"/A1/Myyd.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
