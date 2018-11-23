# spring-security-jwt

## Technology stack
- Java 10
- Spring Boot
- Spring Data
- Spring Security
- PostgreSQL / H2
- Maven
- Log4j
- Lombok
- Swagger

## API Documentation

- [Signup](#signup)
    - [Success](#signup-success)
    - [Email already exists](#signup-email-already-exists)
    - [Bad request](#signup-bad-request)
- [Signin](#signin)
    - [Success](#signin-success)
    - [Email not found](#signin-email-not-found)
    - [Unauthorized](#signin-unauthorized)
- [Current user](#current-user)
    - [Success](#current-user-success)
    - [Unauthorized](#current-user---unauthorized)

## Signup

```
POST: http://localhost:5000/api/auth/signup
```

Header
```
Content-Type: application/json
```

Body
``` json
{
	"name": "Rafał Mituła",
	"email": "rmitula@gmail.com",
	"password": "password"
}
```

## Signup success 
Status: 200

Body (Created user id)
```
1
```

## Signup email already exists
Status: 409

Body (Created user id)
```
{
  "code": 409,
  "message": "Email is already taken"
}
```

## Signup bad request
Status: 400

Body
```
{
  "code": 400,
  "message": "error message..."
}
```

***

## Signin
```
POST: http://localhost:5000/api/auth/signin
```

Header
```
Content-Type: application/json
```

Body
``` json
{
	"email": "rmitula@gmail.com",
	"password": "password"
}
```

## Signin success 
Status: 200

Body
```
{
  "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTQxNTA2MjA4LCJleHAiOjE1NDIxMTEwMDh9.xRU2vmXUvtHmrL_BDKm-rzTKd0Sv8BtPR3AmOO0ZgLnSXIT0EeDh1cN7lvrxM-H2fNuO4vJMJdOXV8By8E4BkQ",
  "tokenType": "Bearer"
}
```

## Signin email not found
Status: 404

Body
```
{
  "code": 404,
  "message": "User not found [email: rmitula@gmail.com]"
}
```

## Signin unauthorized 
Status: 401

Body
```
{
  "timestamp": "2018-11-11T17:37:12.573+0000",
  "status": 401,
  "error": "Unauthorized",
  "message": "Sorry, You're not authorized to access this resource.",
  "path": "/api/auth/signin"
}
```
***

## Current user
Logged in user credentials

```
GET: http://localhost:5000/api/users/me
```

Header
```
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTQxNTA2MjA4LCJleHAiOjE1NDIxMTEwMDh9.xRU2vmXUvtHmrL_BDKm-rzTKd0Sv8BtPR3AmOO0ZgLnSXIT0EeDh1cN7lvrxM-H2fNuO4vJMJdOXV8By8E4BkQ
```

## Current user success 
Status: 200

Body
```
{
  "id": 1,
  "username": "rmitula@gmail.com",
  "name": "Rafał Mituła"
}
```


## Current user - unauthorized 
Status: 401

Body
```
{
  "timestamp": "2018-11-11T17:26:42.886+0000",
  "status": 401,
  "error": "Unauthorized",
  "message": "Sorry, You're not authorized to access this resource.",
  "path": "/api/users/me"
}
```
