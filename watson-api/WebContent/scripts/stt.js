//webkitURL é legado 
URL = window.URL || window.webkitURL;
// stream é criado a partir getUserMedia()
var gumStream;
// Objeto do Record.js
var rec;
// MediaStreamAudioSourceNode
var input;
// criar novo AudioContext
var AudioContext = window.AudioContext || window.webkitAudioContext; // Classe
var audioContext; // objeto
// selecionar os botoes

var btnRecord = document.querySelector("#recordButton");
var btnPause = document.querySelector("#pauseButton");
var btnStop = document.querySelector("#stopButton");

btnRecord.addEventListener("click", function(event) {
	event.preventDefault();
	constraints = {
			audio : true,
			video : false
	}
	
	btnRecord.disabled = true;
	btnPause.disabled = false;
	btnStop.disabled = false;
	
	navigator.mediaDevices.getUserMedia(constraints).then(function(stream) {
		audioContext = new AudioContext;
		gumStream = stream;
		input = audioContext.createMediaStreamSource(stream);
		rec = new Recorder(input, {
			numChannels : 1
		});
		rec.record();
	}).catch(function(err){
		console.log(err);
		btnRecord.disabled = false;
		btnPause.disabled = true;
		btnStop.disabled = true;
	});
});

btnPause.addEventListener("click", function(event) {
	event.preventDefault();
	if(rec.recording) {
		rec.stop();
		this.textContent = "Resume";
	} else {
		rec.record();
		this.textContent = "Pause";
	}
});

btnStop.addEventListener("click", function(event) {
	event.preventDefault();
	btnRecord.disabled = false;
	btnPause.disabled = true;
	btnStop.disabled = true;
	btnPause.textContent = "Pause";
	
	rec.stop();
	gumStream.getAudioTracks()[0].stop();
	rec.exportWAV(generateBlob);
});

function generateBlob(blob) {
	createAudioElement(blob);
	sendBlobToText(blob);
}

function sendBlobToText(blob) {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "stt", true);
	xhr.setRequestHeader("Content-type", "audio/wav");
	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			// Deu bom
			var resposta = JSON.parse(xhr.responseText);
			resposta[0].alternatives.forEach(function(transcript) {
				createMessage(transcript.transcript, "me");
			});
		} else {
			// Deu ruim
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
	xhr.send(blob);
}









