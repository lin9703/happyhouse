package backend.dto;

public class House {
	private String aptName;
	private int dealAmount;
	private double area;
	private int dealYear;
	private int dealMonth;
	private int dealday;

	public House() {
		super();
	}

	public House(String aptName, int dealAmount, double area, int dealYear, int dealMonth, int dealday) {
		super();
		this.aptName = aptName;
		this.dealAmount = dealAmount;
		this.area = area;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealday = dealday;
	}
	
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public int getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(int dealAmount) {
		this.dealAmount = dealAmount;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public int getDealYear() {
		return dealYear;
	}
	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}
	public int getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}
	public int getDealday() {
		return dealday;
	}
	public void setDealday(int dealday) {
		this.dealday = dealday;
	}
	
	@Override
	public String toString() {
		return "House [aptName=" + aptName + ", dealAmount=" + dealAmount + ", area=" + area + ", dealYear=" + dealYear
				+ ", dealMonth=" + dealMonth + ", dealday=" + dealday + "]";
	}
	
}
