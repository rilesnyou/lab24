package co.grandcircus.hiblab.lab24;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.hiblab.lab24.dao.PartyDao;
import co.grandcircus.hiblab.lab24.dao.PartyOptionDao;
import co.grandcircus.hiblab.lab24.dao.RSVPdao;
import co.grandcircus.hiblab.lab24.entity.Party;
import co.grandcircus.hiblab.lab24.entity.PartyOption;
import co.grandcircus.hiblab.lab24.entity.RSVP;

@Controller
public class lab24Controller {
	@Autowired
	private PartyDao dao;
	@Autowired
	private PartyOptionDao dao2;
	@Autowired
	private RSVPdao dao3;

	@RequestMapping("/")
	public String index(Model model) {
		List<Party> party = dao.findAll();
		model.addAttribute("party", party);
		return "home";
	}

	@RequestMapping("/party")
	public String partyList(@RequestParam("id") List<Party> party) {
		return "party";
	}

	@RequestMapping("/partyOption")
	public String partyOptionList(@RequestParam("id") List<PartyOption> partyoption) {
		return "/votes-page";
	}

	@RequestMapping("/votes-page")
	public String votesPage(Model model) {
		List<PartyOption> partyoption = dao2.findAll();
		model.addAttribute("partyoption", partyoption);
		return "votes";
	}

	@RequestMapping("/review-page")
	public String reviewPage(Model model) {
		List<PartyOption> partyoption = dao2.findAll(Sort.by(Direction.DESC, "votes"));
		model.addAttribute("partyoption", partyoption);
		return "review";
	}

	@RequestMapping("/addVotes")
	public String vote(@RequestParam("id") Long id, Model model) {
		PartyOption partyOption = dao2.findById(id).get();
		partyOption.setVotes(partyOption.getVotes() + 1);
		dao2.save(partyOption);
		return "redirect:/votes-page";
	}

	@PostMapping("/vote-page/add")
	public String submitAdd(@RequestParam("name") String name, @RequestParam("description") String description,
			@RequestParam("votes") Integer votes) {
		PartyOption newParty = new PartyOption();
		newParty.setName(name);
		newParty.setDescription(description);
		newParty.setVotes(0);
		dao2.save(newParty);
		return "redirect:/review";
	}
	@RequestMapping("/save-rsvp")
	public String submitRSVP(RSVP rsvp) {
		dao3.save(rsvp);
		return "redirect:/party";
	}
	@RequestMapping("/rsvp/{id}")
	public String showRSVP(Model model, @PathVariable("id") Party party) {
		model.addAttribute("party", party);
		return "RSVP";
	}
}