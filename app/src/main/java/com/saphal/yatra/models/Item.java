package com.saphal.yatra.models;

public class Item {
    int background;
    String packageTitle;

    public Item() {
    }

    public Item(int background, String packageTitle) {
        this.background = background;
        this.packageTitle = packageTitle;
    }

    public int getBackground() {
        return background;
    }

    public String getPackageTitle() {
        return packageTitle;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public void setPackageTitle(String packageTitle) {
        this.packageTitle = packageTitle;
    }
}