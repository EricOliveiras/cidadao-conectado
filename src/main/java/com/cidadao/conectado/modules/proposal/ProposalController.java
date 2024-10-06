package com.cidadao.conectado.modules.proposal;

import com.cidadao.conectado.modules.proposal.payload.request.CreateProposalRequest;
import com.cidadao.conectado.modules.proposal.payload.response.ProposalResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/proposals")
public class ProposalController {
    private final IProposalService iProposalService;

    public ProposalController(IProposalService iProposalService) {
        this.iProposalService = iProposalService;
    }

    @PostMapping
    public ResponseEntity<ProposalResponse> create(@Valid @RequestBody CreateProposalRequest proposal) {
        ProposalResponse proposalResponse = iProposalService.create(proposal);
        return ResponseEntity.status(HttpStatus.CREATED).body(proposalResponse);
    }

    @GetMapping
    public ResponseEntity<List<ProposalResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(iProposalService.readAll());
    }
}
