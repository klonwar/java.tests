package ru.app.model.result.web;

import lombok.SneakyThrows;
import ru.app._infrastructure.application.ApplicationContext;
import ru.app.model.result.entity.Result;
import ru.app.model.result.service.ResultService;
import ru.app.model.test.entity.Test;
import ru.app.model.test.service.TestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "resultServlet", urlPatterns = {"/result"})
public class ResultServlet extends HttpServlet {
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
                    .getRequestDispatcher("/e404.jsp")
                    .forward(request, response);

            return null;
        }

        return id;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var id = handleIdParam(request, response);
        if (id == null) return;

        var result = resultService.getById(Integer.parseInt(id));
        request.setAttribute("result", result);

        getServletContext()
                .getRequestDispatcher("/result.jsp")
                .forward(request, response);

    }
}
