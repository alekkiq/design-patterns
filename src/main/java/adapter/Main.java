package adapter;

public class Main {
    public static void main(String[] args) {
        CalendarToNewDateAdapter dateAdapter = new CalendarToNewDateAdapter(java.util.Calendar.getInstance());
        dateAdapter.setDate(4);
        dateAdapter.setMonth(4);
        //dateAdapter.setYear(2026);

        System.out.println("Current Date: " + dateAdapter.getFullDate());

        dateAdapter.advanceDays(10);
        System.out.println("Date after advancing 10 days: " + dateAdapter.getFullDate());
    }
}
