package Booking;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;
//import com.sun.tools.javac.Main;

public class HotelRoom extends Room implements InfoRoom , SelectBooking{
    private int numRoom;
    private int numCustomers;
    private int numType;
    private static String CheckInDate;
    private static int[] selectHRoom = new int[31];
    private static int countRoomH = 0;
    //private static String[] availableOfHotelR = new String[3];

    public int getCountRoomH(){ // ส่งค่า countRoomH ออก
        return countRoomH;
    }

    public void setSelectHRoom(int numType , int countOfR){ // set ค่าของ array โดยที่ แทนค่าด้วย numType ตำแหน่ง countOfR
        this.selectHRoom[countOfR] = numType;
    }

    public int[] getSelectHRoom(){ // ส่ง selectHRoom ออก
        return selectHRoom;
    }

    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }
    public void setNumCustomers(int numCustomers) {
        this.numCustomers = numCustomers;
    }
    public void setNumType(int numType) {
        this.numType = numType;
    }
    public int getNumRoom() {
        return numRoom;
    }
    public int getNumCustomers() {
        return numCustomers;
    }
    public int getNumType() {
        return numType;
    }
    public HotelRoom(){}
    public HotelRoom(String type, int capacity, int price, int available,String CheckInDate) {
        super(type, capacity, price, available);
        this.CheckInDate = CheckInDate;
    }
    protected static List<HotelRoom> hotelRooms = new ArrayList<>();

    static {
        hotelRooms.add(new HotelRoom("1. Basic Room", 3, 3500, 20 , CheckInDate));
        hotelRooms.add(new HotelRoom("2. Deluxe Room", 6, 5500, 15 , CheckInDate));
        hotelRooms.add(new HotelRoom("3. Super Deluxe Room", 8, 8000, 5 , CheckInDate));
    }


    protected static List<HotelRoom> getHotelRooms() {
        return hotelRooms;
    }

    private static void suggestRoom(List<? extends Room> rooms, int numCustomers) {

        int[] availableOfHotelR = new int[3];

        availableOfHotelR[0] = 20;
        availableOfHotelR[1] = 15;
        availableOfHotelR[2] = 5;

        int nubRoom = 1;
        AvailableHotel avHotel = new AvailableHotel();
        List<String> allOfHotel= new ArrayList<>(avHotel.getAllOfHotel());
        Booking bok = new Booking();
        String cRoom = bok.getCheckInDate();


        int countt = 0;
         for (String check : allOfHotel){
        
                String checkRoom = allOfHotel.get(countt); //รับค่าข้อมูลตัวที่กำลัง check
                String[] salat = checkRoom.split("/"); // ตัวแบ่ง part ของข้อมูล
                int activeRoom = Integer.parseInt(salat[3]); // check จำนวนห้องที่ว่าง

            if (check.startsWith(CheckInDate) && check.endsWith("1")){
                    availableOfHotelR[0] = activeRoom;
            }
            else if (check.startsWith(CheckInDate) && check.endsWith("2")){
                    availableOfHotelR[1] = activeRoom;
            }
            else if (check.startsWith(CheckInDate) && check.endsWith("3")){
                    availableOfHotelR[2] = activeRoom;
            }

            else if(!check.startsWith(CheckInDate) && check.endsWith("1")){
                availableOfHotelR[0] = 20;
            }
            else if(!check.startsWith(CheckInDate) && check.endsWith("2")){
                availableOfHotelR[1] = 15;
            }
            else if(!check.startsWith(CheckInDate) && check.endsWith("3")){
                availableOfHotelR[2] = 5;
            }
            countt++;
        }

        //แสดงห้องที่เหมาะกับำนวนลูกค้าที่เข้าพัก
        int count = 0;
        System.out.print("\u001B[32m");
        for (Room room : rooms) { // 3 ห้อง 

            if (room.getCapacity() >= numCustomers && availableOfHotelR[count] != 0 && count == 0) { // ห้อง แรก
                numCustomers++;
                System.out.format("%-2s %-30s%n", "",room.getType());
            }
            else if (room.getCapacity() >= numCustomers && availableOfHotelR[count] != 0 && count == 1) { // ห้อง 2
                numCustomers++;
                System.out.format("%-2s %-30s%n", "",room.getType());
            }
            else if (room.getCapacity() >= numCustomers && availableOfHotelR[count] != 0 && count == 2) { // ห้อง 3
                numCustomers++;
                System.out.format("%-2s %-30s%n", "",room.getType());
            }
            count++;
        }
        System.out.print("\u001B[31m");
        System.out.println("   4. Exit This Program...  ");
        //System.out.println("   4. Exit the booking...  ");
        System.out.print("\u001B[0m");
    }

    public static int[] infoRoomCheck(int[] availableOfHotelR) {

        availableOfHotelR[0] = 20;
        availableOfHotelR[1] = 15;
        availableOfHotelR[2] = 5;

        int nubRoom = 1;
        AvailableHotel avHotel = new AvailableHotel();
        List<String> allOfHotel= new ArrayList<>(avHotel.getAllOfHotel());
        Booking bok = new Booking();

        boolean found1 = false;
        boolean found2 = false;
        boolean found3 = false;

        int countt = 0;
         for (String check : allOfHotel){
        
                String checkRoom = allOfHotel.get(countt); //รับค่าข้อมูลตัวที่กำลัง check
                String[] salat = checkRoom.split("/"); // ตัวแบ่ง part ของข้อมูล
                int activeRoom = Integer.parseInt(salat[3]); // check จำนวนห้องที่ว่าง

            if (check.startsWith(CheckInDate) && check.endsWith("1")){

                    availableOfHotelR[0] = activeRoom;

                    
            }
            else if (check.startsWith(CheckInDate) && check.endsWith("2")){
                    availableOfHotelR[1] = activeRoom;

            }
            else if (check.startsWith(CheckInDate) && check.endsWith("3")){
                    availableOfHotelR[2] = activeRoom;


            }
            countt++;
        }
        return availableOfHotelR;
    }


    @Override
    public void infoRoom() {

        int[] availableOfHotelR = new int[3];

        availableOfHotelR[0] = 20;
        availableOfHotelR[1] = 15;
        availableOfHotelR[2] = 5;

        int nubRoom = 1;
        AvailableHotel avHotel = new AvailableHotel();
        List<String> allOfHotel = new ArrayList<>(avHotel.getAllOfHotel());
        Booking bok = new Booking();
/* 
        boolean found1 = false;
        boolean found2 = false;
        boolean found3 = false;
*/
        int countt = 0;
         for (String check : allOfHotel){
        
                String checkRoom = allOfHotel.get(countt); //รับค่าข้อมูลตัวที่กำลัง check
                String[] salat = checkRoom.split("/"); // ตัวแบ่ง part ของข้อมูล
                int activeRoom = Integer.parseInt(salat[3]); // check จำนวนห้องที่ว่าง

            if (check.startsWith(CheckInDate) && check.endsWith("1")){
                    availableOfHotelR[0] = activeRoom;
            }
            else if (check.startsWith(CheckInDate) && check.endsWith("2")){
                    availableOfHotelR[1] = activeRoom;

            }
            else if (check.startsWith(CheckInDate) && check.endsWith("3")){
                    availableOfHotelR[2] = activeRoom;


            }
            countt++;
        }



        int count = 0;
        List<HotelRoom> rooms = HotelRoom.getHotelRooms();
        System.out.println("\u001B[33m-----------------------------------------------------------------------------");
        System.out.format("%-30s %-15s %-15s %-10s%n", "Room Type", "Capacity", "Price (Baht)", "Room available");
        System.out.println("-----------------------------------------------------------------------------");
        for (HotelRoom hotelRoom : rooms) {
            //แสดง detail ต่างๆ ของของให้ user ได้เลือก
            //System.out.format("%-30s %-15d %-15d %-10s%n", hotelRoom.getType(), hotelRoom.getCapacity(), hotelRoom.getPrice(), availableOfHotelR[count]);
                if(nubRoom == 1){
                    System.out.format("%-30s %-15d %-15d %-10s%n", hotelRoom.getType(), hotelRoom.getCapacity(), hotelRoom.getPrice(), availableOfHotelR[count]);
                }
                else if(nubRoom == 2){
                    System.out.format("%-30s %-15d %-15d %-10s%n", hotelRoom.getType(), hotelRoom.getCapacity(), hotelRoom.getPrice(), availableOfHotelR[count]);
                }
                else if(nubRoom == 3){
                    System.out.format("%-30s %-15d %-15d %-10s%n", hotelRoom.getType(), hotelRoom.getCapacity(), hotelRoom.getPrice(), availableOfHotelR[count]);
                }
            nubRoom++;
            count++;
        }
        System.out.println("-----------------------------------------------------------------------------\u001B[0m");
    }

    @Override
    public void selectBooking() {
        int countOfR = 0;
        do{
            //input number of room in String ✓✓
            //ถาม user ว่าจะจองกี่ห้อง
            System.out.print("Enter number of room(s) : ");
            String numRoomSTR = in.nextLine().trim();
            int number;
            do {
                if (Pattern.matches("^\\d+$", numRoomSTR)) {
                    number = Integer.parseInt(numRoomSTR);
                    if (number > 40) {
                        System.out.println("Number of room(s) cannot exceed 40. Please enter again.");
                        System.out.print("Enter number of room(s): ");
                        numRoomSTR = in.nextLine().trim();
                    }
                    else if(number <= 0){
                        System.out.println("Number of room(s) cannot exceed lower than 1. Please enter again.");
                        System.out.print("Enter number of room(s): ");
                        numRoomSTR = in.nextLine().trim();
                    }
                    else{
                        setNumRoom(numRoom);
                         Bill storeBill = new Bill("for create array",getNumRoom());
                        //ส่งค่าจำนวนห้องที่จองไป constructor ในคลาส Bill เพื่อสร้าง array ไว้เก็บข้อมูล 
                        number = Integer.parseInt(numRoomSTR);
                        numRoomSTR= String.valueOf(number);
                        break;
                    }
                }
                else{
                        System.out.println("\n !!!Please enter only integer!!! \n");
                        System.out.print("Enter number of room(s) : ");
                        numRoomSTR = in.nextLine().trim();
                }

            } while (!(Pattern.matches("^\\d+$", numRoomSTR) && Integer.parseInt(numRoomSTR) <= 40  && Integer.parseInt(numRoomSTR) > 0));

            number = Integer.parseInt(numRoomSTR);
            numRoomSTR= String.valueOf(number);

             if (Pattern.matches("\\d+$",numRoomSTR)){
                numRoom = Integer.parseInt(numRoomSTR);
                setNumRoom(numRoom);

                Bill storeBill = new Bill("for create array",getNumRoom());
                //ส่งค่าจำนวนห้องที่จองไป constructor ในคลาส Bill เพื่อสร้าง array ไว้เก็บข้อมูล

                if (getNumRoom() > 40) {
                    //ถ้า user กรอกจำนวนห้องมามากกว่า 40 ระบบะเซตให้จำนวนห้องที่ลูกค้าจะจองเป็น 40 ทันที่
                    setNumRoom(40);
                }

                break;
            }

            else{
                System.out.println("\n !!!Please enter only integer!!! \n");
            }

        }while (true);

        //loop ถาม user ตามจำนวนห้องที่จองว่าแต่ละห้องมีผู้พักกี่คน และ จพเลือก type ไหน
        for (int i = 1; i <= getNumRoom(); i++) {

            if (i <= 0) {
                i = 1;
                System.out.println("\n!!! Please enter the information again !!!\n");
            }

            do{
                // enter amount of customers in String ✓✓
                // user ระบุคนที่มาพัก/ห้อง
                System.out.print("Enter number of customers/room ( room " + i + " ) : ");
                String numCustomerSTR = in.nextLine().trim();

                if(Pattern.matches("^\\d+$", numCustomerSTR)){
                    numCustomers = Integer.parseInt(numCustomerSTR);
                    if(numCustomers > 8){
                        System.out.println("\n!!!There is no room of the right size for " + numCustomers + " customers.!!!\n");
                    }
                    else {
                        if (i <= 0) {
                            i = 1;
                        }
                        if (numCustomers <= 8) {
                            setNumCustomers(numCustomers);
                            break;
                        }
                    }
                }
                else{
                    System.out.println("\n!!!Please enter only integer!!!\n");
                }
            }while (true);

            System.out.println("-----------------------------------------------------------------------------");

            do{
                //เลือก type ของห้อง ตามที่ระบบแนะนำมาโดยอ้างอิงจากจำนวนผู้เข้าพัก
                String numTypeStr;
                int[] availableOfHotelR = new int[3];
                availableOfHotelR = infoRoomCheck(availableOfHotelR);

                while(true){
                    System.out.println("You can choose type of room :");// เลือกรูปแบบของห้อง
                    suggestRoom(HotelRoom.getHotelRooms(), numCustomers);
                    System.out.print("Enter the number : ");
                    numTypeStr = in.nextLine().trim();

                    if(numTypeStr.equals("1") && availableOfHotelR[0] == 0){
                        System.out.println("\u001B[31m");
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.println(" Sorry Room Now is Full Please Try Again...");
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.println("\u001B[0m");
                    }

                    else if(numTypeStr.equals("2") && availableOfHotelR[1] == 0){
                        System.out.println("\u001B[31m");
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.println(" Sorry Room Now is Full Please Try Again...");
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.println("\u001B[0m");
                    }

                    else if(numTypeStr.equals("3") && availableOfHotelR[2] == 0){
                        System.out.println("\u001B[31m");
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.println(" Sorry Room Now is Full Please Try Again...");
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.println("\u001B[0m");
                    }

                    if(numTypeStr.equals("1") && availableOfHotelR[0] > 0){
                        availableOfHotelR[0]--;
                        break;
                    }

                    if(numTypeStr.equals("2") && availableOfHotelR[1] > 0){
                        availableOfHotelR[1]--;
                        break;
                    }

                    if(numTypeStr.equals("3") && availableOfHotelR[2] > 0){
                        availableOfHotelR[2]--;
                        break;
                    }
                    if(numTypeStr.equals("4")){
                        break;
                    }
                    else{
                        System.out.println("Please select only the options available here !!!");
                    }
                    
                }

                 
                if (!numTypeStr.equals("1") && !numTypeStr.equals("2") && !numTypeStr.equals("3") && !numTypeStr.equals("4")){
                    System.out.println("\n!!! Please select only the options available here !!!\n");
                }
                else if ((numCustomers >= 4 && numCustomers < 9) && numTypeStr.equals("1")) {
                    System.out.println("\n!!! Sorry, Room type 1 is available for 1-3 customers.\n");
                }
                else if ((numCustomers >= 7 && numCustomers <= 8) && numTypeStr.equals("2")) {
                    System.out.println("\n!!! Sorry, Room type 2 is available for 4-6 customers.\n");
                }
                

                else{
                    numType = Integer.parseInt(numTypeStr);
                    if(numType == 4){
                        Main m = new Main();
                        m.mainRun();
                        System.exit(0);
                        break;
                    }
                  
                    setNumType(numType);
                    setSelectHRoom(numType , countOfR);
                    countRoomH++;
                    countOfR++;
                    Bill hotelBill = new Bill(hotelRooms.get(getNumType()-1).getPrice(),hotelRooms.get(getNumType()-1).getType(),numType);
                    /*
                        ส่งค่าที่ user เลือก ไป constructor ของคลาส Bill
                        โดย hotelRooms.get(getNumType()-1).getPrice() คือ ราคาของห้องที่ user จองไว้
                        hotelRooms.get(getNumType()-1).getType() ตือ type ของห้องที่ user จอง
                     */
                    break;
                }
            }while(true);

            System.out.println("-----------------------------------------------------------------------------");

        }
    }
}