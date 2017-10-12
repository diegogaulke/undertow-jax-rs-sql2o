package com.diegogaulke.jaxrs.dao;

import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.diegogaulke.jaxrs.datasource.DataSource;
import com.diegogaulke.jaxrs.domain.User;

public class UserDAO {

	private static final Sql2o sql2o = new Sql2o(DataSource.getInstance());

	public List<User> getAllUsers() {
		final String sql = "SELECT id, name FROM user";

		try (Connection con = sql2o.open()) {
			return con.createQuery(sql).executeAndFetch(User.class);
		}
	}

	public User getUserById(int id) {
		final String sql = "SELECT * FROM user WHERE id = :id";

		try (Connection con = sql2o.open()) {
			return con.createQuery(sql).addParameter("id", id).executeAndFetchFirst(User.class);
		}
	}

	public void createRandomUser() {
		final User user = new User(Long.toHexString(Double.doubleToLongBits(Math.random())));

		final String sql = "insert into user ( name ) values ( :name )";
		try (Connection con = sql2o.open()) {
			con.createQuery(sql).bind(user).executeUpdate();
		}
	}

}
