package date;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Created by l1s on 14.05.17.
 */
public class DateTimer {
    public static void main(String[] args) {
        Period period = period(LocalDate.of(2018, Month.JANUARY, 1));
        LocalTime time = difTime(LocalTime.of(0, 0));

        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        int hours = time.getHour();
        int minutes = time.getMinute();
        int seconds = time.getSecond();

        StringBuilder sb = new StringBuilder();
        sb.append("До события осталось: лет: ")
                .append(years)
                .append(", месяцев: ")
                .append(months)
                .append(", дней: ")
                .append(days)
                .append(", часов: ")
                .append(hours)
                .append(", минут: ")
                .append(minutes)
                .append(", секунд: ")
                .append(seconds);

        System.out.println(sb);

        /*LocalDate somedate = LocalDate.of(1990, Month.JANUARY, 19);
        LocalDate today = LocalDate.now();

        long numberOfDays = somedate.until(today, ChronoUnit.DAYS);

        System.out.println("Прошло дней: " + numberOfDays);*/
    }

    public static Period period(LocalDate date) {
        LocalDate today = LocalDate.now();

        return Period.between(today, date);
    }

    public static LocalTime difTime(LocalTime time) {
        LocalTime currentTime = LocalTime.now();

        return time.minus(currentTime.getHour(), ChronoUnit.HOURS)
                .minus(currentTime.getMinute(), ChronoUnit.MINUTES)
                .minus(currentTime.getSecond(), ChronoUnit.SECONDS);
    }
}