import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class StopList {
	private int length;
	private String file_path;
	private Stop[] stops;
	
	public StopList(String file_path) {
		this.file_path = file_path;
		
	}
	
	public int getLength() {
		return this.length;
	}
	
	
	public String toString() {
		String result = "";
		for (int i = 0; i < this.length; i++) {
			result += stops[i].toString() + "\n";
		}
		return result;
	}
	
	public void loadStopsFromFile() throws Exception {
		String cLine;
		String[] fields;
		String[] values;
		
		FileReader fr = new FileReader(this.file_path);
		BufferedReader br = new BufferedReader(
			    new InputStreamReader(
			        new FileInputStream(this.file_path),
			        "UTF-8"));
		
		/*
		 * INITIALIZE STOPS ACCORDING TO NUMBER OF LINES
		 */
		
		int n = 0;
		
		while (br.readLine() != null) {
			n++;
		}
		this.length = n;
		stops = new Stop[n];
		
		br.close();
		/*
		 * END
		 */
		
		BufferedReader br2 = new BufferedReader( //reopen BR
			    new InputStreamReader(
			        new FileInputStream(this.file_path),
			        "UTF-8"));
		
		br2.mark(1);
		if (br2.read() != 0xFEFF)
		  br2.reset();
		
		cLine = br2.readLine();
		
		fields = cLine.split(",");
		//fields has the fields
		
		cLine = br2.readLine();
		int i = 0;
		while (cLine != null) {
			values = cLine.split(",");
			stops[i] = new Stop(fields, values);
			
			cLine = br2.readLine();
			i++;
		}
		
		this.length = i;
		
		//close the readers
		br2.close();
		fr.close();
		
	}
}