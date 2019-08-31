CREATE TABLE parkingBoys(
  employeeID  VARCHAR PRIMARY KEY,
);

INSERT INTO parkingBoys values ('parkingboy_1');
INSERT INTO parkingBoys values ('parkingboy_2');
INSERT INTO parkingBoys values ('parkingboy_3');



CREATE TABLE parkingLots(
  parkingLotID  VARCHAR PRIMARY KEY,
  capacity INTEGER,
  availablePositionCount INTEGER,
  employeeID  VARCHAR
);

INSERT INTO parkingLots values ('lot_1','100','50','parkingboy_1');
INSERT INTO parkingLots values ('lot_2','100','60','parkingboy_2');
INSERT INTO parkingLots values ('lot_3','100','70','parkingboy_3');

