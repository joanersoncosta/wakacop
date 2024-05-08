package academy.wakanda.wakacop.sessaovotacao.domin;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import academy.wakanda.wakacop.sessaovotacao.application.api.request.VotoRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VotoPauta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
	private UUID idVotoPauta;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sessao_votacao_id")
	private SessaoVotacao sessaoVotacao;
	private String cpfAssociado;
	private OpcaoVoto opcaoVoto;
	private LocalDateTime momentoVoto;

	public VotoPauta(SessaoVotacao sessaoVotacao, VotoRequest VotoRequest) {
		this.sessaoVotacao = sessaoVotacao;
		this.cpfAssociado = VotoRequest.getCpfAssociado();
		this.opcaoVoto = VotoRequest.getOpcaoVoto();
		this.momentoVoto = LocalDateTime.now();
	}

	public UUID getIdSessao() {
		return this.sessaoVotacao.getIdSessaoVotacao();
	}
	
	public String getIdCpfAssociado() {
		return this.cpfAssociado;
	}

}
