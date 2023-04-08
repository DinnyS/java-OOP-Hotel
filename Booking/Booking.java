package Booking;
import java.util.*;
import java.time.LocalDate;

public class Booking {
    private String year;
    private String month;
    private String day;
    private String hours;

    private String name;

    private String phone;


    Scanner in = new Scanner(System.in);

    public void checkIn(){
        LocalDate currentDate = LocalDate.now();
        boolean check = false;
        String date;

        while (!check) {
            System.out.print("Enter a date (dd/mm/yyyy) : ");
            date = in.next();
            String[] parts = date.split("/");

            if (parts.length == 3) {
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                if (year >= currentDate.getYear() && month == currentDate.getMonthValue() && day >= currentDate.getDayOfMonth()) {
                    check = true;
                } else {
                    System.out.println("Invalid date!");
                }

            } else {
                System.out.println("Invalid date format!");
            }
        }
    }

    public void checkOut(int selectBooking){

        if (selectBooking == 1){
            System.out.println("---------- Check out ----------");
            System.out.print("How long will you be staying ? : ");
            day += in.nextLine();
        }

        else if (selectBooking == 2) {
            System.out.println("---------- Check out ----------");
            System.out.println("How many hours will you be booking ?");
            hours = in.nextLine();
        }

    }

    public void name(){
        System.out.print("name : ");
        name = in.nextLine();
    }

    public void phone(){

        System.out.print("Phone number : ");
        phone = in.nextLine();
        String phoneLimit = "\\d{10}";
        boolean check = true;
        while (check){
            if (!phone.matches(phoneLimit)){
                System.out.println("* Invalid data!! Please try again *");
                System.out.print("Phone number : ");
                phone = in.nextLine();
                phoneLimit = "\\d{10}";
            }else {
                check = false;
            }
        }

    }






}
