package com.goldrush.dao;

import java.sql.Connection;

public interface DB {
	Connection connect();
	int disconnect();
}
