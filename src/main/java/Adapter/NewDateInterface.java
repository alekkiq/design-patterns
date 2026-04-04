package Adapter;

public interface NewDateInterface {
    void setDate(int day);
    void setMonth(int month);
    void setYear(int year);
    int getDate();
    int getMonth();
    int getYear();
    void advanceDays(int days);
}
