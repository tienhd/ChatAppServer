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

CREATE TABLE PUBLIC.ca_authority
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    version BIGINT DEFAULT 0 NOT NULL,
    created_date DATETIME DEFAULT NOW() NOT NULL,
    updated_date DATETIME DEFAULT NOW() NOT NULL,
    deleted BOOLEAN DEFAULT FALSE  NOT NULL,
    authority_key VARCHAR(255) NOT NULL,
    authority_value VARCHAR(255) NOT NULL,
    authority_group_id BIGINT,
    description VARCHAR(255)
);

CREATE TABLE PUBLIC.ca_authority_group
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    version BIGINT DEFAULT 0 NOT NULL,
    created_date DATETIME DEFAULT NOW() NOT NULL,
    updated_date DATETIME DEFAULT NOW() NOT NULL,
    deleted BOOLEAN DEFAULT FALSE  NOT NULL,
    authority_group_key VARCHAR(255) NOT NULL,
    authority_group_value VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);

ALTER TABLE PUBLIC.ca_authority ADD CONSTRAINT unique_ca_id UNIQUE (id);
ALTER TABLE PUBLIC.ca_authority ADD FOREIGN KEY (authority_group_id) REFERENCES ca_authority_group(id);

INSERT INTO ca_authority_group (id, authority_group_key, authority_group_value, description) VALUES (1, 'API_ACCESS', 'ACCEPT', 'Access api group');
INSERT INTO ca_authority (id, authority_key, authority_value, description) VALUES (1, 'USER_AUTHORITY', 'ACCEPT', 'User authority');

INSERT INTO ca_user_account (username, password) VALUES ('test','test');