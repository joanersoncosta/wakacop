package academy.wakanda.wakacop.sessaovotacao.domin;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import academy.wakanda.wakacop.pauta.domain.Pauta;
import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturarequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessaoVotacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
	private UUID idSessaoVotacao;
	private UUID idPauta;
	private Integer tempoDuracao;
	private StatusSessaoVotacao status;
	private LocalDateTime dataAbertura;
	private LocalDateTime dataEncerramento;

	public SessaoVotacao(SessaoAberturarequest sessaoAberturarequest, Pauta pauta) {
		this.idPauta = pauta.getIdPauta();
		this.tempoDuracao = sessaoAberturarequest.getTempoDuracao().orElse(1);
		this.dataAbertura = LocalDateTime.now();
		this.dataEncerramento = dataAbertura.plusMinutes(this.tempoDuracao);
		this.status = StatusSessaoVotacao.ABERTA;
	}
	
}
