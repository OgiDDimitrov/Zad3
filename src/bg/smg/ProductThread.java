package bg.smg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

public class ProductThread extends Thread {
    private String filename;
    private PriorityBlockingQueue<Product> products;

    ProductThread (String name, String filename, PriorityBlockingQueue<Product> products) {
        super(name);
        this.filename = filename;
        this.products = products;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        File file = new File(filename);

        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (input.hasNext()) {
            String name = input.next();
            String category = input.next();
            Double price = input.nextDouble();
            Product p = new Product(name, category, price);
            synchronized(products) {
                products.add(p);
            }
        }

        input.close();

    }
}
