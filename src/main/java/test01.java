import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class test01 {

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        new config().config();
        StoreInquiry stores = new StoreInquiry();
        stores.inquiryOrder();
    }
}
