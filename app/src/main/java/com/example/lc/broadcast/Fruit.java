package com.example.lc.broadcast;

public class Fruit {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Fruit(String name, int imageId) {
        Name = name;
        this.imageId = imageId;
    }

    private String Name;
    private int imageId;
}
