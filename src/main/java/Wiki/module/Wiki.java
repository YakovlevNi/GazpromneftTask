package Wiki.module;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Set;

@Entity
@Setter
@Getter
public class Wiki {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "create_timestamp")
    private LocalDateTime createTimestamp;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;


    @Column(name = "language")
    private String language;


    @Column(name = "wiki")
    private String wiki;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Category> categories;


    @Column(name = "title")
    private String title;


    @Column(name = "auxiliary_text", columnDefinition = "text")
    private String auxiliary_text;

    public String[] getAuxiliary_text() {
        return auxiliary_text
                .replaceAll("\"", "")
                .replace("[", "")
                .replace("]", "")
                .split(",");
    }
    public Long getCreateTimestamp() {
        return createTimestamp.atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    public void setCreateTimestamp(LocalDateTime createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Long getTimestamp() {
        return timestamp.atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "{\"id\": " +  id + ", \"createTimestamp\": " + getCreateTimestamp() + ", \"timestamp\": " + getTimestamp() +
                ", \"language\": " + language + ", \"wiki\": " + wiki + ", \"categories\": " +
                categories.toString() + ", \"title\": " + title +
                ", \"auxiliary_text\": " +
                Arrays.toString(auxiliary_text.replace("[", "").replace("]", "").split(","))
                + "}";
    }


}
