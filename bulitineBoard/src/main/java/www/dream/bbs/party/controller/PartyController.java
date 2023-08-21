package www.dream.bbs.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import www.dream.bbs.party.model.AccountabilityVO;
import www.dream.bbs.party.model.OrganizationVO;
import www.dream.bbs.party.model.PartyVO;
import www.dream.bbs.party.model.PersonVO;
import www.dream.bbs.party.service.PartyService;
import www.dream.bbs.security.dto.SignUpResultDto;

@RestController  //Container에 담기도록 지정
@RequestMapping("/party")
public class PartyController {
	
	@Autowired
	private PartyService partyService;

	@GetMapping("/listAllMember") //  http://localhost:8080/party/listAllMember?ownerId=0000
	public ResponseEntity<List<PersonVO>> listAllMember(/*@RequestParam("id")*/ String ownerId){
		return ResponseEntity.ok(partyService.listAllMember(ownerId));
	}
	
	@PostMapping("/createOrganization") //  http://localhost:8080/party/createOrganization
	public ResponseEntity<Integer> createOrganization(OrganizationVO organization){
		return ResponseEntity.ok(partyService.createOrganization(organization));
	}
	
	@PostMapping("/createManager") //  http://localhost:8080/party
	public ResponseEntity<Integer> createManager(OrganizationVO organization, PersonVO person){
		return ResponseEntity.ok(partyService.createManager(organization, person));
	}
	
	@PostMapping("/anonymous/createMember") //  http://localhost:8080/party
	public ResponseEntity<Integer> createMember(OrganizationVO organization, PersonVO person){
		return ResponseEntity.ok(partyService.createMember(organization, person));
	}
	
	
	@PostMapping("/createAccountability") //  http://localhost:8080/party
	public ResponseEntity<Integer> createAccountability(AccountabilityVO accountabilityVO){
		return ResponseEntity.ok(partyService.createAccountability(accountabilityVO));
	}
	
}
