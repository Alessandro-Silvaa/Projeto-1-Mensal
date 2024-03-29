package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Produto;
import app.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Produto produto){
		try {
			String salvar = this.produtoService.save(produto);
			return new ResponseEntity<>(salvar, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update (@PathVariable long id, @RequestBody Produto produto){
		try {
			String alterar = this.produtoService.update(id, produto);
			return new ResponseEntity<>(alterar, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Produto>> listAll(){
		try {
			List<Produto> lista = this.produtoService.listAll();
			return new ResponseEntity<>(lista,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			String deletar = this.produtoService.delete(id);
			return new ResponseEntity<>(deletar, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByValor")
	
	public ResponseEntity<List<Produto>> findByValor(@RequestParam double valor){
		try {
			
			List<Produto> produto = this.produtoService.findByValor(valor);
			
			return new ResponseEntity<>(produto, HttpStatus.OK);
			
		} catch (Exception e) {			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
}
