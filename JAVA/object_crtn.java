class object_crtn 
{
    int c = 15;
    object_crtn()
    {
        System.out.println("Hello Object");
        int d = 100;
    }
    void display()
    {
        System.out.println("method 1");
        System.out.println(c);
    }
    static int a = 10;
    public static void main(String str[])
    {
        int b = 10;
        object_crtn ob1 = new object_crtn();
        ob1.display();
        object_crtn ob2 = new object_crtn();
            ob2.c = 10;
            //System.out.println(ob1.c);
            //System.out.println(ob2.c);
            ob2.display();
        object_crtn ob3 = new object_crtn();
        ob3.display();
    }    
}
