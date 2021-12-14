package ru.app.model.test.web;

import lombok.SneakyThrows;
import ru.app.Main;
import ru.app._infrastructure.application.ApplicationContext;
import ru.app.model.answer.entity.Answer;
import ru.app.model.answer.entity.AnswerBuilder;
import ru.app.model.question.service.QuestionService;
import ru.app.model.result.service.ResultService;
import ru.app.model.test.entity.Test;
import ru.app.model.test.service.TestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "testServlet", urlPatterns = {"/test"})
public class TestServlet extends HttpServlet {
    private ApplicationContext context;
    private TestService testService;
    private ResultService resultService;

    @Override
    public void init() throws ServletException {
        super.init();
        context = (ApplicationContext) getServletContext().getAttribute("ApplicationContext");
        testService = context.getObject(TestService.class);
        resultService = context.getObject(ResultService.class);
    }

    @SneakyThrows
    private String handleIdParam(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        if (id == null) {
            getServletContext()
                    .getRequestDispatcher("/test-list.jsp")
                    .forward(request, response);

            return null;
        }

        return id;
    }

    @SneakyThrows
    private Test handleProvidedId(HttpServletRequest request, HttpServletResponse response, List<Test> testList, String id) {
        var chosenTest = testList.stream().filter((item) -> item.getId().toString().equals(id)).findFirst();

        if (chosenTest.isEmpty()) {
            getServletContext()
                    .getRequestDispatcher("/e404.jsp")
                    .forward(request, response);
            return null;
        }

        return chosenTest.get();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        var testList = testService.getTestList();
        request.setAttribute("testList", testList);

        var id = handleIdParam(request, response);
        if (id == null) return;

        var chosenTest = handleProvidedId(request, response, testList, id);
        if (chosenTest == null) return;

        request.setAttribute("chosenTest", chosenTest);
        getServletContext()
                .getRequestDispatcher("/test.jsp")
                .forward(request, response);
    }

    private List<Answer> parseQuestions(HttpServletRequest request, Test test) {
        List<Answer> res = new ArrayList<>();

        var paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            var param = paramNames.nextElement();
            var qIdString = param.substring(1);

            if (!param.startsWith("q") && !qIdString.matches("[0-9]+"))
                continue;

            var qId = Integer.parseInt(qIdString);
            var value = Integer.parseInt(request.getParameter(param));

            res.add(new AnswerBuilder().id(value).build());
        }

        return res;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var id = handleIdParam(request, response);
        if (id == null) return;

        var testList = testService.getTestList();
        request.setAttribute("testList", testList);

        var chosenTest = handleProvidedId(request, response, testList, id);
        if (chosenTest == null) return;

        String test = "";

        var answers = parseQuestions(request, chosenTest);
        var score = testService.countScore(chosenTest, answers);

        var res = resultService.saveResult(chosenTest, score);

        response.sendRedirect("/result?id=" + res.getId());
    }
}
