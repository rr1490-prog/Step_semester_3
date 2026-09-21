
package encapsulation_access_control.assigment_problems;

public class Cart {

    private final String cartId;
    private final double[] prices;
    private int itemCount;

    Cart(String cartId, int maximumItems) {

        this.cartId = cartId;

        if (maximumItems < 0) {
            maximumItems = 0;
        }

        prices = new double[maximumItems];
        itemCount = 0;
    }

    void addItem(double price) {

        if (price < 0) {
            System.out.println("Item rejected: invalid price");
            return;
        }

        if (itemCount >= prices.length) {
            System.out.println("Item rejected: cart is full");
            return;
        }

        prices[itemCount] = price;
        itemCount++;
    }

    double getTotal() {

        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {

        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}
