import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by dkomp on 27/6/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestModel {


    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String visibility;


    private String name;

    @Override
    public String toString() {
        return "TestModel{" +
                "visibility='" + visibility + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
