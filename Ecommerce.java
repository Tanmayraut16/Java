import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private double price;
    private int id;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: $" + price;
    }
}

class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return product.getName() + " x " + quantity + " = $" + getTotalPrice();
    }
}

class ShoppingCart {
    private List<CartItem> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            double total = 0;
            System.out.println("Your cart:");
            for (CartItem item : items) {
                System.out.println(item);
                total += item.getTotalPrice();
            }
            System.out.println("Total: $" + total);
        }
    }

    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty. Add items to cart before checking out.");
        } else {
            viewCart();
            items.clear();
            System.out.println("Thank you for your purchase!");
        }
    }
}

class SimpleECommerceApp {
    private static List<Product> products;
    private static ShoppingCart cart;
    private static Scanner scanner;

    public static void main(String[] args) {
        products = new ArrayList<>();
        cart = new ShoppingCart();
        scanner = new Scanner(System.in);

        // Sample products
        products.add(new Product(1, "Laptop", 999.99));
        products.add(new Product(2, "Smartphone", 599.99));
        products.add(new Product(3, "Headphones", 199.99));

        boolean running = true;

        while (running) {
            System.out.println("Welcome to Simple E-Commerce App");
            System.out.println("1. List Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listProducts();
                    break;
                case 2:
                    addProductToCart();
                    break;
                case 3:
                    cart.viewCart();
                    break;
                case 4:
                    cart.checkout();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using the Simple E-Commerce App!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void listProducts() {
        System.out.println("Product List:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void addProductToCart() {
        System.out.print("Enter product ID to add to cart: ");
        int productId = scanner.nextInt();
        Product product = findProductById(productId);

        if (product != null) {
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            cart.addProduct(product, quantity);
            System.out.println("Added " + product.getName() + " to cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
