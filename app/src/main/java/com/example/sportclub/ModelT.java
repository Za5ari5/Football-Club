package com.example.sportclub;

public class ModelT {
    private String title;
    private String title2;
    private String title3;
    private int image;

    public ModelT(String title, String title2, String title3, int image) {
        this.title = title;
        this.title2 = title2;
        this.title3 = title3;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getTitle2() {
        return title2;
    }

    public String getTitle3() {
        return title3;
    }

    public int getImage() {
        return image;
    }
}
