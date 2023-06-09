package Booking.Service.HotelService;

import Booking.Bill;
import Booking.SelectBooking;
import Booking.Service.InfoService;
import Booking.Service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelService extends Service implements InfoService, SelectBooking {
    private static int count = 0;
    private static String[][] detailHotelService;
    private static double[] priceHotelService;
    public HotelService(){}
    public HotelService(String order,String name, double price, String moreDetail) {
        super(order ,name, price, moreDetail);

    }
    private static List<HotelService> hotelServices = new ArrayList<>();

    static {
        PickUp pickUp = new PickUp("A","Car pick-up",350,"per round");
        Buffet buffet = new Buffet("B","Premium buffet with Soft Drink",1200,"per person");
        ThaiMassage thaiMassage = new ThaiMassage("C","Thai massage",400,"per hour");
        FootMassage footMassage = new FootMassage("D","Foot massage",400,"per hour");

        hotelServices.add(pickUp);
        hotelServices.add(buffet);
        hotelServices.add(thaiMassage);
        hotelServices.add(footMassage);
    }

    protected static List<HotelService> getHotelService(){
        return hotelServices;
    }

    @Override
    public void infoService() {
        List<HotelService> services = HotelService.getHotelService();
        System.out.println("\u001B[35m------------------------------------------------------------------------------");
        System.out.format("%-2s %-50s %-10s\n","","Package","Price (THB)");
        System.out.println("------------------------------------------------------------------------------");
        for (HotelService hotelService : services) {
            System.out.format("%-2s %-40s %-10s %-10s\n",hotelService.getOrder(),hotelService.getName(),hotelService.getPrice(),hotelService.getMoreDetail());
        }
        System.out.println("------------------------------------------------------------------------------\u001B[0m");
    }

    @Override
    public void selectBooking() {

        Scanner scan = new Scanner(System.in);
        detailHotelService = new String[5][2];
        priceHotelService = new double[5];

        do{
            System.out.print("Select type of package [A-D]: ");
            String selectPackage = scan.nextLine().trim().toUpperCase();

            if(selectPackage.equals("A")){
                PickUp pickUp = new PickUp();
                pickUp.receiveValue();
                detailHotelService[count][0] = hotelServices.get(0).getName();
                detailHotelService[count][1] = pickUp.showDetail();
                priceHotelService[count] = pickUp.calPrice();
                count++;
            }

            else if(selectPackage.equals("B")){
                Buffet buffet = new Buffet();
                buffet.receiveValue();
                detailHotelService[count][0] = hotelServices.get(1).getName();
                detailHotelService[count][1] = buffet.showDetail();
                priceHotelService[count] = buffet.calPrice();
                count++;
            }

            else if(selectPackage.equals("C")){
                ThaiMassage thaiMassage = new ThaiMassage();
                thaiMassage.receiveValue();
                detailHotelService[count][0] = hotelServices.get(2).getName();
                detailHotelService[count][1] = thaiMassage.showDetail();
                priceHotelService[count] = thaiMassage.calPrice();
                count++;
            }

            else if(selectPackage.equals("D")){
                FootMassage footMassage = new FootMassage();
                footMassage.receiveValue();
                detailHotelService[count][0] = hotelServices.get(3).getName();
                detailHotelService[count][1] = footMassage.showDetail();
                priceHotelService[count] = footMassage.calPrice();
                count++;
            }

            else {
                System.out.println("\u001B[31m!!! Please select only the options available here !!!\u001B[0m");
            }

            if(count == 5){
                System.out.println("\u001B[31mA order is full\u001B[0m");
                break;
            }

            System.out.print("Press 'Y' to continue, if not press other : ");
            String con = scan.nextLine().trim().toUpperCase();

            if(!con.equals("Y")){break;}
        }while (true);

        Bill bill = new Bill(detailHotelService,priceHotelService);
        System.out.println();
    }
}
