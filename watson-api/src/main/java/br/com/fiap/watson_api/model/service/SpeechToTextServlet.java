package br.com.fiap.watson_api.model.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.speech_to_text.v1.SpeechToText;
import com.ibm.watson.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.speech_to_text.v1.model.SpeechRecognitionResults;

@WebServlet(urlPatterns = "/stt")
public class SpeechToTextServlet extends HttpServlet {

	private static final long serialVersionUID = 7476959821119009111L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		byte[] buffer = new byte[1024 * 1024];
		
		InputStream is = req.getInputStream();
		File tempFile = File.createTempFile("speech-", ".wav");
		
		try (FileOutputStream os = new FileOutputStream(tempFile)) {
			int length;
			while((length = is.read(buffer)) != -1) {
				os.write(buffer, 0, length);
			}
		}
		
		IamOptions options = new IamOptions.Builder()
				.apiKey("<apikey>")
				.build();
		
		SpeechToText service = new SpeechToText(options);
		
		RecognizeOptions recognizeOptions = new RecognizeOptions.Builder()
				.audio(tempFile)
				.contentType(HttpMediaType.AUDIO_WAV)
				.model("pt-BR_BroadbandModel")
				.build();
		
		SpeechRecognitionResults transcript = service.recognize(recognizeOptions)
				.execute()
				.getResult();
		
		resp.setContentType("application/json");
		resp.getWriter().write(new Gson().toJson(transcript.getResults()));
	
	}
}




