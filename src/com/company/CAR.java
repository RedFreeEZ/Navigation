package com.company;

import java.util.Random;
import java.util.concurrent.Callable;

public class CAR implements Runnable {
    private int min = 10;
    private int max = 80;
    private int km;
    private int time = 0;
    private int speed = 0;
    private int sr = 0;
    private int speedForM = 0;

    private Random randomSpeed = new Random();

    public CAR(int km) {
        this.km = km * 1000;
    }

    public int getkm() {
        return km;
    }

    @Override
    public void run() {
        while (km > 0) {
            speed = randomSpeed.nextInt(max - min) + min;
            km = km - speed;
            time = time + 1;
            speedForM = speedForM + speed;
            sr = speedForM / time;

            double ost = km / sr;

            System.out.println("Осталось: " + getkm() + "м" + " Скорость: " + speed + " Время: " + time + " Средняя скорость: " + sr + " Время прибытия: " + ost);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
