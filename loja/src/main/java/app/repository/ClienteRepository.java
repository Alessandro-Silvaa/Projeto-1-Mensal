package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import app.entity.Cliente;




public interface ClienteRepository {
	public List<Cliente> findByNome(String nome);
	
	@Query("FROM Clientes c WHERE c.idade > :idade")
	public List<Cliente> findByIdade(int idade);
	
	public List<Cliente> findByCpf(int cpf);

}
