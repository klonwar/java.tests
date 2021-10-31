package ru.app.model.question.entity;

import ru.app.database.Extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionExtractor implements Extractor<Question> {
    @Override
    public List<Question> extract(ResultSet rs) throws SQLException {
        List<Question> result = new ArrayList<>();
        while (rs.next()) {
            var builder = new QuestionBuilder();
            result.add(
                    builder.id(rs.getInt("id"))
                            .content(rs.getString("content"))
                            .points(rs.getInt("points"))
                            .answers(null)
                            .correctAnswer(null)
                            .build()
            );
        }
        return result;
    }
}
