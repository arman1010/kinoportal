package servlet;

import manager.GenreManager;
import manager.KinoManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    GenreManager genreManager = new GenreManager();
    KinoManager kinoManager = new KinoManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("allGenres", genreManager.getAllGenres());
        req.setAttribute("allKinos", kinoManager.getAllKinos());
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}
