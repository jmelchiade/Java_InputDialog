import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//verify cashier

public class Cashier {
    private List<Item> items;

    public Cashier() {
        items = new ArrayList<>();
    }

    public void add(String name, double price) {
        Item item = new Item(name, price);
        items.add(item);
    }

    public int getItemCount() {
        return items.size();
    }

    public double getTotalAmount() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public double getAveragePrice() {
        return getTotalAmount() / getItemCount();
    }

    public void tendered(double amount) {
        double change = amount - getTotalAmount();
        System.out.println("Amount tendered is $" + amount);
        System.out.println("The change is $" + change);
        computeChange(change);
    }

    private void computeChange(double change) {
        int dollars = (int) change;
        int cents = (int) ((change - dollars) * 100);
        int quarters = cents / 25;
        cents %= 25;
        int dimes = cents / 10;
        cents %= 10;
        int nickels = cents / 5;
        cents %= 5;

        System.out.println("The change includes " + dollars + " dollars");
        System.out.println(quarters + " quarters");
        System.out.println(dimes + " dimes");
        System.out.println(nickels + " nickels");
        System.out.println(cents + " cents");
    }

    public void generateReceipt() {
        StringBuilder receipt = new StringBuilder();

        receipt.append("ABC Store\n");

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        receipt.append("Welcome - thanks for stopping, ").append(dateFormat.format(new Date())).append("\n");

        for (Item item : items) {
            receipt.append(item.getName()).append("..........").append(item.getPriceFormatted()).append("\n");
        }

        receipt.append("______________\n");
        receipt.append("Total ..........$").append(getTotalAmountFormatted()).append("\n");

        receipt.append("The number of items purchased is ").append(getItemCount()).append(" items\n");

        receipt.append("The average price per item is $").append(getAveragePriceFormatted()).append("\n");

        System.out.println(receipt.toString());

        JTextArea textArea = new JTextArea(receipt.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        JOptionPane.showMessageDialog(null, scrollPane, "Receipt", JOptionPane.PLAIN_MESSAGE);
    }

    private String getTotalAmountFormatted() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(getTotalAmount());
    }

    private String getAveragePriceFormatted() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(getAveragePrice());
    }

    public static class Item {
        private String name;
        private double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public String getPriceFormatted() {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            return decimalFormat.format(price);
        }
    }
}