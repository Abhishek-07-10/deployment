
# Hospital Mangement: 

This project is a Spring Boot application that allows hospitals to manage their doctors/patients. It provides a user-friendly interface for hospital to create, view, update, and delete patient or dectors records. It also allows doctors to easily search for patient records and view patient history. Additionally, the application provides features such as appointment scheduling, prescription management, and patient data analysis.<br><br>

# Model

## Doctor

### Validation

The following validations are applied to the properties of the Doctor object:

- `docName`: Not blank and must be between 3 and 255 characters.
- `city`: Not blank and must be maximum 20 characters.
- `email`: Not blank and must be a valid email address.
- `phNum`: Not blank and must be at least 10 characters.<br><br>

## Patient

This model is used to store information about a patient.

### Validation

- `patientId`
: Integer. Generated automatically by the database.
- `patientName`
: String. Must be between 3 and 255 characters.
- `symptoms`
: String.
- `phoneNumber`
: String. Must be of 10 characters.
- `city`
: String. Must be maximum 20 characters.
- `email`
: String. Must be valid email address.
- `doctor`
: Doctor. Many-to-one relationship with the Doctor model.<br><br>

# Controller

## Patient Controller

This is the controller class for the Patient entity. It contains methods for adding, retrieving, and deleting patient records.

### Methods

- `addPatient()` : this method adds a patient record to the database. It takes a JSON Objectas an argument and returns a String confirming the save.
<http://localhost:8080/Patient/Add/patient/Details>

- `getPatient()` : this method retrieves all patient records from the database. It returns a List of Patient objects. <http://localhost:8080/Patient/Get/Patient>
- `getSpecialist(symptoms,location)` : This method is used to get the specialist doctor for the given symptoms and city. It takes symptoms and city as input and returns a list of doctors.And will directly assign the suitable doctor availabe for the symptoms.
`Else will say not found any doctor`.
- `getPatientById()` : this method retrieves a single patient record from the database. It takes an Integer as an argument and returns a Patient object.<http://localhost:8080/Patient/GetPatient/patId/1>

- `deletePatient()` : this method deletes a single patient record from the database. It takes an Integeras an argument and returns nothing.http://localhost:8080/Patient/DeletePatient/1<br><br>

## DoctorController

This class is responsible for handling requests for creating and deleting doctors.

### Methods/endpoints

- `addDoctor()`
: This method is used to create a new doctor.<http://localhost:8080/Hospital/Doctor/addDoc>

**Parameters**

- - @Valid : The annotation is used to validate the request body
- - @RequestBody Doctor doctor : The request body should contain a valid Doctor object

Returns String : The response will be a string indicating the success or failure of the operation

`deleteDoc()` : This method is used to delete an existing doctor.<http://localhost:8080/Hospital/Doctor/Delete/Doctor/docId/1>

**Parameters**

- - @PathVariable Integer docId : The id of the doctor to be deleted
Returns String : The response will be a string indicating the success or failure of the operation.<br><br>

# Service

## DoctorService

This class contains methods for interacting with the Doctor entity in the database.

### Methods/Business logic

- `deleteById(Integer docId)`
: This method is used to delete a Doctor from the database by its id.

- `saveDoc(Doctor doctor)`
: This method is used to save a Doctor to the database. It takes in a Doctor object as an argument and returns a String indicating that the save was successful.<br><br>

## PatientService

This is a service class for the Patient model.

### Methods/Business logic

- `savePat1(Patient patient)` : This method is responsible for saving patient details to the database.
- `deleteById(Integer patId)` : This method is responsible for deleting a single patient details from the database by ID.
- `getAllPatient()` : This method is responsible for retrieving all patient details from the database, returns a list of all Patient instances from the database.
- `getPatientById(Integer patId)` : This method is responsible for retrieving a single patient details from the database by ID, returns a Patient instance from the database with the specified ID.<br><br>

# Repository

## DoctorRepo

This class extends JpaRepository<Doctor, Integer> and provides an additional method `getBySymptomsLocation()` to get a list of doctors based on the specialty and city.

### Method 
- `getBySymptomsLocation(symptoms,city)`: To search in database for related query.

**Parameters**:

- `spec` : The specialty of the doctor.
- `city` : The city in which the doctor is located.
**Returns** : A list of Doctor objects that match the provided specialty and city.

**Description**: This method queries `doc_tbl` with the provided `specialty` and `city` and returns a list of `Doctor` objects that match the query.

## PatientRepo

This is the repository interface for the Patient model. It is a JpaRepository that extends the org.springframework.data.jpa.repository.JpaRepository interface.

It has the following generic types:

- `Patient` : the model type 
- `Integer` : the type of the model's primary key.

This repository provides basic CRUD operations for the `Patient` model.

# validation

## Validation Exception Handler
This class contains exception handlers for validation errors and Doctor not found errors.

### Methods
- `handleValidationExceptions()`: This method handles validation errors and returns a map of field names and error messages.

- `handleExceptions()` : This method handles Doctor not found exceptions and returns a custom error message.