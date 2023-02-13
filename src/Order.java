/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author philipv
 */
public class Order {
    
    private int numHamburgers = 0;
    private int numCheeseburgers = 0;
    private int numVeggieburgers = 0;
    private int numSodas = 0;
    private boolean orderToGo = false;
    private int orderNum = 1;
    
    public Order(int numHamburgers, int numCheeseburgers, int numVeggieburgers, int numSodas, boolean orderToGo, int orderNum) {
        this.numHamburgers = numHamburgers;
        this.numCheeseburgers = numCheeseburgers;
        this.numVeggieburgers = numVeggieburgers;
        this.numSodas = numSodas;
        this.orderToGo = orderToGo;
        this.orderNum = orderNum;
    }
    
    
    public int getNumHamburgers() {
        return numHamburgers;
    }
    
    public void setNumHamburgers( int newHamburgers ) {
        if ( newHamburgers < 0 )
            System.out.println("Error: cannot have negative hamburgers.");
        else
            numHamburgers = newHamburgers;
    }
    
    public int getNumCheeseburgers() {
        return numCheeseburgers;
    }
    
    public void setNumCheeseburgers( int newCheeseburgers ) {
        if ( newCheeseburgers < 0 )
            System.out.println("Error: cannot have negative cheeseburgers.");
        else
            numCheeseburgers = newCheeseburgers;
    }
    
    public int getNumVeggieburgers() {
        return numVeggieburgers;
    }
    
    public void setNumVeggieburgers( int newVeggieburgers ) {
        if ( newVeggieburgers < 0 )
            System.out.println("Error: cannot have negative veggieburgers.");
        else
            numVeggieburgers = newVeggieburgers;
    }
    
    public int getNumSodas() {
        return numSodas;
    }
    
    public void setNumSodas( int newSodas ) {
        if ( newSodas < 0 )
            System.out.println("Error: cannot have negative sodas.");
        else
            numSodas = newSodas;
    }
    
    public boolean isOrderToGo() {
        return orderToGo;
    }
    
    public void setOrderToGo( boolean newOrderToGoStatus ) {
        orderToGo = newOrderToGoStatus;
    }
    
    public int getOrderNum() {
        return orderNum;
    }
    
    public void setOrderNum( int newOrderNum ) {
        orderNum = newOrderNum;
    }
    
    
    
}


