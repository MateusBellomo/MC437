package br.unicamp.mc437.sade.persistance;

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

	@Column(name="telRes")
	private String telRes;
	
	@Column(name="telCel")
	private String telCel;

	@Column(name="endereco")
	private String endereco;

	@Column(name="instituicao")
	private String instituicao;
	
	@Column(name="curso")
	private String curso;

	@Column(name="horas_graduacao")
	private Integer hGrad;

	@Column(name="horas_disponivel")
	private Integer hDisp;

	@Column(name="horas_estagio")
	private Integer hEstag;

	@Column(name="curriculo")
	private String curriculo;

	@Column(name="observacoes")
	private String observacoes;

	@Column(name="como_conheceu")
	private String conheceu;
	
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



	public String getTelRes() {
		return telRes;
	}



	public void setTelRes(String telRes) {
		this.telRes = telRes;
	}



	public String getTelCel() {
		return telCel;
	}



	public void setTelCel(String telCel) {
		this.telCel = telCel;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public String getInstituicao() {
		return instituicao;
	}



	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}



	public String getCurso() {
		return curso;
	}



	public void setCurso(String curso) {
		this.curso = curso;
	}



	public Integer gethGrad() {
		return hGrad;
	}



	public void sethGrad(Integer hGrad) {
		this.hGrad = hGrad;
	}



	public Integer gethDisp() {
		return hDisp;
	}



	public void sethDisp(Integer hDisp) {
		this.hDisp = hDisp;
	}



	public Integer gethEstag() {
		return hEstag;
	}



	public void sethEstag(Integer hEstag) {
		this.hEstag = hEstag;
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



	public String getConheceu() {
		return conheceu;
	}



	public void setConheceu(String conheceu) {
		this.conheceu = conheceu;
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