package com.gack951.Prime_Factorization;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.view.View.*;

public class Prime_FactorizationActivity extends Activity implements OnClickListener{

    /** Called when the activity is first created. */
    @Override

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		Button show_button;
		Button clear_button;
		show_button = (Button)findViewById(R.id.show_button);
		show_button.setOnClickListener(this);
		clear_button = (Button)findViewById(R.id.clear_button);
		clear_button.setOnClickListener(this);
    }

	public void onClick(View v){
		TextView textview1=(TextView)findViewById(R.id.textview1);
		EditText edit1=(EditText)findViewById(R.id.edit1);
		switch (v.getId()){
			case R.id.show_button:
				long num,w=3,sqrt_num;
				int i=0,j=1;
				String output_temp="";
				long[][] factors = new long[20][2];

				try{
					num = Long.parseLong(edit1.getText().toString());
				}
				catch (NumberFormatException e){
					return;
				}
				output_temp = Long.toString(num) + "=";
				sqrt_num = (long)(Math.sqrt(num));
				//textview1.setText(output_temp + " " + Long.toString(sqrt_num));

				if (num % 2 == 0){
					while (num % 2 == 0){
						factors[i][0] = 2;
						factors[i][1]++;
						num /= 2;
					}
					sqrt_num = (long)(Math.sqrt(num));
					i++;
				}
				while (w <= sqrt_num){
					if (num % w == 0){
						factors[i][0] = w;
						while (num % w == 0){
							factors[i][1]++;
							num /= w;
						}
						sqrt_num = (long)(Math.sqrt(num));
						i++;
					}
					w += 2;
				}

				if (i == 0){
					output_temp += "(素数)";
				}else{
					output_temp += Long.toString(factors[0][0]);
					if (factors[0][1] > 1){
						output_temp += "^" + Long.toString(factors[0][1]);
					}
					while (j < i){
						output_temp += "×" + Long.toString(factors[j][0]);
						if (factors[j][1] > 1){
							output_temp += "^" + Long.toString(factors[j][1]);
						}
						j++;
					}
					if (num != 1){
						output_temp += "×" + Long.toString(num);
					}
				}
				textview1.setText(output_temp + "\n\n" + textview1.getText().toString());
				edit1.setText("");
				break;
			case R.id.clear_button:
				textview1.setText("");
				edit1.setText("");

		}
	}
}
