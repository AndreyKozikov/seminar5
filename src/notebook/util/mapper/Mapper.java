package notebook.util.mapper;

import notebook.model.User;

import java.util.List;

public interface Mapper {
    String toInput(User e);
    User toOutput(String str);
    List<String> convertToListStr(List<User> users);
}
