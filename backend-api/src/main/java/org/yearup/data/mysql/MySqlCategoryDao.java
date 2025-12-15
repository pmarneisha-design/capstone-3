package org.yearup.data.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao {
    @Autowired
    public MySqlCategoryDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories() {
        // get all categories
        String sql = """
                SELECT * 
                FROM categories; 
                """;
        List<Category> categories = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    Category category = new Category(id, name, description);
                    categories.add(category);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getById(int categoryId) {
        String sql = """
                SELECT *
                FROM categories
                WHERE category_id = ?;
                """;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, categoryId);
        try (ResultSet resultSet = preparedStatement.executeQuery()){
            if (resultSet.next()){
                return mapRow(resultSet);
            }
        }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        // get category by id
                return null;
                }

@Override
public Category create(Category category) {
    String sql = """
            INSERT INTO categories(name, description)
            VALUES (?,?);
            """;

    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
        preparedStatement.setString(1, category.getName());
        preparedStatement.setString(2, category.getDescription());

        preparedStatement.executeUpdate();
        try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
            if (keys.next()) {
                category.setCategoryId(keys.getInt(1));
            }
        }
        return category;
    } catch (SQLException e){
        e.printStackTrace();
    }

        // create a new category
        return null;
    }

    @Override
    public void update ( int categoryId, Category category) {
        String sql = """
                UPDATE categories
                SET name = ?, description = ?
                WHERE category_id = ?;
                """;
        // update category
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setString(3, String.valueOf(categoryId));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete ( int categoryId) {
        String sql = """
                DELETE FROM categories
                WHERE category_id = ?;
                """;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, categoryId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        // delete category

    private Category mapRow (ResultSet row) throws SQLException
    {
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");

        Category category = new Category() {{
            setCategoryId(categoryId);
            setName(name);
            setDescription(description);
        }};

        return category;
    }

}
