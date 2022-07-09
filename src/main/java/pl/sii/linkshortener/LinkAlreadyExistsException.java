package pl.sii.linkshortener;

public class LinkAlreadyExistsException extends RuntimeException {

    public LinkAlreadyExistsException(String id) {
        super("Link with " + id + " already exists");
    }
}
