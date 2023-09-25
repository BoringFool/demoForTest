package io;

import java.io.Serializable;
import java.util.ArrayList;

public class FileDatas implements Serializable {
    private ArrayList<FileData> files;

    public ArrayList<FileData> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<FileData> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "FileDatas{" +
                "files=" + files +
                '}';
    }
}
