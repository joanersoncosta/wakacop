package academy.wakanda.wakacop.sessaovotacao.domin;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import academy.wakanda.wakacop.pauta.domain.Pauta;
import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturarequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.request.VotoRequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.ResultadoSessaoVotacao;
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
	private UUID idSessao;
	private UUID idPauta;
	private Integer tempoDuracao;
	private StatusSessaoVotacao status;
	private LocalDateTime momentoAbertura;
	private LocalDateTime momentoEncerramento;
	
	@OneToMany(mappedBy = "sessaoVotacao", cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@MapKey(name = "cpfAssociado")
	private Map<String, VotoPauta> votos;

	public SessaoVotacao(SessaoAberturarequest sessaoAberturarequest, Pauta pauta) {
		this.idPauta = pauta.getIdPauta();
		this.tempoDuracao = sessaoAberturarequest.getTempoDuracao().orElse(1);
		this.momentoAbertura = LocalDateTime.now();
		this.momentoEncerramento = momentoAbertura.plusMinutes(this.tempoDuracao);
		this.status = StatusSessaoVotacao.ABERTA;
		this.votos = new HashMap<>();
	}
	
	public VotoPauta recebeVoto(VotoRequest votoRequest) {
		validaSessaoAberta();
		validaAssociado(votoRequest.getCpfAssociado());
		VotoPauta voto = new VotoPauta(this, votoRequest);
		votos.put(votoRequest.getCpfAssociado(), voto);
		return voto;
	}

	private void validaSessaoAberta() {
		atualizaStatus();
		if(this.status.equals(StatusSessaoVotacao.FECHADA)) {
			throw new RuntimeException("Sessão está fechada!");
		}
	}

	private void atualizaStatus() {
		if(this.status.equals(StatusSessaoVotacao.ABERTA)) {
			if(LocalDateTime.now().isAfter(momentoEncerramento)) {
				fechaSessao();
			}
		}
	}

	private void fechaSessao() {
		this.status = StatusSessaoVotacao.FECHADA;
	}

	private void validaAssociado(String cpfAssociado) {
		if (votos.containsKey(cpfAssociado)) {
			throw new RuntimeException("Associado Já Votou nessa Sessão!");
		}
	}
	
	public ResultadoSessaoVotacao obtemResultado(){
		atualizaStatus();
		return new ResultadoSessaoVotacao(this);
	}

	public Long getTotalVotos() {
		return Long.valueOf(this.votos.size());
	}
	
	public Long getTotalSim() {
		return calculaVotosPorOpcao(OpcaoVoto.SIM);
	}
	
	public Long getTotalNao() {
		return calculaVotosPorOpcao(OpcaoVoto.NAO);
	}

	private Long calculaVotosPorOpcao(OpcaoVoto opcao) {
		return this.votos.values().stream()
				.filter(voto -> voto.opcaoIgual(opcao))
				.count();
	}
}
