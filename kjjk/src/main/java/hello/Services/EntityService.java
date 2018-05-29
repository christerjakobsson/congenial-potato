package hello.Services;

import hello.Models.EntityBase;
import hello.Repositories.EntityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

public class EntityService<T extends EntityBase> {

    protected EntityRepository<T> repository;

    public EntityService(EntityRepository<T> repository) {
        this.repository = repository;
    }

    public Page<T> findAll(int pageIndex, int pageSize) {
        Pageable page = PageRequest.of(pageIndex, pageSize);
        return repository.findAll(page);
    }

    public Iterable<T> findByIds(UUID[] ids) {
        return repository.findAllById(Arrays.asList(ids));
    }

    public Optional<T> find(UUID id) {
        return repository.findById(id);
    }

    public T save(T entity) {
        T updated = repository.save(entity);
        return updated;
    }

    public void delete(T entity) {
        repository.delete(entity);
    }

}
