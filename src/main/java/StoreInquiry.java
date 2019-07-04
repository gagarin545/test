

import com.sun.xml.internal.ws.util.ReadAllStream;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.*;

import static java.lang.String.format;

public class StoreInquiry extends Inquiry {

    WebDriver driver;
    static boolean Start = false;
    private ScheduledExecutorService executor_inqury = Executors.newScheduledThreadPool(6);
    private  int interval_read = config.INTERVAL;

    private ArrayList<Callable> tasks = new ArrayList<>();
    private ArrayList<String> str = new ArrayList<>();

    void inquiryOrder() throws InterruptedException, ExecutionException, IOException {
        str.add("#global_fltr_f-j_idt534-");
        str.add("#global_fltr_f-j_idt502-");
        str.add("#global_fltr_f-j_idt484-");
        str.add("#global_fltr_f-j_idt505-");
        str.add("#global_fltr_f-j_idt515-");
        str.add("#global_fltr_f-j_idt541-");
        str.add("#global_fltr_f-j_idt513-");
        str.add("#global_fltr_f-j_idt521-");
        str.add("#global_fltr_f-j_idt529-");

        tasks.add(this::ReadLine_Next);

        tasks.add(this::ReadShpd_today);

        String ss;
        while (!Start) {

          //  ScheduledFuture<?> fut_init = executor_inqury.schedule(inquiryInit, config.INTERVAL, TimeUnit.SECONDS);
           // Start = Boolean.parseBoolean(format("%b",fut_init.get()));

            Init init = new Init();
            driver = init.exec();
            ReadToday readToday = new ReadToday();
            ReadNext readNext = new ReadNext();

            while (Start) {

                System.out.println(Calendar.getInstance().getTime());

                ss = readToday.exec(driver, "#slcts-slct_acc-dsp_f-tree-0_0-txt_n", "7");
                for (String str0 : str) {
                    try {
                        ss = readNext.exec(driver, str0 + "1", "1");
                        if (ss.length() > 0) break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (!Start) {
                        System.out.print("Задание -> " + str);
                    }
                }

                ss = readToday.exec(driver, "#slcts-slct_acc-dsp_f-tree-0_0-txt_n", "8");
                tasks.forEach( task -> {
                    try {
                        executor_inqury.schedule( task, config.INTERVAL, TimeUnit.SECONDS).get();
                        if( !Start) { System.out.print( "Задание ->" + task.getClass()); }
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                });

                Start = calendar_read.func(config.START, config.STOP);
                System.out.println("Состояние=" + Start + " Пауза=" + interval_read);

                TimeUnit.MINUTES.sleep( interval_read);
            }
            Start = shutdriver();
            System.out.println("Stop!");
            while (!calendar_read.func(config.START, config.STOP));
        }
    }

    private test<Boolean, Integer> calendar_read = (t1, t2) -> {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR_OF_DAY) > t1 & calendar.get(Calendar.HOUR_OF_DAY) < t2 ;
    };
}
