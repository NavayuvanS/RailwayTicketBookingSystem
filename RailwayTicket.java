import java.util.*;
public class ticketbooking {
    static int lowerberths=1;
    static int middleberths=1;
    static int upperberths=1;
    static int rac=1;
    static int wl=1;

    static Queue<Integer> raclist=new LinkedList<>();
    static Queue<Integer> wllist=new LinkedList<>();

    static ArrayList<Integer> lowerberthposition=new ArrayList<>(Arrays.asList(1));
    static ArrayList<Integer> upperberthposition=new ArrayList<>(Arrays.asList(1));
    static ArrayList<Integer> middleberthposition=new ArrayList<>(Arrays.asList(1));
    static ArrayList<Integer> racposition=new ArrayList<>(Arrays.asList(1));
    static ArrayList<Integer> wlthposition=new ArrayList<>(Arrays.asList(1));

    static Map<Integer,passenger> passengers=new HashMap<>();

    public void bookticket(passenger p,int berthinfo,String berthalloted)
    {
        p.number=berthinfo;
        p.alloted=berthalloted;
        passengers.put(p.passengerid,p);
        System.out.println("--------------------------Booked Successfully");
    }

    public static void addtorac(passenger p,int racinfo,String allotedrac)
    {
        p.alloted=allotedrac;
        p.number=racinfo;
        passengers.put(p.passengerid,p);
        raclist.add(p.passengerid);
        System.out.println("--------------------------added to RAC Successfully");
    }

    public static void addtowl(passenger p,int wlinfo,String allotedwl)
    {
        p.alloted=allotedwl;
        p.number=wlinfo;
        passengers.put(p.passengerid,p);
        wllist.add(p.passengerid);
        System.out.println("-------------------------- added to Waiting List Successfully");
    }

    public static void cancelticket(int id)
    {
        passenger p=passengers.get(id);
        passengers.remove(id);
        int positionbooked=p.number;
        System.out.println("---------------cancelled Successfully");
        if(p.alloted.equals("L"))
        {
            lowerberths++;
            lowerberthposition.add(positionbooked);
        }
        else if(p.alloted.equals("U"))
        {
            upperberths++;
            upperberthposition.add(positionbooked);
        }
        else if(p.alloted.equals("M"))
        {
            middleberths++;
            middleberthposition.add(positionbooked);
        }

        if(raclist.size()>0)
        {
            passenger passengerfromrac=passengers.get(raclist.poll());
            int positionrac=passengerfromrac.number;
            racposition.add(positionrac);
            raclist.remove(passengerfromrac.passengerid);
            rac++;
            if(wllist.size()>0)
            {
                passenger passengerfromwl=passengers.get(wllist.poll());
                int positionwl=passengerfromwl.passengerid;
                wllist.remove(positionwl);
                wlthposition.add(passengerfromwl.number);
                wl++;
                passengerfromwl.number=racposition.get(0);
                passengerfromwl.alloted="rac";
                racposition.remove(0);
                raclist.add(passengerfromwl.passengerid);

                rac--;
                wl++;

            }
            Main.bookticket(passengerfromrac);
        }
    }
    public static void availableticket()
    {
        System.out.println("Lowerberth="+lowerberths);
        System.out.println("Upperberth="+upperberths);
        System.out.println("Middleberth="+middleberths);
        System.out.println("RAC="+rac);
        System.out.println("WL="+wl);
    }
    public void bookedticket()
    {
        if(passengers.size() == 0)
        {
            System.out.println("No details of passengers");
            return;
        }
        for(passenger p : passengers.values())
        {
            System.out.println("PASSENGER ID " + p.passengerid );
            System.out.println(" Name " + p.name );
            System.out.println(" Age " + p.age );
            System.out.println(" Status " + p.number + p.alloted);
            System.out.println("--------------------------");
        }
    }
}
