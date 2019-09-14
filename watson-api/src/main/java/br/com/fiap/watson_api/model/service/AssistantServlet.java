package br.com.fiap.watson_api.model.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.MessageContext;
import com.ibm.watson.assistant.v2.model.MessageInput;
import com.ibm.watson.assistant.v2.model.MessageInputOptions;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.model.MessageResponse;
import com.ibm.watson.assistant.v2.model.SessionResponse;

@WebServlet(urlPatterns = "/assistant")
public class AssistantServlet extends HttpServlet{

	private MessageContext context = new MessageContext();
	private static final long serialVersionUID = 9052436307776407283L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = req.getParameter("question");
		System.out.println(msg);
		
		MessageResponse response = this.assistantAPICall(msg);
		
		resp.setContentType("application/json");
		resp.getWriter().write(new Gson().toJson(response.getOutput().getGeneric()));
	
	}

	private MessageResponse assistantAPICall(String msg) {
		
		// Configuração de autenticação do serviço
		IamOptions options = new IamOptions.Builder()
				.apiKey("<apikey>")
				.build();
		// Criando o objeto do serviço desejado
		Assistant service = new Assistant("2019-02-28", options);
		String assistantId = "<apikey>";
		
		//  Criando minha sessão
		CreateSessionOptions sessionOptions = new CreateSessionOptions.Builder()
				.assistantId(assistantId)
				.build();
		SessionResponse session = service.createSession(sessionOptions)
				.execute()
				.getResult();
		String sessionId = session.getSessionId();
		
		// Definindo retorno do contexto
		MessageInputOptions inputOptions = new MessageInputOptions();
		inputOptions.setReturnContext(true);
		
		// Iniciando a Conversa com Washington
		MessageInput input = new MessageInput.Builder()
				.text(msg)
				.options(inputOptions)
				.build();
		
		MessageOptions optionsMessage = new MessageOptions.Builder()
				.assistantId(assistantId)
				.sessionId(sessionId)
				.input(input)
				.context(this.context)
				.build();
		
		MessageResponse response = service.message(optionsMessage)
				.execute()
				.getResult();
		
		this.context = response.getContext();
		
		return response;
	}

}







