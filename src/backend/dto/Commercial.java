package backend.dto;

public class Commercial {
	private String shopName;
	private String city;
	private String gu;
	private String dong;
	private String lng;
	private String lat;
	
	public Commercial() {
		super();
	}

	public Commercial(String shopName, String city, String gu, String dong, String lng, String lat) {
		super();
		this.shopName = shopName;
		this.city = city;
		this.gu = gu;
		this.dong = dong;
		this.lng = lng;
		this.lat = lat;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	
	
}
