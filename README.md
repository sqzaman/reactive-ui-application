# reactive-ui-application
Its a reactive ui application using spring webflux, angular and tomcat

#Backend with Spring WebFlux, 
Spring WebFlux supports two types of programming models :

1. Traditional annotation-based model with @Controller, @RequestMapping, and other annotations that you have been using in Spring MVC.
2. A brand new Functional style model based on Java 8 lambdas for routing and handling requests.

Here I created two different endpoint using two different apporach

##How to Run Backend
Steps 1 got to project directory
```
>cd C:\reactive-ui-application\backend\springboot-webflux
>C:\reactive-ui-application\backend\springboot-webflux> mvn clean compile
```
Steps 2 run springboot project
>mvn spring-boot:run

you can test api using curl
```
>curl http://localhost:8080/api/v1/events
```

```
>curl http://localhost:8080/api/v1/monitor/speed
```
![speed_api](https://user-images.githubusercontent.com/1064462/89655449-2116ea80-d898-11ea-921c-ef595b3d0801.png)

#Frontend with angular

##How to Run Frontend
Steps 1 got to project directory
```
>cd C:\reactive-ui-application\frontend\event-streaming-ui
>C:\reactive-ui-application\frontend\event-streaming-ui> npm install
```
Steps 2 run angular project
```
>ng serve
```
![ui](https://user-images.githubusercontent.com/1064462/89654959-6a1a6f00-d897-11ea-9349-05bb2f2ec89c.png)
