import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Product {
    private int productId;
    private String productName;
    private String category;
    private double price;

    public Product(int productId, String productName, String category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return String.format("Product(ID: %d, Name: '%s', Category: '%s', Price: $%.2f)",
                productId, productName, category, price);
    }
}

public class ECommerceSearch {
    
    // Linear search implementation
    public static Product linearSearch(List<Product> products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null;
    }
    
    // Binary search implementation
    public static Product binarySearch(List<Product> sortedProducts, int targetId) {
        int low = 0;
        int high = sortedProducts.size() - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            int currentId = sortedProducts.get(mid).getProductId();
            
            if (currentId == targetId) {
                return sortedProducts.get(mid);
            } else if (currentId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        // Initialize product list
        List<Product> products = new ArrayList<>();
        products.add(new Product(101, "Laptop", "Electronics", 999.99));
        products.add(new Product(203, "Smartphone", "Electronics", 699.99));
        products.add(new Product(305, "Headphones", "Electronics", 149.99));
        products.add(new Product(412, "Desk Chair", "Furniture", 199.99));
        products.add(new Product(523, "Coffee Maker", "Appliances", 79.99));
        
        // Create sorted copy for binary search
        List<Product> sortedProducts = new ArrayList<>(products);
        Collections.sort(sortedProducts, Comparator.comparingInt(Product::getProductId));
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("E-commerce Product Search System");
        System.out.println("--------------------------------");
        
        while (true) {
            System.out.println("\nSearch options:");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Exit");
            
            System.out.print("Enter your choice (1-3): ");
            String choice = scanner.nextLine();
            
            if (choice.equals("3")) {
                System.out.println("Exiting...");
                break;
            }
            
            System.out.print("Enter product ID to search: ");
            try {
                int targetId = Integer.parseInt(scanner.nextLine());
                
                Product result = null;
                if (choice.equals("1")) {
                    System.out.println("\n Performing LINEAR SEARCH...");
                    result = linearSearch(products, targetId);
                } else if (choice.equals("2")) {
                    System.out.println("\n Performing BINARY SEARCH...");
                    result = binarySearch(sortedProducts, targetId);
                } else {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }
                
                if (result != null) {
                    System.out.println(" Product found: " + result);
                } else {
                    System.out.println(" Product not found");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for product ID");
            }
        }
        
        scanner.close();
    }
}

