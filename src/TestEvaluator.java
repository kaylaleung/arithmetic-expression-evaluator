
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kayla
 */
public class TestEvaluator {
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in); 
        System.out.println("Enter Arithmetic Infix Expression: ");
        
        String expression = scan.nextLine();
        
        ArithmeticExpressionEvaluator<String> s = new ArithmeticExpressionEvaluator<String>();
        s.InfixToPostfix(expression);

    }
}

/* OUTPUT

run:
Enter Arithmetic Infix Expression: 
( 14 + 8 ) * ( 8 - 4 ) / ( ( 6 - 2 * 2 ) * ( 1 + 2 ) )
Postfix: 14 8 + 8 4 - * 6 2 2 * - 1 2 + * /
Answer: 14.666666666666666
BUILD SUCCESSFUL (total time: 1 second)

run:
Enter Arithmetic Infix Expression: 
10 + 2 - 8 + 3
Postfix: 10 2 + 8 - 3 +
Answer: 7.0
BUILD SUCCESSFUL (total time: 5 seconds)

run:
Enter Arithmetic Infix Expression: 
( ( 1 * 15 ) /  3 ) - ( ( 9 - 7 * 2 ) * ( 2 + 2 * 14 ) ) 
Postfix: 1 15 * 3 / 9 7 2 * - 2 2 14 * + * -
Answer: 155.0
BUILD SUCCESSFUL (total time: 2 seconds)


*/