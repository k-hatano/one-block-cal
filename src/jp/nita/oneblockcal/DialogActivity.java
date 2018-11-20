package jp.nita.oneblockcal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;

public class DialogActivity extends Activity {

	@Override
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
		new AlertDialog.Builder(this).setTitle(getString(R.string.app_name))
				.setMessage(getString(R.string.message))
				.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();
					}
				})
				.setOnCancelListener(new OnCancelListener(){
					@Override
					public void onCancel(DialogInterface arg0) {
						arg0.dismiss();
						finish();
					}
				})
				.show();
	}
	
}
