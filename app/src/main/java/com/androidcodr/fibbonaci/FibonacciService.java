package com.androidcodr.fibbonaci;

import android.os.Handler;
import android.os.Looper;

public class FibonacciService {

    interface OnFibonacciCalculated {
        void onResult(int result);
    }

    public void calculateFibonacci(final int term, final OnFibonacciCalculated callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Calculeaza termenul din seria Fibonacci
                int result = calculateFib(term);

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onResult(result);
                    }
                });
            }
        }).start();
    }

    private int calculateFib(int n) {
        if (n <= 1) {
            return n;
        }
        return calculateFib(n - 1) + calculateFib(n - 2);
    }
}

