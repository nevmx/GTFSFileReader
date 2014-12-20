import java.io.*;
import java.util.*;

public class Agency {
	private String agency_id;
	private String agency_name;
	private String agency_url;
	private String agency_timezone;
	private String agency_lang;
	private String agency_phone;
	private String agency_fare_url;
	private String file_path;
	
	private ArrayList<Route> routes = new ArrayList<Route>();
	
	private ArrayList<Trip> trips = new ArrayList<Trip>();
	
	private ArrayList<StopTime> stoptimes = new ArrayList<StopTime>();
	
	private ArrayList<Stop> stops = new ArrayList<Stop>();
	
	private ArrayList<Calendar> cals = new ArrayList<Calendar>();
	
	/*
	 * CONSTRUCTOR TODO: Add other attributes according to GTFS specs
	 */

	public Agency(String file_path) throws Exception {
		this.file_path = file_path;
		
		String cLine;
		String[] fields;
		String[] values;
		
		FileReader fr = new FileReader(this.file_path);
		BufferedReader br = new BufferedReader(
			    new InputStreamReader(
			        new FileInputStream(this.file_path),
			        "UTF-8"));
		
		br.mark(1);
		if (br.read() != 0xFEFF)
		  br.reset();
		
		cLine = br.readLine(); //read fields line
		fields = cLine.split(",",-1); //split all fields
		
		cLine = br.readLine(); //same for values
		values = cLine.split(",",-1);
		
		if (fields.length != values.length) {
			br.close();
			fr.close();
			throw new Exception();
		}
		
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].equals("agency_id") ) {
				this.agency_id = values[i];
			}
			else if (fields[i].equals("agency_name")) {
				this.agency_name = values[i];
			}
			else if (fields[i].equals("agency_url")) {
				this.agency_url = values[i];
			}
			else if (fields[i].equals("agency_timezone")) {
				this.agency_timezone = values[i];
			}
			else if (fields[i].equals("agency_lang")) {
				this.agency_lang = values[i];
			}
			else if (fields[i].equals("agency_fare_url")) {
				this.agency_fare_url = values[i];
			}
			else if (fields[i].equals("agency_phone")) {
				this.agency_phone = values[i];
			}
		}
		br.close();
		fr.close();
		
	}
	
	/*
	 * GETTER METHODS
	 */
	
	public String getID() {
		return this.agency_id;
	}
	public String getURL() {
		return this.agency_url;
	}
	public String getName() {
		return this.agency_name;
	}
	public String getTimezone() {
		return this.agency_timezone;
	}
	public String getLang() {
		return this.agency_lang;
	}
	public String getPhone() {
		return this.agency_phone;
	}
	public String getFareURL() {
		return this.agency_fare_url;
	}
	
	/*
	 * ROUTES
	 */
	
	public Route getRoute(String id) {
		Route r;
		for (int i = 0; i < routes.size(); i++) {
			r = routes.get(i);
			if (r.getId().equals(id))
				return r;
		}
		return null;
	}
	
	public int getNumberRoutes() {
		return this.routes.size();
	}
	
	public ArrayList<Route> getListOfRoutes() {
		
		return this.routes;
		
	}
	
	/*
	 * END ROUTES
	 */
	
	
	/*
	 * TRIPS
	 */
	
	
	public int getNumberTrips() {
		return this.trips.size();
	}
	
	public ArrayList<Trip> getListOfTrips() {
		
		return this.trips;
		
	}
	
	/*
	 * END TRIPS
	 */
	
	/*
	 * END GETTER METHODS
	 */
	
	/*
	 * SETTER METHODS
	 */
	
	
	
	/*
	 * END SETTER METHODS
	 */
	public void loadRoutes(String rt_file_path) throws Exception {
		String cLine;
		String[] fields;
		String[] values;
		
		BufferedReader br = new BufferedReader(
			    new InputStreamReader(
			        new FileInputStream(rt_file_path),
			        "UTF-8"));
		br.mark(1);
		if (br.read() != 0xFEFF)
		  br.reset();
		
		cLine = br.readLine();
		
		fields = cLine.split(",", -1);
		cLine = br.readLine();
		while (cLine != null) {
			values = cLine.split(",", -1);
			routes.add(new Route(fields, values));
			
			cLine = br.readLine();
		}
		
		
		//close the readers
		br.close();
	}
	
	public void loadTrips(String tr_file_path) throws Exception {
		String cLine;
		String[] fields;
		String[] values;
		
		BufferedReader br = new BufferedReader(
			    new InputStreamReader(
			        new FileInputStream(tr_file_path),
			        "UTF-8"));
		
		br.mark(1);
		if (br.read() != 0xFEFF)
		  br.reset();
		//--------
		cLine = br.readLine();
		
		fields = cLine.split(",", -1);
		cLine = br.readLine();
		while (cLine != null) {
			values = cLine.split(",", -1);
			trips.add(new Trip(fields, values));
			
			cLine = br.readLine();
		}
		
		
		//close the readers
		br.close();
	}
	
	public void loadTripsOfRoute(String tr_file_path, String route_id) throws Exception {
		String cLine;
		String[] fields;
		String[] values;
		
		BufferedReader br = new BufferedReader(
			    new InputStreamReader(
			        new FileInputStream(tr_file_path),
			        "UTF-8"));
		
		br.mark(1);
		if (br.read() != 0xFEFF)
		  br.reset();
		//--------
		cLine = br.readLine();
		
		fields = cLine.split(",", -1);
		
		/*
		 * Figure out at what index the route_id is
		 */
		
		int rt_i = Utilities.getIndexOfField(fields, "route_id");
		
		if (rt_i == -1) {
			br.close();
			throw new Exception();
		}
		cLine = br.readLine();
		while (cLine != null) {
			values = cLine.split(",", -1);
			
			if (values[rt_i].equals(route_id)) { //only if the route_id is the one we're looking for, add Trip
				trips.add(new Trip(fields, values));
			}
			
			cLine = br.readLine();
		}
		
		
		//close the readers
		br.close();
	}
	
	public void assignTripsToRoutes() {
		String parent_rt;
		for (int i = 0; i < trips.size(); i++) {
			parent_rt = trips.get(i).getParentRoute();
			for (int j = 0; j < routes.size(); j++) {
				if (routes.get(j).getId().equals(parent_rt)) {
					routes.get(j).assignTripToRoute(trips.get(i));
				}
			}
		}
	}
	
	public void loadStopTimes(String st_file_path) throws Exception {
		String cLine;
		String[] fields;
		String[] values;
		
		BufferedReader br = new BufferedReader(
			    new InputStreamReader(
			        new FileInputStream(st_file_path),
			        "UTF-8"));
		
	
		br.mark(1);
		if (br.read() != 0xFEFF)
		  br.reset();
		
		cLine = br.readLine();
		
		fields = cLine.split(",", -1);
		cLine = br.readLine();
		while (cLine != null) {
			values = cLine.split(",",-1);
			stoptimes.add(new StopTime(fields, values));
			
			cLine = br.readLine();
		}

		
		//close the readers
		br.close();
	}
	
	
	public void loadStopTimesOfTrip(String st_file_path, String trip_id) throws Exception {
		String cLine;
		String[] fields;
		String[] values;
		
		BufferedReader br = new BufferedReader(
			    new InputStreamReader(
			        new FileInputStream(st_file_path),
			        "UTF-8"));
		
	
		br.mark(1);
		if (br.read() != 0xFEFF)
		  br.reset();
		
		cLine = br.readLine();
		
		fields = cLine.split(",", -1);
		
		int tr_i = Utilities.getIndexOfField(fields, "trip_id");
		
		cLine = br.readLine();
		while (cLine != null) {
			values = cLine.split(",",-1);
			
			if (values[tr_i].equals(trip_id)) {
				stoptimes.add(new StopTime(fields, values));
			}
			
			cLine = br.readLine();
		}

		
		//close the readers
		br.close();
	}
	
	public void assignStopTimesToTrips() {
		for (int i = 0; i < stoptimes.size(); i++) {
			String trip = stoptimes.get(i).getParentTripId();
			for (int j = 0; j < trips.size(); j++) {
				if (trip.equals(trips.get(j).getId())) {
					trips.get(j).assignStopTimeToTrip((stoptimes.get(i)));
				}
			}
		}
	}
	
	public void loadStops(String stop_file_path) throws Exception {
		String cLine;
		String[] fields;
		String[] values;
		
		BufferedReader br = new BufferedReader(
			    new InputStreamReader(
			        new FileInputStream(stop_file_path),
			        "UTF-8"));
		
	
		br.mark(1);
		if (br.read() != 0xFEFF)
		  br.reset();
		
		cLine = br.readLine();
		
		fields = cLine.split(",", -1);
		cLine = br.readLine();
		while (cLine != null) {
			values = cLine.split(",",-1);
			stops.add(new Stop(fields, values));
			
			cLine = br.readLine();
		}

		
		//close the readers
		br.close();
	}
	
	public void loadStopsOf(String stop_file_path) throws Exception {
		String cLine;
		String[] fields;
		String[] values;
		
		BufferedReader br = new BufferedReader(
			    new InputStreamReader(
			        new FileInputStream(stop_file_path),
			        "UTF-8"));
		
	
		br.mark(1);
		if (br.read() != 0xFEFF)
		  br.reset();
		
		cLine = br.readLine();
		
		fields = cLine.split(",", -1);
		cLine = br.readLine();
		while (cLine != null) {
			values = cLine.split(",",-1);
			stops.add(new Stop(fields, values));
			
			cLine = br.readLine();
		}

		
		//close the readers
		br.close();
	}
	
	public void assignStopsToStopTimes() {
		for (int i = 0; i < stops.size(); i++) {
			String stop_id = stops.get(i).getId();
			for (int j = 0; j < stoptimes.size(); j++) {
				if (stop_id.equals(stoptimes.get(j).getId())) {
					stoptimes.get(j).assignStopToStopTime((stops.get(i)));
				}
			}
		}
	}
	public void loadCalendars(String cal_file_path) throws Exception {
		String cLine;
		String[] fields;
		String[] values;
		
		BufferedReader br = new BufferedReader(
			    new InputStreamReader(
			        new FileInputStream(cal_file_path),
			        "UTF-8"));
		
	
		br.mark(1);
		if (br.read() != 0xFEFF)
		  br.reset();
		
		cLine = br.readLine();
		
		fields = cLine.split(",", -1);
		cLine = br.readLine();
		while (cLine != null) {
			values = cLine.split(",",-1);
			cals.add(new Calendar(fields, values));
			
			cLine = br.readLine();
		}

		
		//close the readers
		br.close();
	}
	public void assignCalendarsToTrips() {
		for (int i = 0; i < cals.size(); i++) {
			String stop_id = cals.get(i).getServiceID();
			for (int j = 0; j < trips.size(); j++) {
				if (stop_id.equals(trips.get(j).getServiceID())) {
					trips.get(j).setCalendarInfo((cals.get(i)));
				}
			}
		}
	}
	
}