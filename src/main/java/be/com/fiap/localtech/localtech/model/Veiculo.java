package be.com.fiap.localtech.localtech.model;

import be.com.fiap.localtech.localtech.dtos.VeiculoRequestsDTO;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Veiculo {

    private Long id;
    private String marca;
    private String modelo;
    private String placa;
    private Integer ano;
    private String cor;
    private BigDecimal valorDiaria;

    public Veiculo(VeiculoRequestsDTO veiculoDTO) {
        this.marca = veiculoDTO.marca();
        this.modelo = veiculoDTO.modelo();
        this.placa = veiculoDTO.placa();
        this.ano = veiculoDTO.ano();
        this.cor = veiculoDTO.cor();
        this.valorDiaria = veiculoDTO.valorDiaria();
    }
}


