CREATE TABLE score (
    scoreI BIGINT AUTO_INCREMENT PRIMARY KEY,s
    runs INT NOT NULL,
    wickets INT NOT NULL,
    overs INT NOT NULL,
    FOREIGN KEY (playerId) REFERENCES player(id)
);