package iist.training.hrm.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class CharaterUtils {
	public static String nonUnicodeConvert(String str) {
		try {
			String temp = Normalizer.normalize(str, Normalizer.Form.NFD);
			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			return pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll("đ", "d");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
