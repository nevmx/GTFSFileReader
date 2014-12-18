import java.util.*;
public class Route {
	private String long_name;
	private String type;
	private String text_color;
	private String color;
	private String agency_id;
	private String id;
	private String url;
	private String short_name;
	
	private ArrayList<Trip> route_trips = new ArrayList<Trip>();
	
	/*
	 * CONSTRUCTOR
	 */
	
	public Route(String[] fields, String[] values) throws Exception {
		if (fields.length != values.length) {
			throw new Exception();
		}
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].equals("route_long_name") ) {
				this.long_name = values[i];
			}
			else if (fields[i].equals("route_type")) {
				this.type = values[i];
			}
			else if (fields[i].equals("route_color")) {
				this.color = values[i];
			}
			else if (fields[i].equals("route_text_color")) {
				this.text_color = values[i];
			}
			else if (fields[i].equals("agency_id")) {
				this.agency_id = values[i];
			}
			else if (fields[i].equals("route_id")) {
				this.id = values[i];
			}
			else if (fields[i].equals("route_url")) {
				this.url = values[i];
			}
			else if (fields[i].equals("route_short_name")) {
				this.short_name = values[i];
			}
		}
	}
	
	/*
	 * END CONSTRUCTOR
	 */
	
	/*
	 * GETTER METHODS
	 */
	
	public String getId() {
		return this.id;
	}
	
	public ArrayList<Trip> getTripList() {
		return route_trips;
	}
	
	/*
	 * END GETTER
	 */
	
	/*
	 * ADDER (?) METHOD
	 */
	
	public void assignTripToRoute(Trip tr) {
		route_trips.add(tr);
	}
	
	public String toString() {
		String str;
		
		str = "Route " + this.long_name + " (" + this.id + ") " + " of agency " + this.agency_id;
		
		return str;
	}
	
}