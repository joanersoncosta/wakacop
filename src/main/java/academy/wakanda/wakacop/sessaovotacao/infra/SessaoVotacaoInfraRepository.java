package academy.wakanda.wakacop.sessaovotacao.infra;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import academy.wakanda.wakacop.sessaovotacao.application.repository.SessaoVotacaoRepsitory;
import academy.wakanda.wakacop.sessaovotacao.domin.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class SessaoVotacaoInfraRepository implements SessaoVotacaoRepsitory {
	private final SessaoVotacaoSpringDataJPARepository sessaoVotacaoSpringDataJPARepository;

	@Override
	public SessaoVotacao salva(SessaoVotacao sessaoVotacao) {
		log.info("[start] PautaInfraRepository - salva");
		sessaoVotacaoSpringDataJPARepository.save(sessaoVotacao);
		log.info("[finish] PautaInfraRepository - salva");
		return sessaoVotacao;
	}

	@Override
	public SessaoVotacao buscaSessaoPorId(UUID idSessao) {
		log.info("[start] PautaInfraRepository - buscaSessaoPorId");
		SessaoVotacao sessao = sessaoVotacaoSpringDataJPARepository.findById(idSessao)
				.orElseThrow(() -> new RuntimeException("Sess]ao não encontrada!"));
		log.info("[finish] PautaInfraRepository - buscaSessaoPorId");
		return sessao;
	}
}
