package kr.hs.dgsw.springcrmpractice.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachProtocol {
    private String path;
    private String origin;
}
