package holidaycasestudy;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHandler {
	public static Connection connect()
	{
		//load the driver
		//Establish connection
		Connection connection=null;
		try
		{
		Class.forName("org.postgresql.Driver");
		 connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/HolidayPackage","postgres","Sqwert@456");
		
		
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return connection;
	}
	

}
