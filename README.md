# OpenApi CodeGen Rest Api

Task 2. Swagger codegen.

### Approach

  - Used online Swagger editor to write the api.yaml to create my API definition.
  - Created a empty Springboot maven project and moved api.yaml file into this project.
  - You can find the yaml file in src/main/resources/api.yaml
  - Then added the openapi-generator-maven-plugin from https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-maven-plugin
  - Then added the springfox-swagger-ui, springfox-swagger2 and swagger-annotations dependencies.
  - After adding all the required dependencies, did maven clean install.
  - ```bash
    mvn clean install
    ```
  - Now the stub is created in the target folder with the ServerModel and APIs.
  - Then Implemented the ServerApiDelegate using java Springboot.

## Tech Stack
- `Backend Framework:` `Springboot`
- `Database:` `MongoDB`



## Schema
|    serverModel     |  |  
| -------- | ------- |
|   `id`      | `string` |
|   `name`      | `string` |
|   `language`      | `string` |
|   `framework`      | `string` |




## API Reference 

  - Check the POSTMAN Documentation for both Success and Failure Examples
  - https://documenter.getpostman.com/view/19762721/2s93RNyaP8

### API Endpoints


#### Add Server Object
```javascript
  PUT localhost:8080/server/addServer
```
#### Request Body
```json 
{
    "id":6,
    "name":"game",
    "language":"go",
    "framework":"python"
}
```
#### Example Response
```javascript
  201 CREATED

```

```json 
{
  "id": "6",
  "name": "game",
  "language": "go",
  "framework": "python"
}
```

#### Delete Server Object
```javascript
  DELETE localhost:8080/server/deleteServer/6
```

#### Example Response
```javascript
  200 OK
```
```json 
Record Successfully Deleted
```

#### Get All Server Objects

```javascript
  GET localhost:8080/server/getServer
```
#### Example Response

```javascript
  200 OK
```

```json 
[
  {
    "id": "8",
    "name": "game",
    "language": "go",
    "framework": "python"
  },
  {
    "id": "10",
    "name": "game",
    "language": "go",
    "framework": "python"
  },
  {
    "id": "7",
    "name": "mentos",
    "language": "go",
    "framework": "python"
  }
]
```

#### Get Server Object By Id
```javascript
  GET localhost:8080/server/getServer/byId/10
```

#### Example Response
```javascript
  200 OK
```
```json
{
  "id": "10",
  "name": "game",
  "language": "go",
  "framework": "python"
}
```


#### Get Server Object By Name

```javascript
  GET localhost:8080/server/getServer/byName/game
```
#### Example Response

```javascript
  200 OK
```

```json 
[
  {
    "id": "8",
    "name": "game",
    "language": "go",
    "framework": "python"
  },
  {
    "id": "10",
    "name": "game",
    "language": "go",
    "framework": "python"
  }
]
```
