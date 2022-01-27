package com.wtsc.spjavatask;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Discounter {

    public static @Nullable
    int[] decryptData(@NonNull
                      int[] price,
                      @IntRange(from = 1)
                      int discount,
                      @IntRange(from = 0)
                      int offset,
                      @IntRange(from = 1)
                      int readLength) {

        int[] result = new int[readLength];
        int counter = 0;
        if (discount < 100) {
            for (int i = offset; i < offset + readLength; i++) {
                result[counter++] = price[i] * (100 - discount) / 100;
            }
        }
        return result;
    }
}
