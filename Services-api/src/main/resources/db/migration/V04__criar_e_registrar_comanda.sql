CREATE TABLE comanda (
  id BIGINT NOT NULL AUTO_INCREMENT,
  cod_mesa BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (cod_mesa) REFERENCES mesa (id));


INSERT INTO comanda (cod_mesa) VALUES(1);
INSERT INTO comanda (cod_mesa) VALUES(2);
INSERT INTO comanda (cod_mesa) VALUES(3);
INSERT INTO comanda (cod_mesa) VALUES(4);
INSERT INTO comanda (cod_mesa) VALUES(5);
INSERT INTO comanda (cod_mesa) VALUES(6);