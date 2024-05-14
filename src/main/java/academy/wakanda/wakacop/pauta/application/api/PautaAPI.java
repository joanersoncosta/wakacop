package academy.wakanda.wakacop.pauta.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import academy.wakanda.wakacop.pauta.application.api.request.NovaPautaRequest;
import academy.wakanda.wakacop.pauta.application.api.response.PautaCadastradaResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pauta")
public interface PautaAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PautaCadastradaResponse cadastraPauta(@RequestBody @Valid NovaPautaRequest pautarequest);
}
