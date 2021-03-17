CREATE TABLE states(
    state_id int primary key,
    state_name varchar(30)
);

CREATE TABLE cities(
    city_id int primary key,
    city_name varchar(30),
    state_id int,
    foreign key (state_id) references states(state_id)
);

CREATE TABLE zip(
    zip_code int primary key,
    city_id int,
    foreign key (city_id) references cities(city_id)
);

INSERT INTO states (state_id, state_name) VALUES(1, "J&K");
INSERT INTO states (state_id, state_name) VALUES(2, "Kerala");
INSERT INTO states (state_id, state_name) VALUES(3, "Goa");
INSERT INTO states (state_id, state_name) VALUES(4, "Punjab");
INSERT INTO states (state_id, state_name) VALUES(5, "Jharkhand");
INSERT INTO states (state_id, state_name) VALUES(6, "Rajasthan");

INSERT INTO cities (city_id, city_name, state_id) VALUES(100, "Shrinagar",1);
INSERT INTO cities (city_id, city_name, state_id) VALUES(101, "Kochi",2);
INSERT INTO cities (city_id, city_name, state_id) VALUES(102, "Ranchi",5);
INSERT INTO cities (city_id, city_name, state_id) VALUES(103, "Jaipur",6);
INSERT INTO cities (city_id, city_name, state_id) VALUES(104, "Ladhak",1);
INSERT INTO cities (city_id, city_name, state_id) VALUES(105, "Chandigarh",4);
INSERT INTO cities (city_id, city_name, state_id) VALUES(106, "Dhanbad",5);

INSERT INTO zip (zip_code, city_id) VALUES(302017, 103);
INSERT INTO zip (zip_code, city_id) VALUES(834001, 102);
INSERT INTO zip (zip_code, city_id) VALUES(453356, 104);
INSERT INTO zip (zip_code, city_id) VALUES(987678, 105);
INSERT INTO zip (zip_code, city_id) VALUES(234534, 106);

SELECT z.zip_code, c.city_name, s.state_name
FROM zip z INNER JOIN cities c ON z.city_id = c.city_id
INNER JOIN states s ON c.state_id = s.state_id
WHERE zip_code=302017;