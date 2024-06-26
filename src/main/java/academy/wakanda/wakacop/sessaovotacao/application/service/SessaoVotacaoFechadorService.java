package academy.wakanda.wakacop.sessaovotacao.application.service;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import academy.wakanda.wakacop.sessaovotacao.application.repository.SessaoVotacaoRepsitory;
import academy.wakanda.wakacop.sessaovotacao.domin.PublicadorResultadoSessao;
import academy.wakanda.wakacop.sessaovotacao.domin.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoFechadorService {
	private final SessaoVotacaoRepsitory sessaoVotacaoRepsitory;
	private final PublicadorResultadoSessao publicador;

	@Scheduled(cron = "0 * * * * *")
	public void fechaSessoesEncerradas() {
		log.debug("[start] SessaoVotacaoFechadorService - fechaSessoesEncerradas");
		List<SessaoVotacao> sessoesAbertas = sessaoVotacaoRepsitory.buscaSessoesAbertas();
		log.debug("[sessaoAberta] {}", sessoesAbertas);
		sessoesAbertas.forEach(sessao -> {
			sessao.obtemResultado(publicador);
			sessaoVotacaoRepsitory.salva(sessao);
		});
		log.debug("[finish] SessaoVotacaoFechadorService - fechaSessoesEncerradas");
	}
}