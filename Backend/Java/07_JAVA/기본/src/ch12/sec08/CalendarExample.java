package ch12.sec08;

import java.util.Calendar;

public class CalendarExample {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH)+1;
        int day=cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(year+"년 "+month+"월 "+day+"일 ");

        int week=cal.get(Calendar.DAY_OF_WEEK);
        String dow = switch (week) {
            case Calendar.SUNDAY -> "일";
            case Calendar.MONDAY -> "월";
            case Calendar.TUESDAY -> "화";
            case Calendar.WEDNESDAY -> "수";
            case Calendar.THURSDAY -> "목";
            case Calendar.FRIDAY -> "금";
            default -> "토";
        };
        int amPm=cal.get(Calendar.AM_PM);
        String strAmPm="";
        if (amPm==Calendar.AM) {
            strAmPm="오전";
        } else {
            strAmPm="오후";
        }
        System.out.println(dow+"요일 "+strAmPm);

        int hour=cal.get(Calendar.HOUR);
        int minute=cal.get(Calendar.MINUTE);
        int second=cal.get(Calendar.SECOND);
        System.out.println(hour+"시 "+minute+"분 "+second+"초");
    }
}
