package backend.dto;

public class Shop {
	private String shopName;
	private String gu;
	private String dong;
	private double lng;
	private double lat;
	
	public Shop() {
		super();
	}

	public Shop(String shopName, String gu, String dong, String lng, String lat) {
		super();
		this.shopName = shopName;
		this.gu = gu;
		this.dong = dong;
		this.lng = Double.parseDouble(lng);
		this.lat = Double.parseDouble(lat);
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getGu() {
		return gu;
	}

	public void setGu(String gu) {
		this.gu = gu;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "Shop [shopName=" + shopName + ", gu=" + gu + ", dong=" + dong + ", lng=" + lng + ", lat=" + lat + "]";
	}
	
}
