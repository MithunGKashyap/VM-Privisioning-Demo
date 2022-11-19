
# VM Provisioning Demo

It is a Spring Boot demo project for provisioning VM


## Docker Compose:

Use docker-compose up and then start the server


## Roles

Specify the role as either ADMIN or USER while creating the Users. Only these 2 roles are supported as of now.


## Postman Colelction Details




#### Postman collection path : 
```bash
 - src/main/resources/postman/
```
    
## API Reference

### SignUp

```http
  POST /auth/signUp
```

Payload: 

```json
{
    "username":"kohli",
    "password":"password",
    "email": "kohli@vm",
    "mobileNo":"+91-919191919224",
    "role":"USER"
}
```
#### Payload Details: 

| Json Key | Json Value     | Description                |
| :-------- | :------- | :------------------------- |
| `username` | `string` | Name of the user (**Required**).|
| `password` | `string` | Password of the user (**Required**).|
| `email` | `string` | user's email (**Unique** and  **Required**).|
| `mobile_no` | `string` | user's mobile no (**Unique** and  **Required**).|
| `role` | `string` | Role can be either **ADMIN** or **USER** (**Required**).|


### Login 

```http
  POST /auth/login?username=uname&password=pass
```

#### Query Param : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `username`      | `string` | Username query param (**Required**). |
| `password`      | `string` | Password query param (**Required**). |


### Get All Users [ Only ADMIN ]

```http
  GET /appUser
```


#### Authorization : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Authorization`      | `Bearer Token` | JWT Token must be passed (**Required**). |



#### Path Param : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |



#### Query Param : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |





### Delete User [ Only ADMIN ]

```http
  DELETE /appUser/{appUserId}
```

#### Authorization : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Authorization`      | `Bearer Token` | JWT Token must be passed (**Required**). |


#### Path Param : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `appUserId`      | `Long` | App user id must be passed as Path variable (**Required**). |


#### Query Param : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |


### Get VM Info  [ Like OS, RAM, HardDisk, CPU ]

```http
  GET /vm
```

#### Authorization : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Authorization`      | `Bearer Token` | JWT Token must be passed (**Required**). |


#### Path Param : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |


#### Query Param : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |



### Create VM for User 

```http
  POST /userVm
```

#### Authorization : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Authorization`      | `Bearer Token` | JWT Token must be passed (**Required**). |


#### Path Param : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |


#### Query Param : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |

#### Payload: 

```json
{
    "appUser": 4,
    "os":2,
    "ram":3,
    "hardDisk":2,
    "cpuCores":30
}
```
#### Payload Details: 

| Json Key | Json Value     | Description                |
| :-------- | :------- | :------------------------- |
| `appUser` | `Long` | User ID (**Required**).|
| `os` | `Long` | OS ID [Either check in DB or get it from Get VM details API] (**Required**).|
| `ram` | `Long` | RAM ID Either check in DB or get it from Get VM details API] (**Required**).|
| `hardDisk` | `Long` | HardDisk ID (Either check in DB or get it from Get VM details API] (**Required**).|
| `cpuCores` | `Long` | CPU ID Either check in DB or get it from Get VM details API] (**Required**).|



### Get VM By User ID 

```http
  GET /userVm/{appUserId}
```

#### Authorization : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Authorization`      | `Bearer Token` | JWT Token must be passed (**Required**). |


#### Path Param : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `appUserId`      | `Long` | User ID (**Required**). |


#### Query Param : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |


### Get all User's VM

```http
  GET /userVm/{appUserId}
```

#### Authorization : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Authorization`      | `Bearer Token` | JWT Token must be passed (**Required**). |


#### Path Param : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |


#### Query Param : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |


### Get topN VM and topN  VM by UserID [ Based on Query Param to fetch result]


```http
  GET /userVm/topN?limit={limit}&appUserId={appUserId}
```

#### Authorization : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Authorization`      | `Bearer Token` | JWT Token must be passed (**Required**). |


#### Path Param : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |


#### Query Param : 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `limit`      | `Long` | No of topN records to fetch, If the value is not provided then fetch top 1 record by memory(**Optional**). |
| `appUserId`      | `Long` | UserID to be given to get topN VM of particluar user or else it fetch topN VM among all users (**Optional**). |

