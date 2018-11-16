package jp.nita.oneblockcal;

import android.content.Context;
import android.content.res.Resources;

public class Statics {
	final static long MILLISECS_PER_DAY = 1000 * 60 * 60 * 24;
	final static long HEAVENLY_STEM_OFFSET = 7;

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
	
}
