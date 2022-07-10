package pl.sii.linkshortener.link;

import org.springframework.stereotype.Component;
import pl.sii.linkshortener.link.api.LinkDto;
import pl.sii.linkshortener.link.api.LinkService;
import pl.sii.linkshortener.link.api.exception.LinkAlreadyExistsException;
import pl.sii.linkshortener.link.api.exception.LinkNotFoundException;

import javax.transaction.Transactional;

@Component
public class LinkServiceImpl implements LinkService {

    private final LinkRepository repository;

    public LinkServiceImpl(LinkRepository repository) {
        this.repository = repository;
    }

    @Override
    public LinkDto createLink(LinkDto linkDto) {
        if(repository.findById(linkDto.getId()).isPresent()) {
            throw new LinkAlreadyExistsException(linkDto.getId());
        }
        repository.save(LinkEntity.fromDto(linkDto));
        return linkDto;
    }
    @Override
    @Transactional
    public String getLink(String id) {
        LinkEntity linkEntity = repository.findById(id).orElseThrow(() -> new LinkNotFoundException(id));
        linkEntity.setVisits(linkEntity.getVisits()+1);
        return linkEntity.getTargetUrl();
    }
    @Override
    public LinkDto getLinkDto(String id) {
        return repository.findById(id).orElseThrow(() -> new LinkNotFoundException(id)).toDto();
    }
}
