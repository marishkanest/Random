

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public class StudentsRepository {

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from student";

    //language=SQL
    private static final String SQL_FIND_BY_ID = "select * from student where id = ?";

    //language=SQL
    private static final String SQL_INSERT = "insert into student(group_id, name) values (?, ?)";

    private final DataSource dataSource;

    public StudentsRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private final Function<ResultSet, Student> userMapper = row -> {
        try {
            return Student.builder()
                    .id(row.getInt("id"))
                    .team(row.getInt("group_id"))
                    .name(row.getString("name"))
                    .points(row.getInt("points"))
                    .build();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    };


    public void save(Student model) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, model.getTeam());
            statement.setString(2, model.getName());

            int affectedRows = statement.executeUpdate();

            if (affectedRows != 1) {
                throw new IllegalStateException("Can't insert user");
            }
            // получаю ключи, которые сгенерировала база данных
            ResultSet keys = statement.getGeneratedKeys();

            // если база мне вернула сгенерированный ключ
            if (keys.next()) {
                // запрашиваю сгенерированный ключ, который называется id
                int generatedId = keys.getInt("id");
                // проставляю его в модель пользователя
                model.setId(generatedId);
            } else {
                // если база не смогла вернуть сгенерированный ключ
                throw new IllegalStateException("Can't obtain id");
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }


    public Optional<Student> findById(Integer studentId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID)) {
            preparedStatement.setInt(1, studentId);

            try (ResultSet result = preparedStatement.executeQuery()) {
                // если из базы ничего не пришло
                if (!result.next()) {
                    return Optional.empty();
                }
                // создаем пользователя
                Student student = userMapper.apply(result);
                // вернули результат
                return Optional.of(student);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }


    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(SQL_SELECT_ALL)) {
            while (result.next()) {
                Student student = userMapper.apply(result);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return students;
    }
}
