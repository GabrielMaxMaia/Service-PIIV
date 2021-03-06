CREATE TABLE fechamento_pedido (
  id BIGINT NOT NULL AUTO_INCREMENT,
  cod_pedido BIGINT NULL DEFAULT NULL,
  hora_de_fechamento TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  valor_total DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (cod_pedido) REFERENCES pedido (id));