package br.com.mjv.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mjv.entities.Employee;
import br.com.mjv.services.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
@Tag(name = "Management's Employee System", description = "APIs for Employees Integration")
public class EmployeeResource {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.POST)
	@Operation(summary = "Create a new Employee")
	@ApiResponse(responseCode = "201", description = "Created")
	public ResponseEntity<Void> save(@Valid @RequestBody Employee employee) {
		employee = employeeService.saveEmployee(employee);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@Operation(summary = "GET an Employee by Id")
	@ApiResponse(responseCode = "200", description = "OK", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class)) })
	public ResponseEntity<?> search(@PathVariable("id") Long id) {
		Employee employee = employeeService.searchEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Operation(summary = "REMOVE an Employee by Id")
	@ApiResponse(responseCode = "204", description = "No Content")
	public ResponseEntity<Void> remove(@PathVariable("id") Long id) {
		employeeService.removeEmployee(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@Operation(summary = "UPDATE an Employee by Id")
	@ApiResponse(responseCode = "204", description = "No Content")
	public ResponseEntity<Void> atualizar(@RequestBody Employee employee, @PathVariable("id") Long id) {
		employee.setId(id);
		employeeService.updateEmployee(employee);
		return ResponseEntity.noContent().build();
	}

}
