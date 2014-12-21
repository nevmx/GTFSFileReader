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
public class Stop {
	
	private String id;
	private String code;
	private String name;
	//private String desc;
	private String lat;
	private String lon;
	private String zone_id;
	//private String url;
	private String location_type;
	//private String parent_station;
	//private String timezone;
	//private String wheelchair;
	
	/*
	 * GETTER METHODS
	 */
	
	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getCode() {
		return this.code;
	}
	public String getLat() {
		return this.lat;
	}
	public String getLon() {
		return this.lon;
	}
	public String getZoneID() {
		return this.zone_id;
	}
	public String getLocType() {
		return this.location_type;
	}
	
	/*
	 * END GETTER METHODS
	 */
	
	public String toString() {
		String str;
		str = " Stop ID: [" + this.id + "] at " + this.name;
		return str;
	}
	
	public Stop(String[] fields, String[] values) throws Exception {
		if (fields.length != values.length) {
			throw new Exception();
		}
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].equals("stop_name") ) {
				this.name = values[i];
			}
			else if (fields[i].equals("stop_code")) {
				this.code = values[i];
			}
			else if (fields[i].equals("stop_lat")) {
				this.lat = values[i];
			}
			else if (fields[i].equals("stop_id")) {
				this.id = values[i];
			}
			else if (fields[i].equals("stop_lon")) {
				this.lon = values[i];
			}
			else if (fields[i].equals("zone_id")) {
				this.zone_id = values[i];
			}
			else if (fields[i].equals("location_type")) {
				this.location_type = values[i];
			}
		}
		
	}
	
	
}