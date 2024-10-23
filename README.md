# ED-Demo-Project

## Command for the mysql docker image  
```docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=demodb -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin -p 3306:3306 -v C:/mysql_data:/var/lib/mysql -d mysql:latest```

## Commands for granding permissions to admin user  
```CREATE USER 'user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON * . * TO 'user'@'localhost';
CREATE USER 'user'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON * . * TO 'user'@'%';
CREATE USER 'user'@'172.17.0.1' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'user'@'172.17.0.1' WITH GRANT OPTION;```