CREATE TABLE ASUSER(
	ASUSER_USERID 			VARCHAR(36)  		DEFAULT ''	NOT NULL,
	ASUSER_USERNAME   		VARCHAR(60)   		DEFAULT '',
	ASUSER_EMAIL			VARCHAR(80)			DEFAULT '',
	ASUSER_PWD              VARCHAR(36)         DEFAULT '',
	PRIMARY KEY (ASUSER_USERID)
);