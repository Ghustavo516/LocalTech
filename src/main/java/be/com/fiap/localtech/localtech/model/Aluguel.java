package be.com.fiap.localtech.localtech.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Aluguel {

    private Long id;
    private Pessoa pessoa;
    private Veiculo veiculo;
    private String veiculoModelo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private BigDecimal valorTotal;
}
