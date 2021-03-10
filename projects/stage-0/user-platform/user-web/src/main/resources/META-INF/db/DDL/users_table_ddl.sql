CREATE TABLE users (
   id INT NOT NULL PRIMARY KEY auto_increment,
   name VARCHAR(16) NOT NULL,
   password VARCHAR(64) NOT NULL,
   email VARCHAR(64) NOT NULL,
   phoneNumber VARCHAR(32) NOT NULL,
   PRIMARY KEY (id)
) COMMENT ='用户表';