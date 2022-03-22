package Dictionary;

public class Slangword {
    private String keyword;
    private String Definition;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDefinition() {
        return Definition;
    }

    public void setDefinition(String definition) {
        Definition = definition;
    }

    public Slangword() {
    }

    public Slangword(String keyword, String definition) {
        this.keyword = keyword;
        Definition = definition;
    }
}
