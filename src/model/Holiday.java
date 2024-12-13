package model;
import enums.*;
public class Holiday
{
    private int holiday_id ;
    private int employee_id;
    private String start_date;
    private String end_date;
    private Type type ;
    private int solde =25;

public Holiday(int holiday_id,int employee_id,String start_date,String end_date,Type type  ){
    this.holiday_id=holiday_id;
    this.employee_id=employee_id;
    this.start_date = start_date;
    this.end_date=end_date;
    this.type=type;
}
public int getHoliday_id(){
    return holiday_id;
}
public int getEmployee_id(){
    return employee_id;
}
public String getStart_date(){
    return start_date;
}
public String getEnd_date(){
    return end_date;
}
}



