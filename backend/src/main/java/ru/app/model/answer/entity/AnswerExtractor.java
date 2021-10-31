package ru.app.model.answer.entity;

import ru.app.database.Extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerExtractor implements Extractor<Answer> {
    @Override
    public List<Answer> extract(ResultSet rs) throws SQLException {
        List<Answer> result = new ArrayList<>();
        while (rs.next()) {
            var builder = new AnswerBuilder();
            result.add(
                    builder.id(rs.getInt("id"))
                            .content(rs.getString("content"))
                            .build()
            );
        }
        return result;
    }
}
