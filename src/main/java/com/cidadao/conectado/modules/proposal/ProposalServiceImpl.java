package com.cidadao.conectado.modules.proposal;

import com.cidadao.conectado.config.error.CustomException;
import com.cidadao.conectado.modules.proposal.payload.request.CreateProposalRequest;
import com.cidadao.conectado.modules.proposal.payload.response.ProposalResponse;
import com.cidadao.conectado.modules.user.User;
import com.cidadao.conectado.modules.user.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProposalServiceImpl implements IProposalService {
    private final ProposalRepository proposalRepository;
    private final ProposalMapper proposalMapper;
    private final UserRepository userRepository;

    public ProposalServiceImpl(ProposalRepository proposalRepository, ProposalMapper proposalMapper, UserRepository userRepository) {
        this.proposalRepository = proposalRepository;
        this.proposalMapper = proposalMapper;
        this.userRepository = userRepository;
    }

    @Override
    public ProposalResponse create(CreateProposalRequest proposalRequest) {
        User user = readUserById(proposalRequest.getUserId());
        Proposal proposal = proposalMapper.toEntity(proposalRequest);
        proposal.setUser(user);
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
    public String delete(Long id) {
        return proposalRepository.findById(id)
                .map(proposal -> {
                    proposalRepository.delete(proposal);
                    return "proposal successfully deleted.";
                })
                .orElseThrow(() -> new CustomException("proposal not found", HttpStatus.NOT_FOUND));
    }

    private Proposal readById(Long id) {
        return proposalRepository.findById(id)
                .orElseThrow(
                        () -> new CustomException("proposal not found", HttpStatus.NOT_FOUND)
                );
    }

    private User readUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new CustomException("user not found", HttpStatus.NOT_FOUND)
                );
    }
}
