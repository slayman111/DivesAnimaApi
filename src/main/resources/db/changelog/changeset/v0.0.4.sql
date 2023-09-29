CREATE TABLE daily_images
(
    id    INTEGER GENERATED ALWAYS AS IDENTITY NOT NULL,
    image BYTEA                                NOT NULL,
    CONSTRAINT pk_daily_images PRIMARY KEY (id)
);
