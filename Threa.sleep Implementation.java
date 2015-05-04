package sleep.practice.com.sleepimpl;

import android.os.CountDownTimer;
import android.util.Log;

/**
 * Created by Rahul Raj on 04-May-15.
 */
public class ThreadImpl {

     public static void sleep(long millis){

        boolean flag=true;
        long startTime=System.nanoTime();
        while (flag){


            long endTime=System.nanoTime();
            long diff=endTime-startTime;
            long target=millis*1000000;

            if(diff>target){
                flag=false;

            }

           // flag=false;

        }
    }
}
