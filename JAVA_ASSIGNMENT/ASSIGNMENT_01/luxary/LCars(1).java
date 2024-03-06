package luxary;
import java.util.*;

public class LCars 
{
   
    void disp_top(String x, int pwr, int torq, String feat, String Price_bfr_tx, String Price_wth_tx)
    {
        System.out.print("\n------------------------------------------------------------------------------------------\n\nTop Variant\n\nEngine and Perfomance -\n\n\tEngine Type: "+ x + "\n\tPower: " + pwr + "\n\tTorque: " + torq + "\nFeatures and Aminities -\n\n" + feat + "\n\nPrice-\n\tEx-Showroom Price: " + Price_bfr_tx + "\n\tOn-Road Price: " + Price_wth_tx);
    }
    void disp_mid(String x, int pwr, int torq, String feat, String Price_bfr_tx, String Price_wth_tx)
    {
        System.out.print("\n------------------------------------------------------------------------------------------\n\nMiddle Variant\n\nEngine and Perfomance -\n\n\tEngine Type: "+ x + "\n\tPower: " + pwr + "\n\tTorque: " + torq + "\nFeatures and Aminities -\n\n" + feat + "\n\nPrice-\n\tEx-Showroom Price: " + Price_bfr_tx + "\n\tOn-Road Price: " + Price_wth_tx);
    }
    void disp_base(String x, int pwr, int torq ,String feat, String Price_bfr_tx, String Price_wth_tx)
    {
        System.out.print("\n------------------------------------------------------------------------------------------\n\nBase Variant\n\nEngine and Perfomance -\n\n\tEngine Type: "+ x + "\n\tPower: " + pwr + "\n\tTorque: " + torq + "\nFeatures and Aminities -\n\n" + feat + "\n\nPrice-\n\tEx-Showroom Price: " + Price_bfr_tx + "\n\tOn-Road Price: " + Price_wth_tx);
    }

    public abstract class variants
    {
        abstract void disp_top();
        abstract void disp_mid();
        abstract void disp_base();
    }

    /*String var_opted()
    {
        String var;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input variant which you want to opt for: ");
        var = sc.nextLine();
        if(var.equalsIgnoreCase("top"))
        {
            System.out.println("It would cost you only " + );
        }
        return var;
    }*/

    char fuel_type()
    {
        char fuel;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nAvailable fuel types for your vehicle are as follows:\n[1] Petrol\n[2] Diesel");
        System.out.print("Input 'p' for Petrol or 'd' for Diesel: ");
        fuel = 'a';
        try
        {
            fuel = sc.next().charAt(0);
            if(fuel != 'p' && fuel != 'd')
            {
                System.out.println("Invalid Choice");
                fuel_type();
            }
        }
        catch(ArithmeticException e)
        {
            System.out.println("Invalid Choice");
            fuel_type();
        }
        catch(NullPointerException e)
        {
            System.out.println("Invalid Choice");
            fuel_type();
        }
        catch(Exception e)
        {
            System.out.println("Invalid Choice");
            fuel_type();
        }
        return fuel;
    }

    static StringBuilder s1 = new StringBuilder();
    String str;

    public void display() 
    {
        System.out.println("\nChoose a car type: ");
        System.out.println("[1] Sedan");
        System.out.println("[2] SUV");
        System.out.println("[3] MPV");
        System.out.println("[4] Coupe");
        System.out.println("Your Choice: ");
        Scanner in = new Scanner(System.in);
        in.hasNextLine();
        int choice = 0;
        try{
            choice = in.nextInt();
            if(choice <= 0 || choice > 4)
            {
                System.out.println("Invalid Choice");
                display();
            
            }
        }
        catch(ArithmeticException e){
            System.out.println("Invalid Choice");
            display();
        }
        catch(NullPointerException e){
            System.out.println("Invalid Choice");
            display();
        }
        catch(Exception e){
            System.out.println("Invalid Choice");
            display();
        }
       
        switch (choice) 
        {
            case 1:
                System.out.println("You have chosen a Sedan car.");
                Sedan nsedan = new Sedan();
                nsedan.disp_top("V8", 250, 300, "\t22'' Alloy Wheels\n\tSequential Shifters\n\tLuxirious Seats\n\tRoad Conquerer\nWireless Charger\n\tHeads UP Display\n\t12.83'' MID in Cluster\n\t", "INR 4617000", "INR 6970000");
                nsedan.disp_mid("V6", 190, 225, "\t22'' Alloy Wheels\n\tSequential Shifters\n\tHeight Adjustable Seats\n\tJBL Speakers\n\tSunroof", "INR 4248596", "INR 6750000");
                nsedan.disp_base("V6", 175, 190, "\t21'' Alloy Wheels\n\tNo Sequential Shifters\n\tTilt Adjstment in Steering Wheel\n\tBose Speakers\n\tLED Headlamps", "INR 3985973", "INR 6400000");
                break;
            case 2:
                System.out.println("You have chosen an SUV car.");
                SUV nsuv = new SUV();
                nsuv.disp_top("V6", 250, 300, "\t24'' Alloy Wheels\n\tPedal Shifters\n\tLuxirious Seats\n\tMemorey Seats\n\tWireless Charger\n\tHeads UP Display\n\t9'' MID in Cluster", "INR 15380950" , "INR 28240000");
                nsuv.disp_mid("V6", 190, 225, "\t22'' Alloy Wheels\n\tSequential Shifters\n\tHeight Adjustable Seats\n\tBose Speakers\n\tSunroof", "INR  15380950", "INR 27580900");
                nsuv.disp_base("V6", 175, 190, "\t21'' Alloy Wheels\n\tNo Sequential Shifters\n\tTilt Adjstment in Steering Wheel\n\tBose Speakers\n\tLED Headlamps", "INR  15380950", "INR 25000000");
                break;
            case 3:
                System.out.println("You have chosen an MPV car.");
                MPV nmpv = new MPV();
                nmpv.disp_top("V8", 250, 300, "\t19'' Alloy Wheels\n\tSequential Shifters\n\tLuxirious Seats\n\tMemorey Seats\n\tWireless Charger\n\tHeads UP Display\n\t7.85'' MID in Cluster", "INR 8995495", "INR 18000000");
                nmpv.disp_mid("V8", 190, 225, "\t17'' Alloy Wheels\n\tSequential Shifters\n\tHeight Adjustable Seats\n\tBose Speakers\n\tSunroof", "INR 8995495", "INR 16500000");
                nmpv.disp_base("V6", 175, 190, "\t16'' Alloy Wheels\n\tNo Sequential Shifters\n\tTilt Adjstment in Steering Wheel\n\tBose Speakers\n\tLED Headlamps", "INR 8995495", "INR 12500000");
                break;
            case 4:
                System.out.println("You have chosen a Coupe car.");
                Coupe nhatchback = new Coupe();
                nhatchback.disp_top("\tV4", 250, 300, "\t22'' Alloy Wheels\n\tSequential Shifters\n\tLuxirious Seats\n\tMemorey Seats\n\tWireless Charger\n\tHeads UP Display\n\t5'' MID in Cluster", "INR 19500000" , "INR 23920000");
                nhatchback.disp_mid("V4", 190, 225, "\t22'' Alloy Wheels\n\tSequential Shifters\n\tHeight Adjustable Seats\n\tBose Speakers\n\tSunroof", "INR 19500000", "INR 21854006");
                nhatchback.disp_base("V4", 175, 190, "\t22'' Alloy Wheels\n\tNo Sequential Shifters\n\tTilt Adjstment in Steering Wheel\n\tBose Speakers\n\tLED Headlamps", "INR 19500000", "INR 19984954");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}

// Inheritance
class Sedan extends LCars
{
    Sedan()
    {
        sedan_car();
    }
    public void sedan_car()
    {
        System.out.println("\n\n------------------------------------------------------------------------------------------\n  \t\t\t\t\tSedan car\n------------------------------------------------------------------------------------------\n");
        System.out.println("Available Options are as follows -");
        System.out.println("[1] ES");
        System.out.println("[2] LS");
        String model = "Car";
        while(true)
        {
            System.out.print("Enter the name of car you want to choose: ");
            Scanner in = new Scanner(System.in);
            model = in.nextLine();
            if(model.equalsIgnoreCase("ES")||model.equalsIgnoreCase("LS"))
            {
                break;
            }
        }
        s1.append(model); 
        if(model.equalsIgnoreCase("ES"))
        {
            System.out.println("You have chosen LEXUS ES.");
        }
        else if(model.equalsIgnoreCase("LS"))
        {
            System.out.println("You have chosen LEXUS LS.");
        }
        else
        {
            System.out.println("Invalid choice.");
        }
        //in.close();
        fuel_type();
    }
}

class SUV extends LCars
{
    SUV()
    {
        suv();
    }
    public void suv()
    {
        System.out.println("\n\n------------------------------------------------------------------------------------------\n  \t\t\t\t\tSUV car\n------------------------------------------------------------------------------------------\n");
        System.out.println("Available Options are as follows -");
        System.out.println("[1] NX\n[2] LX\n[3] RX");
        String model = "Car";
        while(true)
        {
            System.out.print("Enter the name of car you want to choose: ");
            Scanner in = new Scanner(System.in);
            model = in.nextLine();
            if(model.equalsIgnoreCase("NX")||model.equalsIgnoreCase("LX")||model.equalsIgnoreCase("RX"))
            {
                break;
            }
        }
        s1.append(model);
        //System.out.println(model);                                                               Just a test case
        if(model.equalsIgnoreCase("NX"))
        {
            System.out.println("You have selected NX");
        }
        else if(model.equalsIgnoreCase("rx"))
        {
            System.out.println("You have selected RX");
        }
        else if(model.equalsIgnoreCase("LX"))
        {
            System.out.println("You have selected LX");
        }
        else
        {
            System.out.println("Invalid choice.");
        }
        fuel_type();
        //in.close();
    }
}

class MPV extends LCars
{
    MPV()
    {
        mpv();
    }
    public void mpv()
    {
        System.out.println("\n\n------------------------------------------------------------------------------------------\n  \t\t\t\t\tMPV car\n------------------------------------------------------------------------------------------\n");
        System.out.println("Available Options are as follows -");
        System.out.println("[1] LM");
         String model = "Car";
        while(true)
        {
            System.out.print("Enter the name of car you want to choose: ");
            Scanner in = new Scanner(System.in);
            model = in.nextLine();
            if(model.equalsIgnoreCase("LM"))
            {
                break;
            }
        }
        s1.append(model);
        //System.out.println(model);                                                               Just a test case
        if(model.equalsIgnoreCase("LM"))
        {
            System.out.println("You have selected LEXUS LM");
        }
        else
        {
            System.out.println("Invalid choice.");
        }
        fuel_type();
    }
}


class Coupe extends LCars
{
    Coupe()
    {
        coupe();
    }
    public void coupe()
    {
        System.out.println("\n\n------------------------------------------------------------------------------------------\n  \t\t\t\t\tCoupe car\n------------------------------------------------------------------------------------------\n");
        System.out.println("Available Options are as follows -");
        System.out.println("[1] LC");
        String model = "Car";
        while(true)
        {
            System.out.print("Enter the name of car you want to choose: ");
            Scanner in = new Scanner(System.in);
            model = in.nextLine();
            if(model.equalsIgnoreCase("LC"))
            {
                break;
            }
        }
        s1.append(model);
        //System.out.println(model);                                                               Just a test case
        if(model.equalsIgnoreCase("LC ") || model.equalsIgnoreCase("LEXUS LC"))
        {
            System.out.println("You have selected LEXUS LC");
        }
        fuel_type();
    }
}
