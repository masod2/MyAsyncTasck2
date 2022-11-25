package com.example.exmyasencylas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.exmyasencylas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        TextView tv2 = findViewById(R.id.tvtimer2);

       binding. button.setOnClickListener(v -> {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    Log.e("e",""+i);
                    SystemClock.sleep(1000);
                    int finalI = i;
                    runOnUiThread(() ->
                            binding.tvTimer.setText("first  timer :"+finalI));
                }
            });
            thread.start();
            ///////////////////////////////////////
            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    SystemClock.sleep(1000);
                    int finalI = i;
                    runOnUiThread(() -> binding.tvtimer2.setText("second  timer :"+finalI+""));
                    binding.button.setClickable(false);//ايقاف خاصية النقر على الزر لمنع حصول تعارض للقيم المعروضة على الشاشة
                }
                binding.button.setClickable(true);

            });
            thread2.start();
        });

    }
}