package adapter2.american;

public class AmericanAddress {

	public boolean validate(String address, String zip, String state) {
		if (address.trim().length() < 10)
			return false;
		if (zip.trim().length()<5)
			return false;
		if (zip.trim().length()>10)
			return false;
		if (state.trim().length() != 2)
			return false;
		
		return true;
	}
	
}
