CREATE TABLE engines(
    id SERIAL PRIMARY KEY,
    name VARCHAR
);

CREATE TABLE cars(
    id SERIAL PRIMARY KEY,
    name VARCHAR ,
    carBrand VARCHAR,
    carBody VARCHAR,
    engine_id INT NOT NULL UNIQUE REFERENCES engines(id)
);

CREATE TABLE drivers(
    id SERIAL PRIMARY KEY,
    name VARCHAR
);

CREATE TABLE history_owner(
    id SERIAL PRIMARY KEY,
    driver_id INT NOT NULL REFERENCES drivers(id),
    car_id INT NOT NULL REFERENCES cars(id)
);

CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    name VARCHAR
);

CREATE TABLE promos(
    id SERIAL PRIMARY KEY,
    description TEXT,
    photo BYTEA,
    status BOOLEAN,
    user_id INT NOT NULL REFERENCES users(id)
);


