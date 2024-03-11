package notebook.util.mapper.impl;

import notebook.util.mapper.Mapper;
import notebook.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper implements Mapper {
    @Override
    public String toInput(User user) {
        return String.format("%s,%s,%s,%s", user.getId(), user.getFirstName(), user.getLastName(), user.getPhone());
    }

    @Override
    public User toOutput(String s) {
        String[] lines = s.split(",");
        long id;
        if (isDigit(lines[0])) {
            id = Long.parseLong(lines[0]);
            return new User(id, lines[1], lines[2], lines[3]);
        }
        throw new NumberFormatException("Id must be a large number");
    }

    @Override
    public List<String> convertToListStr(List<User> users) {
        List<String> lines = new ArrayList<>();
        for (User u: users) {
            lines.add(toInput(u));
        }
        return lines;
    }

    private boolean isDigit(String s) throws NumberFormatException {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
