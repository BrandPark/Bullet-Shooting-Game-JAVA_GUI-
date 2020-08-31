package step4_ingame.staticSrc;

public abstract class ImageUrl {
	
	private static final int USER_UNIT1 = 1;
	
	public static final String getImgUrl(int code) {
		switch(code) {
		case 1: return "resource/img_unit/user_unit.png";
		}
		return null;
	}
	
	
	
	
}
