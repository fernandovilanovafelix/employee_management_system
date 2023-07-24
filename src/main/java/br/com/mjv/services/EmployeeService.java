package br.com.mjv.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.mjv.entities.Employee;
import br.com.mjv.services.exceptions.EmployeeNotFoundException;

@Service
public class EmployeeService {

	Map<Long, Employee> employeesBD = new HashMap<>();

	public Employee searchEmployeeById(Long employeeId) {
		Employee employee = employeesBD.get(employeeId);

		if (employee == null)
			throw new EmployeeNotFoundException("O empregado não pôde ser encontrado.");

		return employee;
	}

	public Employee saveEmployee(Employee employee) {
		Long nextEmployeeId = employeesBD.size() + 1L;
		employee.setId(nextEmployeeId);
		employeesBD.put(nextEmployeeId, employee);
		return employeesBD.get(nextEmployeeId);
	}

	public void updateEmployee(Employee employee) {
		checkEmployeeExistence(employee);
		employeesBD.put(employee.getId(), employee);
	}

	private void checkEmployeeExistence(Employee employee) {
		searchEmployeeById(employee.getId());
	}

	public void removeEmployee(Long employeeId) {
		searchEmployeeById(employeeId);
		employeesBD.remove(employeeId);
	}
}
