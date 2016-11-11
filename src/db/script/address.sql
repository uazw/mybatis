CREATE TABLE address
(
      address_id SERIAL PRIMARY KEY,
      street_name CHARACTER VARYING(255) NOT NULL
);

INSERT INTO
address(address_id, street_name)
VALUES
(1, 'street_1');

INSERT INTO 
address(address_id, street_name)
VALUES
(2, 'street_2');


