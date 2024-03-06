// Write a class Worker and derive classes DailyWorker and SalariedWorker from it. Every worker has a name and a salary rate.
//Write the method ComPay (int hours) to compute the weekly pay of every worker.
//A Daily Worker is paid on the basis of the number of days he/she works.
//The Salaried Worker gets paid the wage for 40 hours a week no matter what the actual hours are.
//Test this program to calculate the pay of workers. You are expected to use the concept of polymorphism to write this program.

abstract class Worker
{
    String Name;
    double Sal_rate;
    public Worker(String Name, double Sal_rate)
    {
        this.Name = Name;
        this.Sal_rate = Sal_rate;
    }
    public abstract double ComPay(int hours);
}

class DailyWorker extends Worker
{
    public DailyWorker(String Name, double Sal_rate)
    {
        super(Name, Sal_rate);
    }
    public double ComPay(int hours)
    {
        return hours * Sal_rate;
    }
}

class SalariedWorker extends Worker
{
    public SalariedWorker(String Name, double Sal_rate)
    {
        super(Name, Sal_rate);
    }
    public double ComPay(int hours)
    {
        return 40 * Sal_rate;
    }
}

public class Q3 {
    public static void main(String[] args)
    {
        DailyWorker d1 = new DailyWorker("A", 100);
        SalariedWorker s1 = new SalariedWorker("B", 200);

        System.out.println("\nDaily Worker \nName: " + d1.Name + "\nSalary: " + d1.ComPay(5));
        System.out.println("\nSalaried Worker \nName: " + s1.Name + "\nSalary: " + s1.ComPay(5));
    }
}
