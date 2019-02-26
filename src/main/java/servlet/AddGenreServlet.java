package servlet;

import manager.GenreManager;
import model.Genre;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/addGenre")
public class AddGenreServlet extends HttpServlet {
    GenreManager genreManager = new GenreManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            Genre genre = new Genre();
            genre.setName(name);
            genreManager.addGenre(genre);
            resp.sendRedirect("/admin/home");
        }
    }
}
