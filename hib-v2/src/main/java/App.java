abstract class A extends B{
	
}
public class App {

	public static void main(String[] args) {
		OfficesHome officesHome = new OfficesHome();
		Offices office = new Offices();
		office.setAddressLine1("A");
		office.setAddressLine2("B");
		office.setCity("KOP");
		office.setCountry("INDIA");
		office.setOfficeCode("8");
		office.setPhone("+44 20 7877 2041");
		office.setPostalCode("213212");
		office.setState("MAH");
		office.setTerritory("ASIA");
		officesHome.persist(office);
	}

}