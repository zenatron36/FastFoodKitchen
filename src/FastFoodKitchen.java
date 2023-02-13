/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.*;
/**
 *
 * @author philipv
 */
public class FastFoodKitchen {
    ArrayList<Order> orderList = new ArrayList<Order>();
    private static int nextOrderNum = 1;
    
    public FastFoodKitchen() {
        Order order1 = new Order(3, 5, 4, 10, true, FastFoodKitchen.getNextOrderNum());
        FastFoodKitchen.incrementNextOrderNum();

        Order order2 = new Order(0, 0, 3, 3, false, FastFoodKitchen.getNextOrderNum());
        FastFoodKitchen.incrementNextOrderNum();

        Order order3 = new Order(1, 1, 0, 2, false, FastFoodKitchen.getNextOrderNum());
        FastFoodKitchen.incrementNextOrderNum();
        
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
    }


    /**
     * Appends the new order to the end of the orderList.
     *
     * @param ham hamburger amount
     * @param cheese cheeseburger amount
     * @param veggie veggieburger amount
     * @param soda soda amount
     * @param toGo is the order to go
     * @return returns the order number of itself (nextOrderNum - 1)
     */
    public int addOrder(int ham, int cheese, int veggie, int soda, boolean toGo) {
        orderList.add(new Order(ham, cheese, veggie, soda, toGo, FastFoodKitchen.getNextOrderNum()));
        FastFoodKitchen.incrementNextOrderNum();
        return nextOrderNum - 1;
    }

    /**
     * Cancels the last order, removing it from the orderList.
     * 
     * @return true if it was successful, false if the orderList is empty.
     */
    public boolean cancelLastOrder() {
        if (orderList.size() > 0) {
            orderList.remove(nextOrderNum - 2);
            nextOrderNum--;
            return true;
        }
        else
            return false;
    }

    /**
     * Checks whether or not the specified orderID corresponds to an order number in progress.
     *
     * @param orderID the order number to be checked
     * @return false if the order is not done, true if the order is done and is no longer in the orderList
     */
    public boolean isOrderDone(int orderID) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderID == orderList.get(i).getOrderNum()) {
                return false;
            }
        }
        return true;
    }


    /**
     * Cancels the order using the given orderID.
     *
     * @param orderID the order number to be cancelled
     * @return true if the order was removed, false if there isn't a match
     */
    public boolean cancelOrder(int orderID) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderID == orderList.get(i).getOrderNum()) {
                orderList.remove(i);
                return true;
            }
        }
        return false;

    }

    /**
     * Finds the order number sequentially, very slow.
     * @param orderID
     * @return i if the order id is found, -1 if it is not found.
     */
    public int findOrderSeq(int orderID) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderNum() == orderID) {
                return i + 1;
            }
        }
        return -1;
    } 

    public void selectionSort(ArrayList<Order> orders) {
        int n = orders.size();
    
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                int burgersI = getTotalBurgers(orders.get(i));
                int burgersJ = getTotalBurgers(orders.get(j));
                if (burgersJ < burgersI) {
                    minIndex = j;
                }
            }
    
            // Swap the found minimum element with the first element
            Order temp = orders.get(minIndex);
            orders.set(minIndex, orders.get(i));
            orders.set(i, temp);
        }
    }

    public void insertionSort(ArrayList<Order> orders) {
        int n = orders.size();
    
        for (int i = 1; i < n; ++i) {
            Order k = orders.get(i);
            int j = i - 1;
            
            int burgersK = getTotalBurgers(k);
            int burgersJ = getTotalBurgers(orders.get(j));
    
            while (j >= 0 && burgersK < burgersJ) {
                orders.set(j + 1, orders.get(j));
                j = j - 1;
                if (j >= 0) {
                    burgersJ = getTotalBurgers(orders.get(j));
                }
            }
            orders.set(j + 1, k);
        }
    }

    public int findOrderBin(ArrayList<Order> orders, int orderID) {
        int left = 0, right = orders.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (orders.get(mid).getOrderNum() == orderID) {
                return mid;
            } else if (orders.get(mid).getOrderNum() < orderID) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    

    public int getTotalBurgers(Order order) {
        return order.getNumHamburgers() + order.getNumCheeseburgers() + order.getNumVeggieburgers();
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }


    /**
     * Gets the number of orders in the orderList.
     * @return the orderList ArrayList size.
     */
    public int getNumOrdersPending() {
        return orderList.size();
    }
    
    /**
     * Gets the next order number available.
     * @return the next order number available.
     */
    public static int getNextOrderNum() {
        return nextOrderNum;
    }
    
    /**
     * Increments the nextOrderNum variable.
     */
    private static void incrementNextOrderNum() {
        nextOrderNum++;
    }
    
}
