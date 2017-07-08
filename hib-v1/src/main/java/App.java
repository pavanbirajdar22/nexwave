import com.hib.dao.EmployeeDAO;
import com.hib.model.Employee;

public class App {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		Employee employee =new Employee();
		employee.setId(2);
		employee.setFirstName("Amol");
		employee.setLastName("B");
		dao.save(employee);
	}

}
