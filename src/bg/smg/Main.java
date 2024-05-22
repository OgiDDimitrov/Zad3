package bg.smg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    public static void main(String[] args) {
        PriorityBlockingQueue<Product> products = new PriorityBlockingQueue<Product>(100, new ProductComparator());
        try {
            ProductThread t1 = new ProductThread("CKThread", "ck.txt", products);
            ProductThread t2 = new ProductThread("GuessThread", "guess.txt", products);
            ProductThread t3 = new ProductThread("TrussardiThread", "trussardi.txt", products);

            t1.start();
            t2.start();
            t3.start();
            List<Thread> threads = new ArrayList<>();
            threads.add(t1);
            threads.add(t2);
            threads.add(t3);
            for (Thread thread: threads) {
                thread.join();
            }
        } catch (Exception exception) {
            System.out.println("There was an error while reading the data.");
            System.exit(1);
        }

        File file = new File("result_products.txt");
        if (file.exists()) {
            System.out.println("File already exists.");
            System.exit(1);
        }

        PrintWriter output = null;
        try {
            output = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Iterator<Product> it = products.iterator();
        while(it.hasNext()) {
            output.println(it.next() + " ");
        }

        output.close();
    }
}