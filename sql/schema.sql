CREATE TABLE IF NOT EXISTS accounts (
	id CHAR(36) PRIMARY KEY,
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL
);


-- Trigger to create UUID for PrimaryKey
DELIMITER //

CREATE TRIGGER before_insert_account
BEFORE INSERT ON accounts 
FOR EACH ROW
BEGIN 
	IF NEW.id IS NULL THEN
		SET NEW.id = UUID();
	END IF;
END //

DELIMITER ;

