package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * @author nguyen
 * @create_date 21/07/2022
 */
public class DateUtil {
  private static final Long LONG_TIME_A_DAY = 86400000L;
  public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  public static Long getOnlyDateFromTimeStamp(Long timeStamp) throws ParseException {
//    Long creationTimeStamp = Long.valueOf(timeStamp);
    Date dateCreated = new Date(timeStamp);
    Date dateFormat = new SimpleDateFormat("yyyy-MM-dd")
        .parse(sdf.format(dateCreated));
    return dateFormat.getTime();
  }

  public static Long remainderDay(Long timeStamp) throws ParseException {
    return getOnlyDateFromTimeStamp(timeStamp + LONG_TIME_A_DAY) - timeStamp;
  }

  public static String convertToYMD(String dateText) throws ParseException {
    SimpleDateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");

    String date = df2.format(df1.parse(dateText));
    return date;
  }


  public static Date atStartOfDay(Date date) {
    LocalDateTime localDateTime = dateToLocalDateTime(date);
    LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
    return localDateTimeToDate(startOfDay);
  }

  public static Date atEndOfDay(Date date) {
    LocalDateTime localDateTime = dateToLocalDateTime(date);
    LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
    return localDateTimeToDate(endOfDay);
  }

  private static LocalDateTime dateToLocalDateTime(Date date) {
    return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
  }

  private static Date localDateTimeToDate(LocalDateTime localDateTime) {
    return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
  }

  public static Date getFirstDayOfMonth() {
    Calendar c = Calendar.getInstance();   // this takes current date
    c.set(Calendar.DAY_OF_MONTH, 1);
    return atStartOfDay(c.getTime());
  }

  public static long getDateDiffFollowingDate(String start_date, String end_date)
      throws ParseException {
    Date d1 = sdf.parse(start_date);
    Date d2 = sdf.parse(end_date);
    long difference_In_Time = d2.getTime() - d1.getTime();
    return (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
  }

  public static String addDate(String source, int add) throws ParseException {
    long givenTimeLong = sdf.parse(source).getTime();
    long added = add*LONG_TIME_A_DAY;
    long resultTimeLong = givenTimeLong + added;
    return sdf.format(new Date(resultTimeLong));
  }
}
