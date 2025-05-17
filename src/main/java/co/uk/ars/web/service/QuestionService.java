package co.uk.ars.web.service;

import co.uk.ars.web.model.Question;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class QuestionService {
    private final ObjectMapper objectMapper;

    public QuestionService(ObjectMapper objectMapper) {
        this.objectMapper =objectMapper;
    }
    public Question getQuestionById(String questionId) throws IOException {
        InputStream is = new ClassPathResource("static/data/questions.json").getInputStream();
        List<Question> questions = objectMapper.readValue(is, new TypeReference<>() {});
        return questions.stream()
                .filter(q -> q.getQuestionId().equals(questionId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Question not found"));
    }

}
