package pl.sii.linkshortener.link;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import pl.sii.linkshortener.link.api.LinkDto;

import java.util.Optional;
@Component
public class Repository implements CrudRepository<LinkDto, String> {

    @Override
    public <S extends LinkDto> S save(S entity) {
        return null;
    }

    @Override
    public <S extends LinkDto> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<LinkDto> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<LinkDto> findAll() {
        return null;
    }

    @Override
    public Iterable<LinkDto> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(LinkDto entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends LinkDto> entities) {

    }

    @Override
    public void deleteAll() {

    }

    void save(String id, LinkDto linkDto) {
    }
}
