package com.example.network.news;

public class News {
    private String name;
    private String imageView;
    private String description;

    public News(String name, String imageView, String description) {
        this.name = name;
        this.imageView = imageView;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
