package bg.smg;
import java.util.Comparator;
public class ProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product firstPlayer, Product secondPlayer) {
        return Double.compare(firstPlayer.getPrice(), secondPlayer.getPrice());
    }
}
