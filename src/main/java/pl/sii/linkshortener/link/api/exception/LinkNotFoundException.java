package pl.sii.linkshortener.link.api.exception;

public class LinkNotFoundException extends RuntimeException {

    public LinkNotFoundException(String id) {
        super("Link with id=" + id + " not found");
    }
}
