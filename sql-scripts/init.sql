create database if not exists projetobar;

USE projetobar;

CREATE TABLE IF NOT EXISTS `comanda` (
  `idcomanda` int NOT NULL,
  `data_criacao` timestamp NOT NULL,
  `valor_total` double DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `valor_de_custo` double DEFAULT NULL,
  `valor_de_venda` double DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `tipo_generico` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `produtos_na_comanda` (
  `idcomanda` int DEFAULT NULL,
  `valor_produto` double DEFAULT NULL,
  `nome_produto` varchar(100) DEFAULT NULL,
  `quantidade` int DEFAULT NULL,
  `data_comanda` timestamp NULL DEFAULT NULL,
  `identificador` int NOT NULL AUTO_INCREMENT,
  `status_comanda` varchar(100) NOT NULL,
  PRIMARY KEY (`identificador`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `roles` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into usuario (id, nome, senha, roles) values (1, "admin", "$2a$10$1U2SLBlsZrGhnpdsSJZfTOoitAhjJ8AHO6tVrs7LKW7HAT1tJhQBa", "ADMIN");