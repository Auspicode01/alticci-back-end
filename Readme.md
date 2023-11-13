# Alticci-back-end

## Description

This microservice was developed as a recruitment process technical challenge.

The goal is to compute a numerical sequence given by the recruiter.

This microservice API has a single endpoint (/alticci/n) exposed on port 8080 which accepts one path variable of type Integer representing the index of the sequence element to be presented.

To compute a given element its necessary to compute all of the previous ones.
The microservice stores the known elements in cache for quick access.

Negative values are not allowed and the sequence size caps at 10001 elements.

## Run The Application

Run the command `mvn install` to build the application.
This command will create the .jar file which is necessary to run the application locally.

In the `/target` folder, execute the command `java -jar alticci-0.0.1.jar` to run the microservice.

You can also run the `DockerBuild.sh` script to containerize and run the application with docker.

### API Documentation

The Restful API has been documented following the Open API standard. 
The Swagger library generated the documentation.

Please refer to the following links: 
[swagger-ui](http://localhost:8080/swagger-ui/index.html#/)
[json format](http://localhost:8080/v3/api-docs)
