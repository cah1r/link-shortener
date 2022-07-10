package pl.sii.linkshortener.link.api;

import pl.sii.linkshortener.link.api.LinkDto;

public interface LinkService {

    LinkDto createLink(LinkDto toDto);
    String getLink(String id);
}
