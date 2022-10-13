package holidaycasestudy;

public class Package {

		
	
	private String packageId;
	private String sourcePlace;
	private String destinationPlace;
	private double basicFare;
	private int noOfDays;
	private double packageCost;

	


public String getPackageId() {
		return packageId;
	}




	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}




	public String getSourcePlace() {
		return sourcePlace;
	}




	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}




	public String getDestinationPlace() {
		return destinationPlace;
	}




	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}




	public double getBasicFare() {
		return basicFare;
	}




	public void setBasicFare(double basicFare) {
		this.basicFare = basicFare;
	}




	public int getNoOfDays() {
		return noOfDays;
	}




	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}




	public double getPackageCost() {
		return packageCost;
	}




	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}




public void calculatePacakgeCost() {
	if(this.noOfDays<=5)
	{
		this.packageCost= this.basicFare*this.noOfDays;
	}
	if(this.noOfDays>5 && this.noOfDays<=8)
	{
		this.packageCost= this.basicFare*this.noOfDays*0.97;
	}
	if(this.noOfDays>8 && this.noOfDays<=10)
	{
		this.packageCost= this.basicFare*this.noOfDays*0.95;
	}
	if(this.noOfDays>5)
	{
		this.packageCost= this.basicFare*this.noOfDays*0.93;
	}
	
	this.packageCost*=1.12;
}


}
