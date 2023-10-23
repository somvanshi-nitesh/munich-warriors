-- Create a table to store information about cricket players
CREATE TABLE players (
    player_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    date_of_birth DATE,
    country VARCHAR(50),
    role VARCHAR(10),
    batting_hand VARCHAR(10),
    bowling_style VARCHAR(20)
);

-- Create a table to store information about cricket teams
CREATE TABLE team (
    team_id INT PRIMARY KEY AUTO_INCREMENT,
    team_name VARCHAR(100) NOT NULL,
    home_ground VARCHAR(100),
    captain VARCHAR(100),
    established_year INT
);

-- Create a table to store cricket player statistics
CREATE TABLE player_statistics (
    statistic_id INT PRIMARY KEY AUTO_INCREMENT,
    player_id INT,
    matches_played INT,
    runs_scored INT,
    wickets_taken INT,
    centuries INT,
    fifties INT,
    FOREIGN KEY (player_id) REFERENCES players(player_id)
);
