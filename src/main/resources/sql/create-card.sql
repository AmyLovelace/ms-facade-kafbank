CREATE OR REPLACE FUNCTION create_card()
RETURNS TRIGGER AS $$
BEGIN
  INSERT INTO card (account_id, cardnumber, membership, descriptionstatus, balance)
  VALUES ('${account_id}', '${cardnumber}', '${membership}', '${descriptionstatus}',
  '${balance}');

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TABLE IF NOT EXISTS card (
  id SERIAL PRIMARY KEY,
  account_id INT NOT NULL,
  cardnumber VARCHAR(255) NOT NULL UNIQUE,
  membership VARCHAR(255) NOT NULL,
  descriptionstatus VARCHAR(255) NOT NULL,
  balance INT NOT NULL
);
