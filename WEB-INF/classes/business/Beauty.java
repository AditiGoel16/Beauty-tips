/**
 *
 * @author Aditi
 * Date : 30th April, 2017
 * Beauty Bean
 */
package business;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Beauty implements Serializable {

    /**
     * @return the tipsCode
     */
    public String getTipsCode() {
        return tipsCode;
    }

    /**
     * @param tipsCode the tipsCode to set
     */
    public void setTipsCode(String tipsCode) {
        this.tipsCode = tipsCode;
    }

    /**
     * @return the tipstatus
     */
    public String getTipstatus() {
        return tipstatus;
    }

    /**
     * @param tipstatus the tipstatus to set
     */
    public void setTipstatus(String tipstatus) {
        this.tipstatus = tipstatus;
    }

    /**
     * @return the tipsCode
     */
    public String gettipsCode() {
        return getTipsCode();
    }

    /**
     * @param tipsCode the tipsCode to set
     */
    public void settipsCode(String tipsCode) {
        this.setTipsCode(tipsCode);
    }

    /**
     * @return the autherEmail
     */
    public String getAutherEmail() {
        return autherEmail;
    }

    /**
     * @param autherEmail the autherEmail to set
     */
    public void setAutherEmail(String autherEmail) {
        this.autherEmail = autherEmail;
    }

    /**
     * @return the tipstatus
     */
    public String gettipstatus() {
        return getTipstatus();
    }

    /**
     * @param tipstatus the tipstatus to set
     */
    public void settipstatus(String tipstatus) {
        this.setTipstatus(tipstatus);
    }

    /**
     * @return the auther
     */
    public String getAuther() {
        return auther;
    }

    /**
     * @param auther the auther to set
     */
    public void setAuther(String auther) {
        this.auther = auther;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the dateCreated
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * @param dateCreated the dateCreated to set
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.description = Description;
    }

    /**
     * @return the urlToImange
     */
    public String getUrlToImage() {
        return urlToImage;
    }

    /**
     * @param urlToImange the urlToImange to set
     */
    public void setUrlToImage(String urlToImange) {
        this.urlToImage = urlToImange;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    private String auther;
    private String tipsCode;
    private String title;
    private String autherEmail;
    private Date dateCreated;
    private String tipstatus;
    private String description;
    private String urlToImage;
    private String url;
    
    public Beauty() {
        auther = "";
        title = "";
        //dateCreated = ;
        description = "";
        urlToImage = "";
        url = "";
    }
    
    
}
