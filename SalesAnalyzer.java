import java.util.Scanner;
import java.io.*;
/**
 * This class can be used to analyze the sales of a group of
 * salespeople. You will be completing the methods to find 
 * the total sales, average sales, min and max sales and 
 * generating a report that returns a table with each 
 * salesperson's name and amount of sales.  The more 
 * challenging part of this project is to write the methods 
 * that return an array of names that meet certain criteria.
 * These methods include people with sales greater than or 
 * equal to a given amount as well as people that have 
 * the maximum sales amounts.
 */
public class SalesAnalyzer
{

    private SalesPerson[] staff;

    /**
     * 1. Constructor for class SalesAnalyzer.
     * @param s - String - the name of the file with the data
     * See the Assignment instructions for details on how
     * to build the constructor for this class.
     * 
     */
    public SalesAnalyzer(String s) throws IOException
    {
        File f1 = new File(s);
        Scanner sc = new Scanner(f1);
        String value = sc.nextLine();
        int size = Integer.parseInt(value);
        staff = new SalesPerson[size];
        for(int i = 0; i < size; i++)
        {
            String person = sc.nextLine();
            String[] arr = person.split(",");
            int sales = Integer.parseInt(arr[1]);
            SalesPerson sp = new SalesPerson(arr[0], sales);
            staff[i] = sp;
        }
        sc.close();
    }
    

    /*#
     * 2. Write the method totalSales
     */
    /**
     * Determines the total amount of sales for all 
     * salespeople in the object's array
     * @return  the total sales of all salespeople
     */
    public int totalSales()
    {
        int total = 0;
        for(int i = 0; i < staff.length; i++)
        {
            total += staff[i].getSales();
        }
        return total;
    }
    
    /*#
     * 3. Write the method averageSale
     */
    /**
     * Determines the average sales amount from the 
     * salespeople in the object's array
     * @return  the average of the sales from all salespeople
     */
    public double averageSale()
    {
        return (double) this.totalSales()/staff.length;
    }    

    /*#
     * 4. Write the method maxSale 
     */
    /**
     * Determines the highest sales amount from the 
     * salespeople in the object's array
     * @return  the maximum sales amount from all salespeople
     */
    public int maxSale()
    {        
        int max = staff[0].getSales();
        for(SalesPerson sp:staff)
        {
            if(max < sp.getSales())
            {
                max = sp.getSales();
            }
        }
        return max;
    }
    
    /*#
     * 5. Write the method minSale 
     */
    /**
     * Determines the lowest sales amount from the 
     * salespeople in the object's array
     * @return  the minimum sales amount of all salespeople
     */
    public int minSale()
    {           
        int min = staff[0].getSales();
        for(SalesPerson sp:staff)
        {
            if(min > sp.getSales())
            {
                min = sp.getSales();
            }
        }
        return min;
    }
    
    /*#
     * 6. Write the method numSalesAtOrAbove
     */
    /**
     * Finds the number of salespeople whose sales 
     * were at or above an input value
     * @param n is the minimum sales amount to be counted   
     * @return  the number of salespeople whose sales are 
     * greater or equal to n.
     */
    public int numSalesAtOrAbove(int n)
    {
        int num = 0;
        for(SalesPerson sp:staff)
        {
            if(sp.getSales() >= n)
            {
                num++;
            }
        }
        return num;
    }
    
    /*#
     * 7. Write the method maxSalesPeople
     */
    /** 
     * Finds all salespeople who have the most sales 
     * of those in object's array
     * @return  an array of the names of the salespeople 
     * who have the highest sales.
     */
    public String[] maxSalesPeople()
    {   
        int maxAmt = this.maxSale();
        String[] names = new String[numSalesAtOrAbove(maxAmt)];
        int num = 0;
        for(int i = 0; i < staff.length; i++)
        {
            if(staff[i].getSales() == maxAmt)
            {
                names[num] = staff[i].getName();
                num++;
            }
        }
        return names;
    }
    /*#
     * 8. Write the method peopleWithSalesAtOrAbove
     */
    /**
     * Finds all salespeople whose sales amount was 
     * at or above an input amount
     * @param n is the minimum sales amount for 
     * sales person to be included   
     * @return an array of strings of the names of 
     * salespeople that have sales that are greater 
     * than or equal to n.
     */
    public String[] peopleWithSalesAtOrAbove(int n)
    {       
        int people = numSalesAtOrAbove(n);
        int num = 0;
        String[] names = new String[people];
        for(int i = 0; i < staff.length; i++)
        {
            if(staff[i].getSales() >= n)
            {
                names[num] = staff[i].getName();
                num++;
            }
        }
        return names;
        
    }
    /*#
     * 9. Complete the report method. 
    /**
     * Prints a table with all salespeople and their 
     * total sales
     * @return a string that, when printed, creates 
     * a table of salespeople and sales amounts.
     * Formatting should be one salesperson per line:  
     * NAME<tab><tab>SALES
     */
    public String report()
    {
        String s = "Salesperson\tSales\n" + "--------------------\n";
        for(SalesPerson sp:staff)
        {
            s += sp.getName() + "\t\t" + sp.getSales() + "\n";
        }
        return s;
    }
}