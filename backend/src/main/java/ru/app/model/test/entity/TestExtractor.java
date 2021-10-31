package ru.app.model.test.entity;

import ru.app.database.Extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestExtractor implements Extractor<Test> {
    @Override
    public List<Test> extract(ResultSet rs) throws SQLException {
        List<Test> result = new ArrayList<>();
        while (rs.next()) {
            var builder = new TestBuilder();
            result.add(
                    builder.id(rs.getInt("id"))
                            .title(rs.getString("title"))
                            .questions(null)
                            .build()
            );
        }
        return result;
    }
}
