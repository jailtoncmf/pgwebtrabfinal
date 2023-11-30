CREATE TABLE Prato (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    ingredientes TEXT NOT NULL,
    tipo VARCHAR(20) NOT NULL
);

INSERT INTO Prato (nome, ingredientes, tipo) 
VALUES
    ('Frango Grelhado', 'Frango', 'prato principal'),
    ('Milkshake', 'Açúcar, Leite, Sorvete', 'sobremesa');
	
SELECT * FROM prato;

UPDATE prato SET nome = 'Coxinha' WHERE id = 8;

DELETE FROM prato;	

CREATE TABLE Pedido (
    id SERIAL PRIMARY KEY,
    data DATE NOT NULL,
    entrada INTEGER,
    principal INTEGER,
    sobremesa INTEGER,
    FOREIGN KEY (entrada) REFERENCES Prato(id),
    FOREIGN KEY (principal) REFERENCES Prato(id),
    FOREIGN KEY (sobremesa) REFERENCES Prato(id)
);

INSERT INTO Pedido (data, entrada, principal, sobremesa) VALUES
    ('2023-11-29', 1, 2, 3),
    ('2023-11-30', 2, 1, 3),
    ('2023-12-01', 3, 1, 2);
	
SELECT * FROM pedido;

UPDATE pedido SET nome = 'Coxinha' WHERE id = 8;

DELETE FROM pedido;
	
