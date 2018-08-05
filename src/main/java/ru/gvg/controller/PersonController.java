package ru.gvg.controller;

import ru.gvg.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gvg.repository.UserRepository;

import java.util.Map;

/**
 * @author Valeriy Gyrievskikh
 * @since 05.08.2018.
 */
@Controller
public class PersonController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"/person-list"}, method = RequestMethod.GET)
    public String personList(Map<String, Object> model) {
        model.put("persons", userRepository.getListUser());
        return "person-list";
    }

    @RequestMapping(value = {"/person-create"}, method = RequestMethod.GET)
    public String personCreate(Map<String, Object> model) {
        User user = new User();
        model.put("person", user);
        return "person-create";
    }

    @RequestMapping(value = {"/person-remove"}, method = RequestMethod.GET)
    public String personRemove(@RequestParam("id") String personId) {
        userRepository.removeUserById(personId);
        return "redirect:/person-list";
    }

    @RequestMapping(value = {"/person-edit"}, method = RequestMethod.GET)
    public String personEdit(@RequestParam("id") String personId, Map<String, Object> model) {
        final User user = userRepository.findOne(personId);
        model.put("person", user);
        return "person-edit";
    }

    @RequestMapping(value = {"/person-save"}, method = RequestMethod.POST)
    public String personSave(@ModelAttribute("person") User user) {
        userRepository.merge(user);
        return "redirect:/person-list";
    }

}
