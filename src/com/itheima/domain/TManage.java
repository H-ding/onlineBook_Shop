package com.itheima.domain;



/**
 * TManage entity. @author MyEclipse Persistence Tools
 */

public class TManage  implements java.io.Serializable {


    // Fields    

     private String musername;
     private String mpassword;


    // Constructors

    /** default constructor */
    public TManage() {
    }

	/** minimal constructor */
    public TManage(String musername) {
        this.musername = musername;
    }
    
    /** full constructor */
    public TManage(String musername, String mpassword) {
        this.musername = musername;
        this.mpassword = mpassword;
    }

   
    // Property accessors

    public String getMusername() {
        return this.musername;
    }
    
    public void setMusername(String musername) {
        this.musername = musername;
    }

    public String getMpassword() {
        return this.mpassword;
    }
    
    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }
   








}