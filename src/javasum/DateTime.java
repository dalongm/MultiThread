package javasum;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
    public static void main(String[] args) {
        System.out.println("年月日 时分秒");
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH)); // 0- 11
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY)); // 0-23
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));
        System.out.println();

        System.out.println("JDK8 年月日 时分秒");
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getMonthValue());
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());

        System.out.println("从19700101 00:00:00到现在的毫秒数");
        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(Clock.systemDefaultZone().millis());
        System.out.println();


        System.out.println("该月的最后一天");
        Calendar time = Calendar.getInstance();
        System.out.println(time.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println();

        SimpleDateFormat oldsdf = new SimpleDateFormat("yyyy/MM/dd");
        Date d = new Date();
        System.out.println(oldsdf.format(d));

        DateTimeFormatter newsdf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = LocalDate.now();
        System.out.println(date.format(newsdf));
    }
}
