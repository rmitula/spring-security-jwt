# spring-security-jwt


### 1. Signup

#### 1.1 Request
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

#### 1.2 Response
##### 1.2.1 Success 
Status: 200

Body (Created user id)
```
1
```

##### 1.2.2 Email already exists 
Status: 409

Body (Created user id)
```
{
  "code": 409,
  "message": "Email is already taken"
}
```

##### 1.2.3 Email already exists 
Status: 409

Body (Created user id)
```
{
  "code": 409,
  "message": "Email is already taken"
}
```

##### 1.2.4 Bad request
Status: 400

Body
```
{
  "code": 400,
  "message": "error message..."
}
```

### 2. Signin
#### 2.1 Request
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

#### 2.2 Response

##### 2.2.1 Success 
Status: 200

Body
```
{
  "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTQxNTA2MjA4LCJleHAiOjE1NDIxMTEwMDh9.xRU2vmXUvtHmrL_BDKm-rzTKd0Sv8BtPR3AmOO0ZgLnSXIT0EeDh1cN7lvrxM-H2fNuO4vJMJdOXV8By8E4BkQ",
  "tokenType": "Bearer"
}
```

##### 2.2.2 Unauthorized 
Status: 401

### 3. Logged in user credentials

#### 3.1 Request
```
GET: http://localhost:5000/api/users/me
```

Header
```
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTQxNTA2MjA4LCJleHAiOjE1NDIxMTEwMDh9.xRU2vmXUvtHmrL_BDKm-rzTKd0Sv8BtPR3AmOO0ZgLnSXIT0EeDh1cN7lvrxM-H2fNuO4vJMJdOXV8By8E4BkQ
```

#### 3.2 Response

##### 3.2.1 Success 
Status: 200

Body
```
{
  "id": 1,
  "username": "rmitula@gmail.com",
  "name": "Rafał Mituła"
}
```


##### 3.2.2 Unauthorized 
Status: 401

