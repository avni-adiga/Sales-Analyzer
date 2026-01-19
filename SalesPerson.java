// Create the SalesPerson class below.

public class SalesPerson
{
    // Each Salesperson object has a name (String) 
    // and an amount of sales (int).
    private String name;
    private int sales;
    // The constructor takes 2 parameters: the name 
    // and the amount of sales IN THAT ORDER
    public SalesPerson(String n, int s)
    {
        name = n;
        sales = s;
    }
    //Write a getter for the name (called getName)
    public String getName()
    {
        return name;
    }
    //Write a getter for the amount of sales
    //(called getSales)
    public int getSales()
    {
        return sales;
    }
}