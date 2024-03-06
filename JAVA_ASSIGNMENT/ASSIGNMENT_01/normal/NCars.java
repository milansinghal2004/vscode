package normal;
import java.util.*;

public class NCars 
{
    
    void disp_top(String x, int pwr, int torq, String feat, String Price_bfr_tx, String Price_wth_tx)
    {
        System.out.print("\n------------------------------------------------------------------------------------------\n\nTop Variant\nEngine and Perfomance - \n\tEngine Type: "+ x + "\n\tPower: " + pwr + "\n\tTorque: " + torq + "\nFeatures and Aminities - \n" + feat + "\n\nPrice - \n\tEx-Showroom Price: " + Price_bfr_tx + "\n\tOn-Road Price: " + Price_wth_tx);
    }
    void disp_mid(String x, int pwr, int torq, String feat, String Price_bfr_tx, String Price_wth_tx)
    {
        System.out.print("\n------------------------------------------------------------------------------------------\n\nMiddle Variant\nEngine and Perfomance - \n\tEngine Type: "+ x + "\n\tPower: " + pwr + "\n\tTorque: " + torq + "\nFeatures and Aminities - \n" + feat + "\n\nPrice - \n\tEx-Showroom Price: " + Price_bfr_tx + "\n\tOn-Road Price: " + Price_wth_tx);
    }
    void disp_base(String x, int pwr, int torq ,String feat, String Price_bfr_tx, String Price_wth_tx)
    {
        System.out.print("\n------------------------------------------------------------------------------------------\n\nBase Variant\nEngine and Perfomance - \n\tEngine Type: "+ x + "\n\tPower: " + pwr + "\n\tTorque: " + torq + "\nFeatures and Aminities - \n" + feat + "\n\nPrice - \n\tEx-Showroom Price: " + Price_bfr_tx + "\n\tOn-Road Price: " + Price_wth_tx);
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
    class Sedan {
    Sedan()
    {
        sedan_car();
    }
    void display_inner()
    {
        NCars.this.disp_top("V6", 250, 300, "\t18'' Alloy Wheels\n\tSequential Shifters\n\tElectronically Adjustable Seats\n\tMemorey Seats\nWireless Charger\n\tHeads UP Display\n\t7'' MID in Cluster\n\t", "INR 4617000", "INR 5356000");
                NCars.this.disp_mid("V4", 190, 225, "\t17'' Alloy Wheels\n\tSequential Shifters\n\tHeight Adjustable Seats\n\tJBL Speakers\n\tSunroof", "INR 4248596", "INR 4812500");
                NCars.this.disp_base("V4", 175, 190, "\t16'' Alloy Wheels\n\tNo Sequential Shifters\n\tTilt Adjstment in Steering Wheel\n\tBose Speakers\n\tLED Headlamps", "INR 3985973", "INR 4582000");
    }
    public void sedan_car()
    {
        System.out.println("\n\n------------------------------------------------------------------------------------------\n  \t\t\t\t\tSedan car\n------------------------------------------------------------------------------------------\n");
        System.out.println("Available Options are as follows -");
        System.out.println("[1] Camry");String model = "Car";
        while(true)
        {
            System.out.print("Enter the name of car you want to choose: ");
            Scanner in = new Scanner(System.in);
            model = in.nextLine();
            if(model.equalsIgnoreCase("camry"))
            {
                break;
            }
        }
        s1.append(model); 
        //int val = model.toString().compareToIgnoreCase("CAmry");
        if(model.equalsIgnoreCase("CAmry"))
        {
            System.out.println("You have chosen Camry.");
        }
        else
        {
            System.out.println("Invalid choice.");
        }
        //in.close();
        fuel_type();
    }
}
    
    class SUV 
{
    SUV()
    {
        suv();
    }
    void display_inner()
    {
          NCars.this.disp_top("V4", 250, 300, "\t20'' Alloy Wheels\n\tPedal Shifters\n\tElectronically Adjustable Seats\n\tMemorey Seats\n\tWireless Charger\n\tHeads UP Display\n\t9'' MID in Cluster", "INR 3500000" , "INR 5074745");
                NCars.this.disp_mid("V4", 190, 225, "\t17'' Alloy Wheels\n\tSequential Shifters\n\tHeight Adjustable Seats\n\tBose Speakers\n\tSunroof", "INR 3495000", "INR 4595899");
                NCars.this.disp_base("V4", 175, 190, "\t16'' Alloy Wheels\n\tNo Sequential Shifters\n\tTilt Adjstment in Steering Wheel\n\tBose Speakers\n\tLED Headlamps", "INR 3495899", "INR 4285945");
    }
    public void suv()
    {
        System.out.println("\n\n------------------------------------------------------------------------------------------\n  \t\t\t\t\tSUV car\n------------------------------------------------------------------------------------------\n");
        System.out.println("Available Options are as follows -");
        System.out.println("[1] Urban Cruiser Hyrider\n[2] Hilux\n[3] Fortuner\n[4] Legender");String model = "Car";
        while(true)
        {
            System.out.print("Enter the name of car you want to choose: ");
            Scanner in = new Scanner(System.in);
            model = in.nextLine();
            if(model.equalsIgnoreCase("Urban cruize hyrider")||model.equalsIgnoreCase("fortuner")||model.equalsIgnoreCase("hilux")||model.equalsIgnoreCase("legender"))
            {
                break;
            }
        }
        s1.append(model);
        //System.out.println(model);                                                               Just a test case
        if(model.equalsIgnoreCase("urban cruiser hyrider"))
        {
            System.out.println("You have selected URBAN CRUISER HYRIDER");
        }
        else if(model.equalsIgnoreCase("fortuner"))
        {
            System.out.println("You have selected FORTUNER");
        }
        else if(model.equalsIgnoreCase("hilux"))
        {
            System.out.println("You have selected HILUX");
        }
        else if(model.equalsIgnoreCase("legender"))
        {
            System.out.println("You have selected FORTUNER LEGENDER");
        }
        else
        {
            System.out.println("Invalid choice.");
        }
        fuel_type();
        //in.close();
    }
}

class MPV
{
    MPV()
    {
        mpv();
    }

    void display_inner()
    {
        NCars.this.disp_top("V4", 250, 300, "\t19'' Alloy Wheels\n\tSequential Shifters\n\tElectronically Adjustable Seats\n\tMemorey Seats\n\tWireless Charger\n\tHeads UP Display\n\t7.85'' MID in Cluster", "INR 4617000", "INR 5356000");
                NCars.this.disp_mid("V4", 190, 225, "\t17'' Alloy Wheels\n\tSequential Shifters\n\tHeight Adjustable Seats\n\tBose Speakers\n\tSunroof", "INR 4248596", "INR 4812500");
                NCars.this.disp_base("V4", 175, 190, "\t16'' Alloy Wheels\n\tNo Sequential Shifters\n\tTilt Adjstment in Steering Wheel\n\tBose Speakers\n\tLED Headlamps", "INR 3985973", "INR 4582000");
    }
    public void mpv()
    {
        System.out.println("\n\n------------------------------------------------------------------------------------------\n  \t\t\t\t\tMPV car\n------------------------------------------------------------------------------------------\n");
        System.out.println("Available Options are as follows -");
        System.out.println("[1] Rumion\n[2] Innova Crysta\n[3] Innova Hycross\n[4] Vellfire");
        String model = "Car";
        while(true)
        {
            System.out.print("Enter the name of car you want to choose: ");
            Scanner in = new Scanner(System.in);
            model = in.nextLine();
            if(model.equalsIgnoreCase("rumion")||model.equalsIgnoreCase("innova crysta")||model.equalsIgnoreCase("innova hycross")||model.equalsIgnoreCase("vellfire"))
            {
                break;
            }
        }
        s1.append(model);
        //System.out.println(model);                                                               Just a test case
        if(model.equalsIgnoreCase("rumion"))
        {
            System.out.println("You have selected TOYOTA RUMION");
        }
        else if(model.equalsIgnoreCase("innova crysta"))
        {
            System.out.println("You have selected TOYOTA INNOVA CRYSTA");
        }
        else if(model.equalsIgnoreCase("innova hycross"))
        {
            System.out.println("You have selected TOYOTA INNOVA HYCROSS");
        }
        else if(model.equalsIgnoreCase("vellfire"))
        {
            System.out.println("You have selected TOYOTA VELLFIRE");
        }
        else
        {
            System.out.println("Invalid choice.");
        }
        fuel_type();
    }
}

class Hatchback
{
    Hatchback()
    {
        hatchback();
    }
    void display_inner()
    {
        NCars.this.disp_top("\tV4", 250, 300, "\t18'' Alloy Wheels\n\tSequential Shifters\n\tElectronically Adjustable Seats\n\tMemorey Seats\n\tWireless Charger\n\tHeads UP Display\n\t5'' MID in Cluster", "INR 3500000" , "INR 5074745");
                NCars.this.disp_mid("V4", 190, 225, "\t17'' Alloy Wheels\n\tSequential Shifters\n\tHeight Adjustable Seats\n\tBose Speakers\n\tSunroof", "INR 3495000", "INR 4595899");
                NCars.this.disp_base("V4", 175, 190, "\t16'' Alloy Wheels\n\tNo Sequential Shifters\n\tTilt Adjstment in Steering Wheel\n\tBose Speakers\n\tLED Headlamps", "INR 3495899", "INR 4285945");
    }
    public void hatchback()
    {
        System.out.println("\n\n------------------------------------------------------------------------------------------\n  \t\t\t\t\tHatchback car\n------------------------------------------------------------------------------------------\n");
        System.out.println("Available Options are as follows -");
        System.out.println("[1] Glanza");String model = "Car";
        while(true)
        {
            System.out.print("Enter the name of car you want to choose: ");
            Scanner in = new Scanner(System.in);
            model = in.nextLine();
            if(model.equalsIgnoreCase("glanza"))
            {
                break;
            }
        }
        s1.append(model);
        //System.out.println(model);                                                               Just a test case
        if(model.equalsIgnoreCase("glanza ") || model.equalsIgnoreCase("toyota glanza"))
        {
            System.out.println("You have selected TOYOTA GLANZA");
        }
        fuel_type();
    }
}


char fuel_type()
    {
        char fuel;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nAvailable fuel types for your vehicle are as follows:\n[1] Petrol\n[2] Diesel");
        System.out.print("Input 'p' for Petrol or 'd' for Diesel: ");
        fuel = 'p';
        while(true)
        {
            if(fuel != 'p' && fuel != 'd')
            {
                System.out.println("Invalid Choice");
                fuel_type();
            }
        }
        //return fuel;
    }

    static StringBuilder s1 = new StringBuilder();
    String str;

    public void display() 
    {
        System.out.println("\nChoose a car type: ");
        System.out.println("[1] Sedan");
        System.out.println("[2] SUV");
        System.out.println("[3] MPV");
        System.out.println("[4] Hatchback");
        System.out.println("Disclaimer: Enter the number only!\nYour Choice: ");
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
                Sedan nsedan = new NCars.Sedan();
                nsedan.display_inner();
                break;
            case 2:
                System.out.println("You have chosen an SUV car.");
                SUV nsuv = new NCars.SUV();
                nsuv.display_inner();           
                break;
            case 3:
                System.out.println("You have chosen an MPV car.");
                MPV nmpv = new NCars.MPV();
                nmpv.display_inner();
                break;
            case 4:
                System.out.println("You have chosen a Hatchback car.");
                Hatchback nhatchback = new Hatchback();
                nhatchback.display_inner();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
    
}