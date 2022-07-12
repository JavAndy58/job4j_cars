CREATE TABLE engines(
    id SERIAL PRIMARY KEY
);

CREATE TABLE cars(
    id SERIAL PRIMARY KEY,
    engine_id INT NOT NULL UNIQUE REFERENCES engines(id)
);

CREATE TABLE drivers(
    id SERIAL PRIMARY KEY
);

CREATE TABLE history_owner(
    id SERIAL PRIMARY KEY,
    driver_id INT NOT NULL REFERENCES drivers(id),
    car_id INT NOT NULL REFERENCES cars(id)
);


