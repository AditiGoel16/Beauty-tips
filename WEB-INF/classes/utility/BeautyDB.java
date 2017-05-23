package utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import business.Beauty;
import business.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Aditi h Beauty DB Utility class to get and add Beauty
 * details into the database.
 */
public class BeautyDB {

    public static Beauty getBeauty(String tipsCode) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM BeautyDB "
                + "WHERE tipsCode = ?";
        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, tipsCode);
            rs = ps.executeQuery();
            Beauty Beauty = null;
            if (rs.next()) {
                Beauty = new Beauty();
                Beauty.settipsCode(rs.getString("tipsCode"));
                Beauty.setTitle(rs.getString("title"));
                SimpleDateFormat parser=new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
                Date date = parser.parse(rs.getString("DateCreated"));
                Beauty.setDateCreated(date);
                Beauty.setDescription(rs.getString("Description"));
                Beauty.setTipstatus(rs.getString("tipstatus"));
                Beauty.setUrl(rs.getString("url"));
                Beauty.setUrlToImage(rs.getString("UrlToImage"));
            }
            connection.close();
            return Beauty;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(BeautyDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BeautyDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static ArrayList<Beauty> getAllBeauty() throws IOException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM BeautyDB ";
        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Beauty Beauty = null;
            ArrayList<Beauty> BeautyList = new ArrayList<>();
            while (rs.next()) {
                Beauty = new Beauty();
                Beauty.settipsCode(rs.getString("tipsCode"));
                Beauty.settipsCode(rs.getString("tipsCode"));
                Beauty.setTitle(rs.getString("title"));
                SimpleDateFormat parser=new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
                Date date = parser.parse(rs.getString("DateCreated"));
                Beauty.setDateCreated(date);
                Beauty.setDescription(rs.getString("Description"));
                Beauty.setTipstatus(rs.getString("tipstatus"));
                Beauty.setUrl(rs.getString("url"));
                Beauty.setUrlToImage(rs.getString("UrlToImage"));
                BeautyList.add(Beauty);
            }
            connection.close();
            return BeautyList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(BeautyDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BeautyDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
        return null;
    }

    public static ArrayList<Beauty> getMyBeauty(String email) throws IOException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM BeautyDB "
                + "WHERE AutherEmail = ? ";

        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            Beauty Beauty = null;
            ArrayList<Beauty> studies = new ArrayList<>();
            if (rs != null) {
                while (rs.next()) {
                    Beauty = new Beauty();
                    Beauty.settipsCode(rs.getString("tipsCode"));
                    Beauty.setTitle(rs.getString("title"));
                    SimpleDateFormat parser=new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
                    Date date = parser.parse(rs.getString("DateCreated"));
                    Beauty.setDateCreated(date);
                    Beauty.setDescription(rs.getString("Description"));
                    Beauty.setTipstatus(rs.getString("tipstatus"));
                    Beauty.setUrl(rs.getString("url"));
                    Beauty.setUrlToImage(rs.getString("UrlToImage"));
                    studies.add(Beauty);
                }
            }
            connection.close();
            return studies;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(BeautyDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BeautyDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static ArrayList<Beauty> getBeautyByStatus(String status) throws IOException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM BeautyDB "
                + "WHERE tipstatus = ?";

        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, status);
            rs = ps.executeQuery();
            Beauty Beauty = null;
            ArrayList<Beauty> studies = new ArrayList<>();
            if (rs != null) {
                while (rs.next()) {
                    Beauty = new Beauty();
                    Beauty.settipsCode(rs.getString("tipsCode"));
                    Beauty.setTitle(rs.getString("title"));
                    SimpleDateFormat parser=new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
                    Date date = parser.parse(rs.getString("DateCreated"));
                    Beauty.setDateCreated(date);
                    Beauty.setDescription(rs.getString("Description"));
                    Beauty.setTipstatus(rs.getString("tipstatus"));
                    Beauty.setUrl(rs.getString("url"));
                    Beauty.setUrlToImage(rs.getString("UrlToImage"));
                    studies.add(Beauty);
                }
            }
            connection.close();
            return studies;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(BeautyDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BeautyDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static int addBeauty(Beauty Beauty,User user) throws IOException {

        PreparedStatement ps = null;
        Connection connection = null;
        String query
                = "INSERT INTO BeautyDB(tipsCode,Title, Auther, AutherEmail, Description, url, tipstatus, urltoImage,DateCreated) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = ConnectionPool.getConnection();
            System.out.println("conn"+connection);
            ps = connection.prepareStatement(query);
            System.out.println("stmt"+ps);
            ps.setString(1, Beauty.gettipsCode());
            ps.setString(2, Beauty.getTitle());
            ps.setString(3, user.getName());
            ps.setString(4, user.getEmail());
            ps.setString(5, Beauty.getDescription());
            ps.setString(6, Beauty.getUrl());
            ps.setString(7, "Pending for Approval");
            ps.setString(8, Beauty.getUrlToImage());
            ps.setString(9, (Beauty.getDateCreated()).toString());
            return ps.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e);
            return 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BeautyDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closePreparedStatement(ps);
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(BeautyDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    public static int updateBeautyStatus(String tipsCode, String tipstatus) throws IOException {

        PreparedStatement ps = null;
        Connection connection = null;
        String query = "UPDATE BeautyDB SET "
                + "tipstatus = ?"
                + "WHERE tipsCode = ?";
        try {
            connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, tipstatus);
            ps.setString(2, tipsCode);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BeautyDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closePreparedStatement(ps);
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(BeautyDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
}
