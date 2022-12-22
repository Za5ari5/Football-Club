package com.example.sportclub;

public class ModelS {
    private String title;
    private String title2;
    private int image;

    public ModelS(String title, String title2, int image) {
        this.title = title;
        this.title2 = title2;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getTitle2() {
        return title2;
    }

    public int getImage() {
        return image;
    }
}
