package com.zhoudewei.learning.basic.dto;

/**
 * @author： zhoudewei
 * @date： 2022/1/14 10:30 上午
 * @description： nba球队
 * @version： v1.0
 */
public class NbaTeam {

    /**
     * 所属城市
     */
    private String city;

    /**
     * 队名
     */
    private String name;

    /**
     * 主场名称
     */
    private String home;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public NbaTeam(String city, String name, String home) {
        this.city = city;
        this.name = name;
        this.home = home;
    }

    @Override
    public String toString() {
        return "{" +
                "city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", home='" + home + '\'' +
                '}';
    }
}
