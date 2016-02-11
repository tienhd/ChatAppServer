CREATE TABLE PUBLIC.ca_user_account
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    version BIGINT DEFAULT 0 NOT NULL,
    created_date DATETIME DEFAULT NOW() NOT NULL,
    updated_date DATETIME DEFAULT NOW() NOT NULL,
    deleted BOOLEAN DEFAULT FALSE  NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
ALTER TABLE PUBLIC.ca_user_account ADD CONSTRAINT unique_ca_user_account_id UNIQUE (id);
ALTER TABLE PUBLIC.ca_user_account ADD CONSTRAINT unique_ca_user_account_username UNIQUE (username);

CREATE TABLE PUBLIC.ca_role
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    version BIGINT DEFAULT 0 NOT NULL,
    created_date DATETIME DEFAULT NOW() NOT NULL,
    updated_date DATETIME DEFAULT NOW() NOT NULL,
    deleted BOOLEAN DEFAULT FALSE  NOT NULL,
    role VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);
ALTER TABLE PUBLIC.ca_role ADD CONSTRAINT unique_ca_id UNIQUE (id);
ALTER TABLE PUBLIC.ca_role ADD CONSTRAINT unique_ca_role UNIQUE (role);

INSERT INTO ca_role (role, description) VALUES ('USER_ROLE', 'User');

INSERT INTO ca_user_account (username, password) VALUES ('test','test');