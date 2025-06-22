import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product("P001", "Laptop", "Electronics"),
                new Product("P002", "Shoes", "Fashion"),
                new Product("P003", "Book", "Education"),
                new Product("P004", "Camera", "Electronics"),
                new Product("P005", "Watch", "Accessories")
        };
        
        System.out.println("Linear Search:");
        Product result1 = SearchUtil.linearSearch(products, "Camera");
        System.out.println(result1 != null ? result1 : "Product not found");

        Arrays.sort(products);
        System.out.println("\nBinary Search:");
        Product result2 = SearchUtil.binarySearch(products, "Camera");
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}
