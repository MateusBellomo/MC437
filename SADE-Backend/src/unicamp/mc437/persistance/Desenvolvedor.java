package unicamp.mc437.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Desenvolvedor")
public class Desenvolvedor {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="rg")
	String rg;

	@Column(name="telefone")
	private String telefone;

	@Column(name="celular")
	private String celular;
	
	@Column(name="endereco")
	private String endereco;

	@Column(name="instituicao_ensino")
	private String instituicaoEnsino;
	
	@Column(name="curso")
	private String curso;

	@Column(name="horas_graduacao")
	private String horasGraduacao;

	@Column(name="horas_disponivel")
	private String horasDisponivel;

	@Column(name="horas_estagio")
	private String horasEstagio;

	@Column(name="curriculo")
	private String curriculo;

	@Column(name="observacoes")
	private String observacoes;

	@Column(name="como_conheceu")
	private String comoConheceu;
	
	@Column(name="java")
	Integer java;
	
	@Column(name="php")
	Integer php;

	@Column(name="mysql")
	Integer mysql;
	
	@Column(name="ajax")
	Integer ajax;

	@Column(name="javascript")
	Integer javascript;
	
	@Column(name="python")
	Integer python;

	@Column(name="csharp")
	Integer csharp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(String instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getHorasGraduacao() {
		return horasGraduacao;
	}

	public void setHorasGraduacao(String horasGraduacao) {
		this.horasGraduacao = horasGraduacao;
	}

	public String getHorasDisponivel() {
		return horasDisponivel;
	}

	public void setHorasDisponivel(String horasDisponivel) {
		this.horasDisponivel = horasDisponivel;
	}

	public String getHorasEstagio() {
		return horasEstagio;
	}

	public void setHorasEstagio(String horasEstagio) {
		this.horasEstagio = horasEstagio;
	}

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getComoConheceu() {
		return comoConheceu;
	}

	public void setComoConheceu(String comoConheceu) {
		this.comoConheceu = comoConheceu;
	}

	public Integer getJava() {
		return java;
	}

	public void setJava(Integer java) {
		this.java = java;
	}

	public Integer getPhp() {
		return php;
	}

	public void setPhp(Integer php) {
		this.php = php;
	}

	public Integer getMysql() {
		return mysql;
	}

	public void setMysql(Integer mysql) {
		this.mysql = mysql;
	}

	public Integer getAjax() {
		return ajax;
	}

	public void setAjax(Integer ajax) {
		this.ajax = ajax;
	}

	public Integer getJavascript() {
		return javascript;
	}

	public void setJavascript(Integer javascript) {
		this.javascript = javascript;
	}

	public Integer getPython() {
		return python;
	}

	public void setPython(Integer python) {
		this.python = python;
	}

	public Integer getCsharp() {
		return csharp;
	}

	public void setCsharp(Integer csharp) {
		this.csharp = csharp;
	}

	@Override
	public String toString(){
		return "id="+id+", nome="+nome+", obs="+observacoes;
	}
}