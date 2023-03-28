CREATE TABLE cities
(
    id    BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE hotels
(
    id      BIGSERIAL PRIMARY KEY,
    title   VARCHAR(255)                  NOT NULL,
    rate    REAL,
    address VARCHAR(255)                  NOT NULL,
    city_id BIGINT REFERENCES cities (id) NOT NULL
);

CREATE TABLE rooms
(
    id            BIGSERIAL PRIMARY KEY,
    room_number   INTEGER                       NOT NULL,
    floor         INTEGER                       NOT NULL,
    state         BOOLEAN                       NOT NULL DEFAULT true,
    price_per_day REAL                          NOT NULL,
    hotel_id      BIGINT REFERENCES hotels (id) NOT NULL
);

CREATE TABLE users
(
    id               BIGSERIAL PRIMARY KEY,
    name             VARCHAR(255),
    surname          VARCHAR(255),
    date_of_birth    DATE,
    username         VARCHAR(255) NOT NULL,
    password         VARCHAR(255) NOT NULL,
    password_confirm VARCHAR(255)
);

CREATE TABLE roles
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE users_roles
(
    roles_id BIGINT REFERENCES roles (id),
    user_id  BIGINT REFERENCES users (id),
    PRIMARY KEY (roles_id, user_id)
);

CREATE TABLE rents
(
    id             BIGSERIAL PRIMARY KEY,
    room_id        BIGINT REFERENCES rooms (id) NOT NULL,
    user_id        BIGINT REFERENCES users (id) NOT NULL,
    entry_date     DATE                         NOT NULL,
    departure_date DATE                         NOT NULL,
    total_price    REAL                         NOT NULL,
    state          BOOLEAN                      NOT NULL default true
);

CREATE TABLE additional_features
(
    id          BIGSERIAL PRIMARY KEY,
    description TEXT,
    price       REAL NOT NULL
);

CREATE TABLE rents_additional_features_entities
(
    rent_entity_id               BIGINT REFERENCES rents (id),
    additional_features_entities_id BIGINT REFERENCES additional_features (id),

    PRIMARY KEY (rent_entity_id, additional_features_entities_id)
)
