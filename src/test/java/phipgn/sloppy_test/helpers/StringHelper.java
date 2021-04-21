package phipgn.sloppy_test.helpers;

public class StringHelper {
	
	public static String sanitizeText(String text) {
		text = text.replaceAll("[àáạảãâầấậẩẫăằắặẳẵ]", "a");
		text = text.replaceAll("[èéẹẻẽêềếệểễ]", "e");
		text = text.replaceAll("[ìíịỉĩ]", "i");
		text = text.replaceAll("[òóọỏõôồốộổỗơờớợởỡ]", "o");
		text = text.replaceAll("[ùúụủũưừứựửữ]", "u");
		text = text.replaceAll("[ỳýỵỷỹ]", "y");
		text = text.replaceAll("[đ]", "d");
		text = text.replaceAll("[, ]", "");
		return text.toLowerCase();
	}
	
}
