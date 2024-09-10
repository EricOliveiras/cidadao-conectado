package com.cidadao.conectado.modules.proposal;

import com.cidadao.conectado.modules.proposal.payload.request.CreateProposalRequest;
import com.cidadao.conectado.modules.proposal.payload.response.ProposalResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProposalMapper {
    Proposal toEntity(CreateProposalRequest createProposalRequest);
    ProposalResponse toDto(Proposal proposal);
    List<ProposalResponse> toDto(List<Proposal> proposals);
}
