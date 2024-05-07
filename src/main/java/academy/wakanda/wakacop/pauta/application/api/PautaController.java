package academy.wakanda.wakacop.pauta.application.api;

import org.springframework.web.bind.annotation.RestController;

import academy.wakanda.wakacop.pauta.application.api.request.NovaPautaRequest;
import academy.wakanda.wakacop.pauta.application.api.response.PautaCadastradaResponse;
import academy.wakanda.wakacop.pauta.application.service.PautaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PautaController implements PautaAPI {
	private final PautaService pautaService;
	
	@Override
	public PautaCadastradaResponse cadastraPauta(NovaPautaRequest pautarequest) {
		log.info("[inicia] PautaController - cadastraPauta");
		PautaCadastradaResponse pautaCadastrada = pautaService.cadastraPauta(pautarequest);
		log.info("[finaliza] PautaController - cadastraPauta");
		return pautaCadastrada;
	}

}
