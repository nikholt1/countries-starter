package ek.ianb.countries.controller;

import ek.ianb.countries.model.Country;
import ek.ianb.countries.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("")
    public String getCountries(Model model) {
        List<Country> countries = countryService.findAllCountries();
        model.addAttribute("countries", countries);
        return "countries";
    }
}
