package com.wtsc.spjavatask;

import static com.wtsc.spjavatask.Discounter.decryptData;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // для хранения счётчика запусков дефолтный: <имя пакета>_preferences
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        int startsCounter = sp.getInt("startsCounter", 0);
        // проверка числа запусков приложения, обновление счётчика
        if (startsCounter < 2) {
            SharedPreferences.Editor e = sp.edit();
            startsCounter++;
            e.putInt("startsCounter", startsCounter);
            e.apply();
        } else {
            // уведомление о 3+ запуске, выравнивание по центру
            Toast toast1=Toast.makeText(getApplicationContext(),
                    getString(R.string.msg_3rd_start),
                    Toast.LENGTH_LONG);
            toast1.setGravity(Gravity.CENTER,0,0);
            toast1.show();
        }
        // Задание "Скидка" (консольная версия также в Scratches)
        TextView textView = findViewById(R.id.textView);
        int[] prices = {5,100,20,66,16};
        textView.setText("Результат: " +
                Arrays.toString(decryptData(prices, 50, 1, 3)));
    }
}