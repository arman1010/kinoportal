package servlet;

import manager.GenreManager;
import manager.KinoManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/home")
public class AdminHomeServlet extends HttpServlet {
    KinoManager kinoManager = new KinoManager();
    GenreManager genreManager = new GenreManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().getAttribute("user");
        req.setAttribute("allGenres", genreManager.getAllGenres());
        req.setAttribute("allKinos", kinoManager.getAllKinos());
        req.getRequestDispatcher("/WEB-INF/admin/adminHome.jsp").forward(req,resp);

    }
}
