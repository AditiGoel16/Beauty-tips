package controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import business.Beauty;
import business.User;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.BeautyDB;
import utility.UserDB;

/**
 *
 * @author Aditi Goel 
 * Beauty controller which controls the flow of application related to study details. 
 */
public class BeautyController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("theUser");
        User admin = (User) session.getAttribute("theAdmin");
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            if (user != null) {
                url = "/main.jsp";
            } else {
                if (admin != null) {
                    url = "/admin.jsp";
                } else {
                    url = "/main.jsp";
                }
            }
        } else if (action.equalsIgnoreCase("addBeauty")) {
            if (user != null) {
                try {
                    Beauty newBeauty = new Beauty();
                    newBeauty.settipsCode(request.getParameter("tipsCode"));
                    newBeauty.setTitle(request.getParameter("Title"));
                    newBeauty.setDescription(request.getParameter("Description"));
                    newBeauty.setUrl(request.getParameter("url"));
                    newBeauty.setUrlToImage(request.getParameter("UrlToImage"));
                    SimpleDateFormat parser=new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
                    Date date = new Date();
                    //parser.
                    date = parser.parse(date.toString());
                    newBeauty.setDateCreated(date);
                    user = (User)session.getAttribute("theUser");
                    BeautyDB.addBeauty(newBeauty,user);
                    url="/main.jsp";
                } catch (ParseException ex) {
                    Logger.getLogger(BeautyController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }
        else if (action.equalsIgnoreCase("myBeauty")) {
            if (user != null) {
                ArrayList<Beauty> BeautyList = new ArrayList<>();
                BeautyList = BeautyDB.getMyBeauty(user.getEmail());
                request.setAttribute("BeautyList", BeautyList);
                url="/Beautylist.jsp";
                }
            }
        else if (action.equalsIgnoreCase("viewBeauty")) {
            if (admin != null || user != null) {
                String tipsCode = (String) request.getParameter("tipsCode");
                Beauty Beauty = BeautyDB.getBeauty(tipsCode);
                request.setAttribute("Beauty", Beauty);
                url="/viewBeauty.jsp";
                }
            }
        else if (action.equalsIgnoreCase("PostedBeauty")) {
            if (admin != null) {
                ArrayList<Beauty> BeautyList = new ArrayList<>();
                BeautyList = BeautyDB.getBeautyByStatus("Pending for Approval");
                request.setAttribute("BeautyList", BeautyList);
                url="/Beautyapproval.jsp";
                }
            }
        else if (action.equalsIgnoreCase("approve")) {
            if (admin != null) {
                String tipsCode = (String) request.getParameter("tipsCode");
                System.out.println(tipsCode);
                BeautyDB.updateBeautyStatus(tipsCode, "Approved");
                url="/approved.jsp";
                }
            }
        else if (action.equalsIgnoreCase("disapprove")) {
            if (admin != null) {
                String tipsCode = (String) request.getAttribute("tipsCode");
                BeautyDB.updateBeautyStatus(tipsCode, "Approved");
                url="/disapproved.jsp";
                }
            }
        else {
                url = "/login.jsp";
            }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        }
        // forward request and response objects to specified URL
        

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
