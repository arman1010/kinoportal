package servlet;

import manager.GenreManager;
import manager.KinoManager;
import model.Genre;
import model.Kino;
import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(urlPatterns = "/admin/addKino")
public class AddKinoServlet extends HttpServlet {
    KinoManager kinoManager = new KinoManager();
    GenreManager genreManager = new GenreManager();
    Set<Genre> genres = new HashSet<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        if (ServletFileUpload.isMultipartContent(req)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024 * 1024);
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(1024 * 1024 * 50);
            upload.setSizeMax(1024 * 1024 * 5 * 50);
            String uploadPath = "C:\\MoviePortal\\uploadImages";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                Kino kino = new Kino();
                List<FileItem> formItems = upload.parseRequest(req);
                if (formItems != null && formItems.size() > 0) {
                    for (FileItem item : formItems) {
                        if (!item.isFormField()) {
                            String fileName = System.currentTimeMillis() + "_" + new File(item.getName()).getName();
                            String filePath = uploadPath + File.separator + fileName;
                            File storeFile = new File(filePath);
                            item.write(storeFile);
                            kino.setPicUrl(fileName);
                        } else {
                            if (item.getFieldName().equals("name")) {
                                kino.setName(item.getString());
                            } else if (item.getFieldName().equals("description")) {
                                kino.setDescription(item.getString());
                            } else if (item.getFieldName().equals("year")) {
                                kino.setYear(Integer.parseInt(item.getString()));
                            } else if (item.getFieldName().equals("genre")) {
                                Genre genre = genreManager.getGenreByName(item.getString());
                                genres.add(genre);
                                kino.setGenre(genres);
                            } else if (item.getFieldName().equals("directorName")) {
                                kino.setDirectorName(item.getString());
                            }
                        }
                    }
                    kino.setUser(user);
                    kino.setDate(new Date());
                    kinoManager.addKino(kino);
                    resp.sendRedirect("/admin/home");
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
