package com.zhoudewei.learning.basic.generics;

import com.zhoudewei.learning.basic.dto.NbaStar;
import com.zhoudewei.learning.basic.dto.NbaTeam;

/**
 * @author： zhoudewei
 * @date： 2022/1/14 10:28 上午
 * @description： 泛型练习
 * @version： v1.0
 */
public class demo {

    public static <T> T getObject(T obj){
        return obj;
    }

    public static void main(String[] args){

        NbaTeam nbaTeam = new NbaTeam("Los Angeles","Lakers","Staples Center");
        NbaStar nbaStar = new NbaStar("Kobe Bryant","Shooting Guard");

        NbaTeam returnTeam = getObject(nbaTeam);
        NbaStar returnStar = getObject(nbaStar);
        System.out.println("球队:" + returnTeam.toString());
        System.out.println("球星:" + returnStar.toString());


    }
}
