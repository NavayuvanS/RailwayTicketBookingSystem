public class passenger {
    String name;
    int age;
    String prebirth;
    static int Id=1;
    int number;
    int passengerid;
    String alloted;
    passenger(String name,int age,String prebirth)
    {
        this.name=name;
        this.age=age;
        this.prebirth=prebirth;
        passengerid=Id++;
        number=-1;
        alloted="";
    }
}
