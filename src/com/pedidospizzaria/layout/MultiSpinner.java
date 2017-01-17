package com.pedidospizzaria.layout;

import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MultiSpinner extends Spinner implements OnMultiChoiceClickListener, OnCancelListener{

	private List<String> items;
	private boolean[] selected;
	private String defaultText;
	
	public MultiSpinner(Context context) {
		super(context);
	}

	public MultiSpinner(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MultiSpinner(Context context, AttributeSet attribute, int defStyle) {
		super(context, attribute, defStyle);
	}
	
	public boolean[] getSelected(){
		return selected;
	}
	
	public void onCancel(DialogInterface arg0) {
		StringBuffer spinnerBuffer = new StringBuffer();
		boolean someSelected = false;
		for (int i = 0; i < items.size(); i++) {
			if (selected[i]) {
				Log.e("teste", "no for, iten de numero: " + i + "chegou true");
				spinnerBuffer.append(items.get(i));
				spinnerBuffer.append(", ");
				someSelected = true;
			}
		}
		String spinnerText;
		if (someSelected) {
			Log.e("teste", "boolean someUnselected chegou false");
			spinnerText = spinnerBuffer.toString();
			if (spinnerText.length() > 2) {
				spinnerText = spinnerText.substring(0, spinnerText.length() - 2);
			}
		} else {
			Log.e("teste", "boolean someUnselected chegou true");
			spinnerText = defaultText;
		}
		ArrayAdapter<String>adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, new String[] {spinnerText});
		setAdapter(adapter);
	}
	
	
	public void onClick(DialogInterface arg0, int arg1, boolean arg2) {
		if (arg2) {
			selected[arg1] = true;
		} else {
			selected[arg1] = false;
		}
		
	}
	
	@Override
	public boolean performClick() {
		AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
		builder.setMultiChoiceItems(items.toArray(new CharSequence[items.size()]), selected, this);
		builder.setPositiveButton(android.R.string.ok, 
				new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int arg1) {
						dialog.cancel();
					}
				});
		builder.setOnCancelListener(this);
		builder.show();
		return true;
	}
	
	public void setItems(List<String> items, String allText) {
		this.items = items;
		this.defaultText = allText;

		// all selected by default
		selected = new boolean[items.size()];

		// all text on the spinner
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
				android.R.layout.simple_spinner_item, new String[] { allText });
		setAdapter(adapter);
	}

}
