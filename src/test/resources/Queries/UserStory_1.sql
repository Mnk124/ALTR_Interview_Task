Create Table Employee(ID int NOT NULL PRIMARY KEY,
                      Name varchar(255) NOT NULL,
                      Salary int NOT NULL,
                      Gender char,
                      Title varchar(255) NOT NULL,
                      DOB Date);
COMMIT;
INSERT INTO Employee(ID,Name,Salary,Gender,Title,DOB)

VALUES (10,'Mustafa', 105000, 'M','SDET',"1989-05-27"),
       (20,'Forrest', 150000, 'M','Team Leader',"1985-12-01");
commit;

#Execute query to get all IDs from Employees
SELECT ID FROM Employee;
#Verify all employees has unique ID
SELECT DISTINCT ID FROM Employee;
#execute query to get all columns
SELECT * FROM Employee