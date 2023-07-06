public class TestCashier {
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        String name = GetData.getWord("Enter name of item");
        double price = GetData.getDouble("Enter price of item");
        cashier.add(name, price);

        name = GetData.getWord("Enter name of item");
        price = GetData.getDouble("Enter price of item");
        cashier.add(name, price);

        // Add two more entries
        name = GetData.getWord("Enter name of item");
        price = GetData.getDouble("Enter price of item");
        cashier.add(name, price);

        name = GetData.getWord("Enter name of item");
        price = GetData.getDouble("Enter price of item");
        cashier.add(name, price);

        double averagePrice = cashier.getAveragePrice();
        System.out.println("The average price of the items is $" + averagePrice);


        double amount = GetData.getDouble("Enter amount of money for payment");
        cashier.tendered(amount);

  
        cashier.generateReceipt();
    }
}