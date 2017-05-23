package utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import business.User;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aditi Goel User DB Utility class to get User details
 * from the database.
 */
public class UserDB {

    public static User getUser(String emailAddress) throws IOException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM UserDb "
                + "WHERE Email = ?";
        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setType(rs.getString("Type"));
                user.setPassword((rs.getString("Password")));
                user.setNumOfPostedTips(Integer.parseInt(rs.getString("NumPostedtips")));
                user.setNumOfPosts(Integer.parseInt(rs.getString("NumOfPosts")));
            }
            connection.close();
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }

    }
    public static User insertUser(User user) throws IOException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "Insert Into userDB "
                + "(Name, Email,Password,Type,NumOfPosts,NumPostedtips) VALUES"
                + "(?,?,?,?,?,?)";
        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, "Reporter");
            ps.setInt(5,0);
            ps.setInt(6,0);
            int result= ps.executeUpdate();
            if(result == 1){
                connection.close();
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
        return null;
    }
    public static ArrayList<User> getUsers() throws IOException {

        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM User ";
        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            User user = null;
            ArrayList<User> users = new ArrayList<>();
            while (rs.next()) {
                user = new User();
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setType(rs.getString("Type"));
                user.setPassword((rs.getString("Password")));
                user.setNumOfPostedTips(Integer.parseInt(rs.getString("numOfPostedTips")));
                user.setNumOfPosts(Integer.parseInt(rs.getString("NumOfPosts")));
                users.add(user);
            }
            connection.close();
            return users;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }
}
