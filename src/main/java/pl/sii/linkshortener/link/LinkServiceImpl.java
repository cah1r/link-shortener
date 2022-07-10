package pl.sii.linkshortener.link;

import org.springframework.stereotype.Service;
import pl.sii.linkshortener.controller.LinkDto;
import pl.sii.linkshortener.link.api.exception.LinkAlreadyExistsException;
import java.util.HashMap;
import java.util.Map;

@Service
public class LinkServiceImpl implements LinkService {

    final Map<String, LinkDto> repository = new HashMap<>();
    @Override
    public LinkDto createLink(LinkDto linkDto) {
        if(repository.get(linkDto.getId()) != null) {
            throw new LinkAlreadyExistsException(linkDto.getId());
        }
        repository.put(linkDto.getId(), linkDto);
        return linkDto;
    }
    @Override
    public String getLink(String id) {
        return repository.get(id).getTargetUrl();
    }
}
