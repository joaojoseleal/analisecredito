![github-small](logo_zup-transports.png)

ZUP-TRANSPORTS - _Truck fleet_
=====

The startup **ZUP-TRANSPORTS** is inviting you to join a squad for build a new application for management a _truck fleet_!
As the developer, you are the responsible to design and implement a platform 'full stack' with the principals resource to manage a truck fleet.

You can use any programming language and web frameworks that supports HTTP. 

## Instructions:

#### Backend requirements:
- A RESTful API for domains "truck" and "user"
- The API should be protected, access only with credentials
- For deactivate a truck, should be has a reason

Required fields "truck":
```
> manufacturer: String (25)
> year: Int (4)
> type: String (supports only BOX_TRUCK, TRAILER_TRUCK or REFRIGERATED_TRUCK)
> active: Boolean
> reason: String (255)
```

Required fields "user":
```
> name: String (100) 
> login: Int (4)
> password: String (min 4, max 8 according by good practices)
> role: String (supports only READ or WRITE)
> active: Boolean
```

#### Frontend requirements:
- Should be developed like a "web client"
- A dashboard with resources to manage trucks
- A 'admin area' to manage users
- A good and clean design of view elements

## What will be evaluated:
- A solution design diagram
- Adherence to requirements
- Elegance of the solution
- Documentation
- Defense of the solution through presentation
- The source code must be in a Git repository
- It should contain a file named README.md describing the solution and how to test and run the project
