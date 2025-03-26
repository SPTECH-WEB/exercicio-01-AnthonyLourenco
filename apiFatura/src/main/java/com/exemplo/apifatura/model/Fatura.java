package com.exemplo.apifatura.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "faturas")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Não pode estar em branco")
    @Pattern(regexp = "\\d{16}")
    private String numeroCartao;

    @NotBlank(message = "Não pode estar em branco")
    @Size(min = 3, max = 100, message = "O nome do titular deve ter entre 3 e 100 caracteres")
    private String nomeTitular;

    @NotNull(message = "Valor invalido")
    @DecimalMin(value = "10.00", message = "O valor minimo é R$10.00")
    @DecimalMax(value = "5000.00", message = "O valor maximo é R$5000.00")
    private Double valor;

    @NotNull(message = "Não pode estar em branco")
    @FutureOrPresent(message = "Data de vencimento deve ser a data atual ou futura")
    private LocalDate dataPagamento;

    @NotBlank(message = "Não pode estar em branco")
    @Email(message = "Email invalido")
    private String emailContato;
}
