DROP TABLE IF EXISTS arrays, array_values CASCADE;

CREATE TABLE IF NOT EXISTS arrays (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    name VARCHAR UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS array_values (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    array_id INTEGER NOT NULL REFERENCES arrays(id) ON UPDATE CASCADE ON DELETE CASCADE,
    value INTEGER,
    sort VARCHAR NOT NULL
);