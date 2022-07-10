package pl.sii.linkshortener.link;

import org.springframework.stereotype.Component;
import pl.sii.linkshortener.link.api.LinkDto;
import pl.sii.linkshortener.link.api.LinkService;
import pl.sii.linkshortener.link.api.exception.LinkAlreadyExistsException;
import pl.sii.linkshortener.link.api.exception.LinkNotFoundException;

@Component
public class LinkServiceImpl implements LinkService {

    private final Repository repository;

    public LinkServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public LinkDto createLink(LinkDto linkDto) {
        if(repository.findById(linkDto.getId()).isPresent()) {
            throw new LinkAlreadyExistsException(linkDto.getId());
        }
        repository.save(linkDto);
        return repository.findById(linkDto.getId()).get();
    }
    @Override
    public String getLink(String id) {
        return repository.findById(id).orElseThrow(() -> new LinkNotFoundException(id)).getTargetUrl();
    }
}
