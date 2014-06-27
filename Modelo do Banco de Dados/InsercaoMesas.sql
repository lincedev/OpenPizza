-- INSERIR MESAS
INSERT INTO Mesa(numero) VALUES(1);
INSERT INTO Mesa(numero) VALUES(2);
INSERT INTO Mesa(numero) VALUES(3);
INSERT INTO Mesa(numero) VALUES(4);
INSERT INTO Mesa(numero) VALUES(5);


-- INSERIR PIZZAS
INSERT INTO Produto (descricao) VALUES('Pizza de Calabresa');
INSERT INTO Pizza(codProduto, preco, tamanho, fatias, ingredientes) VALUES((SELECT codigo FROM Produto ORDER BY codigo DESC LIMIT 1), 5.0, 'Mini', 4, 'Calabresa');

INSERT INTO Produto (descricao) VALUES('Pizza de Calabresa');
INSERT INTO Pizza(codProduto, preco, tamanho, fatias, ingredientes) VALUES((SELECT codigo FROM Produto ORDER BY codigo DESC LIMIT 1), 10.0, 'Pequena', 6, 'Calabresa');

INSERT INTO Produto (descricao) VALUES('Pizza de Calabresa');
INSERT INTO Pizza(codProduto, preco, tamanho, fatias, ingredientes) VALUES((SELECT codigo FROM Produto ORDER BY codigo DESC LIMIT 1), 15.0, 'Média', 6, 'Calabresa');

INSERT INTO Produto (descricao) VALUES('Pizza de Calabresa');
INSERT INTO Pizza(codProduto, preco, tamanho, fatias, ingredientes) VALUES((SELECT codigo FROM Produto ORDER BY codigo DESC LIMIT 1), 20.0, 'Grande', 6, 'Calabresa');


INSERT INTO Produto (descricao) VALUES('Pizza de Lombinho');
INSERT INTO Pizza(codProduto, preco, tamanho, fatias, ingredientes) VALUES((SELECT codigo FROM Produto ORDER BY codigo DESC LIMIT 1), 6.0, 'Mini', 4, 'Lombrinho');

INSERT INTO Produto (descricao) VALUES('Pizza de Lombinho');
INSERT INTO Pizza(codProduto, preco, tamanho, fatias, ingredientes) VALUES((SELECT codigo FROM Produto ORDER BY codigo DESC LIMIT 1), 11.0, 'Pequena', 6, 'Lombinho');

INSERT INTO Produto (descricao) VALUES('Pizza de Lombinho');
INSERT INTO Pizza(codProduto, preco, tamanho, fatias, ingredientes) VALUES((SELECT codigo FROM Produto ORDER BY codigo DESC LIMIT 1), 16.0, 'Média', 6, 'Lombinho');

INSERT INTO Produto (descricao) VALUES('Pizza de Lombinho');
INSERT INTO Pizza(codProduto, preco, tamanho, fatias, ingredientes) VALUES((SELECT codigo FROM Produto ORDER BY codigo DESC LIMIT 1), 21.0, 'Grande', 6, 'Lombinho');


-- INSERIR LANCHES
INSERT INTO Produto(descricao) VALUES('X Salada');
INSERT INTO Lanche(codProduto, preco, ingredientesLanche) VALUES((SELECT codigo FROM Produto ORDER BY codigo DESC LIMIT 1), 5.0, 'Pão, hamburger, salada');

INSERT INTO Produto(descricao) VALUES('X Bacon');
INSERT INTO Lanche(codProduto, preco, ingredientesLanche) VALUES((SELECT codigo FROM Produto ORDER BY codigo DESC LIMIT 1), 6.0, 'Pão, hamburger, bacon');

-- INSERIR BEBIDAS
INSERT INTO Produto(descricao) VALUES('Suco de Laranja');
INSERT INTO Bebidas(codProduto, preco) VALUES((SELECT codigo FROM Produto ORDER BY codigo DESC LIMIT 1), 2.5);

INSERT INTO Produto(descricao) VALUES('Coca-Cola 600ml');
INSERT INTO Bebidas(codProduto, preco) VALUES((SELECT codigo FROM Produto ORDER BY codigo DESC LIMIT 1), 2.5);

-- INSERIR OUTROS
INSERT INTO Produto(descricao) VALUES('Chocolate Prestígio');
INSERT INTO Outros(codProduto, preco) VALUES((SELECT codigo FROM Produto ORDER BY codigo DESC LIMIT 1), 2.0);

INSERT INTO Produto(descricao) VALUES('Trufa');
INSERT INTO Outros(codProduto, preco) VALUES((SELECT codigo FROM Produto ORDER BY codigo DESC LIMIT 1), 2.2);