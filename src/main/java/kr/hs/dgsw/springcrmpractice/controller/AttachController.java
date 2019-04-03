package kr.hs.dgsw.springcrmpractice.controller;

import kr.hs.dgsw.springcrmpractice.protocol.AttachProtocol;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class AttachController {

    @PostMapping("/attach")
    public AttachProtocol attach(@RequestPart MultipartFile file) {
        String path = "\\upload\\" + UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        try {
            File dest = new File(System.getProperty("user.dir") + path);
            dest.getParentFile().mkdirs();
            file.transferTo(dest);
        }
        catch (IOException e) {
            return null;
        }

        return new AttachProtocol(path, file.getOriginalFilename());
    }
}
