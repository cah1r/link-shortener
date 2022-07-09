package pl.sii.linkshortener;

import org.springframework.stereotype.Service;
import pl.sii.linkshortener.Controller.LinkDto;

import java.util.HashMap;
import java.util.Map;

@Service
class LinkServiceImpl implements LinkService {

    private Map<String, LinkDto> dtoMap = new HashMap<>();
    @Override
    public LinkDto createLink(LinkDto toDto) {
        if(dtoMap.get(toDto.getId()) != null) {
            throw new LinkAlreadyExistsException(toDto.getId());
        }
        dtoMap.put(toDto.getId(), toDto);

        return toDto;
    }

    @Override
    public String getLink(String id) {
        return dtoMap.get(id).getTargetUrl();
    }
}
