package Class;

public class ThuVienChung {
	
	public static boolean isValidateInput(String s){
		for(int i=0;i<s.length();i++){
			if( s.charAt(i)<'0' || (s.charAt(i)> '9' && s.charAt(i) < 'A') || s.charAt(i) > 'z' || (s.charAt(i) > 'Z' && s.charAt(i) < 'a')){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isOverMaxLength(String s){
		return (s.length()>100)?true:false;
	}
	
}
