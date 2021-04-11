package backend.dto;

public class Shop {
	private String shopName;
	private String gu;
	private String dong;
	private double lng;
	private double lat;
	private String codeName;

	public Shop() {
		super();
	}

	public Shop(String shopName, String gu, String dong, String lng, String lat, String codeName) {
		super();
		this.shopName = shopName;
		this.gu = gu;
		this.dong = dong;
		this.lng = Double.parseDouble(lng);
		this.lat = Double.parseDouble(lat);
		this.codeName = codeName;
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

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	@Override
	public String toString() {
		return "Shop [shopName=" + shopName + ", gu=" + gu + ", dong=" + dong + ", lng=" + lng + ", lat=" + lat
				+ ", codeName=" + codeName + "]";
	}

}
