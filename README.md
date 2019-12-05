# Employee-Skills-Tracking-Application

This is a simple application that tracks employee skills that I built from the ground up. Users are able to view, create, update, and delete employees and skills. The backend for this project was built using Spring Boot with the Java lanaguage and for the sake of simplicity, the data is stored in an in-memory H2 database. The front end was designed with Vue.js.

# What I Learned

This project was an immense learning experience because it involved a number of frameworks that I had never used before. I have read that when it comes to programming the best way to learn is by doing and this project reinforced that idea for me. I was impressed by how powerful Spring Boot is and how it is capable of doing a lot of complex work underneath the hood. This was also the first project I have completed that was built using an SPA framework. While I am proud of my work on this project, it has also made me realize some important things I need to work on improving in future projects. There is a lot of nuance in how Vue components are built and arranged and I think there is still a lot to learn about how to link many small components in a way to keep code clean and reduce repetition. Additionally, while I have a good understanding of unit testing in general, I need to work on improving my understanding of testing in a web application setting. Overall, I am proud that I was able to built this project from the ground up without any outside assistance and look forward to completing some more equally rewarding projects in the near future.

https://github.com/users/tomphillipsmusic/projects/1

# Directions

1. Open employee-skills-tracking-application (which is a maven file written in Java) and run EmployeeSkillsTrackingApplication.java as a java application. Once the application is loaded, it will be run on localhost:8080.

2. To see the database, go to localhost:8080/h2-console
  JDBC URL: jdbc:h2:mem:employee-skills
  username: sa
  password: (leave blank)
  
3. Open employee-skills-tracking-webapp and run the command npm run serve. This application should appear at localhost:8081

4. If everything is setup correctly, you should see a table of employees from the database on the homepage. Select documentation at the website's header to see specific information on how the REST API works.

Documentation for the API can be found at: 
https://documenter.getpostman.com/view/9650473/SWDzeM91?version=latest


