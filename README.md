# Welcome To workforce optimizer Backend Challenge 1



### Relation Explanination
Many to Many Relation between Shift and ShiftGroup and braked relation in middle table to make accessible relation also i assumed make relation with primary key not string for best berformance.


## Auto Installation Using Docker Compose.
1- Install ```docker``` and ```docker-compose``` depends on your OS,  for docker check [here](https://docs.docker.com/get-docker/), and for docker-compose [here](https://docs.docker.com/compose/install/)

2- Clone Project and open terminal inside projectDir

3- execute ``` ./mvnw clean package spring-boot:repackage```

4- execute ```docker-compose up```

4-Enjoy with postman collection {{projectDir}}/workforce-optimizer attached with project or find it [here](https://www.getpostman.com/collections/2c129af84b63f71ef90b)



## Manual Installation Using IDE.

1- Clone Project and open terminal inside projectDir.

2- Open with your favorite IDE (netabeans, eclipse,...).

3- Change MySql properties from ```application.properites``` file debend on your localhost.

4- build and enjoy.



## Data seeder.
Note: in application.properties file there is boolean flag load.seed.data to load test data or not.

Shift Table
id|code        |
--|------------|
2 |shift_code_2|
1 |shift_code_1|

Shift_group Table
id|code         |
--|-------------|
20|shift_group_2|
10|shift_group_1|

Shift_grouping Table
shift_code_id|shift_group_id|
-------------|--------------|
           18|            10|
           18|            11|
           19|            10|

Use Api to test codes.

ProjectDir
```
├───src/
│   ├───main/
│   │   ├───java/
│   │   │   └───com/
│   │   │       └───workforce/
│   │   │           └───app/
│   │   │               ├───body/────────────────────────────────────>> request/response body templates
│   │   │               │   ├───IsBelongToGroupRequestBody.java
│   │   │               │   └───IsBelongedResponse.java
│   │   │               ├───controller/──────────────────────────────>> controller api url
│   │   │               │   └───ShifGroupingController.java
│   │   │               ├───model/───────────────────────────────────>> database models relation
│   │   │               │   ├───Shift.java
│   │   │               │   └───ShiftGroup.java
│   │   │               ├───repository/──────────────────────────────>> database repositories CRUD functions
│   │   │               │   ├───ShiftGroupRepository.java
│   │   │               │   └───ShiftRepository.java
│   │   │               ├───service/─────────────────────────────────>> service for busiess logic
│   │   │               │   └───impl/
│   │   │               │       └───ShifGroupingService.java
│   │   │               ├───template/────────────────────────────────>> common template standard formate
│   │   │               │   └───ResponseTemplate.java
│   │   │               └───ApplicationStarter.java ─────────────────>> Main App starter point
│   │   └───resources/
│   │       ├───META-INF/
│   │       ├───db/
│   │       │   └───changelog/───────────────────────────────────────>> if will use liquibase database migration tool
│   │       ├───static/
│   │       ├───templates/
│   │       └───application.properties───────────────────────────────>> application configuration proparties 
│   └───test/
│       └───java/
│           └───com/
│               └───example/
│                   └───demo/────────────────────────────────────────>> Test files
│                       └───DemoApplicationTests.java
├───Dockerfile───────────────────────────────────────────────────────>> Docker image for java
├───README.md────────────────────────────────────────────────────────>> we are here
├───docker-compose.yml───────────────────────────────────────────────>> docker images (database and api)
├───pom.xml──────────────────────────────────────────────────────────>> application dependency 
└───workforce-optimizer.postman_collection.json──────────────────────>> postman collection API
```