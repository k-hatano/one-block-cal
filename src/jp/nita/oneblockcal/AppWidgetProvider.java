package jp.nita.oneblockcal;

import java.util.Date;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class AppWidgetProvider extends android.appwidget.AppWidgetProvider {

	static void updateWidget(Context context, AppWidgetManager manager, int id) {
		Date date = new Date();
		long time = date.getTime() - date.getTimezoneOffset() * 60 * 1000;

		int displayItem = Statics.getDisplayItem(context, id);

		RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.main);

		switch (displayItem) {
		case Statics.DISPLAY_ITEM_HEAVENLY_STEM:
			views.setTextViewText(R.id.textview_center_large, Statics.getHeavenlyStemIdeograph(context, time));
			views.setTextViewText(R.id.textview_bottom_small, Statics.getHeavenlyStemRomaji(context, time));
			break;
		case Statics.DISPLAY_ITEM_EARTHLY_BRANCH:
			views.setTextViewText(R.id.textview_center_large, Statics.getEarthlyBranchIdeograph(context, time));
			views.setTextViewText(R.id.textview_bottom_small, Statics.getEarthlyBranchRomaji(context, time));
			break;
		default:
			break;
		}

		Intent intent = new Intent(context, DialogActivity.class);
		intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, id);
		
		PendingIntent pendingIntent = PendingIntent.getActivity(context, id, intent, 0);
		views.setOnClickPendingIntent(R.id.layout_main, pendingIntent);

		manager.updateAppWidget(id, views);
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
