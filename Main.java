import java.util.*;
public class Main { 
    public static void bookticket(passenger p)
    {
        ticketbooking booker=new ticketbooking();
        if(ticketbooking.wl<0)
        {
            System.out.println("No Tickets Available");
            return;
        }
        if((p.prebirth.equals("L")&&ticketbooking.lowerberths>0)||
                (p.prebirth.equals("M")&&ticketbooking.middleberths>0)||
                (p.prebirth.equals("U")&&ticketbooking.upperberths>0))
        {
            if(p.prebirth.equals("U"))
            {
                booker.bookticket(p,(ticketbooking.upperberthposition.get(0)),"U");
                ticketbooking.upperberths--;
                ticketbooking.upperberthposition.remove(0);
            }
            else if(p.prebirth.equals("M"))
            {
                booker.bookticket(p,(ticketbooking.middleberthposition.get(0)),"M");
                ticketbooking.middleberths--;
                ticketbooking.middleberthposition.remove(0);
            }
            else if(p.prebirth.equals("L"))
            {
                booker.bookticket(p,(ticketbooking.lowerberthposition.get(0)),"L");
                ticketbooking.lowerberths--;
                ticketbooking.lowerberthposition.remove(0);
            }
        }
        else if(ticketbooking.upperberths>0)
        {
            booker.bookticket(p,(ticketbooking.upperberthposition.get(0)),"U");
            ticketbooking.upperberthposition.remove(0);
            ticketbooking.upperberths--;
        }
        else if(ticketbooking.middleberths>0)
        {
            booker.bookticket(p,(ticketbooking.middleberthposition.get(0)),"M");
            ticketbooking.middleberths--;
            ticketbooking.middleberthposition.remove(0);
        }
        else if(ticketbooking.lowerberths>0)
        {
            booker.bookticket(p,(ticketbooking.lowerberthposition.get(0)),"L");
            ticketbooking.lowerberthposition.remove(0);
            ticketbooking.lowerberths--;
        }
        else if(ticketbooking.rac>0)
        {
            ticketbooking.addtorac(p,(ticketbooking.racposition.get(0)),"rac");
            ticketbooking.rac--;
            ticketbooking.racposition.remove(0);
        }
        else if(ticketbooking.wl>0)
        {
            ticketbooking.addtowl(p,(ticketbooking.wlthposition.get(0)),"wl");
            ticketbooking.wl--;
            ticketbooking.wlthposition.remove(0);
        }
    }
    public static void cancelticket(int id)
    {

        if(!ticketbooking.passengers.containsKey(id))
        {
            System.out.println("Enter the valid id:");
        }
        else{
            ticketbooking.cancelticket(id);
        }
    }
    public static void main(String[] args) {
        Scanner na=new Scanner(System.in);
        boolean loop=true;
        while(loop)
        {
            System.out.println("1.Book Ticket\n2.Cancel Ticket\n3.Available Ticket\n4.Booked Tickets\n5.Exit");
            System.out.println("Enter your choice:");
            int choice=na.nextInt();
            switch(choice)
            {
                case 1:
                {
                    System.out.println("Enter your name:");
                    String name=na.next();
                    System.out.println("Enter your age:");
                    int age=na.nextInt();
                    System.out.println("Enter your birth preference:");
                    String prebirth=na.next();
                    passenger p=new passenger(name,age,prebirth);
                    bookticket(p);
                }
                break;

                case 2:
                {
                    System.out.println("Enter passengerid to cancel:");
                    int id=na.nextInt();
                    cancelticket(id);
                }
                break;
                case 3:
                {
                    ticketbooking.availableticket();
                }
                break;
                case 4:
                {
                    ticketbooking booker=new ticketbooking();
                    booker.bookedticket();
                }
                break;
                case 5:{
                    System.out.println("Thank you");
                    loop=false;
                }
                break;
                default:
                break;
            }
        }
    }
}
