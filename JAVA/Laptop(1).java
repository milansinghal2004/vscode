import java.io.*;

 class Laptop{//this class will contain the details about the different laptops.
    protected String cpu;//name of cpu
    protected int []cpu_spec=new int[2];//array stores speed(GHz), and cores
    protected String gpu;//name of gpu, by knowing name we can know if it has special features like ray-tracing
    protected int []gpu_spec=new int[2];//array stores speed(MHz), memory
    protected int battery;//no. of hours
    protected int ram;//in GB
    protected int []screen=new int[2];//array stores refresh rate(Hz), resolution(pixels)
    protected int price;//in INR
    protected int weight;//in KG
    Laptop(){}
    Laptop(String cpu, int cpu_spec1,int cpu_spec2, String gpu, int gpu_spec1,int gpu_spec2, int battery, int ram, int screen,int screen2, int price, int weight){
        this.cpu=cpu;
        this.cpu_spec[0]=cpu_spec1;
        this.cpu_spec[1]=cpu_spec2;
        this.gpu=gpu;
        this.gpu_spec[0]=gpu_spec1;
        this.gpu_spec[1]=gpu_spec2;
        this.battery=battery;
        this.ram=ram;
        this.screen[0]=screen;
        this.screen[1]=screen2;
        this.price=price;
        this.weight=weight;
    }
}
class Ideal_Laptop extends Laptop{
    Ideal_Laptop(){

    }
    Ideal_Laptop(String cpu, int cpu_spec1,int cpu_spec2, String gpu, int gpu_spec1,int gpu_spec2, int battery, int ram, int screen,int screen2, int price, int weight){
 
        super( cpu,  cpu_spec1, cpu_spec2, gpu,gpu_spec1,gpu_spec2, battery,ram,screen, screen2,price, weight);//reusing parent constructor. User will assign values to these variables, which will then be compared to variables of Laptop object to find perfect laptop
    }
    Laptop[] Laptop_search(Laptop list[]){//this method will search for the perfect laptop by performance. Returns an array of objects of class Laptop, which match Ideal_Laptop attributes.
        int size = list.length;
        Laptop[] Laptop_ideal=new Laptop[size];//list of ideal laptops
        for(int i=0; i<size; i++){
            if(list[i].cpu_spec[1]>cpu_spec[1]){//nested if statements here will check if every attribute of tested object matches or exceeds ideal laptop expectations
                if(list[i].cpu_spec[0]>cpu_spec[0]){
                    if(list[i].gpu_spec[1]>gpu_spec[1]){
                        if(list[i].gpu_spec[0]>gpu_spec[0]){
                            if(list[i].battery>battery){
                                if(list[i].ram>ram){
                                    if(list[i].weight<weight){
                                        if(list[i].screen[0]>screen[0]){
                                            if(list[i].screen[1]>screen[1]){
                                                if(list[i].price<price){
                                                    Laptop_ideal[i]=list[i];
                                                }
                                                else{continue;}
                                            }
                                            else{continue;}
                                        }
                                        else{continue;}
                                    }
                                    else{continue;}
                                }
                                else{continue;}
                            }
                            else{continue;}
                        }
                        else{continue;}
                    }
                    else{continue;}
                }
                else{continue;}
            }
            else{continue;}//continue statement will skip the iteration 
        }
        return Laptop_ideal;
    }
}
class Main extends Laptop{
    public static void main(String args[]){
        Laptop list[]=new Laptop[2];
        Laptop obj1 = new Laptop("Intel i9",1000, 4, "Nvidia RTX 3060", 1000, 32, 10, 32,144, 4000, 10000, 10);
        list[0]=obj1;
        
        Ideal_Laptop obj2 = new Ideal_Laptop("Intel i9", 900, 3, "Nvidia RTX 3060", 900, 16, 5, 16,100, 1080, 90000, 15);
        Laptop []ideal_list=new Laptop[2];
        ideal_list=obj2.Laptop_search(list);
        for(int i=0; i<ideal_list.length; i++){
            System.out.println(ideal_list[i].cpu);
        }
    }
}