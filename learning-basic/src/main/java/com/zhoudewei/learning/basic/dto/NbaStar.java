package com.zhoudewei.learning.basic.dto;

/**
 * @author： zhoudewei
 * @date： 2022/1/14 10:34 上午
 * @description： nba球星
 * @version： v1.0
 */
public class NbaStar {

    private String name;

    private String position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public NbaStar(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
