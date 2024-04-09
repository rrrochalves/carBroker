CREATE TABLE carro(
    id INTEGER NOT NULL PRIMARY KEY IDENTITY,
    timestamp_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modelo_id INTEGER NOT NULL,
    ano INTEGER,
    combustivel VARCHAR(10),
    num_portas INTEGER,
    cor VARCHAR(10),
    CONSTRAINT carro_modelo_id_fkey FOREIGN KEY (modelo_id) REFERENCES modelo(id) ON DELETE RESTRICT ON UPDATE CASCADE
);