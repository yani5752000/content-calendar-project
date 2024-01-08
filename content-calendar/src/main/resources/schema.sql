-- CREATE TABLE IF NOT EXISTS Content (
--     id INTEGER AUTO_INCREMENT,
--     title VARCHAR(255) NOT NULL,
--     desc TEXT,
--     status VARCHAR(20) NOT NULL,
--     content-type VARCHAR(50) NOT NULL,
--     date-created TIMESTAMP NOT NULL,
--     date-updated TIMESTAMP,
--     url VARCHAR(255),
--     primary key (id)
-- );

CREATE TABLE IF NOT EXISTS Content (
    id SERIAL PRIMARY KEY,
    title varchar(255) NOT NULL,
    description text,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255)
);

INSERT INTO Content(title, description, status, content_type, date_created)
 VALUES('THE TITLE', 'It is about nothing', 'IDEA', 'ARTICLE', CURRENT_TIMESTAMP);