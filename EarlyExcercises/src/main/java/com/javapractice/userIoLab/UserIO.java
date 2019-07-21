package com.javapractice.userIoLab;

public interface UserIO {

	public void print(String message);

	public double readDouble(String prompt);

	public double readDouble(String prompt, double min, double max);

	public float readFloat(String prompt);

	public float readFloat(String promt, float min, float max);

	public int readInt(String promt);

	public int readInt(String promt, int min, int max);

	public long readLong(String promt);

	public long readLong(String promt, long min, long max);

	public String readString(String prompt);
}
