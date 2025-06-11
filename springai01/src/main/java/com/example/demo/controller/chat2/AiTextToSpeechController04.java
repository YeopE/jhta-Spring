package com.example.demo.controller.chat2;

import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiAudioSpeechOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.ai.openai.audio.speech.SpeechPrompt;
import org.springframework.ai.openai.audio.speech.SpeechResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.io.OutputStream;

@RestController
public class AiTextToSpeechController04 {
    @Autowired
    private OpenAiAudioSpeechModel openAiAudioSpeechModel;

    @GetMapping("/tts1")
    public byte[] toAudio01(@RequestParam("text") String text){
        var speechOptions = OpenAiAudioSpeechOptions.builder()
                .model("tts-1")

                .voice(OpenAiAudioApi.SpeechRequest.Voice.NOVA)
                .responseFormat(OpenAiAudioApi.SpeechRequest.AudioResponseFormat.MP3)
                .speed(1.0f)
                .build();
        SpeechPrompt speechPrompt = new SpeechPrompt(text, speechOptions);
        SpeechResponse speechResponse = openAiAudioSpeechModel.call(speechPrompt);
        return speechResponse.getResult().getOutput();
    }

    @GetMapping("/tts2")
    public StreamingResponseBody toAudio02(@RequestParam("text") String text){
        var speechOptions = OpenAiAudioSpeechOptions.builder()
                .model("tts-1")

                .voice(OpenAiAudioApi.SpeechRequest.Voice.NOVA)
                .responseFormat(OpenAiAudioApi.SpeechRequest.AudioResponseFormat.MP3)
                .speed(1.0f)
                .build();
        SpeechPrompt speechPrompt = new SpeechPrompt(text, speechOptions);
        //스트리밍방식으로 데이터 보내기
        Flux<SpeechResponse> resp = openAiAudioSpeechModel.stream(speechPrompt);
        StreamingResponseBody streamingResponseBody = new StreamingResponseBody() {
            @Override
            public void writeTo(OutputStream outputStream) throws IOException {
                resp.toStream().forEach(chuck -> {
                    try {
                        outputStream.write(chuck.getResult().getOutput());
                        outputStream.flush();    
                    }catch (IOException ie) {
                        System.out.println(ie.getMessage());
                    }
                });
            }
        };
        return streamingResponseBody;
    }
}
