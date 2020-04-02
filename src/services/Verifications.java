package services;

public class Verifications {
	private static final byte maxTextLength = 120; //max 127
	public static String verifyName(String text) {
		String res = "";
		for(int i = 0; i < text.length();i++){
			if(Character.isLetter(text.charAt(i)) || Character.isSpaceChar(text.charAt(i))) {
			res = res + text.charAt(i);
			}
		}
		return res;
	}
	public static String verifyText(String text) {
		return (text.length() <= maxTextLength)? text : text.substring(0, maxTextLength );
	}
	public static String verifyTextNumber(String text) {
		//TODO ??
		return (text.length() <= maxTextLength)? text : text.substring(0, maxTextLength );
	}
}
