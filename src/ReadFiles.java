public class ReadFiles {
	public static void main(String[] args) {
		
		try {
			Agency ag = new Agency("agency.txt");
			ag.loadRoutes("routes.txt");
			ag.loadTrips("trips.txt");
			//ag.assignTripsToRoutes();
			ag.loadStopTimes("stop_times.txt");
			//ag.assignStopTimesToTrips();
			ag.loadStops("stops.txt");
			//ag.assignStopsToStopTimes();
			ag.loadCalendars("calendar.txt");
			//ag.assignCalendarsToTrips();
			
			
			for (int i = 0; i < ag.getListOfRoutes().size(); i++) {
				System.out.println(ag.getListOfRoutes().get(i));
				
				for (int j = 0; j < ag.getListOfRoutes().get(i).getTripList().size(); j++) {
					
					System.out.println(" "+ag.getListOfRoutes().get(i).getTripList().get(j));
					
					for (int k = 0; k < ag.getListOfRoutes().get(i).getTripList().get(j).getStopTimeList().size(); k++){
						System.out.println("   " + ag.getListOfRoutes().get(i).getTripList().get(j).getStopTimeList().get(k) + " name: " + ag.getListOfRoutes().get(i).getTripList().get(j).getStopTimeList().get(k).getStopInfo().getName());
				
					}
				}
				
				
			}
			
			System.out.println(ag.getListOfRoutes().size() + " routes");
			System.out.println(ag.getListOfTrips().size() + " trips");

			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}