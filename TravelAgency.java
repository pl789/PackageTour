package holidaycasestudy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TravelAgency {
	public static void main(String[] args) {
	
	}
	public List<Package> generatePackageCost(String filepath)  {
		List<Package> list = new ArrayList<Package>();
		try {
			Reader reader=new FileReader(filepath);
			BufferedReader br=new BufferedReader(reader);
			String s="";
			while((s=br.readLine())!=null) {
				Package p= new Package();
				String[]a=s.split(",");
				String packageId= a[0];
				try {
					if(validate(packageId)) {
						p.setPackageId(a[0]);
						p.setSourcePlace(a[1]);
						p.setDestinationPlace(a[2]);
						p.setBasicFare(Double.parseDouble(a[3]));
						p.setNoOfDays(Integer.parseInt(a[4]));
						p.calculatePacakgeCost();
						list.add(p);
					}
				}catch(InvalidPackageIdException e) {
					System.out.println(e.getMessage());
				}
			}
	
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return list;
		}
					
		

	public boolean validate(String packageId) throws InvalidPackageIdException {
		Pattern pattern =Pattern.compile( "[a-zA-Z0-9]{3}[\\/]{1}[a-zA-Z0-9]{3}");
		Matcher m=pattern.matcher(packageId);
		if(m.matches())
			return true;
		else throw new InvalidPackageIdException("Invalid Package Id");
	}

	public List<Package> findPackagesWithMinimumNumberOfDays() {

		List<Package> list = new ArrayList<Package>();
		try {
			Connection connection = DBHandler.connect();

			PreparedStatement ps = connection.prepareStatement("select * from Package_Details where no_of_days=(select MIN(no_of_days) from Package_Details)");
            
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Package p=new Package();
				p.setPackageId(rs.getString(1));
				p.setSourcePlace(rs.getString(2));
				p.setDestinationPlace(rs.getString(3));
				p.setNoOfDays(rs.getInt(4));
				p.setPackageCost(rs.getDouble(5));
				list.add(p);
			}

				

			}catch (Exception ex) {
				System.out.println(ex.getMessage());

		} 
		
		return list;

	}


}
