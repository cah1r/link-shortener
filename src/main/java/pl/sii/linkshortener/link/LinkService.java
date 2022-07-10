package pl.sii.linkshortener.link;

import pl.sii.linkshortener.controller.LinkDto;

public interface LinkService {

    LinkDto createLink(LinkDto toDto);
    String getLink(String id);
}
