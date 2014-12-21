import java.util.Scanner;

public class ReadFiles {
	public static void main(String[] args) {
		
		try {
			Agency ag = new Agency("agency.txt");
			ag.loadRoutes("routes.txt");
			ag.loadStops("stops.txt");
			ag.loadCalendars("calendar.txt");
			
			Scanner scan = new Scanner(System.in);
			String input;
			
			System.out.println(ag.getName() + " " + ag.getPhone());
			while(true){
				for (int i = 0; i < ag.getListOfRoutes().size(); i++) {
					System.out.println(ag.getListOfRoutes().get(i).toString());
				}
				
				System.out.print("Enter Route ID or exit: ");
				input = scan.nextLine();
				
				if (input.equals("exit"))
					break;
				
				ag.loadTripsOfRoute("trips.txt", input);
				
				for (int i = 0; i < ag.getListOfTrips().size(); i++) {
					System.out.println(ag.getListOfTrips().get(i).toString());
				}
				System.out.print("Enter Trip ID: ");
				input = scan.nextLine();
				
				ag.loadStopTimesOfTrip("stop_times.txt", input);
				ag.assignStopsToStopTimes();
				ag.assignCalendarsToTrips();
				
				for (int i = 0; i < ag.getListOfStopTimes().size(); i++) {
					System.out.println(ag.getListOfStopTimes().get(i).toString() + ag.getListOfStopTimes().get(i).getStopInfo().toString());
				}
				scan.nextLine();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}