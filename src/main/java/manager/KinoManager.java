package manager;

import db.DBConnectionProvider;
import model.Genre;
import model.Kino;
import util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KinoManager {
    private Connection connection;

    public KinoManager() {
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    public void addKino(Kino kino) {
        UserManager userManager = new UserManager();
        String query = "INSERT INTO kino(`name`,`description`,`pic_url`,`year`,`director`,`user_id`,`date`)" +
                " VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, kino.getName());
            statement.setString(2, kino.getDescription());
            statement.setString(3, kino.getPicUrl());
            statement.setInt(4, kino.getYear());
            statement.setString(5, kino.getDirectorName());
            statement.setInt(6, kino.getUser().getId());
            statement.setString(7, DateUtil.convertDateToString(kino.getDate()));

            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                kino.setId(generatedKeys.getInt(1));
            }
            addGenreIdAndKinoId(kino.getId(), kino.getGenre());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Set<Kino> getAllKinos() {
        UserManager userManager = new UserManager();
        GenreManager genreManager = new GenreManager();
        String query = "SELECT * FROM kino";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Set<Kino> kinos = new HashSet<>();
            Set<Genre> genres = new HashSet<>();
            while (resultSet.next()) {
                Kino kino = new Kino();
                kino.setId(resultSet.getInt(1));
                kino.setName(resultSet.getString(2));
                kino.setDescription(resultSet.getString(3));
                kino.setPicUrl(resultSet.getString(4));
                kino.setYear(resultSet.getInt(5));
                kino.setDirectorName(resultSet.getString(6));
                List<Integer> genreIdByKinoId = genreManager.getGenreIdByKinoId(kino.getId());
                for (Integer integer : genreIdByKinoId) {
                    genres.add(genreManager.getGenreById(integer));
                }
                kino.setGenre(genres);
                kino.setUser(userManager.getUserById(resultSet.getInt(7)));
                kino.setDate(DateUtil.convertStringToDate(resultSet.getString(8)));
                kinos.add(kino);
            }
            return kinos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addGenreIdAndKinoId(int kinoId, Set<Genre> genres) {
        try {
            for (Genre genre : genres) {
                String query = "INSERT INTO genre_movie (movie_id, genre_id) VALUES (" + kinoId + "," + genre.getId() + ")";
                Statement statement = connection.createStatement();
                statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Kino getKinoById(int id) {
        GenreManager genreManager=new GenreManager();
        UserManager userManager=new UserManager();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM kino WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(query);
            Set<Kino> kinos = new HashSet<>();
            Set<Genre> genres = new HashSet<>();
            if (resultSet.next()) {
                Kino kino = new Kino();
                kino.setId(resultSet.getInt(1));
                kino.setName(resultSet.getString(2));
                kino.setDescription(resultSet.getString(3));
                kino.setPicUrl(resultSet.getString(4));
                kino.setYear(resultSet.getInt(5));
                kino.setDirectorName(resultSet.getString(6));
                List<Integer> genreIdByKinoId = genreManager.getGenreIdByKinoId(kino.getId());
                for (Integer integer : genreIdByKinoId) {
                    genres.add(genreManager.getGenreById(integer));
                }
                kino.setGenre(genres);
                kino.setUser(userManager.getUserById(resultSet.getInt(7)));
                kino.setDate(DateUtil.convertStringToDate(resultSet.getString(8)));
                return kino;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
