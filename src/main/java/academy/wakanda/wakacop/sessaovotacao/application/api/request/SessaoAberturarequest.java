package academy.wakanda.wakacop.sessaovotacao.application.api.request;

import java.util.Optional;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

@ToString
public class SessaoAberturarequest {
	@Getter
	@NotNull
	private UUID idPauta;
	private Integer tempoDuracao;

	public Optional<Integer> getTempoDuracao() {
		return Optional.ofNullable(this.tempoDuracao);
	}
}
