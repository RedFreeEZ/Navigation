package com.company;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableExample implements Callable
{   private int randomSpeed;

    public Object call() throws Exception
    {   int min = 10;
        int max = 80;
      /* Random generator = new Random();
        Integer randomSpeed = generator.nextInt(5);
        Thread.sleep(randomSpeed * 1000);*/
        randomSpeed = (new Random().nextInt(max - min) + min);
        Thread.sleep(randomSpeed*100);//

        return randomSpeed;
    }
}
