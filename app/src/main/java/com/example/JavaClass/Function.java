package com.example.JavaClass;

public class Function {
    String nameText;
    int iconImg;

    public Function() {
    }

    public Function(String nameText) {
        this.nameText = nameText;
    }

    public int getIconImg() {
        return iconImg;
    }

    public void setIconImg(int iconImg) {
        this.iconImg = iconImg;
    }

    public Function(String nameText, int iconImg) {
        this.nameText = nameText;
        this.iconImg = iconImg;
    }

    public String getNameText() {
        return nameText;
    }

    public void setNameText(String nameText) {
        this.nameText = nameText;
    }

}
