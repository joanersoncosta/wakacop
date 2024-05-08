package academy.wakanda.wakacop.sessaovotacao.application.api;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturarequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.request.VotoRequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.SessaoAberturaResponse;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.VotoResponse;

@RestController
@RequestMapping("/sessao")
public interface SessaovotacaoAPI {

	@PostMapping("/abertura")
	@ResponseStatus(code = HttpStatus.CREATED)
	public SessaoAberturaResponse abreSessao(@RequestBody @Valid SessaoAberturarequest sessaorequest);

	@PostMapping("/{idSessao}/voto")
	@ResponseStatus(code = HttpStatus.CREATED)
	public VotoResponse recebeVoto(@PathVariable UUID  idSessao, @RequestBody @Valid VotoRequest votoRequest);
}
