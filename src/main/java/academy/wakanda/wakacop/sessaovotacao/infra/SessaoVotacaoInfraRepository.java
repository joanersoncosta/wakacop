package academy.wakanda.wakacop.sessaovotacao.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import academy.wakanda.wakacop.sessaovotacao.application.repository.SessaoVotacaoRepsitory;
import academy.wakanda.wakacop.sessaovotacao.domin.SessaoVotacao;
import academy.wakanda.wakacop.sessaovotacao.domin.StatusSessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class SessaoVotacaoInfraRepository implements SessaoVotacaoRepsitory {
	private final SessaoVotacaoSpringDataJPARepository sessaoVotacaoSpringDataJPARepository;

	@Override
	public SessaoVotacao salva(SessaoVotacao sessaoVotacao) {
		log.debug("[start] PautaInfraRepository - salva");
		sessaoVotacaoSpringDataJPARepository.save(sessaoVotacao);
		log.debug("[finish] PautaInfraRepository - salva");
		return sessaoVotacao;
	}

	@Override
	public SessaoVotacao buscaSessaoPorId(UUID idSessao) {
		log.debug("[start] PautaInfraRepository - buscaSessaoPorId");
		SessaoVotacao sessao = sessaoVotacaoSpringDataJPARepository.findById(idSessao)
				.orElseThrow(() -> new RuntimeException("Sess]ao não encontrada!"));
		log.debug("[finish] PautaInfraRepository - buscaSessaoPorId");
		return sessao;
	}

	@Override
	public List<SessaoVotacao> buscaSessoesAbertas() {
		log.debug("[start] PautaInfraRepository - buscaSessoesAbertas");
		
		log.debug("[finish] PautaInfraRepository - buscaSessoesAbertas");
		List<SessaoVotacao> sessoes = sessaoVotacaoSpringDataJPARepository.findByStatus(StatusSessaoVotacao.ABERTA);;
		return sessoes ;
	}
}
