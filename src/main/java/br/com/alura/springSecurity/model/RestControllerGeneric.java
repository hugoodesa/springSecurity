package br.com.alura.springSecurity.model;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import br.com.alura.springSecurity.interfaces.CrudController;

public abstract class RestControllerGeneric<Entity extends MainEntity, Repository extends JpaRepository<Entity, Long>>
		implements CrudController<Entity> {

	@Autowired
	Repository repository;

	@Override
	public ResponseEntity<Entity> post(Entity body) {
		try {
			Entity savedEntity = this.repository.save(body);
			return ResponseEntity.ok(savedEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}

	@Override
	public ResponseEntity<Entity> update(Long id, Entity body) {
		try {
			Optional<Entity> entityFind = this.repository.findById(id);
			
			if(entityFind.isPresent()) {
				body.setId(id);
				this.repository.save(body);
				return ResponseEntity.ok(body);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}

	@Override
	public ResponseEntity<Entity> delete(Long id) {
		try {
			this.repository.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}

	@Override
	public ResponseEntity<Entity> get(Long id) {
		try {
			Optional<Entity> entidadeSelecionada = this.repository.findById(id);
			if(entidadeSelecionada.isPresent()) {
				return ResponseEntity.ok(entidadeSelecionada.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}
	
	@Override
	public Page<Entity> getAll(@PageableDefault(direction = Direction.ASC,page = 0,size = 5) Pageable paginacao) {
		return this.repository.findAll(paginacao);
	}

}
