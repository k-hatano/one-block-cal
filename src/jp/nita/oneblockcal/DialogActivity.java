package jp.nita.oneblockcal;

import android.app.Activity;
import android.app.AlertDialog;
import android.appwidget.AppWidgetManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;

public class DialogActivity extends Activity {

	@Override
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
		Resources res = this.getResources();
		String[] items = res.getStringArray(R.array.display_items);
		
		final Activity finalActivity = this;
		final int finalWidgetId = this.getIntent().getExtras().getInt(  
                AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);  
		int currentDisplayItem = Statics.getDisplayItem(this, finalWidgetId);
		
		new AlertDialog.Builder(this).setTitle(getString(R.string.display_item))
				.setSingleChoiceItems(items, currentDisplayItem, new OnClickListener(){
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						Statics.setDisplayItem(finalActivity, finalWidgetId, arg1);
					}
				})
				.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(finalActivity);
						AppWidgetProvider.updateWidget(finalActivity, appWidgetManager, finalWidgetId);
						
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
