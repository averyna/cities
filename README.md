City List Application
Application which allows the user to browse through the paginated list of cities with the
corresponding photos, search by the name and edit the city.

Backend
Has been created using Java 8, Spring Boot, Maven, MongoDb

Frontend
Created in a separate repository (cities-fe) using React + Redux.
The source code is arranged in a bundle.js.
bundle.js and index.html are placed in a static content of backend cities project.

How to run the application:
1. clone the project (https://github.com/averyna/cities.git)
2. start MongoDb in Docker with command "docker-compose up -d" (docker-compose file is in the root folder)
3. run CitiesApplication.java in IntelliJ Idea or execute: 1. "mvn clean install", 2. "java -jar target/cities-0.0.1-SNAPSHOT.jar"
4. After application start UI is accessible here: http://localhost:63342/cities/static/index.html or
you can run src/main/resources/static/index.html in IntelliJ




________________________________________________________________________________________________

Task statement
Create an enterprise-grade "city list" application (it will stay there for years, will be extended
and maintained) which allows the user to do the following:
- browse through the paginated list of cities with the corresponding photos
- search by the name
- edit the city (both name and photo)

Notes
- initial list of cities should be populated using the attached cities.csv file
- city addition, deletion and sorting are not in the scope of this task

Technical clarification
- Spring Boot
- any build system
- any database
- any frontend stack
- Usage of Spring Data REST is prohibited

Bonus points (not mandatory)
- Frontend stack should be one from the list: Angular; VueJS; React
- Editing the city should be only allowed for users with Spring Security's role  ROLE_ALLOW_EDIT

Expected outcome
A repository link to your GitHub account from where you can clone the solution and run it with
little-to- zero effort.
