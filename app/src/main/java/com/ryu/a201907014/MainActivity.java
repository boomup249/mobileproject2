package com.ryu.a201907014;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] scores = {R.id.momid, R.id.mofin, R.id.moapp, R.id.moatt, R.id.jamid, R.id.jafin, R.id.jaapp, R.id.jaatt, R.id.jspmid, R.id.jspfin, R.id.jspapp, R.id.jspatt, R.id.vcmid, R.id.vcfin, R.id.vcapp, R.id.vcatt,
            R.id.sysmid, R.id.sysfin, R.id.sysapp, R.id.sysatt, R.id.dbmid, R.id.dbfin, R.id.dbapp, R.id.dbatt, R.id.menmid, R.id.menfin, R.id.menapp, R.id.menatt, R.id.osmid, R.id.osfin, R.id.osapp, R.id.osatt};
    int[] results = {R.id.mototal, R.id.moavg, R.id.jatotal, R.id.jaavg, R.id.jsptotal, R.id.jspavg, R.id.vctotal, R.id.vcavg, R.id.systotal, R.id.sysavg, R.id.dbtotal, R.id.dbavg, R.id.mentotal, R.id.menavg, R.id.ostotal, R.id.osavg};
    TextView[] res;
    EditText[] score;
    Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = new TextView[results.length];
        score = new EditText[scores.length];
        for(int i = 0; i < scores.length; i++){
            score[i] = findViewById(scores[i]);
        }
        
        for(int i = 0; i < results.length; i++){
            res[i] = findViewById(results[i]);
        }
        calc = findViewById(R.id.calc);
        calc.setOnClickListener(btnl);
    }
    View.OnClickListener btnl = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String result[] = new String[score.length];
            for(int i = 0; i < score.length; i++){
                result[i] = score[i].getText().toString();
            }
            try {
                double value[] = new double[score.length];
                for (int i = 0; i < score.length; i++) {
                    value[i] = Double.parseDouble(result[i]);
                }
                double results[] = new double[res.length];
                for (int i = 0; i < score.length / 2; i++) {
                    results[i * 2] = value[i * 4] + value[i * 4 + 1] + value[i * 4 + 2] + 20 - Math.floor(value[i * 4 + 3] / 3);
                    res[i * 2].setText(results[i * 2] + "");
                    if (100 >= results[i * 2] && results[i * 2] >= 90) {
                        res[i * 2 + 1].setText("A+");
                    } else if (89 >= results[i * 2] && results[i * 2] >= 80) {
                        res[i * 2 + 1].setText("A0");
                    } else if (79 >= results[i * 2] && results[i * 2] >= 70) {
                        res[i * 2 + 1].setText("B+");
                    } else if (69 >= results[i * 2] && results[i * 2] >= 60) {
                        res[i * 2 + 1].setText("B0");
                    } else if (59 >= results[i * 2] && results[i * 2] >= 50) {
                        res[i * 2 + 1].setText("C+");
                    } else if (49 >= results[i * 2] && results[i * 2] >= 40) {
                        res[i * 2 + 1].setText("C0");
                    } else if (39 >= results[i * 2] && results[i * 2] >= 30) {
                        res[i * 2 + 1].setText("D+");
                    } else if (29 >= results[i * 2] && results[i * 2] >= 20) {
                        res[i * 2 + 1].setText("D0");
                    } if (19 >= results[i * 2] || value[i * 4 + 3] >= 12) {
                        res[i * 2 + 1].setText("F");
                    }
                }
            }
            catch(Exception e){
                return;
            }
        }
    };
}