package ru.rblednov.sprtutors.sprtutors.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ThreadLocalRandom;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DefaultController {
    @GetMapping(value = "/ol/**", produces = "text/html;charset=UTF-8")
    public ResponseEntity<byte[]> getPage() throws IOException {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        InputStream inputStream = new ClassPathResource("/html/" + randomNum + ".html").getInputStream();
        byte[] body = inputStream.readAllBytes();
        return new ResponseEntity<byte[]>(body, HttpStatus.OK);
    }

    @GetMapping(value = "/img/{paintName}")
    public ResponseEntity<byte[]> getImg(@PathVariable(value = "paintName") String paintName,
                                         HttpServletResponse response) throws IOException {
        InputStream inputStream = new ClassPathResource("/img/"+paintName).getInputStream();
        byte[] body = inputStream.readAllBytes();
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        return new ResponseEntity<byte[]>(body, HttpStatus.OK);
    }
}
