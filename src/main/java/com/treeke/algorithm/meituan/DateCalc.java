package com.treeke.algorithm.meituan;

public class DateCalc {

    public static void main(String[] args) {
        DateCalc dateCalc = new DateCalc();
        int i = dateCalc.dateCalc("2020-03-05");
        System.out.println(i);
    }

    private int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};

    //2020-03-05
    public int dateCalc(String date){
        int res = 0;
        String[] split = date.split("-");
        Integer year = Integer.valueOf(split[0]);
        Integer month = Integer.valueOf(split[1]);
        for (int i = 0; i < month-1; i++) {
            res = res + months[i];
        }
        if(month > 2 && year % 4 == 0){
            res++;
        }
        Integer days = Integer.valueOf(split[2]);
        return res + days;
    }
}
