package co.grandcircus.hiblab.lab24;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.hiblab.lab24.dao.PartyDao;
import co.grandcircus.hiblab.lab24.dao.PartyOptionDao;
import co.grandcircus.hiblab.lab24.entity.Party;
import co.grandcircus.hiblab.lab24.entity.PartyOption;

@Controller
public class lab24Controller {
	@Autowired
	private PartyDao dao;
	@Autowired
	private PartyOptionDao dao2;
	
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
		return "partyOption";
	}
	@RequestMapping("/votes-page")
	public String votesPage(Model model) {
		List<partyoption> partyoption = dao2.findAll();
//		model.addAttribute("partyoption", partyoption);
		return "votes";
	}
	@RequestMapping("/review-page")
	public String reviewPage() {
		return "review";
	}
	@RequestMapping("/addVotes")
	public String vote(@RequestParam("id") Long id, Model model) {
		PartyOption partyOption = dao2.findById(id).get();
		partyOption.setVotes(partyOption.getVotes()+1);
		dao2.save(partyOption);
		return "redirect:/vote-page";
	}
	@PostMapping("/vote-page/add")
	public String submitAdd(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("votes") int votes) {
		PartyOption newParty = new PartyOption();
		newParty.setName(name);
		newParty.setDescription(description);
		newParty.setVotes(0);
		dao2.save(newParty);
		return "redirect:/vote-page";
	}
}
