This is Backend Project a small feature of StudentDashboard Here you add some features
1. Add a student
2. Add a Subject
3. View  all students
4. View all subjects
5. Can assign subjects to students.
6. Added security Filter to project ,JWT filter also login and register using database too.
# You can run this project in IDE like Eclipse and Intellij ,load the maven dependencies create a database query 
Anyone can used H2 database I have commented out,in application.properties
# Added SQL scripts for local database in folder 
# The project can be run on postman 
# JWT token is also created for certain amount of time for Stateless Session.
# you can add more features in this project .
 If using local database you need to create three tables Student,subject and one table Student_subject, I haven't added script for   Student_subject table.
 # Please Name the tables and column names according to entity  ,names given to avoid errors ,So JPA repository will work properly.
