package com.mmakowski.citron.ui.android;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * The main view for entering expressions.
 *
 */
public class ExpressionEntry extends Activity {
    final Handler resultHandler = new Handler();
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.main);
        setProgressBarIndeterminateVisibility(false);

        final EditText input = (EditText) findViewById(R.id.expression);
        final Button button = (Button) findViewById(R.id.calculate);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	CalculationThread calcThread = new CalculationThread(ExpressionEntry.this, input.getText().toString());
            	calcThread.start();
            	input.setEnabled(false);
            	button.setClickable(false);
            	setProgressBarIndeterminateVisibility(true);
            }
        });
    }
	
	void setResultFromNonUIThread(final String result) {
		resultHandler.post(new Runnable() {
			public void run() {
				setResult(result);
			}
		});
	}
	
	void setResult(String result) {
		final TextView resultView = (TextView) findViewById(R.id.result);
		resultView.setText(result);
        final Button button = (Button) findViewById(R.id.calculate);
    	button.setClickable(true); 
    	setProgressBarIndeterminateVisibility(false);
	}
}