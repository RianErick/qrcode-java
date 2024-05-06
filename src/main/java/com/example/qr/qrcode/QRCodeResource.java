package com.example.qr.qrcode;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class QRCodeResource {

    private final Service service;

    public QRCodeResource(Service service) {
        this.service = service;
    }

    @PostMapping("run")
    public void qrCode() throws IOException, WriterException {
      String data = "www.geeksforgeeks.org";

      String path = "demo.png";

      String charset = "UTF-8";

      Map<EncodeHintType, ErrorCorrectionLevel> hashMap
              = new HashMap<EncodeHintType,
                            ErrorCorrectionLevel>();

      hashMap.put(EncodeHintType.ERROR_CORRECTION,
              ErrorCorrectionLevel.L);

      service.createQR(data, path, charset, hashMap, 500, 500);
  }

}
