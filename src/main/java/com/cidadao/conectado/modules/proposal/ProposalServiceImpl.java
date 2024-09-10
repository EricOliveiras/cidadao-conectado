package com.cidadao.conectado.modules.proposal;

import com.cidadao.conectado.config.error.CustomException;
import com.cidadao.conectado.modules.proposal.payload.request.CreateProposalRequest;
import com.cidadao.conectado.modules.proposal.payload.response.ProposalResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

public class ProposalServiceImpl implements IProposalService {
    private final ProposalRepository proposalRepository;
    private final ProposalMapper proposalMapper;

    public ProposalServiceImpl(ProposalRepository proposalRepository, ProposalMapper proposalMapper) {
        this.proposalRepository = proposalRepository;
        this.proposalMapper = proposalMapper;
    }

    @Override
    public ProposalResponse create(CreateProposalRequest proposalRequest) {
        Proposal proposal = proposalMapper.toEntity(proposalRequest);
        return proposalMapper.toDto(proposalRepository.save(proposal));
    }

    @Override
    public ProposalResponse read(Long id) {
        return proposalMapper.toDto(readById(id));
    }

    @Override
    public List<ProposalResponse> readAll() {
        Page<Proposal> proposals = proposalRepository.findAll(
                PageRequest.of(0, 20, Sort.by("id"))
        );
        return proposals
                .stream()
                .map(proposalMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProposalResponse update(Long id, CreateProposalRequest proposalRequest) {
        Proposal proposal = readById(id);
        BeanUtils.copyProperties(proposalRequest, proposal, "id");
        return proposalMapper.toDto(proposalRepository.save(proposal));
    }

    @Override
    public boolean delete(Long id) {
        Proposal proposal = readById(id);
        proposalRepository.delete(proposal);
        return true;
    }

    private Proposal readById(Long id) {
        return proposalRepository.findById(id)
                .orElseThrow(
                        () -> new CustomException("proposal not found", HttpStatus.NOT_FOUND)
                );
    }
}
