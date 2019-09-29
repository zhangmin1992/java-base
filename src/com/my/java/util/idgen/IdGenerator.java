package com.my.java.util.idgen;

public interface IdGenerator {

	void init();

	long nextId();

	long nextId(String nameColumn);

	IdRange nextBatch(String nameColumn);

	IdRange nextBatch(String nameColumn, int batchSize);
}
