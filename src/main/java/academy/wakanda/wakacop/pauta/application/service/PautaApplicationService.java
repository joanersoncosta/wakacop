package academy.wakanda.wakacop.pauta.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import academy.wakanda.wakacop.pauta.application.api.request.NovaPautaRequest;
import academy.wakanda.wakacop.pauta.application.api.response.PautaCadastradaResponse;
import academy.wakanda.wakacop.pauta.application.repository.PautaRepsitory;
import academy.wakanda.wakacop.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PautaApplicationService implements PautaService {
	private final PautaRepsitory pautaRepsitory;
	
	@Override
	public PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta) {
		log.debug("[inicia] PautaApplicationService - cadastraPauta");
		log.debug("[novaPauta] {}", novaPauta);
		Pauta pauta = pautaRepsitory.salva(new Pauta(novaPauta));
		log.debug("[finaliza] PautaApplicationService - cadastraPauta");
		return new PautaCadastradaResponse(pauta);
	}

	@Override
	public Pauta getPautaPorId(UUID idPauta) {
		log.debug("[inicia] PautaApplicationService - getPautaPorId");
		log.debug("[idPauta] {}", idPauta);
		Pauta pauta = pautaRepsitory.buscaPautaporId(idPauta);
		log.debug("[finaliza] PautaApplicationService - getPautaPorId");
		return pauta;
	}
}