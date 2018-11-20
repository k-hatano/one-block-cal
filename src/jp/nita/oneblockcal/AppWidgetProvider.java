package jp.nita.oneblockcal;

import java.util.Date;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

public class AppWidgetProvider extends android.appwidget.AppWidgetProvider {

	static void updateWidget(Context context, AppWidgetManager manager, int id) {
		Date date = new Date();
		long time = date.getTime() + date.getTimezoneOffset() * 60 * 1000;
		
		RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.main);
		views.setTextViewText(R.id.textview_center_large, Statics.getHeavenlyStemIdeograph(context, time));
		views.setTextViewText(R.id.textview_bottom_small, Statics.getHeavenlyStemRomaji(context, time));
		
		ComponentName widget = new ComponentName(context, AppWidgetProvider.class);
        manager.updateAppWidget(widget, views);
	}
	
	@Override
	public void onUpdate(Context context, AppWidgetManager manager, int ids[]) {
		super.onUpdate(context, manager, ids);
		for (int id : ids) {
			updateWidget(context, manager, id);
        }
		
		return;
	}
	
}
