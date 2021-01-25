# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM java:8
 
MAINTAINER Brijesh K Dhaker <brijeshdhaker@gmail.com> 

CMD mkdir -p /apps/libs && mkdir -p /apps/configs
 
ADD target/my-app-docker.jar /apps/
 
EXPOSE 8080
 
CMD java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n /apps/my-app-docker.jar