package co.uk.ars.web.controller;

import co.uk.ars.web.model.Question;
import co.uk.ars.web.repository.QuestionRepository;
import co.uk.ars.web.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class GovernmentContractController {
    private final QuestionService questionService;
    private final QuestionRepository questionRepository;

    public GovernmentContractController(QuestionService questionService, QuestionRepository questionRepository) {
        this.questionService = questionService;
        this.questionRepository = questionRepository;
    }

    @GetMapping("/government-contracts")
    public String showForm(Model model) throws IOException {
        Question question = questionService.getQuestionById("government-contracts");
        model.addAttribute("question", question);
        return "government-contracts";
    }

    @PostMapping("/government-contracts")
    public String handleSubmit(@ModelAttribute("question") Question question,
                               BindingResult bindingResult,
                               Model model) {
        if (question.getSelectedOption() == null || question.getSelectedOption().isEmpty()) {
            bindingResult.rejectValue("selectedOption", "required", "Please select an option.");
            return "government-contracts";
        }

        questionRepository.save(question);
        return "redirect:/government-grants";
    }

}
