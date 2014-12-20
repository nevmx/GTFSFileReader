public class Utilities {
	public static int getIndexOfField(String[] fields, String field) {
			
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].equals(field)) {
				return i;
			}
		}
		
		return -1;
	}
}