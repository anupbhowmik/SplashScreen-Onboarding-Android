package com.example.splashscreen;

public class Model {
    private final int image;
    private final String title;

    public Model(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
