
import java.sql.*;
import java.util.ArrayList;

public class SalaryStdDev {

	static {
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver").getConstructor().newInstance();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		try {
		 	Connection con = null;
		 		
	 		String dbname = args[0];
	 		String tablename = args[1];
	 		String username = args[2];
	 		String password = args[3];
	 		
	 		if(args.length == 4) {
		 		String url = "jdbc:db2://localhost:50000/" + dbname;
		 		con = DriverManager.getConnection(url,username,password);
		 	}
		 	
		 	Statement statement = con.createStatement();
		 	ResultSet rs = statement.executeQuery("SELECT SALARY FROM " + tablename);
		 	ArrayList<Float> salaryList = new ArrayList<Float>();
			while(rs.next()) {
		 		salaryList.add(rs.getFloat(1));
		 	}
		 	rs.close();
		 	statement.close();
		 	con.close();
		 	int size = salaryList.size();
		 	double mean = calculateMean(salaryList, size);
		 	double square = calculateSquare(salaryList, size);
		 	double stddev = calculateStddev(mean, square);
		 	System.out.println("Standard Deviation is = "+ stddev);
		 } catch(Exception e) {
		 	e.printStackTrace();
		 }
	 }

	private static double calculateMean(ArrayList<Float> salaryList, int size) {
		double sum = 0;
		for(int i = 0; i < size; i++) {
			sum += salaryList.get(i);
		}
		double mean = sum/size;
		return mean;
	}

	private static double calculateSquare(ArrayList<Float> salaryList, int size) {
		double sum_of_salsquare = 0;
		for(int i = 0; i < size; i++) {
			double salsquare = Math.pow(salaryList.get(i), 2);
			sum_of_salsquare += salsquare;
		}
		double mean_of_salsquare = sum_of_salsquare/size;
		return mean_of_salsquare;
	}
	
	private static double calculateStddev(double mean, double square) {
		double stddev = Math.sqrt((square - Math.pow(mean, 2)));
		return stddev;
	}

}
