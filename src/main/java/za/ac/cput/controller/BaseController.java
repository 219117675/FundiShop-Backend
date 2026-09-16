package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<T> {

    protected abstract Object getService();

    protected abstract T createEntity(T entity);
    protected abstract T updateEntity(T entity);
    protected abstract T getEntity(Long id);
    protected abstract List<T> getEntities();
    protected abstract void deleteEntity(Long id);

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        return ResponseEntity.ok(createEntity(entity));
    }

    @PutMapping
    public ResponseEntity<T> update(@RequestBody T entity) {
        return ResponseEntity.ok(updateEntity(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getEntity(id));
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        return ResponseEntity.ok(getEntities());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteEntity(id);
        return ResponseEntity.noContent().build();
    }
}
