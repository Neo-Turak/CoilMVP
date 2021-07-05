package com.easyhome.jrconsumer.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringUtil {

    public static List<String> getLabels1() {
        List<String> ls = new ArrayList<String>();
        ls.add("全部");
        ls.add("未发起");
        ls.add("已发起");
        ls.add("已确认");
        return ls;
    }

    public static List<String> getLabels2() {
        List<String> ls = new ArrayList<String>();
        ls.add("全部");
        ls.add("未发起");
        ls.add("已发起");
        ls.add("已指派");
        ls.add("已确认");
        return ls;
    }

    public static List<String> getLabels3() {
        List<String> ls = new ArrayList<String>();
        ls.add("全部");
        ls.add("未开工");
        ls.add("已开工");
        ls.add("隐藏");
        ls.add("中期");
        ls.add("基础");
        ls.add("竣工");
        ls.add("结算");
        return ls;
    }

    /**
     * 产生4位随机数(0000-9999)
     * @return 4位随机数
     */
    public static String getFourRandom(){
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if(randLength<4){
            for(int i=1; i<=4-randLength; i++){
                fourRandom = "0" + fourRandom ;
            }
        }
        return fourRandom;
    }

}
