
CREATE TABLE IF NOT EXISTS account (
  id SERIAL PRIMARY KEY ,
  accountnumber VARCHAR(255) NOT NULL UNIQUE,
  age INT NOT NULL
);

CREATE TABLE IF NOT EXISTS card (
  id SERIAL PRIMARY KEY,
  cardnumber VARCHAR(255) NOT NULL UNIQUE,
  membership VARCHAR(255) NOT NULL,
  descriptionstatus VARCHAR(255) NOT NULL,
  balance INT NOT NULL
);

ALTER TABLE card ADD CONSTRAINT fk_id FOREIGN KEY (id) REFERENCES account (id);

