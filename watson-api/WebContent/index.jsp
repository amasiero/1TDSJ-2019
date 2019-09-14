<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IBM Watson w/ Java SDK</title>
<link rel="icon" href="favicon.png">
<link rel="stylesheet" type="text/css" href="style/main.css" />
</head>
<body>
	<section class="container">
		<h2 class="title">Chatbot Example w/ Watson API and Java</h2>
		<div class="chat-container"></div>
		<input type="text" id="question" name="question" class="field"
			placeholder="Type your question or message to convert in audio" />
		<div class="controls">
			<button id="sendQuestion">Send</button>
			<button id="getVoiceButton">Get Voice</button>
			<button id="recordButton">Record</button>
			<button id="pauseButton" disabled>Pause</button>
			<button id="stopButton" disabled>Stop</button>
		</div>
	</section>
	<script src="https://cdn.rawgit.com/mattdiamond/Recorderjs/08e7abd9/dist/recorder.js"></script>
	<!-- Para a versão dois utilizar o script main.js -->
	<script type="text/javascript" src="scripts/assistant.js"></script>
	<script type="text/javascript" src="scripts/tts.js"></script>
	<script type="text/javascript" src="scripts/stt.js"></script>
</body>
</html>