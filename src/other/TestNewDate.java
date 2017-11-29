package other;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TestNewDate {
	
	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		LocalDate firstDay2017 = LocalDate.of(2017, Month.JANUARY, 1);
		System.out.println(firstDay2017);
		
		LocalDate dateFromBase = LocalDate.ofEpochDay(365);
		System.out.println(dateFromBase);
		
		LocalDate dateFrom2017 = LocalDate.ofYearDay(2017, 100);
		System.out.println(dateFrom2017);
		
		
		LocalTime current = LocalTime.now();
		System.out.println(current);
		
		LocalTime specificTime = LocalTime.of(23, 34, 57);
		System.out.println(specificTime);
		
		
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println(currentTime);
		
		LocalDateTime specific = LocalDateTime.of(2017, 1, 20, 12, 34, 34);
		System.out.println(specific);
		
		
		System.out.println(today.getYear() + " " + today.isLeapYear());
		System.out.println(today.plusDays(24));
		System.out.println(today.minusWeeks(3));
		
		LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
		Period period = today.until(lastDayOfMonth);
		System.out.println(period.getDays());
		
		
		System.out.println(currentTime.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println(currentTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(LocalDate.now().plusMonths(1));
	}
}
