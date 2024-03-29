package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;
	@NotBlank(message = "Campo nome não pode ser nulo")
	private String nome;
	@Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
	@NotBlank(message = "Cpf inválido")
	private String cpf;
	@NotNull
	private Integer idade;
	@Pattern(regexp = "(^\\([1-9]{2}\\) (?:[2-8]|9[0-9])[0-9]{3}\\-[0-9]{4}$)")
	@NotBlank(message = "Telefone inválido")
	private String telefone;
}
