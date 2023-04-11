package Booking;
import java.util.*;

public class MeetingRoom extends Room implements InfoRoom , SelectBooking {
    private int numRoom;
    private int time;

    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getNumRoom() {
        return numRoom;
    }

    public int getTime() {
        return time;
    }

    protected MeetingRoom(String type, int price, int available) {
        super(type, price, available);
    }

    private static List<MeetingRoom> meetingRooms = new ArrayList<>();

    static {
        meetingRooms.add(new MeetingRoom("1. The Universe (250 people)", 50000, 1));
        meetingRooms.add(new MeetingRoom("2. The World (100 people)",30000,1));
        meetingRooms.add(new MeetingRoom("3. The Mini World (50 people)", 20000,1));
        meetingRooms.add(new MeetingRoom("4. The Town (50 people)",20000,1));
    }

    protected static List<MeetingRoom> getMeetingRooms(){
        return meetingRooms;
    }


    @Override
    public void infoRoom() {
        List<MeetingRoom> rooms = MeetingRoom.getMeetingRooms();
        System.out.println("------------------------------------------------------------------------------");
        System.out.format("%-40s %-20s %-10s%n", "Room Type", "Price/Day (Baht)", "Room available");
        System.out.println("------------------------------------------------------------------------------");
        for (MeetingRoom meetingRoom : rooms) {
            System.out.format("%-40s %-20d %-10s%n", meetingRoom.getType(), meetingRoom.getPrice(), meetingRoom.getAvailable());
        }
        System.out.println("------------------------------------------------------------------------------");
    }

    @Override
    public void selectBooking() {
        boolean check = true;
        System.out.print("Enter the number type : ");
        numRoom = in.nextInt();
        while (check) {

            if (numRoom<1||numRoom>4){
                System.out.println("!!! Please select only the options available here !!!");
                System.out.print("Enter the number type : ");
                numRoom = in.nextInt();
            }
            else {
                setNumRoom(numRoom);
                check = false;
            }

        }
        System.out.println(" ====== Select time ====== ");
        System.out.println("*** The half day price will be half the full day price ***");
        System.out.format("%-2s %-2s%n","","1. All day");
        System.out.format("%-2s %-2s%n","","2. Half day (Morning)");
        System.out.format("%-2s %-2s%n","","3. Half day (Afternoon)");
        System.out.println(" ========================= ");
        System.out.print(" Enter : ");
        time = in.nextInt();

        boolean checks = true;
        while (checks) {
            if (time<1||time>3){
                System.out.println("!!! Please select only the options available here !!!");
                System.out.println("Which package do you need?");
                System.out.println("*** The half day price will be half the full day price ***");
                System.out.format("%-2s %-2s%n","","1. All day");
                System.out.format("%-2s %-2s%n","","2. Half day (Morning)");
                System.out.format("%-2s %-2s%n","","3. Half day (Afternoon)");
                System.out.println(" ========================= ");
                System.out.print(" Enter : ");
                time = in.nextInt();

            }
            else {
                setTime(time);
                checks = false;
            }

        }
        System.out.println("------------------------------------------------------------------------------");
    }
}
