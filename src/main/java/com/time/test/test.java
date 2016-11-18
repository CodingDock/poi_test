package com.time.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;

/**
 * Created by 肖明明 on 2016/11/18.
 */
public class test {
    
    //获取指定月份的第几周周几
    
    
    //
    //
    //
    //
    //
    //
    //
    //
    //


    public static void main(String[] args) {
        //

//        LocalDate ld=LocalDate.parse("2016-11-11").with(TemporalAdjusters.
//                firstInMonth(DayOfWeek.MONDAY));
        LocalDate ld=LocalDate.parse("2016-11-11").with(TemporalAdjusters.dayOfWeekInMonth(1,DayOfWeek.MONDAY));
        System.out.println("1--"+ld);
        ld=ld.with(TemporalAdjusters.dayOfWeekInMonth(2,DayOfWeek.MONDAY));
        System.out.println("2--"+ld);
        ld=ld.with(TemporalAdjusters.dayOfWeekInMonth(3,DayOfWeek.MONDAY));
        System.out.println("3--"+ld);
        ld=ld.with(TemporalAdjusters.dayOfWeekInMonth(4,DayOfWeek.MONDAY));
        System.out.println("4--"+ld);
        ld=ld.with(TemporalAdjusters.dayOfWeekInMonth(5,DayOfWeek.MONDAY));
        System.out.println("5--"+ld);
        ld=ld.with(TemporalAdjusters.dayOfWeekInMonth(1,DayOfWeek.MONDAY));
        System.out.println("6--"+ld);
    }
    
    
}
