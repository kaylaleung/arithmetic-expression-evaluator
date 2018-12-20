import java.util.ArrayList;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kayla
 * @param <Item>
 */
public class ArithmeticExpressionEvaluator<Item> {
    
    private ArrayList<String> items = new ArrayList<String>();

    public boolean isEmpty() 
    {
        return items.size() == 0; 
    }

    public void push(String item) 
    {
        items.add(item);
    }

    public String pop() 
    {
        return items.remove(items.size() - 1);
    }
    
    public int checkPrecedence(String s)
    {
        
        switch (s) {
            case "(":
            case ")":
                return 3;
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return 0;
        }
    }
    
    public boolean isStringDouble(String s)
    {
        try
        {
            Double.parseDouble(s);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public void printStack()
    {
        System.out.print("Stack: ");
        
        for(int i = 0; i < items.size(); i ++)
        {
            System.out.print(items.get(i) + " ");
        }
        
        System.out.println();
    }
    
    public void InfixToPostfix(String infix)
    {
        Scanner scan = new Scanner(infix); 
        String postfix = "";
        
        while(scan.hasNext())
        {
            String value = scan.next();
            //System.out.println("Processing: " + value);
            
            if(isStringDouble(value))
            {
                postfix = postfix + value + " ";
            }
            else
            {
                int index = -1;
                if (items.contains("("))
                {
                    index = 1;
                }
                        
                if(isEmpty())
                {          
                    push(value);
                }
                
                else if (value.equals(")") && (items.contains("(")))
                {
                    while(!items.get(items.size() - 1).equals("("))
                    {
                        postfix = postfix + items.get(items.size() - 1) + " ";
                        pop();
                    }
                    pop();
                }
                
                else if(checkPrecedence(value) < checkPrecedence(items.get(items.size() - 1)) || value.equals("("))
                {
                    push(value);
                }
                
                else
                {
                    if(checkPrecedence(value) > 0 && checkPrecedence(value) < 3 && index == -1)
                    {
                        while(!items.isEmpty() && (checkPrecedence(value) >= checkPrecedence(items.get(items.size() - 1))))
                        {
                           if(checkPrecedence(items.get(items.size() - 1)) != 3)
                            {
                                postfix = postfix + items.get(items.size() - 1) + " ";
                            }
                            //System.out.println("Pushed out " + items.get(items.size() - 1));                       
                            pop();
                        }
                    }
                    push(value);
                }
               
            }
            //printStack();
            //System.out.println("Postfix: " + postfix);
        }
        
        postfix = postfix + items.get(0);
        pop();
        System.out.println("Postfix: " + postfix);
        EvaluatePostfix(postfix);
    }
    
    public Double operator(String o)
    {
        double x = Double.parseDouble(items.get(items.size() - 1));
        double y = Double.parseDouble(items.get(items.size() - 2));
        //System.out.println("x = " + x +" , y = " + y);
        switch (o) {
            case "*":
                return x * y;
            case "/":
                return y / x;
            case "+":
                return x + y;
            default:
                return y - x;
        }
            
    }
    public void EvaluatePostfix(String postfix)
    {
        
        Scanner scan2 = new Scanner(postfix); 
        
        while(scan2.hasNextLine())
        {
            String value = scan2.next();
            
            if(isStringDouble(value))
            {
                push(value);
            }
            
            else
            {
                if(items.size() - 1 >= 0 && items.size() - 2 >= 0)
                {
                    double answer = operator(value);
                    pop();
                    pop();
                    push(Double.toString(answer));
                }
                
            }
            
            //printStack();

        }
        Double answer = Double.parseDouble(items.get(0));
        System.out.println("Answer: " + answer);
       
    }

    
    
}


