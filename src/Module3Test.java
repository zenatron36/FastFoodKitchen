import java.util.ArrayList;

public class Module3Test {
    public static void main(String[] args) {
        FastFoodKitchen kitchen = new FastFoodKitchen();

        // //Part A
        // int orderPosition = kitchen.findOrderSeq(3);
        // System.out.println("Using sequential search >> order position is " + orderPosition);

        //Part B
        //kitchen.selectionSort(kitchen.orderList);

        //Part C
        kitchen.insertionSort(kitchen.orderList);
        ArrayList<Order> sortedOrders = kitchen.getOrderList();
        //int orderSize = 0;
        for (Order order : sortedOrders) {
            System.out.println(order.getOrderNum() + " has " + kitchen.getTotalBurgers(order));
        }

        //Part D
        int orderPositon = kitchen.findOrderBin(kitchen.orderList, 2);
        System.out.println("Using binary search >> order position is " + orderPositon);
    }
}
