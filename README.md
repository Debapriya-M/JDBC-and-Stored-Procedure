# JDBC-and-Stored-Procedure
Standard Deviation Calculation from the Employee table in DB2 sample database using JDBC and Stored Procedure


Here using JDBC and stored procedure to compute standard deviation for employee's salary. The methods have been validated using SQL's stddev function. 

Data: Used the employee table in DB2 sample database or we can create a table employee with this schema and load the sample data into the database first. 

Standard deviation: In statistics, the standard deviation (SD, or σ ) is a measure that is used to quantify the amount of variation or dispersion of a set of data values.
 
Task 1: Write a JDBC program to compute the standard deviation of all salaries. The program should run as "java  -cp "path2jdbcdriver.jar" SalaryStdDev databasename tablename login password", where tablename is the tablename, and login and password are database login information.

Task 2: Write a SQL PL based stored procedure to compute the standard deviation of the salary. The code should run as "db2 -td@ -f stddev.sql"

Performance considerations: Try to minimize the number of table scans. For example, one avg computation will scan the table once. Try to minimize system resources. 
