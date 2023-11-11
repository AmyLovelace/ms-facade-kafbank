CREATE OR REPLACE FUNCTION create_card()
RETURNS TRIGGER AS $$
BEGIN
  INSERT INTO card (account_id, card_number, membership, description_status, balance)
  VALUES (NEW.id, generate_random_card_number(), 'Standard', 'Activo', 0);

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TABLE IF NOT EXISTS card (
  id SERIAL PRIMARY KEY,
  account_id INT NOT NULL,
  card_number VARCHAR(255) NOT NULL UNIQUE,
  membership VARCHAR(255) NOT NULL,
  description_status VARCHAR(255) NOT NULL,
  balance INT NOT NULL
);
