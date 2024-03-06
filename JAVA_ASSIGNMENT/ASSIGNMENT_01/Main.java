import java.util.*;             // importing library
import normal.NCars;            // importing packages
import luxary.LCars;            

public class Main
{
    static Map<String, Integer> map; 
    public static void mentananceServices(){
        map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
       
        System.out.println("Services: ");
        System.out.println("1. Car Wash              1,200.00");
        System.out.println("2. Car Polish            700.00");
        System.out.println("3. Car Interier Clening  3,700.00");
        System.out.println("4. Engine oil Change     1,900.00");
        System.out.println("5. Wheel Change          1,20,000.00");
        System.out.println("6. PPF Application       3,00,000.00");
        System.out.println("Enter Your Choose: ");
        int choose =0;
        try{ choose = sc.nextInt();
        }
        catch(ArithmeticException e){
            System.out.println("Invalid Choice");
            mentananceServices();
        }
        catch(InputMismatchException e){
            System.out.println("Invalid Choice");
            mentananceServices();
        }
        catch(NullPointerException e){
            System.out.println("Invalid Choice");
            mentananceServices();
        }
        catch(Exception e){
            System.out.println("Invalid Choice");
            mentananceServices();
        }
        switch(choose){
            case 1:
                map.put("Car Wash", 1200); break;
            case 2:
                map.put("Car Polish", 700); break;
            case 3:
                map.put("Car Interier Cleaning", 3700); break;
            case 4:
                map.put("Engine oil Change", 1900); break;
            case 5:
                map.put("Wheel Change ", 1_20_00); break;
            case 6:
                map.put("PPF Application", 300000); break;
            default:
                System.out.println("Invalid Choice");
                mentananceServices();

        }
        
            
    }
    public static void ride()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPlease select the the following:\n[1] Normal Cars\n[2] Luxary Cars \n[3] Services");
        System.out.print("Disclaimer: Enter the number only!\nYour choice: ");
        int choice =0;
        
        try{
            choice = sc.nextInt();
            if(choice <= 0 || choice > 3)
            {
                System.out.println("Invalid Choice");
                ride();
            
            }
        }
        catch(ArithmeticException e){
            System.out.println("Invalid Choice");
            ride();
        }
        catch(NullPointerException e){
            System.out.println("Invalid Choice");
            ride();
        }
        catch(Exception e){
            System.out.println("Invalid Choice");
            ride();
        
        } 
        switch(choice)
        {
            case 1:
                // Normal Cars
                NCars n = new NCars();
                n.display();
                break;
            case 2:
                // Luxary Cars
                LCars l = new LCars();
                l.display();
                break;
            case 3:
                mentananceServices();
                for(Map.Entry m : map.entrySet()){
                    System.out.println( m.getKey() + " Total Cost: " + m.getValue() );
                }
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }
    public static void purpose()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPlease select the purpose of your visit from the list:\n[1] Car Selection  &  Services \n[2] Testride\t\t[Coming Soon]");
        System.out.print("Disclaimer: Enter the number only!\nYour choice: ");
        int choice =0;
        try{
            choice = sc.nextInt();
            if(choice <1 || choice>2){
                System.out.println("Invalid Choice");
                purpose();
            }
            
        }
        catch(ArithmeticException e){
            System.out.println("Invalid Choice");
            purpose();
        }
        catch (NumberFormatException e){
            System.out.println("\t!!Invalid input Type!!\n\tPlease only Enter numbers"); 
            purpose();
        }
        catch(NullPointerException e){
            System.out.println("Invalid Choice");
            purpose();
        }
        catch(Exception e){
            System.out.println("Invalid Choice");
            purpose();
      
        } 
        switch(choice)
        {
            case 1:
                // Car Selection
                ride();
                break;
            case 2:
                System.out.println("Not Avialible");purpose();
                break;
            default:
                System.out.println("Invalid Choice");
                purpose();
        }
        

    }
    static{System.out.println("Hello");}
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Welcome Message
        System.out.println("Welcome to LT Cars\n");                     
        //sc.nextLine();
        System.out.println("Press any key");
        // Taking Details
        String var3 = "User";
        long pno = 00L;
        final String check = "[a-zA-Z ]+";
        while(true)
        {
            sc.nextLine();
            System.out.print("\nPlease enter your Contact Details\nName: ");          
            try{
                var3 = sc.nextLine();
                while (!var3.matches(check)) {
                    System.out.println("Invalid input! Please enter a string (letters and spaces only):");
                    System.out.print("Name: ");
                    var3 = sc.nextLine();
                  }
            }
            catch(StringIndexOutOfBoundsException e){
            System.out.println("Invalid Choice"); continue;
            }
            catch(NullPointerException e){
                System.out.println("Invalid Choice");continue;
            }
            catch(Exception e){
                System.out.println("Invalid Choice");continue;
        
            } 
            System.out.print("Contact Number: ");
            try{
                pno = sc.nextLong();
            }
            catch(StringIndexOutOfBoundsException e){
            System.out.println("Invalid Choice");continue;
            }
            catch(NullPointerException e){
                System.out.println("Invalid Choice");continue;
            }
            catch(Exception e){
                System.out.println("Invalid Choice");continue;
        
            }

            // Displaying Details
            System.out.println("\n" +var3+ ", please recheck the details you have entered\nName: " +var3 + "\nPhone Number: " +pno);
                System.out.println("Do you want to update details: ");
                System.out.println("[1] Yes\n[2] No");
                System.out.print("Disclaimer: Enter integer only!\nYour choice: ");
                try{int choi = sc.nextInt();
                if(choi == 2)
                {
                    break;

                }
                }
                catch(ArithmeticException e){
                    System.out.println("Invalid Choice");continue;}
                    catch(InputMismatchException e){
                        System.out.println("Invalid Choice");continue;}
                catch(NullPointerException e){
                    System.out.println("Invalid Choice");continue;
                }
                catch(Exception e){
                    System.out.println("Invalid Choice");continue;
            
                } 
            }
            // Taking the Purpose of Visit
            purpose();
            //sc.close();
    }
}