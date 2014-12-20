import java.util.Scanner;

public class ReadFiles {
	public static void main(String[] args) {
		
		try {
			Agency ag = new Agency("agency.txt");
			ag.loadRoutes("routes.txt");
			//ag.loadTrips("trips.txt");
			//ag.loadTripsOfRoute("trips.txt", "152-170");
			//ag.assignTripsToRoutes();
			//ag.loadStopTimesOfTrip("stop_times.txt", "32256431-SEPT14-SEP14DA-Weekday-10");
			//ag.assignStopTimesToTrips();
			ag.loadStops("stops.txt");
			//ag.assignStopsToStopTimes();
			ag.loadCalendars("calendar.txt");
			//ag.assignCalendarsToTrips();
			
			/*
			for (int i = 0; i < ag.getListOfRoutes().size(); i++) {
				System.out.println(ag.getListOfRoutes().get(i));
				
				for (int j = 0; j < ag.getListOfRoutes().get(i).getTripList().size(); j++) {
					
					System.out.println(" "+ag.getListOfRoutes().get(i).getTripList().get(j));
					
					for (int k = 0; k < ag.getListOfRoutes().get(i).getTripList().get(j).getStopTimeList().size(); k++){
						System.out.println("   " + ag.getListOfRoutes().get(i).getTripList().get(j).getStopTimeList().get(k) + " name: " + ag.getListOfRoutes().get(i).getTripList().get(j).getStopTimeList().get(k).getStopInfo().getName());
				
					}
				}
				
				
			}
			*/
			
			System.out.println("Agency: " + ag.getName() + " . Available Routes: ");
			
			for (int i = 0; i < ag.getListOfRoutes().size(); i++) {
				System.out.println(ag.getListOfRoutes().get(i).toString());
			}
			System.out.print("Enter Route: ");

			
			
			Scanner s = new Scanner(System.in);
			String input = s.nextLine();
			
			
			ag.loadTripsOfRoute("trips.txt", input);
			ag.assignCalendarsToTrips();
			
			for(int i = 0; i < ag.getListOfTrips().size(); i++) {
				System.out.println(ag.getListOfTrips().get(i).toString());
			}
			
			System.out.print("Enter Trip: ");
			input = s.nextLine();
			ag.loadStopTimesOfTrip("stop_times.txt", input);
			ag.assignStopsToStopTimes();
			
			
			for(int i = 0; i < ag.getListOfStopTimes().size(); i++) {
				System.out.println(ag.getListOfStopTimes().get(i).toString() + ag.getListOfStopTimes().get(i).getStopInfo());
			}
			
			s.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}