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
public class IncomeOusideUKController {

    private QuestionService questionService;
    private QuestionRepository questionRepository;

    public IncomeOusideUKController(QuestionService questionService, QuestionRepository questionRepository) {
        this.questionService = questionService;
        this.questionRepository = questionRepository;
    }

    @GetMapping("/income-outside-uk")
    public String governmentGrants(Model model) throws IOException {
        Question question = questionService.getQuestionById("income-outside-uk");
        model.addAttribute("question", question);
        return "income-outside-uk";
    }
    @PostMapping ("/income-outside-uk")
    public String handleSubmit(@ModelAttribute("question") Question question, BindingResult bindingResult, Model model) throws IOException {
        if (question.getSelectedOption() == null || question.getSelectedOption().isEmpty()) {
            bindingResult.rejectValue("selectedOption", "required", "Please select an option.");
            return "income-outside-uk";
        }
        questionRepository.save(question);
        return "redirect:/next-url";
    }
}
