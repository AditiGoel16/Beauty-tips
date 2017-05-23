package business;

import java.io.Serializable;

/**
 *
 * @author Aditi
 */
public class User implements Serializable {

    /**
     * @return the numOfPostedTips
     */
    public int getNumOfPostedTips() {
        return numOfPostedTips;
    }

    /**
     * @param numOfPostedTips the numOfPostedTips to set
     */
    public void setNumOfPostedTips(int numOfPostedTips) {
        this.numOfPostedTips = numOfPostedTips;
    }

    public User(String name, String email, String type, int numOfPosts, int numOfPostedTips) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.numOfPosts = numOfPosts;
        this.numOfPostedTips = numOfPostedTips;
        //this.password = password;//To change body of generated methods, choose Tools | Templates.
    }

    

   
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the numOfPosts
     */
    public int getNumOfPosts() {
        return numOfPosts;
    }

    /**
     * @param numOfPosts the numOfPosts to set
     */
    public void setNumOfPosts(int numOfPosts) {
        this.numOfPosts = numOfPosts;
    }

    

    private String name;
    private String email;
    private String type;
    private String password;
    private int numOfPosts;
    private int numOfPostedTips;

    public User() {
        name = "";
        email = "";
        type = "";
        password = "";
        numOfPosts = 0;
        numOfPostedTips = 0;
    }

    public User(String name, String email, String type,String password, int numOfPosts, int NumPostedtips) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.numOfPosts = numOfPosts;
        this.numOfPostedTips = NumPostedtips;
        this.password = password;
    }

    
}
