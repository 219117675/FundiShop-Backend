package za.ac.cput.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseService<T> {

    private final JpaRepository<T, Long> repository;

    protected BaseService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public T update(T entity) {
        return repository.save(entity);
    }

    public T getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found with id: " + id));
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Record not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
