DROP TABLE IF EXISTS player;
DROP TABLE IF EXISTS match;
DROP TABLE IF EXISTS team;
DROP SEQUENCE sqnc;

CREATE TABLE IF NOT EXISTS team
(
  team_id          INT DEFAULT nextval('sqnc') PRIMARY KEY,
  team_name        VARCHAR(200),
  points           INT,
  goals_for        INT,
  goals_against    INT,
  current_standing INT
);
CREATE TABLE IF NOT EXISTS player
(
  player_id        INT DEFAULT nextval('sqnc') PRIMARY KEY,
  player_name      VARCHAR(200),
  number           INT,
  playing_position VARCHAR(50),
  team_id          INT REFERENCES team (team_id)
);
CREATE TABLE IF NOT EXISTS match
(
  match_id         INT DEFAULT nextval('sqnc') PRIMARY KEY,
  home_team_id     INT REFERENCES team (team_id),
  guest_team_id    INT REFERENCES team (team_id),
  matchday         DATE,
  stadium          VARCHAR(200),
  home_team_score  INT DEFAULT 0,
  guest_team_score INT DEFAULT 0
);

INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    1,
    'Manchester City',
    72,
    79,
    20,
    1
  );
  INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    3,
    'Manchester United',
    59,
    53,
    20,
    2
  );
INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    2,
    'Liverpool',
    57,
    65,
    32,
    3
  );
  INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    5,
    'Tottenham Hotspur',
    55,
    53,
    24,
    4
  );
INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    4,
    'Chelsea',
    53,
    50,
    25,
    5
  );

INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    6,
    'Arsenal',
    45,
    51,
    36,
    6
  );
INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    7,
    'Burnley',
    37,
    22,
    25,
    7
  );
INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    8,
    'Leicester City',
    36,
    40,
    41,
    8
  );
INSERT INTO team (team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    9,
    'Everton',
    34,
    32,
    47,
    9
  );
INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    10,
    'Watford',
    33,
    38,
    47,
    10
  );
INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    11,
    'Bournemouth',
    32,
    33,
    43,
    11
  );
INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    12,
    'Brighton and Hove Albion',
    31,
    26,
    37,
    12
  );
INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    13,
    'West Ham United',
    30,
    35,
    50,
    13
  );
INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    14,
    'Huddersfield Town',
    30,
    25,
    48,
    14
  );
INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    15,
    'Newcastle United',
    29,
    27,
    38,
    15
  );
INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    16,
    'Southampton',
    27,
    29,
    41,
    16
  );
INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    17,
    'Crystal Palace',
    27,
    25,
    42,
    17
  );
INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    18,
    'Swansea City',
    27,
    21,
    41,
    18
  );
INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    19,
    'Stoke City',
    26,
    28,
    54,
    19
  );
INSERT INTO team (team_id,team_name, points, goals_for, goals_against, current_standing) VALUES
  (
    20,
    'West Bromwich Albion',
    20,
    22,
    42,
    20
  );



INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Ederson',
    31,
    'Goalkeeper',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Vincent Kompany',
    4,
    'Defender',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'John Stones',
    5,
    'Defender',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Nicolas Otamendi',
    30,
    'Defender',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Tosin Adarabioyo',
    24,
    'Defender',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Kyle Walker',
    2,
    'Defender',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Danilo',
    3,
    'Defender',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Benjamin Mendy',
    22,
    'Defender',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Aymeric Laporte',
    14,
    'Defender',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Bernardo Silva',
    20,
    'Midfielder',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Ilkay Gundogan',
    8,
    'Midfielder',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Kevin De Bruyne',
    17,
    'Midfielder',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Fabian Delph',
    18,
    'Midfielder',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Leroy Sane',
    19,
    'Midfielder',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'David Silva',
    21,
    'Midfielder',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Fernandinho',
    25,
    'Midfielder',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Oleksandr Zinchenko',
    35,
    'Midfielder',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Raheem Sterling',
    7,
    'Forward',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Sergio Aguero',
    10,
    'Forward',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Gabriel Jesus',
    33,
    'Forward',
    1
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'David de Gea',
    1,
    'Goalkeeper',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Sergio Romero',
    20,
    'Goalkeeper',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Victor Lindelof',
    2,
    'Defender',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Eric Bailly',
    3,
    'Defender',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Phil Jones',
    4,
    'Defender',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Marcos Rojo',
    5,
    'Defender',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Chris Smalling',
    12,
    'Defender',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Daley Blind',
    17,
    'Defender',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Luke Shaw',
    23,
    'Defender',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Antonio Valencia',
    25,
    'Defender',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Matteo Darmian',
    36,
    'Defender',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Paul Pogba',
    6,
    'Midfielder',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Juan Mata',
    8,
    'Midfielder',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Jesse Lingard',
    14,
    'Midfielder',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Michael Carrick',
    16,
    'Midfielder',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Ashley young',
    18,
    'Midfielder',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Ander Herrera',
    21,
    'Midfielder',
    3
  );

INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Marouane Fellaini',
    27,
    'Midfielder',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Nemanja Matic',
    31,
    'Midfielder',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Scott McTominay',
    39,
    'Midfielder',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Angel Gomes',
    47,
    'Midfielder',
    3
  );

INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Anthony Martial',
    11,
    'Forward',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Marcus Rashford',
    19,
    'Forward',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Romelu Lukaku',
    9,
    'Forward',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Zlatan Ibrahimovic',
    10,
    'Forward',
    3
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Alexis Sanchez',
    7,
    'Forward',
    3
  );
  INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Willy Caballero',
    1,
    'Goalkeeper',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Thibaut Courtois',
    13,
    'Goalkeeper',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Marcos Alonso',
    3,
    'Defender',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Marcos Alonso',
    3,
    'Defender',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Gary Cahill',
    24,
    'Defender',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Cesar Azpilicueta',
    28,
    'Defender',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'David Luiz',
    30,
    'Defender',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Antonio Rudiger',
    2,
    'Defender',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Andreas Christensen',
    27,
    'Defender',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Davide Zappacosta',
    21,
    'Defender',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Cesc Fabregas',
    4,
    'Midfielder',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Ngolo Kante',
    7,
    'Midfielder',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Eden Hazard',
    10,
    'Midfielder',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Victor Moses',
    15,
    'Willian',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Tiemoue Bakayoko',
    14,
    'Midfielder',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Daniel Drinkwater',
    6,
    'Midfielder',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Dujon Sterling',
    66,
    'Midfielder',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Pedro',
    11,
    'Forward',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Alvaro Morata',
    9,
    'Forward',
    4
  );
INSERT INTO player (player_name, number, playing_position, team_id) VALUES
  (
    'Olivier Giroud',
    18,
    'Forward',
    4
  );
  INSERT INTO match (home_team_id, guest_team_id, matchday, stadium, home_team_score,guest_team_score) VALUES
  (
      3,
    4,
    '2018-02-25',
    'Old Trafford, Manchester',
    2,
    1
  );
