package com.company;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    private int arrsp[] = new int[5];
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // FutureTask is a concrete class that
        // implements both Runnable and Future
        // Future как об объекте, который хранит результат - он может не удерживать его пр€мо сейчас, но будет делать это в будущем (как только Callable вернетс€). “аким образом, Future - это, по сути, один из способов, с помощью которого основной поток может отслеживать прогресс и результаты других потоков.
        FutureTask[] randomNumberTasks = new FutureTask[5];

        for (int i = 0; i < 5; i++)
        {
            CallableExample callable = new CallableExample();

            // Create the FutureTask with Callable
            randomNumberTasks[i] = new FutureTask(callable);

            // As it implements Runnable, create Thread
            // with FutureTask
            Thread t = new Thread(randomNumberTasks[i]);
            t.start();

        }
        for (int i = 0; i < 5; i++)
        {
            // As it implements Future, we can call get()
            System.out.println(randomNumberTasks[i].get());
            // Ётот метод блокируетс€ до тех пор, пока не будет получен результат
            // ћетод get может генерировать проверенные исключени€
            // нравитс€, когда его прерывают. Ёто и есть причина
            // дл€ добавлени€ предложени€ throws в main


        }
    }
}
