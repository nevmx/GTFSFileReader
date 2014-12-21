/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gtfs.reader;

/**
 *
 * @author Max
 */
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