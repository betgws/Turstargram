package umc.thurstagram.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SaveListResponse<T> {

    private T saves;
}