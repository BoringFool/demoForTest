package io;

import java.io.Serializable;

public class FileData implements Serializable {

    private int num;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
