package academy.wakanda.wakacop.pauta.application.service;

import org.springframework.stereotype.Service;

import academy.wakanda.wakacop.pauta.application.api.request.NovaPautaRequest;
import academy.wakanda.wakacop.pauta.application.api.response.PautaCadastradaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PautaApplicationService implements PautaService {

	@Override
	public PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta) {
		log.info("[inicia] PautaApplicationService - cadastraPauta");
		log.info("[novaPauta] {}", novaPauta);
		log.info("[finaliza] PautaApplicationService - cadastraPauta");
		return null;
	}

}
