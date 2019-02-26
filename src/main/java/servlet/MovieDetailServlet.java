package servlet;

import manager.KinoManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/movieDetail")
public class MovieDetailServlet extends HttpServlet {
    KinoManager kinoManager = new KinoManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int kinoId = Integer.parseInt(id);
        req.setAttribute("currentKino",kinoManager.getKinoById(kinoId));
        req.getRequestDispatcher("movieDetail.jsp").forward(req, resp);
    }
}
