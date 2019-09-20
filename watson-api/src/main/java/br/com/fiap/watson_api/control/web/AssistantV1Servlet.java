package br.com.fiap.watson_api.control.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.assistant.v1.model.Context;
import com.ibm.watson.assistant.v1.model.MessageInput;
import com.ibm.watson.assistant.v1.model.MessageOptions;
import com.ibm.watson.assistant.v1.model.MessageResponse;
import com.ibm.watson.assistant.v1.Assistant;

@WebServlet(urlPatterns = "/v1")
public class AssistantV1Servlet extends HttpServlet {
	
	private Context context;
	private static final long serialVersionUID = -8716683257301345455L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String msg = req.getParameter("question");
		if (msg.isEmpty()) this.context = null;
		
		MessageResponse response = this.assistantAPICall(msg);
		
		resp.setContentType("application/json");
		resp.getWriter().write(new Gson().toJson(response.getOutput().getText()));
	}

	private MessageResponse assistantAPICall(String msg) {

		// Configuração de autenticação do serviço
		IamOptions options = new IamOptions.Builder()
				.apiKey("<apikey>")
				.build();
		
		// Criando o objeto do serviço desejado
		Assistant service = new Assistant("2018-02-16", options);
		String workspaceId = "<skill_id>";
		
		// Preparando a mensagem de envio
		MessageInput input = new MessageInput();
		input.setText(msg);
		
		// Configurando os parametros para o Watson
		MessageOptions messageOptions = new MessageOptions.Builder()
				.workspaceId(workspaceId)
				.input(input)
				.context(this.context)
				.build();
		
		// Conectando com o Assistant e recebendo a resposta dele
		MessageResponse response  = service.message(messageOptions)
				.execute()
				.getResult();
		
		this.context = response.getContext();
		
		// Verifica se as variaveis de contexto foram totalmente preenchidas
		// Quando o nó de dialogo for completo reinicia o contexto
		if (response.getContext().getSystem().getProperties().get("branch_exited") != null)
			if ((boolean) response.getContext().getSystem().getProperties().get("branch_exited") &&
					response.getContext().getSystem().getProperties().get("branch_exited_reason").equals("completed"))
				this.context = null;
		
		return response;
	}

}
