class Calc
{
	public static void main(String args[])
	{
	

	char symb = args[1].charAt(0);
	float a = Float.parseFloat(args[0]);
	float b = Float.parseFloat(args[2]);
	switch(symb){
	case '+':
		System.out.println("Sum: "+(a+b)); break;
	case '-':
		System.out.println("Difference: "+(a-b));break;
	case '/':
		System.out.println("Div: "+(a/b));break;
	case 'x':
		System.out.println("mul: "+(a*b));break;
	default:
		System.out.println("Invalid Input");
		}
	
	}
}