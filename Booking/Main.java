package Booking;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Main {

    public Main(){}

    public static void mainRun(){
        main(null);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // ==================================== Main Menu =======================================================

        do {

            System.out.println();
            System.out.println();
            System.out.println(" ----- Welcome to Mackky Hotel 5 Star ----- ");
            System.out.println();

            System.out.println(" == Select == "); // เลือกหัวข้อ
            System.out.println(" 1. Information Hotel Booking.Room "); // ข้อมูลของโรงแรม
            System.out.println(" 2. Booking"); // การจอง
            System.out.println("\u001B[31m"); 
            System.out.println(" 3. Exit The program"); // ออกจากระบบ
            System.out.println("\u001B[0m");
            System.out.print(" : ");

            String select = scan.nextLine().trim(); // ใช้ select ในการเลือกหัวข้อ (เป็น String)


            // --------------------------- Information Of Hotel ----------------------------------------

            if (select.equals("1")) {
                System.out.println();
                System.out.println();
                System.out.println(" == Information Hotel Booking.Room == ");
                System.out.println();
                System.out.println(" - Hotel Booking.Room ");
                System.out.println("     1. Basic Booking.Room (1-3)         3,500 Baht/day");
                System.out.println("     2. Deluxe Booking.Room (4-6)        5,500 Baht/day");
                System.out.println("     3. Super Deluxe Booking.Room (7-8)  8,000 Baht/day");
                System.out.println();
                System.out.println(" - Meeting Booking.Room ");
                System.out.println("     1. The Universe (250)      50,000 Baht/day    25,000 Baht/half day ");
                System.out.println("     2. The World (100)         30,000 Baht/day    15,000 Baht/half day ");
                System.out.println("     3. The Mini World (50)     20,000 Baht/day    10,000 Baht/half day ");
                System.out.println("     4. The Town (50)           20,000 Baht/day    10,000 Baht/half day ");

                System.out.println(" == Privileges if staying this Hotel == ");
                System.out.println(" - Steam Booking.Room");
                System.out.println(" - Massage Booking.Room");
                System.out.println(" - Swimming Pool");
                System.out.println(" - Jacuzzi");

                // ปริ้นครบแล้ว จะกลับไปหน้า Welcome
            }


            // -------------------- Booking of Hotel ---------------------------------------------------
            // การจองห้องต่างๆ

            else if (select.equals("2")) {
                do {
                    System.out.println();
                    System.out.println();
                    System.out.println(" ----- Booking -----");
                    System.out.println(" 1. Hotel Booking.Room ");
                    System.out.println(" 2. Meeting Booking.Room ");
                    System.out.println(" 3. Back to Menu");
                    System.out.println();
                    System.out.println(" == Select == ");
                    System.out.print(" : ");

                    String strSelectBooking = scan.nextLine().trim();
                    int selectBooking = 0;

                    if(Pattern.matches("\\d+$",strSelectBooking)){
                        selectBooking = Integer.parseInt(strSelectBooking); // จะใช้ตัวแปรเป็น int มีชื่อว่า select booking
                    }
                    else{
                        System.out.println("\n !!!Please enter only integer!!! \n");
                        break;
                    }

                    Booking booking = new Booking();

                    // --------------- Booking Hotel Booking.Room ----------------------

                    if (selectBooking == 1) {
                        System.out.println();
                        System.out.println(" ===== Booking Hotel Booking.Room ===== ");
                        System.out.println();

                        booking.startBookingHotel(selectBooking); //เข้าหน้าการจอง
                    }


                    // --------------- Booking Meeting Booking.Room --------------------

                    else if (selectBooking == 2) {
                        System.out.println();
                        System.out.println(" ===== Booking Meeting Booking.Room ===== ");
                        System.out.println();

                        booking.startBooking(selectBooking); //เข้าหน้าการจอง
                    }

                    else if (selectBooking == 3 ) {
                        break;
                    }


                    else {
                        System.out.println("Error!!! please Try Again "); // ถ้าหรอกผิดจะให้หรอกใหม่
                    }

                }while (true);} // Loop ของ Booking

            else if(select.equals("3")){
                System.exit(0);
            }





/* 

            // ================================ ADMIN ====================================================

            else if (select.equals("Admin123")) { // ------------================== รหัส Admin 123 ================-------------
                do {
                    System.out.println();
                    System.out.println(" -----===== ADMIN =====----- ");
                    System.out.println(" 1. Show All Booking.Room Data ");
                    System.out.println(" 2. Change Data");
                    System.out.println(" 3. Back to Menu");

                    System.out.println();
                    System.out.println(" ----- select ----- ");
                    System.out.print(" : ");

                    int adminSelect = scan.nextInt();

                    if (adminSelect == 1 ){ // แสดงข้อมูลทั้งหมด

                    }

                    else if(adminSelect == 2 ){ // แก้ไขข้อมูล

                    }

                    else if (adminSelect == 3) { // กลับไปหน้าเมนู
                        break;
                    }

                    else {
                        System.out.println("Error!!! Please Try Again"); // ต้องกรอกข้อมูลหน้านี้ใหม้
                    }
                }while (true);

            } // Loop ของ Admin*/


        }while (true); // Loop ของ Main Menu

    }
}
