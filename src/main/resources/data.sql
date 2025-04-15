CREATE TABLE veiculos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(255),
    modelo VARCHAR(255),
    placa VARCHAR(255),
    ano INT,
    cor VARCHAR(255),
    valor_diaria DECIMAL(10,2)
);

CREATE TABLE pessoa (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      nome VARCHAR(255),
      sobrenome VARCHAR(255),
      cpf VARCHAR(255),
      telefone VARCHAR(255),
      email VARCHAR(255)
);

CREATE TABLE aluguel (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     pessoa_id BIGINT,
     veiculo_id BIGINT,
     veiculoModelo VARCHAR(255),
     dataInicio DATE,
     dataFim DATE,
     valorTotal DECIMAL(10,2),
     FOREIGN KEY (pessoa_id) REFERENCES pessoa(id),
     FOREIGN KEY (veiculo_id) REFERENCES veiculo(id)
);


INSERT INTO veiculos (marca, modelo, placa, ano, cor, valor_diaria)
VALUES ('Chevrolet', 'Celta', 'ABC-1234', 2010, 'preta', 100.00);

INSERT INTO pessoa (nome, sobrenome, cpf, telefone, email)
VALUES ('Gustavo', 'Rodrigues', '123.456.798-10', '11997083635', 'teste@gmail.com');

