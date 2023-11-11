CREATE TABLE IF NOT EXISTS card (
    id SERIAL PRIMARY KEY,
    account_id INT NOT NULL REFERENCES account (id),
    card_number VARCHAR(255) NOT NULL UNIQUE,
    membership VARCHAR(255) NOT NULL,
    description_status VARCHAR(255) NOT NULL,
    balance INT NOT NULL
);
