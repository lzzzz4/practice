package cn.dubidubi.model;

import java.io.Serializable;
import java.util.Date;

public class biliCos implements Serializable {

    private String name;
    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}