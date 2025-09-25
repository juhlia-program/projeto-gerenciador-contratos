package app;

	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;

	public class Contrato {

	    private int id;
	    private String descricao;
	    private double valor;
	    private LocalDate dataAssinatura; 
	    private StatusContrato status; 

	    public Contrato(int id, String descricao, double valor, LocalDate dataAssinatura, StatusContrato status) {
	        this.id = id;
	        this.descricao = descricao;
	        this.valor = valor;
	        this.dataAssinatura = dataAssinatura;
	        this.status = status;
	    }

	    public int getId() { return id; }
	    public String getDescricao() { return descricao; }
	    public double getValor() { return valor; }
	    public LocalDate getDataAssinatura() { return dataAssinatura; }
	    public StatusContrato getStatus() { return status; }

	    @Override
	    public String toString() {
	        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        return "Contrato [" +
	               "ID=" + id +
	               ", Descrição='" + descricao + '\'' +
	               ", Valor=R$ " + String.format("%.2f", valor) +
	               ", Data de Assinatura=" + dataAssinatura.format(formatador) +
	               ", Status=" + status +
	               ']';
	    }
	}


