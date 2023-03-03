# springboot-database-security
Inserting Record
----------------
```bash
URL : http://localhost:4004/employee/save
HTTP Method : POST
```
Json Request :
```json
{
    "username":"sankar",
    "password":"1234",
    "roles":"ROLE_USER"
}
```
Json Response :
```json
{
    "id": 46,
    "username": "sankar",
    "password": "$2a$10$jhMUm1T5ZHIfKcBwZfSSpOrk5Mx9LtkKq.oWtylfQUM6A9rIsn2tG",
    "roles": "ROLE_USER"
}
```
Authorized person can accees this link
-------------------------------------
```bash
URL : http://localhost:4004/employee/user
HTTP Method : GET
```
For Login purpose Enter this username & password:
```san
username:sankar
password:1234
#this password will encrypted in login time
```
### About Application
In this way you can insert and login with role based authentication and authorization perform on this application:





