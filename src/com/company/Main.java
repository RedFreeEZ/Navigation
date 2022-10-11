package com.company;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    private int arrsp[] = new int[5];
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // FutureTask is a concrete class that
        // implements both Runnable and Future
        // Future ��� �� �������, ������� ������ ��������� - �� ����� �� ���������� ��� ����� ������, �� ����� ������ ��� � ������� (��� ������ Callable ��������). ����� �������, Future - ���, �� ����, ���� �� ��������, � ������� �������� �������� ����� ����� ����������� �������� � ���������� ������ �������.
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
            // ���� ����� ����������� �� ��� ���, ���� �� ����� ������� ���������
            // ����� get ����� ������������ ����������� ����������
            // ��������, ����� ��� ���������. ��� � ���� �������
            // ��� ���������� ����������� throws � main


        }
    }
}
