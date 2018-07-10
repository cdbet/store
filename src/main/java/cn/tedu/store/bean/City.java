package cn.tedu.store.bean;

public class City {

	private Integer id;
	private String provinceCode;
	private String cityCode;
	private String CityName;
	public City(Integer id, String provinceCode, String cityCode, String cityName) {
		super();
		this.id = id;
		this.provinceCode = provinceCode;
		this.cityCode = cityCode;
		CityName = cityName;
	}
	public City() {
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CityName == null) ? 0 : CityName.hashCode());
		result = prime * result + ((cityCode == null) ? 0 : cityCode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((provinceCode == null) ? 0 : provinceCode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (CityName == null) {
			if (other.CityName != null)
				return false;
		} else if (!CityName.equals(other.CityName))
			return false;
		if (cityCode == null) {
			if (other.cityCode != null)
				return false;
		} else if (!cityCode.equals(other.cityCode))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (provinceCode == null) {
			if (other.provinceCode != null)
				return false;
		} else if (!provinceCode.equals(other.provinceCode))
			return false;
		return true;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", provinceCode=" + provinceCode + ", cityCode=" + cityCode + ", CityName=" + CityName
				+ "]";
	}
	
}
