package com.easyhome.jrconsumer.util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @创建人 lin
 * @创建时间 2019/11/7
 * @描述
 */
public class DateUtil {
    public static List<String> getFirstAndLastDayOfMonth(String date_str) throws Exception {

        Log.e("dafdafda", date_str);
        //     String date_str = "2019-02-15";
        List<String> dates = new ArrayList<String>();
        Calendar cale = Calendar.getInstance();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        cale.setTime(formatter.parse(date_str));


        cale.add(Calendar.MONTH, 0);

        cale.set(Calendar.DAY_OF_MONTH, 1);

        String firstDayOfMonth = formatter.format(cale.getTime()); // 当月第一天 2019-02-01
        dates.add(firstDayOfMonth);

        cale.add(Calendar.MONTH, 1);

        cale.set(Calendar.DAY_OF_MONTH, 0);

        String lastDayOfMonth = formatter.format(cale.getTime()); // 当月最后一天 2019-02-28
        dates.add(lastDayOfMonth);

        return dates;
    }

    public static boolean compare(String time1, String time2) throws ParseException {
        //如果想比较日期则写成"yyyy-MM-dd"就可以了
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //将字符串形式的时间转化为Date类型的时间
        Date a = sdf.parse(time1);
        Date b = sdf.parse(time2);
        //Date类的一个方法，如果a早于b返回true，否则返回false
        if (a.before(b)) {
            return true;
        } else {
            return false;
        }
		/*
		 * 如果你不喜欢用上面这个太流氓的方法，也可以根据将Date转换成毫秒
		if(a.getTime()-b.getTime()<0)
			return true;
		else
			return false;
		*/
    }

    //就算两个时间的差距
    public static String getTimeDifference(String s1, String s2) {
        long day = 0L;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date beginDate = format.parse(s1);
            Date endDate = format.parse(s2);
            day = (beginDate.getTime() - endDate.getTime()) / (24 * 60 * 60 * 1000);
            System.out.println("相隔的天数=" + day);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return day + "";

    }

    public static String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
//获取当前时间
        Date date = new Date(System.currentTimeMillis());
        // time1.setText("Date获取当前日期时间" + simpleDateFormat.format(date));

        return simpleDateFormat.format(date);
    }

    /**
     * @param day 日期
     * @param num 前一天-1 后一天 1
     */
    public static String getDay(String day, int num) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day1 = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day1 + num);

        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
       // System.out.println(dayAfter);
    }

}


