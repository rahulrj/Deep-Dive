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
	
	// 1.The Android implementation is also almost same. Apart from that, it also handles concurrency conditions. But what if a processor
	 // takes less than 1 nanoseconds to reach from startTime to endTime. In that case, it will fail.
	 
	 //2. And also when the parameter (millis) that we pass has the maximum value for a long, then also multiplying it with 10^6 will overflow.
	 
	 
	 // Nannos is for extra nanosecond precesion
	 public static void javaImpl(long mills,int nanos){
		 
		long start = System.nanoTime();
        long duration = (millis * NANOS_PER_MILLI) + nanos;

        Object lock = currentThread().lock;

        // Wait may return early, so loop until sleep duration passes.
        synchronized (lock) {
            while (true) {
                sleep(lock, millis, nanos);

                long now = System.nanoTime();
                long elapsed = now - start;

                if (elapsed >= duration) {
                    break;
                }

                duration -= elapsed;
                start = now;
                millis = duration / NANOS_PER_MILLI;
                nanos = (int) (duration % NANOS_PER_MILLI);
            }
        }
		 
		 
		 
	 }
	 
	 
	
}
