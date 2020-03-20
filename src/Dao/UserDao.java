package Dao;
import domain.User;
import util.JDBCUtils;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 操作数据库中user表的类
 * @author Yui
 */
public class UserDao {
    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 登录方法
     * @param loginuser 只有用户名和密码
     * @return 用户的全部数据,没有查询到返回null
     */
    public User login(User loginuser){
        try {
            //编写sql
            String sql = "select * from user where username = ? and password = ?";
            //调用query方法
            User user_1 = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginuser.getUsername(),loginuser.getPassword());

            return user_1;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean regist(String username,String password){

        try {
            Connection conn = JDBCUtils.getConnection();
            String sql = "insert into user (Username,Password,basketball,football,selfstudy,coach,tabletennis) values (?,?,'no','no','no','no','no')";
            PreparedStatement ps = null;
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void insql(String user, List<String> Pro) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        for (String s : Pro) {
            String sql = "update user set " + s +"='yes' where Username =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            ps.executeUpdate();
            ps.close();
        }
    }

    public User findsql(String user){
        String sql = "select * from user where username = ?";
        User user_re = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),user);
        return user_re;
    }

    public void changepwd(String name,String newpwd) throws SQLException {
        String sql = "update user set Password=? where Username =?";
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,newpwd);
        ps.setString(2,name);
        ps.executeUpdate();
    }
}
