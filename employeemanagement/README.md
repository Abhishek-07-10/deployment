# Models
## Class
### DepartmentModel
This class represents a department entity in the database. It contains the following attributes:

- `Id`
: An integer value representing the department's id. This is generated automatically by the database.
- `department`
: A string value representing the department's name.

The class is annotated with 
@Data
, 
@Entity
, 
@AllArgsConstructor
, 
@NoArgsConstructor
 and 
@Table
 annotations. The 
**@Table**
 annotation is used to specify the table name in the database. The 
**@Id**
 annotation is used to specify the primary key of the table. The 
**@GeneratedValue**
 annotation is used to specify that the primary key should be generated automatically by the database.

### EmployeeModel 
This is the documentation for the 
EmployeeModel
 class.

***Properties***
- `Id` : Integer : An auto-generated ID used to uniquely identify an employee
- `fullName` : String - The full name of the employee
- `email` : String - The email of the employee
- `phNum` : String - The phone number of the employee
- `salary` : String - The salary of the employee
- `status` : String - The current status of the employee
- `department` : DepartmentModel - The department the employee belongs to
- `manager_id` : ManagerModel - The manager of the employee

### Manager Model
This class is used to represent a manager's data in the employeemanagement application. It is annotated with 
@Entity
 and 
@Table
 to indicate that it is an entity that should be stored in the database.

Properties
The class contains the following properties:

- `Id`
: A unique identifier for the manager. This is generated automatically using the 
**@GeneratedValue**
 annotation.
- `managerName`
: The name of the manager.

# Controller
## Classes
### DepartmentController
This controller handles requests related to creating and managing departments.

**Methods**
- `addDepartment()` : 
This method is used to add a new department to the system.

**Parameters**

- `department(DepartmentModel)` : The department object to be added to the system.

### EmployeeController
This controller is responsible for handling requests for updating an employee's information.

- `addEmployee()` : This method is used for updating an employee's information.

**Parameters**:

- `Id` : The ID of the employee to update.
- `employee` : The updated employee information in JSON format.
Returns: Nothing.

**Implementation**

The 
`setEmployee()`
 method is called, which takes in the employee information in JSON format, and the employee ID, and returns an 
EmployeeModel
 object.
The 
`updateEmployee()`
 method of 
EmployeeService
 is called, which takes in the 
EmployeeModel
 object as a parameter, and updates the employee information in the database.

 ### HRController
This controller is used to handle all the employee related operations. It provides methods to add, update and fetch employees.

**Methods**
- `addEmployee()` : This method is used to add a new employee to the system.

**Parameters**

- `employee`
: A JSON string containing employee details.

- `setEmployee`
This is a helper method used to parse the JSON string containing employee details and create an 
EmployeeModel
 object.

### Manager Controller
This controller is responsible for managing the operations related to the 
ManagerModel
 model.

**Methods**
- `addManager()` : 
This method is used to add a new 
ManagerModel
 to the system.

**Parameters**
- `@RequestBody ManagerModel manager`
: The 
ManagerModel
 object to be added.
**Usage**
This method is called when an HTTP 
POST
 request is sent to the 
/add/manager
 endpoint.

# Service
## Classes
### DepartmentService
This class is responsible for handling all operations related to departments.

**Methods**
- `saveDepartment()` : 
This method is used to save a new department to the repository.

**Parameters**

- `department(DepartmentModel)`: The department object to be saved.

### EmployeeService
This class contains methods for performing operations related to Employee Model.

**Methods**
- `updateEmployee(EmployeeModel obj)` : This method updates an employee record.

**Parameters**

- `obj` : An instance of EmployeeModel containing the updated employee information.
 - `getEmployeeById(Integer Id)`: This method returns an employee record for the given id.

### Manager Service
This class is responsible for managing the 
ManagerModel
 object. It provides methods to save a 
ManagerModel
 object to the database.

**Methods**
- `saveManager(ManagerModel manager)`
This method takes in a 
ManagerModel
 object and saves it to the database.

Dependencies
This class requires the following dependencies:

- `ManagerRepository`
: Responsible for managing the 
ManagerModel
 object.
- `@Autowired`
: An annotation used to inject the 
ManagerRepository
 dependency.
- `@Service`
: An annotation used to mark this class as a service.

### EmployeeEmployeeRepositoryService
This service class is responsible for managing Employee Model objects. It is annotated with 
`@Service`
 to indicate that it is a service class.

The class is autowired with 
EmployeeRepository
 to access the repository layer.

**Methods**
- `updateEmployee(EmployeeModel obj)` : This method is used to update an existing Employee Model object. It takes an 
EmployeeModel
 object as a parameter and saves it to the repository layer.

- `getEmployeeById(Integer Id)` : This method is used to retrieve an existing Employee Model object. It takes an 
Integer
 object as a parameter and returns the corresponding 
EmployeeModel
 object from the repository layer.

- `getAllEmployee()` : This method is used to retrieve all existing Employee Model objects. It returns a 
List
 of 
EmployeeModel
 objects from the repository layer.


## Configuration

This class contains a configuration for a Spring Security application. It enables web security and configures a UserDetailsService and SecurityFilterChain.

- `UserDetailsService` : This bean is used to configure the application's users. It is an InMemoryUserDetailsManager that holds a single user with the username 
admin
 and the password 
**abhi321**
. The user has the role 
**ADMIN**
.

- `SecurityFilterChain` :This bean configures the security filter chain for the application. It configures the application to require authentication for requests to the 
**/admin/**** path, and to permit all requests to any other path. It also configures the application to use form-based authentication.

- `PasswordEncoder`
This bean is used to encode passwords for the application's users. It uses BCryptPasswordEncoder.