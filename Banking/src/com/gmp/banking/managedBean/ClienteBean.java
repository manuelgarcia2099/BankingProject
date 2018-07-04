package com.gmp.banking.managedBean;

import com.gmp.banking.bean.TbCliente;
import com.gmp.banking.bean.TbEmprestimo;
import com.gmp.banking.bean.TbRisco;
import com.gmp.banking.business.BusinessCliente;
import com.gmp.banking.business.BusinessClienteImpl;
import com.gmp.banking.business.BusinessRisco;
import com.gmp.banking.business.BusinessRiscoImpl;
import com.gmp.banking.mockClass.MockClass;
import com.gmp.banking.utils.Constantes;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
@ManagedBean(name="clienteBean")
@ViewScoped
public class ClienteBean{
	static final Logger log = Logger.getLogger(ClienteBean.class);

	FacesContext jsfCtx= FacesContext.getCurrentInstance();
	ResourceBundle bundle = jsfCtx.getApplication().getResourceBundle(jsfCtx, "msg");


	private BusinessCliente businessCliente = new BusinessClienteImpl();
	private BusinessRisco businessRisco = new BusinessRiscoImpl();

	private TbCliente cliente;
	private TbCliente clienteSearch;
	private TbEmprestimo emprestimo;

	private List<TbCliente> listaCliente;

	private Integer accion;
	private String titulo;

	private Integer tipoAuxiliar;

	private boolean checked;

	public ClienteBean() {
		cliente = new TbCliente();
		clienteSearch = new TbCliente();
		emprestimo = new TbEmprestimo();

		ListarClientes(cliente);

		FacesContext context = FacesContext.getCurrentInstance();
		Map requestParams = context.getExternalContext().getRequestParameterMap();
		String idCliente = (String) requestParams.get("id");

		  /**
		   * Para Avaliação
		   * Se o idCliente!= null set juros da TbEmprestimo para se mostrar na página loanSearch.xhtml 
		   * Se o codigo de estado!=null e cod_est == 1 | set value checked para mostrar o campo checkbox na tela addCliente.xhtml
		   */
		if (idCliente!=null){
			cliente.setCode_cli(Integer.parseInt(idCliente));
			cargarDatos(cliente.getCode_cli());

			tipoAuxiliar = cliente.getCode_tip();

			emprestimo.setJuros(ObtenerJuro(cliente.getCode_ris()).doubleValue());

			if(cliente.getCode_est()!=null && cliente.getCode_est()==Constantes.IN_FLAG_ONE) {
				checked=true;
			}

			accion = Constantes.IN_FLAG_UPDATE;
			titulo = bundle.getString(Constantes.VC_BOTAO_UPDATE);
		}
		else{
			accion = Constantes.IN_FLAG_ADD;
			titulo = bundle.getString(Constantes.VC_BOTAO_ADD);
			ListarClientes(cliente);
		}

		titulo += " " + bundle.getString(Constantes.VC_TITULO_CLIENTE);
		titulo = titulo.substring(Constantes.IN_FLAG_ZERO, titulo.length() - Constantes.IN_FLAG_ONE);

	}

	/**
	 * Para Avaliação
	 * @param cliente listamos los clientes 
	 */
	public void ListarClientes(TbCliente cliente) {
		try {
			listaCliente = businessCliente.listarCliente(cliente);
		}
		catch (DataAccessException dae){
			viewMsgDataAccessException(dae);
		}
		catch (Exception e){
			viewMsgException(e);
		}
	}

	public void cargarDatosMaestros() {
		cliente=new TbCliente();
	}

	public void cargarDatos() {
	}
	
	/**
	 * Para Avaliação
	 * @param carregamos os dados de un cliente a partir de seu código
	 */
	public void cargarDatos(Integer code_cli) {

		cliente = new TbCliente();
		cliente.setCode_cli(code_cli);
		try {
			cliente = businessCliente.obtenerCliente(cliente);
		}
		catch (DataAccessException dae){
			viewMsgDataAccessException(dae);
		}
		catch (Exception e){
			viewMsgException(e);
		}
	}

	/**
	 * Para Avaliação
	 * No momento de salvar o cliente, verifica se o checkbox é true or false ((operadorternario)?1:2)
	 * Se insertar Cliente foi bem sucedido, envia message de sucesso. Volta para página clienteSearch.xhtml
	 * Caso o item seja duplicado, envia message de Error Item duplicado
	 */
	public void guardarRegistroCliente() {

		try {

			cliente.setCode_est((checked)?Constantes.IN_FLAG_ONE:Constantes.IN_FLAG_TWO);  
			setValuesAccordingType(cliente.getCode_tip());

			int resp = businessCliente.insertarCliente(cliente);

			if (resp > Constantes.IN_FLAG_ZERO) {
				ListarClientes(new TbCliente());
				viewMessageSuccess();
				redirectPagina(Constantes.VC_PAGINA_CLIENTE);	
			}
			else{

				switch (resp) {
				case -2: viewMsgSpecificError(Constantes.VC_ERROR_ITEM_DUPLICADO);
				break;
				default: viewMsgError();
				break;
				}
			}
		}
		catch (DuplicateKeyException due){
			viewMsgDuplicateKeyException(due);
		}
		catch (DataAccessException dae){
			viewMsgDataAccessException(dae);
		}
		catch (Exception e){
			viewMsgException(e);
		}
	}

	/**
	 * Para Avaliação
	 * @param code_tip do selectOneMenu vai se setear os valores para salvar no banco de dados do cliente.
	 * Como o critério é só uma informação(patrimonio|dívida|estado) segundo o tipo de cliente os outros ficam com valor null
	 * Ese dado null se vai mostrar com uma string (Sem dados) 
	 */
	public void setValuesAccordingType(Integer code_tip) {

		switch (code_tip) {
		case 1:
			cliente.setDivi_cli(null);
			cliente.setCode_est(null);
			break;
		case 2:
			cliente.setPatr_cli(null);
			cliente.setCode_est(null);
			break;
		case 3:
			cliente.setDivi_cli(null);
			cliente.setPatr_cli(null);
			break;
		default:
			cliente.setCode_est(null);
			cliente.setDivi_cli(null);
			cliente.setPatr_cli(null);
			break;
		}

	}
	/**
	 * Para Avaliação
	 * No momento de atualizar o cliente, verifica se o checkbox é true or false ((operadorternario)?1:2)
	 * Se insertar Cliente foi bem sucedido, envia message de sucesso. Volta para página clienteSearch.xhtml
	 */
	public void actualizarRegistroCliente() {

		try {

			cliente.setCode_est((checked)?Constantes.IN_FLAG_ONE:Constantes.IN_FLAG_TWO);  
			setValuesAccordingType(cliente.getCode_tip());

			int resp = businessCliente.actualizarCliente(cliente);

			if (resp > Constantes.IN_FLAG_ZERO) {
				ListarClientes(new TbCliente());

				viewMessageSuccess();
				redirectPagina(Constantes.VC_PAGINA_CLIENTE);

			}
			else{

				viewMsgError();

			}
		}
		catch (DuplicateKeyException due){
			viewMsgDuplicateKeyException(due);
		}
		catch (DataAccessException dae){
			viewMsgDataAccessException(dae);
		}
		catch (Exception e){
			viewMsgException(e);
		}
	}

	public Integer ObtenerTipoCliente() {

		if(cliente.getCode_tip()!=null) {
			return cliente.getCode_tip();
		}

		return tipoAuxiliar;

	}

	/**
	 * Para Avaliação
	 * Trabalhei os dados com BigDecimal, por isso faço compareTo para setear os valores de codigo de risco do cliente.
	 */
	public void ObtenerTipoRisco(){
		BigDecimal rendimento = cliente.getRmes_cli();

		if(rendimento.compareTo(Constantes.BD_FACTOR_A)<=Constantes.IN_FLAG_ZERO) {
			cliente.setCode_ris(Constantes.IN_FLAG_THREE); 
		}else if(rendimento.compareTo(Constantes.BD_FACTOR_A)>Constantes.IN_FLAG_ZERO && rendimento.compareTo(Constantes.BD_FACTOR_B)<=Constantes.IN_FLAG_ZERO){
			cliente.setCode_ris(Constantes.IN_FLAG_TWO);
		} else if(rendimento.compareTo(Constantes.BD_FACTOR_B)>Constantes.IN_FLAG_ZERO) {
			cliente.setCode_ris(Constantes.IN_FLAG_ONE);
		}
	}

	/**
	 * Para Avaliação
	 * Caso não seja ainda selecionado um cliente na listagem para poder excluir vai se mostrar uma mensagem de esperando item ser selecionado.
	 * Ao excluir (eliminar) vai se mostrar uma mensagem de sucesso. 
	 */
	public void eliminarRegistroCliente() {
		try {
			if (cliente!=null && cliente.getCode_cli()!=null){

				int resp = businessCliente.eliminarCliente(cliente.getCode_cli());

				if (resp > Constantes.IN_FLAG_ZERO) {
					ListarClientes(new TbCliente());
					viewMessageSuccess();
					redirectPagina(Constantes.VC_PAGINA_CLIENTE);
				} else{
					viewMsgError();
				}

			}else{
				viewMessageWaitingForSelect();
			}
		}
		catch (DataAccessException dae){
			viewMsgDataAccessException(dae);
		}
		catch (Exception e){
			viewMsgException(e);
		}
	}

	/**
	 * Para Avaliação
	 * @param event se pode obter os dados do cliente selecionado
	 */
	public void onRowSelect(SelectEvent event) {
		cliente = (TbCliente) event.getObject();
		Integer code_cli = cliente.getCode_cli();

		cliente = new TbCliente();
		cliente.setCode_cli(code_cli);

		try {
			cliente = businessCliente.obtenerCliente(cliente);
		}
		catch (DataAccessException dae){
			viewMsgDataAccessException(dae);
		}
		catch (Exception e){
			viewMsgException(e);
		}
	}

	/**
	 * Para Avaliação
	 * @return String que contém a path loanSearch.xhtml incluindo o codigo de cliente
	 */
	public String cargaPaginaLoan(){

		if (cliente!=null && cliente.getCode_cli()!=null){
			return Constantes.VC_PAGINA_LOAN_CLIENTE + Constantes.VC_REDIRECT_TRUE_ID + cliente.getCode_cli();
		}
		else{
			viewMessageWaitingForSelect();
			return "";

		}
	}

	/**
	 * Para Avaliação
	 * Method Extract para reusar cada vez que se tenha que ir para outra página
	 * @param pagina
	 */
	public void redirectPagina(String pagina) {

		try {
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * Para Avaliação
	 * @return String que contém a path addCliente.xhtml incluindo o codigo de cliente
	 */
	public String cargaPaginaEditar(){

		if (cliente!=null && cliente.getCode_cli()!=null){
			return Constantes.VC_PAGINA_ADD_CLIENTE + Constantes.VC_REDIRECT_TRUE_ID + cliente.getCode_cli();
		}
		else{
			viewMessageWaitingForSelect();
			return "";
		}
	}

	/**
	 * Para Avaliação
	 * @param vc_codigo temos o código do cliente, com ele podemos setear um TbRisco para poder obter seu juro segundo como foi construido no banco de dados
	 * @return juros da TbRisco
	 */
	public BigDecimal ObtenerJuro(Integer vc_codigo){

		if(vc_codigo!=null){
			try {

				TbRisco risco = new TbRisco();
				risco.setCode_ris(vc_codigo);
				risco = businessRisco.obtenerRisco(risco);
				return risco.getJuro_ris();

			} catch (DataAccessException e) {
				log.debug("DataAccessException: " + e,e);
			} catch (Exception e) {
				log.debug("Exception: " + e,e);
			}

		}else {

			return null;
		}

		return null;
	}
	/**
	 * Para Avaliação
	 * Listagem dos clientes usando um TbCliente chamado clienteSearch
	 * quem vai ter os dados segundo o que está sendo procurado seja nome, sobrenome, tipo de cliente, tipo de risco.
	 */
	public List<TbCliente> Buscar(){
		try {
			listaCliente = businessCliente.listarCliente(clienteSearch);

		}catch (DataAccessException dae){
			viewMsgDataAccessException(dae);
		}
		catch (Exception e){
			viewMsgException(e);
		}
		return null;
	}

	/**
	 *  Para Avaliação
	 *  Criei um elemento emprestimo de tipo TbEmprestimo. Vai armazenar o valor solicitado e o tempo. 
	 *  O juro foi seteado no momento que se seleciona o cliente para fazer a simulação de empréstimo
	 *  con o código de risco do cliente, posso obter o juro da tbRisco e colocar na TbEmprestimo emprestimo.
	 *  Mediante BigDecimal, posso ter um pouco de precisão no momento de calcular o empréstimo. 
	 *  Além do total, posso ter os pagos mensais
	 */
	public void Calcular(){

		if(emprestimo.getTempo()!=Constantes.IN_FLAG_ZERO && emprestimo.getValorSolicitado()!=Constantes.IN_FLAG_ZERO) {

			double importe = emprestimo.getValorSolicitado();
			double juros = emprestimo.getJuros();
			double tempo = emprestimo.getTempo();
			
			juros = juros/1200;

			double numerador = juros * Math.pow(Constantes.IN_FLAG_ONE+juros, tempo);
			double denominador = Math.pow(Constantes.IN_FLAG_ONE+juros, tempo)-Constantes.IN_FLAG_ONE;

			double cuota = importe*(numerador/denominador);
			BigDecimal cuotaBD = BigDecimal.valueOf(cuota).setScale(Constantes.IN_FLAG_TWO, BigDecimal.ROUND_HALF_UP);

			BigDecimal totalBD = cuotaBD.multiply(BigDecimal.valueOf(tempo));
			totalBD = totalBD.setScale(Constantes.IN_FLAG_TWO, BigDecimal.ROUND_HALF_UP);

			emprestimo.setCuota(cuotaBD);
			emprestimo.setTotal(totalBD);

		} 
		else {
			viewMsgSpecific(Constantes.VC_ERROR_FALTA_DADOS);
		}
	}

	/**
	 * Permite limpar os dados para fazer outra consulta sem trocar o valor do Juro do cliente para continuar com outra a simulação na mesma tela.
	 */
	public void LimpiarEmprestimo(){
		emprestimo.setValorSolicitado(0);
		emprestimo.setTempo(0);
		emprestimo.setCuota(BigDecimal.valueOf(0));
		emprestimo.setTotal(BigDecimal.valueOf(0));
	}

	public void Limpiar(){
		clienteSearch = new TbCliente();
		ListarClientes(clienteSearch);
	}
	/**
	 * Os mensagens seguintes posso reusar em varios setores do código 
	 */
	public void viewMessageWaitingForSelect() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString(Constantes.VC_TITLE_SELECT), bundle.getString(Constantes.VC_SELECT));
		log.debug("msg: " + msg.getDetail());        		 
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}

	public void viewMessageSuccess() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString(Constantes.VC_TITLE_SUCCESS), bundle.getString(Constantes.VC_SUCCESS));
		log.debug("msg: " + msg.getDetail()); 
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void viewMsgError() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString(Constantes.VC_TITLE_ERROR),	bundle.getString(Constantes.VC_ERROR));
		log.debug("msg: " + msg.getDetail());       		 
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}

	public void viewMsgSpecificError(String error) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString(Constantes.VC_TITLE_ERROR),	bundle.getString(error));
		log.debug("msg: " + msg.getDetail());       		 
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}

	public void viewMsgSpecific(String message) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString(Constantes.VC_TITLE_MESSAGE),	bundle.getString(message));
		log.debug("msg: " + msg.getDetail());       		 
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}

	public void viewMsgDuplicateKeyException(DuplicateKeyException due) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString(Constantes.VC_TITLE_ERROR),	bundle.getString(Constantes.VC_ERROR) + " " + due.getMessage());
		log.debug("msg: " + due,due);        		 
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}

	public void viewMsgDataAccessException(DataAccessException dae) {
		log.debug("ESTOY EN DataAccessException: "+ dae,dae);   
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString(Constantes.VC_TITLE_ERROR),	bundle.getString(Constantes.VC_ERROR) + " " + dae.getMessage());
		log.debug("msg: " + dae,dae);        		 
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}

	public void viewMsgException(Exception e) {
		log.debug("ESTOY EN Exception: "+ e,e);  
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString(Constantes.VC_TITLE_ERROR), bundle.getString(Constantes.VC_ERROR) + " " + e.getMessage());
		log.debug("msg: " + e,e);        		 
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}

	public TbCliente getCliente() {
		return cliente;
	}

	public void setCliente(TbCliente cliente) {
		this.cliente = cliente;
	}

	public List<TbCliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<TbCliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public TbCliente getClienteSearch() {
		return clienteSearch;
	}

	public void setClienteSearch(TbCliente clienteSearch) {
		this.clienteSearch = clienteSearch;
	}

	public Integer getAccion() {
		return accion;
	}

	public void setAccion(Integer accion) {
		this.accion = accion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public TbEmprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(TbEmprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public Integer getTipoAuxiliar() {
		return tipoAuxiliar;
	}

	public void setTipoAuxiliar(Integer tipoAuxiliar) {
		this.tipoAuxiliar = tipoAuxiliar;
	}
}