package resources;

public enum Variables {
    ResourcePath("C:\\Snowden\\Programing_School\\JobHunt\\UniversityApiTesting\\src\\test\\java\\resources\\SearchParameters.csv"),
    BaseUrl("http://universities.hipolabs.com"),
    SearchBarForName("/search?name=");

    private final String value;

    Variables(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}