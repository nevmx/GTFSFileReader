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
import java.util.Arrays;
public class Calendar {
	private String service_id;
	
	private String start_date;
	private String end_date;
	
	private boolean[] week = new boolean[7];

	/*
	 * GETTER
	 */
	
	public String getServiceID() {
		return this.service_id;
	}
	public String getStartDate() {
		return this.start_date;
	}
	public String getEndDate() {
		return this.end_date;
	}
	public boolean[] getWeek() {
		return this.week;
	}
	
	/*
	 * END GETTER
	 */
	
	/*
	 * CONSTRUCTOR
	 */
	public Calendar(String[] fields, String[] values) throws Exception {
		Arrays.fill(week, false); //fill the week array with false values - no service
		if (fields.length != values.length) {
			throw new Exception();
		}
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].equals("service_id") ) {
				this.service_id = values[i];
			}
			else if (fields[i].equals("start_date")) {
				this.start_date = values[i];
			}
			else if (fields[i].equals("end_date")) {
				this.end_date = values[i];
			}
			else if (fields[i].equals("monday")) {
				this.week[0] = binaryToBool(values[i]);
			}
			else if (fields[i].equals("tuesday")) {
				this.week[1] = binaryToBool(values[i]);
			}
			else if (fields[i].equals("wednesday")) {
				this.week[2] = binaryToBool(values[i]);
			}
			else if (fields[i].equals("thursday")) {
				this.week[3] = binaryToBool(values[i]);
			}
			else if (fields[i].equals("friday")) {
				this.week[4] = binaryToBool(values[i]);
			}
			else if (fields[i].equals("saturday")) {
				this.week[5] = binaryToBool(values[i]);
			}
			else if (fields[i].equals("sunday")) {
				this.week[6] = binaryToBool(values[i]);
			}
		}
		
	}
	private static boolean binaryToBool(String str) throws Exception {
		if (str.equals("0")) {
			return false;
		}
		else if (str.equals("1")) {
			return true;
		}
		else throw new Exception();
	}
	/*
	 * END CONSTRUCTOR
	 */
	public String toString() {
		String str = "";
		
		//str+="From " + this.start_date + " to " + this.end_date + " on ";
		
		if (week[0] == true) {
			str+=" Mon";
		}
		if (week[1] == true) {
			str+=" Tue";
		}
		if (week[2] == true) {
			str+=" Wed";
		}
		if (week[3] == true) {
			str+=" Thu";
		}
		if (week[4] == true) {
			str+=" Fri";
		}
		if (week[5] == true) {
			str+=" Sat";
		}
		if (week[6] == true) {
			str+=" Sun";
		}
		
		return str;
	}
}