CREATE TABLE engines(
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE cars(
    id SERIAL PRIMARY KEY,
    name TEXT,
    engine_id INT NOT NULL UNIQUE REFERENCES engines(id)
);

CREATE TABLE drivers(
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE history_owner(
    id SERIAL PRIMARY KEY,
    driver_id INT NOT NULL REFERENCES drivers(id),
    car_id INT NOT NULL REFERENCES cars(id)
);


