package jp.nita.oneblockcal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;

public class Statics {
	final static long MILLISECS_PER_DAY = 1000 * 60 * 60 * 24;
	final static long HEAVENLY_STEM_OFFSET = 7;
	final static long EARTHLY_BRANCH_OFFSET = 5;

	public static final String PREF_KEY = "ONE_BLOCK_CAL";
	public static final String PREF_DISPLAY_ITEM = "DISPLAY_ITEM";
	public static final String PREF_DISPLAY_ITEM_PREFIX = "DISPLAY_ITEM_";
	
	public static final String EXTRA_WIDGET_ID = "WIDGET_ID";
	
	public static final int DISPLAY_ITEM_HEAVENLY_STEM = 0;
	public static final int DISPLAY_ITEM_EARTHLY_BRANCH = 1;

	public static String getHeavenlyStemIdeograph(Context context, long time) {
		Resources res = context.getResources();
		String[] stems = res.getStringArray(R.array.heavenly_stems_ideograph);
		
		long day = time / MILLISECS_PER_DAY;
		int index = (int)((day + HEAVENLY_STEM_OFFSET) % 10);
		return stems[index];
	}
	
	public static String getHeavenlyStemRomaji(Context context, long time) {
		Resources res = context.getResources();
		String[] stems = res.getStringArray(R.array.heavenly_stems_romaji);
		
		long day = time / MILLISECS_PER_DAY;
		int index = (int)((day + HEAVENLY_STEM_OFFSET) % 10);
		return stems[index];
	}

	public static String getEarthlyBranchIdeograph(Context context, long time) {
		Resources res = context.getResources();
		String[] stems = res.getStringArray(R.array.earthly_branch_ideograph);
		
		long day = time / MILLISECS_PER_DAY;
		int index = (int)((day + EARTHLY_BRANCH_OFFSET) % 12);
		return stems[index];
	}
	
	public static String getEarthlyBranchRomaji(Context context, long time) {
		Resources res = context.getResources();
		String[] stems = res.getStringArray(R.array.earthly_branch_romaji);
		
		long day = time / MILLISECS_PER_DAY;
		int index = (int)((day + EARTHLY_BRANCH_OFFSET) % 12);
		return stems[index];
	}
	
	public static int getDisplayItem(Context context, int widgetId) {
		SharedPreferences pref = context.getSharedPreferences(PREF_KEY, Activity.MODE_PRIVATE);
		return pref.getInt(Statics.PREF_DISPLAY_ITEM_PREFIX + widgetId, 0);
	}
	
	public static void setDisplayItem(Context context, int widgetId, int displayItem) {
		SharedPreferences pref = context.getSharedPreferences(PREF_KEY, Activity.MODE_PRIVATE);
		Editor editor = pref.edit();
		editor.putInt(Statics.PREF_DISPLAY_ITEM_PREFIX + widgetId, displayItem);
		editor.commit();
	}
	
}
