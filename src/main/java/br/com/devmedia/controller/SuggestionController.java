package br.com.devmedia.controller;

import br.com.devmedia.model.Contact;
import br.com.devmedia.model.Phone;
import br.com.devmedia.model.Suggestion;
import br.com.devmedia.repository.ContactRepository;
import br.com.devmedia.repository.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SuggestionController implements WebMvcConfigurer {

    private SuggestionRepository suggestionRepository;
    private ContactRepository contactRepository;

    @Autowired
    public SuggestionController(SuggestionRepository suggestionRepository, ContactRepository contactRepository) {
        this.suggestionRepository = suggestionRepository;
        this.contactRepository = contactRepository;
    }

    @GetMapping("/")
    public String listSuggestion(Model model) {
        List<Suggestion> suggestions = new ArrayList<>();
        suggestionRepository.findAll().forEach(suggestions::add);

        model.addAttribute("suggestions", suggestions);

        return "suggestion/list";
    }

    @GetMapping("suggestion")
    public String formSuggestion(final Suggestion suggestion, Model model) {
        Contact contact = new Contact();
        contact.getPhones().add(new Phone());

        suggestion.setContact(contact);

        model.addAttribute("suggestion", suggestion);

        return "suggestion/new";
    }

    @PostMapping("suggestion")
    public String newSuggestion(@Valid @ModelAttribute Suggestion suggestion, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/suggestion/new";
        }

        Contact contact = suggestion.getContact();
        contact.getPhones().forEach(phone -> phone.setContact(contact));

        contactRepository.save(contact);
        suggestionRepository.save(suggestion);

        return "redirect:/";
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("suggestion/list");
        registry.addViewController("/suggestion").setViewName("suggestion/new");
    }
}
