package date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class DayCounter {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2017, Month.JANUARY, 1);
        LocalDate endDate = LocalDate.of(2017, Month.DECEMBER, 31);

        //System.out.println(countWeekend(startDate, endDate));
        System.out.println(countFriday13(startDate, endDate));
    }

    static int countWeekend(LocalDate start, LocalDate end) {
        int weekDays = 0;

        if (start.isEqual(end))

            return weekDays;

        while (start.isBefore(end)) {
            if(DayOfWeek.SATURDAY.equals(start.getDayOfWeek())
                    || DayOfWeek.SUNDAY.equals(start.getDayOfWeek())) {
                weekDays++;
            }

            start = start.plusDays(1);
        }

        return weekDays;
    }

    static int countFriday13(LocalDate start, LocalDate end) {
        int fridays13 = 0;

        if (start.isEqual(end))

            return fridays13;

        while (start.isBefore(end)) {
            if(DayOfWeek.FRIDAY.equals(start.getDayOfWeek())
                    && start.getDayOfMonth() == 13) {
                fridays13++;
                System.out.println(start);
            }

            start = start.plusDays(1);
        }

        return fridays13;
    }
}