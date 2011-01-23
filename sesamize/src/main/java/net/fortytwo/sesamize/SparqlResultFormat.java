package net.fortytwo.sesamize;

/**
 * User: josh
 * Date: Apr 13, 2010
 * Time: 10:13:36 PM
 */
public enum SparqlResultFormat {
    // Note: the XML format is defined first, so that it is the default format.
    XML("application/sparql-results+xml", "xml"),
    JSON("application/sparql-results+json", "json"),
    TAB("text/tab-delimited-values", "tab"); // ~

    private final String mediaType;
    private final String[] nicknames;

    private SparqlResultFormat(final String mimeType,
                               final String... nicknames) {
        mediaType = mimeType;
        this.nicknames = nicknames;
    }

    public String getMediaType() {
        return mediaType;
    }

    public static SparqlResultFormat lookup(final String mediaType) {
        for (SparqlResultFormat f : SparqlResultFormat.values()) {
            if (f.mediaType.equals(mediaType)) {
                return f;
            }
        }

        return null;
    }

    public static SparqlResultFormat lookupByNickname(final String name) {
        for (SparqlResultFormat f : SparqlResultFormat.values()) {
            for (String s : f.nicknames) {
                if (s.equals(name)) {
                    return f;
                }
            }
        }

        return null;
    }
}
