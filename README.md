# CS545-lab5

LAB 5
CS545 – Authentication (JWT)
 

Based on your previous lab, you will add authentication to all actions that were previously made. 

There will be two roles (USER, ADMIN). The ADMIN should access all the pages that a user can access plus an /admin path (you should add this path).

The User should access all paths except the /admin path. 

You will be mapping the authentication with the JPA database in your project. There should be a login path /authenticate where a user enters his/her credentials. If the user provides valid credentials, it should generate a token. 

Note: “In this assignment you will be manually copying the token to the authentication header when using postman or any other alternative.”


Optional:

When a user makes a post, it should read the user information and when it saves the post, it will also store the user that made that post (without passing a userId), it should be extracted from the authenticated user.  




You may refer to the demo in the link below to integrate the JWT to your project. 
https://github.com/muhyidean/spring-security-1.git

