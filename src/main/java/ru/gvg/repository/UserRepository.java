package ru.gvg.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Repository;
import ru.gvg.model.User;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Valeriy Gyrievskikh
 * @since 05.08.2018.
 */
@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class UserRepository {

    private Map<String, User> users = new LinkedHashMap<>();

    @PostConstruct
    private void init() {
        merge(new User("Иван", "Иванов", ""));
        merge(new User("Петр", "Петров", ""));
        merge(new User("Сидор", "Сидоров", ""));
    }

    public Collection<User> getListUser() {
        return users.values();
    }

    public void merge(User user) {
        if (user == null) return;
        if (user.getId() == null || user.getId().isEmpty()) return;
        ;
        users.put(user.getId(), user);
    }

    public User findOne(String id) {
        if (id == null || id.isEmpty()) return null;
        return users.get(id);
    }

    public void removeUserById(String id) {
        if (id == null || id.isEmpty()) return;
        users.remove(id);
    }
}
