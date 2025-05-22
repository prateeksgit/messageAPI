The implementation of RESTful APIs in Java. (Using JAX-RS)
Covered Some Important Concepts for API to be fully RESTful. 

-Clear implementation of RESOURCE URI
Initial step for designing of APIs, Handled both Instance URI and Collection URI. 

-HTTP Methods:
HTTP methods are backbones of REST APIs. I have tried to cover the subtle differences of method idempotence in POST Vs PUT method. 
As we know POST is non-idempotent where as PUT is the idempotent one. 

-RESPONSES
The greatest feature of REST API is it's stateless transfer. We can send responses in any format as per requirements. 
In RESTAPIs "Responses are different representation of same Resources".
-In this project i have handled response in XML and JSON format.

-STATUS CODES AND HEADER.
Using standard status codes,headers (Location), and response bodies (entity) builds predictability, which is key in any API design. 
Project is designed to handle these aspects at minimum. 

--HATEOAS
HyperMedia As The Engine of Application State.
As name suggest the HyperMedia(Links to other resources) attempts to drive the state of applicaiton, it's  a concept where sending a response drives the cllient interaction with the application. 
The project consist of implementation of HATEOAS as well. 

Well, i tried to fullfill the Richardson's Maturity Model of APIs within this project. 
Next, i plan to transform this project to use the real time datebase with SPRING framework in place. 

Thank you. 

