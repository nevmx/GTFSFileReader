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
public class StopTime {
	private String trip_id;
	private String arrival_time;
	private String departure_time;
	private String stop_id;
	private String stop_sequence;
	private String stop_headsign;
	private String pickup_type;
	private String drop_off_type;
	private String shape_dist_traveled;
	
	private Stop stop_info;
	
	public StopTime(String[] fields, String[] values) throws Exception {
		if (fields.length != values.length) {
			throw new Exception();
		}
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].equals("trip_id") ) {
				this.trip_id = values[i];
			}
			else if (fields[i].equals("arrival_time")) {
				this.arrival_time = values[i];
			}
			else if (fields[i].equals("departure_time")) {
				this.departure_time = values[i];
			}
			else if (fields[i].equals("stop_id")) {
				this.stop_id = values[i];
			}
			else if (fields[i].equals("stop_sequence")) {
				this.stop_sequence = values[i];
			}
			else if (fields[i].equals("stop_headsign")) {
				this.stop_headsign = values[i];
			}
			else if (fields[i].equals("pickup_type")) {
				this.pickup_type = values[i];
			}
			else if (fields[i].equals("drop_off_type")) {
				this.drop_off_type = values[i];
			}
			else if (fields[i].equals("shape_dist_traveled")) {
				this.shape_dist_traveled = values[i];
			}
		}
	}
	public String getParentTripId() {
		return this.trip_id;
	}
	public String getId() {
		return this.stop_id;
	}
	public Stop getStopInfo() {
		return stop_info;
	}
	public String toString() {
		String str;
		str =  this.arrival_time + " at [" + this.stop_id + "] " + this.getStopInfo();
		return str;
	}
	public void assignStopToStopTime(Stop st) {
		this.stop_info = st;
	}
        public String getDepTime() {
            return this.departure_time;
        }
}