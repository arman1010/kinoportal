package manager;

import db.DBConnectionProvider;
import model.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenreManager {
    private Connection connection;

    public GenreManager() {
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    public void addGenre(Genre genre) {
        String query = "INSERT INTO genre(`name`) VALUES (?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, genre.getName());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                genre.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Set<Genre> getAllGenres() {
        String query = "SELECT * FROM genre";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Set<Genre> genres = new HashSet<>();
            while (resultSet.next()) {
                Genre genre = new Genre();
                genre.setId(resultSet.getInt(1));
                genre.setName(resultSet.getString(2));
                genres.add(genre);
            }
            return genres;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Genre getGenreById(int id) {
        String query = "SELECT * FROM genre WHERE id = " + id;
        try {
            Statement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Genre genre = new Genre();
                genre.setId(resultSet.getInt(1));
                genre.setName(resultSet.getString(2));
                return genre;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Integer> getGenreIdByKinoId(int kinoId) {
        String query = "SELECT genre_id FROM genre_movie WHERE `movie_id` = " + kinoId;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Integer> integers = new ArrayList<>();
            while (resultSet.next()) {
                integers.add(resultSet.getInt(1));
            }
            return integers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Genre getGenreByName(String name) {
        String query = "SELECT * FROM genre WHERE `name` = '" + name + "'";
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Genre genre = new Genre();
                genre.setId(resultSet.getInt(1));
                genre.setName(resultSet.getString(2));
                return genre;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}