
CREATE TABLE account (
  id SERIAL PRIMARY KEY,
  account_number VARCHAR(255) NOT NULL UNIQUE,
  age INT NOT NULL
);

CREATE TABLE card (
  id SERIAL PRIMARY KEY,
  account_id INT NOT NULL,
  card_number VARCHAR(255) NOT NULL UNIQUE,
  membership VARCHAR(255) NOT NULL,
  description_status VARCHAR(255) NOT NULL,
  balance INT NOT NULL
);

ALTER TABLE card ADD CONSTRAINT fk_account_id FOREIGN KEY (account_id) REFERENCES account (id);

CREATE TRIGGER account_insert_card
AFTER INSERT ON account
FOR EACH ROW
EXECUTE PROCEDURE create_card();

CREATE OR REPLACE FUNCTION create_card()
RETURNS TRIGGER AS $$
BEGIN
  INSERT INTO card (account_id, card_number, membership, description_status, balance)
  VALUES (NEW.id, generate_random_card_number(), 'Standard', 'Activo', 0);

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;
