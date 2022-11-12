# CS545-lab6

LAB 6

Group members:

+ *Ganbayar Tsogbadrakh*

+ *Yumjirdulam Chinbat*


 We work as a group and secured refreshToken in our way. It is very hard to secure if refreshToken is stolen.
 But we improved 2 things in our project to secure refreshToken.

 1. shortened refreshToken expiration date. 
 2. Our application always require valid and expired accessToken for the new token request. 
 	if Hacker stole only refreshToken and send the new accessToken request , our server wont provide the accessToken. 
 	if Hacker send the any String or another expired accessToken not issued by our secret, also we dont give him an accessToken :)

