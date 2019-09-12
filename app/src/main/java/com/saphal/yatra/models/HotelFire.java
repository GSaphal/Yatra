package com.saphal.yatra.models;

public class HotelFire {
    String hname,haddress,hphone,hwebsite,image;



    public HotelFire(String hname, String haddress, String hphone, String hwebsite, String image) {
        this.hname = hname;
        this.haddress = haddress;
        this.hphone = hphone;
        this.hwebsite = hwebsite;
        this.image=image;
    }

    public HotelFire() {
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    public String getHphone() {
        return hphone;
    }

    public void setHphone(String hphone) {
        this.hphone = hphone;
    }

    public String getHwebsite() {
        return hwebsite;
    }

    public void setHwebsite(String hwebsite) {
        this.hwebsite = hwebsite;
    }
}
