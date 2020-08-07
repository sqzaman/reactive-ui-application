# reactive-ui-application
Its a reactive ui application using spring webflux, angular and tomcat

#Backend with Spring WebFlux 
Spring WebFlux supports two types of programming models :

Traditional annotation-based model with @Controller, @RequestMapping, and other annotations that you have been using in Spring MVC.

A brand new Functional style model based on Java 8 lambdas for routing and handling requests.

Here I created two different endpoint using two different apporach

##How to Run Backend
Steps 1 got to project directory
>cd C:\reactive-ui-application\backend\springboot-webflux
>C:\reactive-ui-application\backend\springboot-webflux> mvn clean compile

Steps 2 run springboot project
>mvn spring-boot:run

you can test api using curl
```
curl http://localhost:8080/api/v1/events
```

```
curl http://localhost:8080/api/v1/monitor/speed
```

#Frontend with angular

##How to Run Backend
Steps 1 got to project directory
>cd C:\reactive-ui-application\frontend\event-streaming-ui
>C:\reactive-ui-application\frontend\event-streaming-ui> npm install

Steps 2 run angular project
>ng serve