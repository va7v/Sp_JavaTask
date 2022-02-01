package com.wtsc.spjavatask;

import static com.wtsc.spjavatask.Discounter.decryptData;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final String MY_SETTINGS = "my_settings";
    private static final String STARTS_COUNTER = "starts_counter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // проверка: запущено ли приложение впервые
        if (savedInstanceState == null)
        {
            SharedPreferences sp = getSharedPreferences(MY_SETTINGS,
                    Context.MODE_PRIVATE);
            int startsCounter = sp.getInt(STARTS_COUNTER, 0);
            // уведомление о 3-м запуске, выравнивание по центру
            if (startsCounter == 3) {
                Toast toast1=Toast.makeText(getApplicationContext(),
                        getString(R.string.msg_3rd_start),
                        Toast.LENGTH_LONG);
                toast1.setGravity(Gravity.CENTER,0,0);
                toast1.show();
            }
            // обновление счётчика запусков приложения
            SharedPreferences.Editor e = sp.edit();
            startsCounter++;
            e.putInt(STARTS_COUNTER, startsCounter);
            e.apply();
        }

        // Задание "Скидка" (консольная версия также в Scratches)
        TextView textView = findViewById(R.id.textView);
        int[] prices = {5,100,20,66,16};
        textView.setText(getString(R.string.test_result) +
                Arrays.toString(decryptData(prices, 50, 1, 3)));
    }
}