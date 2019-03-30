package com.jk.model;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {

    private Integer productno;
    private  String productname;
    private double productprice;
    private Date grounddate;
    private  String imagepath;
    private  Integer attentionnumber;

    public Integer getProductno() {
        return productno;
    }

    public void setProductno(Integer productno) {
        this.productno = productno;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getProductprice() {
        return productprice;
    }

    public void setProductprice(double productprice) {
        this.productprice = productprice;
    }

    public Date getGrounddate() {
        return grounddate;
    }

    public void setGrounddate(Date grounddate) {
        this.grounddate = grounddate;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public Integer getAttentionnumber() {
        return attentionnumber;
    }

    public void setAttentionnumber(Integer attentionnumber) {
        this.attentionnumber = attentionnumber;
    }
}
