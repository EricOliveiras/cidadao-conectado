package com.cidadao.conectado.modules.proposal;

import com.cidadao.conectado.modules.proposal.payload.request.CreateProposalRequest;
import com.cidadao.conectado.modules.proposal.payload.response.ProposalResponse;

import java.util.List;

public interface IProposalService {
    ProposalResponse create(CreateProposalRequest proposalRequest);
    ProposalResponse read(Long id);
    List<ProposalResponse> readAll();
    ProposalResponse update(Long id, CreateProposalRequest proposalRequest);
    boolean delete(Long id);
}
