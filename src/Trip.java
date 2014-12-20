import java.util.*;

public class Trip {
	private String route_id;
	private String direction_id;
	private String trip_headsign;
	private String shape_id;
	private String service_id;
	private String trip_id;
	private String trip_short_name;
	
	private ArrayList<StopTime> stoptime_list = new ArrayList<StopTime>();
	
	private Calendar service_calendar;
	
	/*
	 * CONSTRUCTOR
	 */
	
	public Trip(String[] fields, String[] values) throws Exception {
		if (fields.length != values.length) {
			throw new Exception();
		}
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].equals("route_id") ) {
				this.route_id = values[i];
			}
			else if (fields[i].equals("direction_id")) {
				this.direction_id = values[i];
			}
			else if (fields[i].equals("trip_headsign")) {
				this.trip_headsign = values[i];
			}
			else if (fields[i].equals("shape_id")) {
				this.shape_id = values[i];
			}
			else if (fields[i].equals("service_id")) {
				this.service_id = values[i];
			}
			else if (fields[i].equals("trip_id")) {
				this.trip_id = values[i];
			}
			else if (fields[i].equals("trip_short_name")) {
				this.trip_short_name = values[i];
			}
			
		}
	}
		
	/*
	 * END CONSTRUCTOR
	 */
	
	/*
	 * GETTER START
	 */
	
	public String getParentRoute() {
		return this.route_id;
	}
	
	public int getID() {
		return Integer.parseInt(this.trip_id);
	}
	
	public String getServiceID() {
		return this.service_id;
	}
	
	public ArrayList<StopTime> getStopTimeList() {
		return this.stoptime_list;
	}
	public Calendar getCalendarInfo() {
		return this.service_calendar;
	}
	
	/*
	 * END GETTER
	 */
	
	/*
	 * ADDER (?) METHOD
	 */
	
	public void assignStopTimeToTrip(StopTime st) {
		stoptime_list.add(st);
	}
	
	public String getId() {
		return this.trip_id;
	}
	public String toString() {
			String str;
			str = "Trip: " + this.trip_headsign + "  " + this.trip_id + "Service: " + this.service_id + ", " + this.service_calendar;
			return str;
	}
	/*
	 * SETTER METHOD
	 */
	public void setCalendarInfo(Calendar cal) {
		this.service_calendar = cal;
	}
		
}
