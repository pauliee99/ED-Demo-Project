# ED-Demo-Project

## Command for the mysql docker image
```docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=yourpassword -e MYSQL_DATABASE=mydatabase -e MYSQL_USER=myuser -e MYSQL_PASSWORD=mypassword -p 3306:3306 -v C:/mysql_data:/var/lib/mysql -d mysql:latest```
