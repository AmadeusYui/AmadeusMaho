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

/**
 * @author Yui
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        //1.设置request编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数Map
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        //2.1制作JavaBean
        User loginuser = new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);
        //3.获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        //删除session中存储的验证码
        session.removeAttribute("checkCode_session");
        //4.判断验证码是否正确
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)){
            //忽略大小写比较字符串
            //判断用户名和密码是否一致
            User user = dao.login(loginuser);
            if (user != null){
                //需要调用UserDao查询数据库
                //登陆成功
                //存储用户信息
                session.setAttribute("user",username);
                //重定向到登陆页面
                response.sendRedirect(request.getContextPath()+"/work/index.jsp");
            }else {
                //登陆失败
                request.setAttribute("login_error","用户名或密码错误");
                //转发到登陆页面
                request.getRequestDispatcher("/A1/login.jsp").forward(request,response);
            }
        }else {
            //验证码不一致
            //存储提示信息到request
            request.setAttribute("cc_error","验证码错误");
            //转发到登陆页面
            request.getRequestDispatcher("/A1/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
