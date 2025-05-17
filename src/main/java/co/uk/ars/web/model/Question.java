package co.uk.ars.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collation = "governmentContracts")
@Getter
@Setter
@NoArgsConstructor
public class Question {
    @Id
    private String id;
    @JsonProperty("QuestionId")
    private String questionId;
    private String title;
    private String text;
    private String guidance;
    private String type;
    private List<String> options;
    private Map<String, String> errors;
    private String selectedOption;
}
