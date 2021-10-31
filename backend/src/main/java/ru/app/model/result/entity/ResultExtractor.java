package ru.app.model.result.entity;

import ru.app.database.Extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultExtractor implements Extractor<Result> {
    @Override
    public List<Result> extract(ResultSet rs) throws SQLException {
        List<Result> result = new ArrayList<>();
        while (rs.next()) {
            var builder = new ResultBuilder();
            result.add(
                    builder.id(rs.getInt("id"))
                            .score(rs.getInt("score"))
                            .testId(rs.getInt("test_id"))
                            .test(null)
                            .build()
            );
        }
        return result;
    }
}
